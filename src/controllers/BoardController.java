package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

public class BoardController implements MouseListener {
	BuilderView bView;
	AbstractLevelModel lm;
	Board board;
	Bullpen bp;
	BullpenView bpv;
	
	public BoardController(BuilderView bView, AbstractLevelModel lm) {
		this.bView = bView;
		this.lm = lm;
		this.board = lm.getBoard();
		this.bp = lm.getBullpen();
		this.bpv = bView.getBullpenView();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// tile swapping
		AbstractTile selectedTile = (AbstractTile)e.getSource();
		// throw exception if the mouse has selected a null tile
		if(selectedTile == null) {
			throw new RuntimeException("BoardController::somehow selected a null tile");
		} 
		
		// differentiate between 1 click and double click
		int clickCount = e.getClickCount();
		switch(clickCount) {
		case 1: // cases of a single click
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
			// do nothing
			else {
				
			}
			
			break;
		case 2: // cases of a double click
			// double click on a board tile results in a swap to a release tile
			if(selectedTile.getTileType().equals("board")){
				Move m = new SwapTileBoardToReleaseMove(bView, (BoardTile) selectedTile, lm);
				m.doMove();
			} 
			// single click on a release tile results in a swap to a board tile
			else if (selectedTile.getTileType().equals("Release")) {
				Move m = new SwapTileReleaseToBoardMove(bView, (ReleaseTile) selectedTile, lm);	
				m.doMove();
			} 
			// do nothing
			else {
				
			}
			break;
		default:
			// do nothing
			break;
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
			Piece selectedPiece = ((PieceTile) selectedTile).getPiece();
			// TODO set piece to the active drag source, not sure how to do this
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
		Piece pieceBeingDragged = new Piece(1); //TODO change this
		// TODO get the piece being dragged
		// return piece to the bullpen
		if(pieceBeingDragged != null) {
			Move m = new MovePieceOffBoardMove(lm, pieceBeingDragged);
			m.doMove();
		}
	}

}
