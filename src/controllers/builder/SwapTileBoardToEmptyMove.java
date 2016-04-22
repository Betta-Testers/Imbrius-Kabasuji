package controllers.builder;

import controllers.common.Move;
import model.AbstractLevelModel;
import model.Board;
import model.BoardTile;
import model.EmptyTile;
import view.BuilderView;

/**
 * Represents the swap between a board tile and an empty tile
 * 
 * @author awharrison
 *
 */
public class SwapTileBoardToEmptyMove extends Move {
	Board board;
	BoardTile oldTile;
	EmptyTile newTile;
	
	public SwapTileBoardToEmptyMove (BuilderView bView, BoardTile old, AbstractLevelModel lm) {
		// Commented builderView out for now, since it's not used for anything other than a null check
		if((bView == null) || (old == null) || (lm == null)) { 
			throw new RuntimeException("SwapTileBoardToReleaseMove::failed to initialize constructor inputs");
		}
		this.board = lm.getBoard();
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
		if(this.oldTile.getTileType().equals("board"))
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
