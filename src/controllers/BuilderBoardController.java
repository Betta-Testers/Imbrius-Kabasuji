package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import view.BuilderView;
import view.BullpenView;
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
 * @author awharrison
 *
 */

public class BuilderBoardController extends MouseAdapter {
	BuilderView bView;
	AbstractLevelModel lm;
	Board board;
	Bullpen bp;
	BullpenView bpv;
	Piece draggedPiece;
	
	public BuilderBoardController(BuilderView bView, AbstractLevelModel lm) {
		this.bView = bView;
		this.lm = lm;
		this.board = lm.getBoard();
		this.bp = lm.getBullpen();
		this.bpv = bView.getBullpenView();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO make everything one click, release tiles can be toggled off
		// TODO make grab the selectedTile from a tileView
		// tile swapping
		AbstractTile selectedTile = (AbstractTile)e.getSource();
		// throw exception if the mouse has selected a null tile
		if(selectedTile == null) {
			throw new RuntimeException("BoardController::somehow selected a null tile");
		} 
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
	}

	@Override
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
		board.showPiecePreview(bp.getSelectedPiece(), e.getX()/board.getTileSize(), e.getY()/board.getTileSize());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(draggedPiece != null) {
			Move m = new MovePieceOffBoardMove(lm, draggedPiece);
			m.doMove();
			draggedPiece = null;
		}
	}

}
