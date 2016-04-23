package controllers.builder;

import controllers.common.Move;
import model.AbstractTile;
import model.Board;
import model.EmptyTile;

/**
 * Represents the swap between a board tile and an empty tile
 * 
 * @author awharrison
 * @author Dylan
 *
 */
public class SwapTileBoardToEmptyMove extends Move {
	Board board;
	AbstractTile oldTile;
	EmptyTile newTile;
	
	public SwapTileBoardToEmptyMove (AbstractTile old, Board b) {
		this.board = b;
		this.oldTile = old;
	}
	
	@Override
	public boolean doMove() {
		if(isValid()) {
			this.newTile = new EmptyTile(oldTile.getRow(), oldTile.getCol());
			board.swapTile(newTile); // may want to throw runtime exception if this does not return a copy of the old tile
			return true;
		}
		return false;
	}

	@Override
	public boolean isValid() {
		if(oldTile.getTileType().equals("board")){return true;}
		return false;
	}

	@Override
	public boolean undo() {
		// TODO Auto-generated method stub
		board.swapTile(oldTile);
		return true;
	}
	
	@Override 
	public boolean redo() {
		board.swapTile(newTile);
		return true;
	}
}
