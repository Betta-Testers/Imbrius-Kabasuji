package controllers.builder;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import app.UndoManager;
import controllers.common.IMove;
import controllers.common.MovePieceOffBoardMove;
import controllers.common.MovePieceOnBoardMove;
import controllers.common.PlacePieceOnBoardFromBullpenMove;
import view.BoardView;
import view.BuilderView;
import view.BullpenView;
import view.ReleaseNumberCreationView;
import view.SelectedPieceView;
import model.AbstractLevelModel;
import model.AbstractTile;
import model.Board;
import model.Bullpen;
import model.Piece;
import model.PieceTile;

/**
 * Controls all actions having to do with the board in the Builder application
 * Handles showing piece placement previews, placing pieces, dragging pieces around, and removing them from the board
 * Also handles swapping types of tiles, empty <-> board <-> release tiles (including changing number/color)
 * 
 * @author awharrison
 * @author dfontana
 * @author hejohnson
 */

public class BuilderBoardController implements MouseListener, MouseMotionListener {
	/** Top level view for the level editor/creator **/
	BuilderView bView;
	/** Entity that is currently being edited **/
	AbstractLevelModel lm;
	/** Board model that this controller acts on **/
	Board board;
	/** Bullpen model in the current level **/
	Bullpen bp;
	/** View of the current bullpen **/
	BullpenView bpv;
	/** View for the current board **/
	BoardView boardView;
	/** View of the piece that is selected to be placed from the bullpen **/
	SelectedPieceView spv;
	/** Panel on the side that holds the toggle buttons for setting the tile number **/
	ReleaseNumberCreationView rncv;

	/**Tracks all the pieces that governed a hint placement**/
	ArrayList<Piece> hintPieces;

	/** Tracks if the mouse is on the board **/
	boolean mouseOn;
	/** Row offset between the origin tile and the tile that was clicked on within the piece **/
	int rOffset;
	/** Column offset between the origin tile and the tile that was clicked on within the piece **/
	int cOffset;
	
	int tileCount;

	/** 
	 * Creates the builder board's controller
	 * @param builderView The BuilderView that this controller updates the state of
	 * @param levelModel The level entity that is being built
	 */
	public BuilderBoardController(BuilderView bView, AbstractLevelModel lm) {
		this.bView = bView;
		this.lm = lm;
		this.board = lm.getBoard();
		this.bp = lm.getBullpen();
		this.bpv = bView.getBullpenView();
		this.boardView = bView.getBoardView();
		this.rncv = bView.getReleaseNumberView();
		this.spv = bView.getSelectedPieceView();
		this.hintPieces = new ArrayList<Piece>();
		this.tileCount = 0;
	}

	/**
	 * Select a piece that is currently on the board, if the tile that was clicked is part of a piece. 
	 * Removes piece from the board, and sets it as the dragged piece in the board entity
	 * @param me MouseEvent
	 */
	@Override
	public void mousePressed(MouseEvent me) {
		if(bView.getStateOfPlacement()){
			AbstractTile source  = board.getTileAt(me.getX(), me.getY());
			if (source instanceof PieceTile) {
				board.setDraggedPiece(((PieceTile)source).getPiece());
				rOffset = -((PieceTile)source).getRowInPiece();
				cOffset = -((PieceTile)source).getColInPiece();
				board.removePiece(board.getDraggedPiece());	
				boardView.redraw();
				boardView.repaint();
			}	
		}

	}

