package controllers;

import model.AbstractLevelModel;
import model.Board;
import model.BoardTile;
import model.EmptyTile;
import view.BuilderView;

public class SwapTileBoardToEmptyMove extends Move {
	Board board;
	BoardTile oldTile;
	EmptyTile newTile;
	
	public SwapTileBoardToEmptyMove (BuilderView bView, BoardTile old, AbstractLevelModel lm) {
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
		// TODO is there anything that would make this invalid?
		return true;
	}

	@Override
	public boolean undo() {
		// TODO Auto-generated method stub
		return false;
	}
}
