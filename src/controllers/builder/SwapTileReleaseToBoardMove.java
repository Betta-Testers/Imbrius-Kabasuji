package controllers.builder;

import view.ReleaseNumberCreationView;
import controllers.common.Move;
import model.AbstractTile;
import model.Board;
import model.BoardTile;

/**
 * Represents the swap between a release tile and a board tile
 * 
 * @author awharrison
 * @author Dylan
 */
public class SwapTileReleaseToBoardMove extends Move {
	Board board;
	AbstractTile oldTile;
	BoardTile newTile;
	ReleaseNumberCreationView rncv;
	
	public  SwapTileReleaseToBoardMove (ReleaseNumberCreationView rncv, AbstractTile old, Board b) {
		this.board = b;
		this.rncv = rncv;
		this.oldTile = old;
	}
	
	@Override
	public boolean doMove() {
		if(isValid()) {
			this.newTile = new BoardTile(oldTile.getRow(), oldTile.getCol());
			board.swapTile(newTile); // may want to throw runtime exception if this does not return a copy of the old tile
			return true;
		}
		return false;
	}

	@Override
	public boolean isValid() {
		if(oldTile.getTileType().equals("release")){ return true;}
		return false;
	}

	@Override
	public boolean undo() {
		board.swapTile(oldTile);
		return true;
	}

	@Override 
	public boolean redo() {
		board.swapTile(newTile);
		return true;
	}
}
