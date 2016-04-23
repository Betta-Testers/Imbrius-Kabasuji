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
				move = new MovePieceOnBoardMove(m, source, board.getDraggedPiece(), rOffset, cOffset); //ADDED
				if(!move.doMove()){
					move = new PlacePieceOnBoardFromBullpenMove(m, source, bpv);
					move.doMove();
				}else{
					board.putPieceOnBoard(board.getDraggedPiece(), board.getDraggedPiece().getOriginRow(), board.getDraggedPiece().getOriginCol());
					board.setDraggedPiece(null);
					board.clearPiecePreview();
				}
				spv.getPiecePanel().redraw();
				spv.getPiecePanel().repaint();
			}
		}else if(rncv.getNumberSelected() < 0){
			AbstractTile source = board.getTileAt(me.getX(), me.getY());
			Move move;
			move = new SwapTileBoardToEmptyMove(source, board);
			if(!move.doMove()){
				move = new SwapTileEmptyToBoardMove(source, board);
				if(!move.doMove()){
					move = new SwapTileReleaseToBoardMove(rncv, source, board);	
					move.doMove();
				}
			}
		}else{
			AbstractTile source = board.getTileAt(me.getX(), me.getY());
			Move move;
			move = new SwapTileBoardToReleaseMove(rncv, source, board);
			if(!move.doMove()){
				move = new SwapTileReleaseToReleaseMove(rncv, source, board);
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
