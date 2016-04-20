package controllers.builder;

import view.BuilderView;
import view.ReleaseNumberCreationView;
import controllers.common.Move;
import model.AbstractLevelModel;
import model.Board;
import model.BoardTile;
import model.ReleaseTile;

public class SwapTileBoardToReleaseMove extends Move {
	Board board;
	BoardTile oldTile;
	ReleaseTile newTile;
	ReleaseNumberCreationView rncv;
	
	public  SwapTileBoardToReleaseMove (BuilderView bView, BoardTile old, AbstractLevelModel lm) {
		if((bView == null) || (old == null) || (lm == null)) { 
			throw new RuntimeException("SwapTileBoardToReleaseMove::failed to initialize constructor inputs");
		}
		this.board = lm.getBoard();
		this.rncv = bView.getReleaseNumberView();
		this.oldTile = old;
	}
	
	@Override
	public boolean doMove() {
		if(isValid()) {
			this.newTile = new ReleaseTile(oldTile.getRow(), oldTile.getCol(), rncv.getNumberSelected(), rncv.getColorSelected());
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
		board.swapTile(oldTile);
		return true;
	}
	
	@Override 
	public boolean redo() {
		board.swapTile(newTile);
		return true;
	}

}
