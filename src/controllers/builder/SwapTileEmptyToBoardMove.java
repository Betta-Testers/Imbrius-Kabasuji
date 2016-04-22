package controllers.builder;

import controllers.common.Move;
import model.AbstractLevelModel;
import model.Board;
import model.BoardTile;
import model.EmptyTile;
import view.BuilderView;

/**
 * Represents the swap between an empty tile and a board tile
 * 
 * @author awharrison
 *
 */
public class SwapTileEmptyToBoardMove extends Move {
	Board board;
	EmptyTile oldTile;
	BoardTile newTile;
	
	public SwapTileEmptyToBoardMove (BuilderView bView, EmptyTile old, AbstractLevelModel lm) {
		if((bView == null) || (old == null) || (lm == null)) { 
			throw new RuntimeException("SwapTileBoardToReleaseMove::failed to initialize constructor inputs");
		}
		this.board = lm.getBoard();
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
		if(this.oldTile.getTileType().equals("empty"))
			return true;
		else
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
