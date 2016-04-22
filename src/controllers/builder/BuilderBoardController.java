package controllers.builder;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import controllers.common.Move;
import controllers.common.MovePieceOffBoardMove;
import controllers.common.PlacePieceOnBoardFromBullpenMove;
import view.BoardView;
import view.BuilderView;
import view.BullpenView;
import view.ReleaseNumberCreationView;
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
 */

public class BuilderBoardController implements MouseListener, MouseMotionListener {
	BuilderView bView;
	AbstractLevelModel m;
	Board board;
	Bullpen bp;
	BullpenView bpv;
	Piece draggedPiece;
	BoardView boardView;
	ReleaseNumberCreationView rncv;
	
	public BuilderBoardController(BuilderView bView, AbstractLevelModel lm) {
		this.bView = bView;
		this.m = lm;
		this.board = lm.getBoard();
		this.bp = lm.getBullpen();
		this.bpv = bView.getBullpenView();
		this.boardView = bView.getBoardView();
		this.rncv = bView.getReleaseNumberView();
	}

	
	/**
	 * Select a piece that is currently on the board
	 * @param me MouseEvent
	 */
	@Override
	public void mousePressed(MouseEvent me) {
//		AbstractTile source = m.getBoard().getTileAt(me.getX(), me.getY());
//		
//		if(source == null) {
//			throw new RuntimeException("BoardController::somehow selected a null tile");
//		}
//		
//		// lift a piece off the board
//		if(source.getTileType().equals("piece")) {
//			board.removePiece(((PieceTile) source).getPiece());
//			draggedPiece = ((PieceTile) source).getPiece();
//		} 
//		// place a piece
//		else if(source.getTileType().equals("board")) {
//				Move move = new PlacePieceOnBoardFromBullpenMove(m, source, bpv);
//				move.doMove();
//		}
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
			
		}else if(rncv.getNumberSelected() < 0){
			AbstractTile source = m.getBoard().getTileAt(me.getX(), me.getY());
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
			AbstractTile source = m.getBoard().getTileAt(me.getX(), me.getY());
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
//		AbstractTile source = m.getBoard().getTileAt(me.getX(), me.getY());
//		if(source == null) {
//			throw new RuntimeException("BoardController::somehow selected a null tile");
//		}
//		
//		// place a piece
//		else if(source.getTileType().equals("board")) {
//			Move move = new PlacePieceOnBoardFromBullpenMove(m, source, bpv);
//			move.doMove();
//		}
	}

	@Override
	/**
	 * If currently dragging a piece, remove the piece from the board and return it to the bullpen
	 * 
	 * @param me MouseEvent
	 */
	public void mouseExited(MouseEvent e) {
		if(draggedPiece != null) {
			//Move move = new MovePieceOffBoardMove(m, draggedPiece);
			//move.doMove();
			draggedPiece = null;
		}
	}

	@Override
	/**
	 * Show a preview of a piece on the board if a piece is in the bullpen
	 * 
	 * @param me MouseEvent
	 */
	public void mouseDragged(MouseEvent e) {
		//TODO implement after pieceMove button added
		//board.showPiecePreview(draggedPiece, e.getX()/board.getTileSize(), e.getY()/board.getTileSize());
	}

	@Override
	/**
	 * Redraw the piece being dragged where the mouse goes
	 * 
	 * @param me MouseEvent
	 */
	public void mouseMoved(MouseEvent e) {
		if(bp.getSelectedPiece() != null){
			board.showPiecePreview(bp.getSelectedPiece(), e.getX()/board.getTileSize(), e.getY()/board.getTileSize());
		}
		
	}

	//====================== UNUSED BUT REQUIRED ======================//
	@Override
	public void mouseClicked(MouseEvent me) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
}
