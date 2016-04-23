package controllers.builder;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import controllers.common.Move;
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
import model.BoardTile;
import model.Bullpen;
import model.EmptyTile;
import model.Piece;
import model.PieceTile;
import model.ReleaseTile;

/**
 * Controls all actions having to do with manipulating tiles on a Puzzle or Lightning board in builder mode 
 * 
 * @author awharrison
 * @author Dylan
 * @author hejohnson
 */

public class BuilderBoardController implements MouseListener, MouseMotionListener {
	BuilderView bView;
	AbstractLevelModel m;
	Board board;
	Bullpen bp;
	BullpenView bpv;
	Piece draggedPiece;
	BoardView boardView;
	SelectedPieceView spv;
	ReleaseNumberCreationView rncv;
	boolean mouseOn;
	int rOffset;
	int cOffset;
	
	public BuilderBoardController(BuilderView bView, AbstractLevelModel lm) {
		this.bView = bView;
		this.m = lm;
		this.board = lm.getBoard();
		this.bp = lm.getBullpen();
		this.bpv = bView.getBullpenView();
		this.boardView = bView.getBoardView();
		this.rncv = bView.getReleaseNumberView();
		this.spv = bView.getSelectedPieceView();
	}


	/**
	 * Select a piece that is currently on the board
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
	 * Convert tile on board into opposite form: Board Vs Empty. Using a released action allows
	 * the user to click as quick as they want, preventing accidental behavior not related to a click
	 * (like a press, move, release instead of just a click).
	 * @param me MouseEvent
	 */
	@Override
	public void mouseReleased(MouseEvent me) {
		if(bView.getStateOfPlacement()){
			Move move = null;
			AbstractTile source  = board.getTileAt(me.getX(), me.getY());
			if (mouseOn) {
				if (board.getDraggedPiece() == null) {
					if (m.getBullpen().getSelectedPiece() != null) {
						move = new PlacePieceOnBoardFromBullpenMove(m, source, bpv);
					}
				} else {
					move = new MovePieceOnBoardMove(m, source, board.getDraggedPiece(), rOffset, cOffset);
				}
				
				if (move != null && move.doMove()) {
					//levelModel.pushMove(m); // If it's a builder, the level will push onto the stack. If player, the level can just discard it
					board.setDraggedPiece(null);
					spv.getPiecePanel().redraw();
					spv.getPiecePanel().repaint();
				} else {
					if (board.getDraggedPiece() != null) { // Can't place the piece, and a piece was being dragged. Just return the piece to the original location.
						board.putPieceOnBoard(board.getDraggedPiece(), board.getDraggedPiece().getOriginRow(), board.getDraggedPiece().getOriginCol());
						board.setDraggedPiece(null);
						board.clearPiecePreview();
					}
				} 
			}
		}else if(rncv.getNumberSelected() < 0){
			AbstractTile source = board.getTileAt(me.getX(), me.getY());
			if(source.getTileType().equals("board")){
				Move move = new SwapTileBoardToEmptyMove(bView, (BoardTile) source, m);
				move.doMove();
			} else if (source.getTileType().equals("empty")) {	
				Move move = new SwapTileEmptyToBoardMove(bView, (EmptyTile) source, m);
				move.doMove();
			} else if(source.getTileType().equals("release")){
				Move move = new SwapTileReleaseToBoardMove(bView, (ReleaseTile) source, m);	
				move.doMove();
			}
		}else{
			AbstractTile source = board.getTileAt(me.getX(), me.getY());
			if(source.getTileType().equals("board")){
				Move move = new SwapTileBoardToReleaseMove(bView, (BoardTile) source, m);
				move.doMove();
			} 
			else if (source.getTileType().equals("release")) {
				Move move = new SwapTileReleaseToReleaseMove(bView, (ReleaseTile) source, m);
				move.doMove();
			}
		}
		boardView.redraw();
		boardView.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		mouseOn = true;
	}
	
	/**
	 * If currently dragging a piece, remove the piece from the board and return it to the bullpen
	 * 
	 * @param me MouseEvent
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		if(bView.getStateOfPlacement()){
			mouseOn = false;
			Move move = new MovePieceOffBoardMove(m, bpv);
			move.doMove();
			board.clearPiecePreview();
			boardView.redraw();
			boardView.repaint();
		}
	}

	@Override
	/**
	 * Show a preview of a piece on the board if a piece is in the bullpen
	 * 
	 * @param me MouseEvent
	 */
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

	@Override
	/**
	 * Redraw the piece being dragged where the mouse goes
	 * 
	 * @param me MouseEvent
	 */
	public void mouseMoved(MouseEvent me) {
		if(bView.getStateOfPlacement()){
			Piece p;
			AbstractTile source  = board.getTileAt(me.getX(), me.getY());
			p = bp.getSelectedPiece();
			
			if(p != null){
				board.clearPiecePreview();
				board.showPiecePreview(p, source.getRow(), source.getCol());
				boardView.redraw();
				boardView.repaint();
			}
		}
	}

	//====================== UNUSED BUT REQUIRED ======================//
	@Override
	public void mouseClicked(MouseEvent me) {}
}
