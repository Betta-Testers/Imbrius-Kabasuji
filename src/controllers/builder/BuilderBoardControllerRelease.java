package controllers.builder;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import controllers.common.Move;
import controllers.common.MovePieceOffBoardMove;
import controllers.common.PlacePieceOnBoardFromBullpenMove;
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
import model.ReleaseTile;
import model.PieceTile;

/**
 * Controls all actions having to do with manipulating tiles on a Release board in builder mode 
 * 
 * @author awharrison
 *
 */

public class BuilderBoardControllerRelease implements MouseListener, MouseMotionListener {
	BuilderView bView;
	AbstractLevelModel lm;
	Board board;
	Bullpen bp;
	BullpenView bpv;
	ReleaseNumberCreationView rncv;
	Piece draggedPiece;
	
	public BuilderBoardControllerRelease(BuilderView bView, AbstractLevelModel lm) {
		this.bView = bView;
		this.lm = lm;
		this.board = lm.getBoard();
		this.bp = lm.getBullpen();
		this.bpv = bView.getBullpenView();
		rncv = bView.getReleaseNumberView();
	}
	
	@Override
	/**
	 * Swap individual tile types on the board
	 * 
	 * @param me MouseEvent
	 */
	
	// TODO place piece if a piece is in the bullpen
	public void mouseClicked(MouseEvent e) {
		// TODO make everything one click, release tiles can be toggled off
		// TODO make grab the selectedTile from a tileView
		// tile swapping
		AbstractTile selectedTile = (AbstractTile)e.getSource();
		// throw exception if the mouse has selected a null tile
		if(selectedTile == null) {
			throw new RuntimeException("BoardController::somehow selected a null tile");
		} 
		
		if(rncv.getNumberSelected() == 0) {
			// single click on a board tile results in a swap to an empty tile
			if(selectedTile.getTileType().equals("board")){
				Move m = new SwapTileBoardToEmptyMove(bView, (BoardTile) selectedTile, lm);
				m.doMove();
			} 
			// single click on an empty tile results in a swap to a board tile
			else if (selectedTile.getTileType().equals("empty")) {				
				Move m = new SwapTileEmptyToBoardMove(bView, (EmptyTile) selectedTile, lm);
				m.doMove();
			}
			// single click on a release tile results in a swap to a board tile
			else if (selectedTile.getTileType().equals("Release")) {
				Move m = new SwapTileReleaseToBoardMove(bView, (ReleaseTile) selectedTile, lm);	
				m.doMove();
			} 
		} else {
			// click on a board tile with a ReleaseNumber toggle button toggled results in a swap to a release tile
			if(selectedTile.getTileType().equals("board")){
				Move m = new SwapTileBoardToReleaseMove(bView, (BoardTile) selectedTile, lm);
				m.doMove();
			} 
			// click on a release tile with a ReleaseNumber toggle button toggled results in a swap to a release tile
			else if (selectedTile.getTileType().equals("Release")) {
				Move m = new SwapTileReleaseToReleaseMove(bView, (ReleaseTile) selectedTile, lm);
				m.doMove();
			}
		}
			
	}

	@Override
	/**
	 * Select a piece that is currently on the board
	 * 
	 * @param me MouseEvent
	 */
	public void mousePressed(MouseEvent e) {
		AbstractTile selectedTile = (AbstractTile)e.getSource();
		
		if(selectedTile == null) {
			throw new RuntimeException("BoardController::somehow selected a null tile");
		}
		
		// lift a piece off the board
		if(selectedTile.getTileType().equals("piece")) {
			draggedPiece = ((PieceTile) selectedTile).getPiece();
		} 
		// place a piece
		else if(selectedTile.getTileType().equals("board")) {
				Move m = new PlacePieceOnBoardFromBullpenMove(lm, selectedTile);
				m.doMove();
		}
	}
	

	@Override
	/**
	 * place a piece on the board from that was previously on the board
	 * 
	 * @param me MouseEvent
	 */
	public void mouseReleased(MouseEvent e) {
		AbstractTile selectedTile = (AbstractTile)e.getSource();
		if(selectedTile == null) {
			throw new RuntimeException("BoardController::somehow selected a null tile");
		}
		
		// place a piece
		else if(selectedTile.getTileType().equals("board")) {
			Move m = new PlacePieceOnBoardFromBullpenMove(lm, selectedTile);
			m.doMove();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// preview piece on the board
	}

	@Override
	/**
	 * If currently dragging a piece, remove the piece from the board and return it to the bullpen
	 * 
	 * @param me MouseEvent
	 */
	public void mouseExited(MouseEvent e) {
		if(draggedPiece != null) {
			Move m = new MovePieceOffBoardMove(lm, draggedPiece);
			m.doMove();
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
		board.showPiecePreview(draggedPiece, e.getX()/board.getTileSize(), e.getY()/board.getTileSize());
		
	}

	@Override
	/**
	 * Redraw the piece being dragged where the mouse goes
	 * 
	 * @param me MouseEvent
	 */
	public void mouseMoved(MouseEvent e) {
		board.showPiecePreview(bp.getSelectedPiece(), e.getX()/board.getTileSize(), e.getY()/board.getTileSize());
		
	}

}