	/**
	 * Convert tile on board into another form: Release <-> Release <-> Board <-> Empty 
	 * OR
	 * Place a piece on the board for: Previewing, Generating the Board, Making/removing hints.
	 * Using a released action allows the user to click as quick as they want, preventing accidental behavior not related to a click
	 * (like a press, move, release instead of just a click).
	 * @param me MouseEvent
	 */
	@Override
	public void mouseReleased(MouseEvent me) {
		IMove move = null;
		AbstractTile source = board.getTileAt(me.getX(), me.getY());
		
		if(bView.getStateOfPlacement()){
			if(bView.getStateOfBoardConvert()){
				if (mouseOn) {
					move = new PieceToNewBoardTilesMove(bp, board, source, bView.getLevelPropertiesView());
					if(move.doMove()){
						UndoManager.getInstance().pushMove(move);
					}
				}
			}else if(bView.getStateOfHintConvert()){
				if (mouseOn) {
					move = new PieceToHintMove(hintPieces, bp, board, source);
					if(move.doMove()){
						UndoManager.getInstance().pushMove(move);
					}
				}
			}else{
				if (mouseOn) {
					move = new MovePieceOnBoardMove(lm, source, board.getDraggedPiece(), rOffset, cOffset);
					if(!move.doMove()){
						if(board.getDraggedPiece() != null){ // Move failed, put the piece back
							board.putPieceOnBoard(board.getDraggedPiece(), board.getDraggedPiece().getOriginRow(), board.getDraggedPiece().getOriginCol());
							board.setDraggedPiece(null);
							board.clearPiecePreview();
						}
						move = new PlacePieceOnBoardFromBullpenMove(lm, source, bpv);
						if(move.doMove()){
							UndoManager.getInstance().pushMove(move);
						}
					}else{
						UndoManager.getInstance().pushMove(move);
					}
				}
			}
			spv.getPiecePanel().redraw();
			spv.getPiecePanel().repaint();
		}else if(rncv.getNumberSelected() < 0){
			move = new RemoveHintMove(hintPieces, source, board);
			if(!move.doMove()){
				move = new SwapTileBoardToEmptyMove(source, board, bView.getLevelPropertiesView());
				if(!move.doMove()){
					move = new SwapTileEmptyToBoardMove(source, board, bView.getLevelPropertiesView());
					if(!move.doMove()){
						move = new SwapTileReleaseToBoardMove(source, board);	
						if(move.doMove()){
							UndoManager.getInstance().pushMove(move);
						}
					}else{
						UndoManager.getInstance().pushMove(move);
					}
				}else{
					UndoManager.getInstance().pushMove(move);
				}
			}else{
				UndoManager.getInstance().pushMove(move);
			}
		}else{
			move = new SwapTileBoardToReleaseMove(rncv, source, board);
			if(!move.doMove()){
				move = new SwapTileReleaseToReleaseMove(rncv, source, board);
				if(move.doMove()){
					UndoManager.getInstance().pushMove(move);
				}
			}else{
				UndoManager.getInstance().pushMove(move);
			}
		}
		
		
		boardView.redraw();
		boardView.repaint();
	}

	/**
	 * Tracks if mouse is over the board
	 * @param me MouseEvent
	 */
	@Override
	public void mouseEntered(MouseEvent me) {
		mouseOn = true;
	}

	/**
	 * If currently dragging a piece, remove the piece from the board and return it to the bullpen
	 * 
	 * @param me MouseEvent
	 */
	@Override
	public void mouseExited(MouseEvent me) {
		if(bView.getStateOfPlacement()){
			mouseOn = false;
			IMove move = new MovePieceOffBoardMove(lm, bpv);
			if(move.doMove()){
				UndoManager.getInstance().pushMove(move);
			}
			board.clearPiecePreview();
			boardView.redraw();
			boardView.repaint();
		}
	}

	/**
	 * Shows a preview of the piece being dragged (if there is one)
	 * 
	 * @param me MouseEvent
	 */
	@Override
	public void mouseDragged(MouseEvent me) {
		if(bView.getStateOfPlacement()){
			AbstractTile source  = board.getTileAt(me.getX(), me.getY());
			Piece p;
			if (board.getDraggedPiece() == null) {
				return;
			} else {
				p = board.getDraggedPiece();
			}
			board.clearPiecePreview();
			board.showPiecePreview(p, source.getRow()+rOffset, source.getCol()+cOffset);
			boardView.redraw();
			boardView.repaint();
		}
	}

	/**
	 * Show a preview of the piece that is selected to be placed (if it exists)
	 * 
	 * @param me MouseEvent
	 */
	@Override
	public void mouseMoved(MouseEvent me) {
		if(bView.getStateOfPlacement()){
			Piece p;
			AbstractTile source  = board.getTileAt(me.getX(), me.getY());
			p = bp.getSelectedPiece();

			if(p != null){
				board.clearPiecePreview();
				if(bView.getStateOfBoardConvert()){
					board.showConversionPreview(p, source.getRow(), source.getCol());
				}else if(bView.getStateOfHintConvert()){
					board.showHintPreview(p, source.getRow(), source.getCol());
				}else{
					board.showPiecePreview(p, source.getRow(), source.getCol());
				}
				boardView.redraw();
				boardView.repaint();
			}
		}
	}

	//====================== UNUSED BUT REQUIRED ======================//
	@Override
	public void mouseClicked(MouseEvent me) {}
}
