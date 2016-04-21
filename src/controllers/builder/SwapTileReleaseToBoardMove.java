package controllers.builder;

import view.BuilderView;
import view.ReleaseNumberCreationView;
import controllers.common.Move;
import model.AbstractLevelModel;
import model.Board;
import model.BoardTile;
import model.ReleaseTile;

/**
 * Represents the swap between a release tile and a board tile
 * 
 * @author awharrison
 *
 */
public class SwapTileReleaseToBoardMove extends Move {
	Board board;
	ReleaseTile oldTile;
	BoardTile newTile;
	ReleaseNumberCreationView rncv;
	
	public  SwapTileReleaseToBoardMove (BuilderView bView, ReleaseTile old, AbstractLevelModel lm) {
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
			this.newTile = new BoardTile(oldTile.getRow(), oldTile.getCol());
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
		board.swapTile(oldTile);
		return true;
	}

	@Override 
	public boolean redo() {
		board.swapTile(newTile);
		return true;
	}
}
