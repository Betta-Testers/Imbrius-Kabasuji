package controllers.builder;

import view.ReleaseNumberCreationView;
import controllers.common.Move;
import model.AbstractTile;
import model.Board;
import model.ReleaseTile;

/**
 * Represents the swap between one release tile another release tile
 * 
 * @author awharrison
 * @author Dylan
 *
 */
public class SwapTileReleaseToReleaseMove extends Move {
	Board board;
	AbstractTile oldTile;
	ReleaseTile newTile;
	ReleaseNumberCreationView rncv;
	
	public  SwapTileReleaseToReleaseMove (ReleaseNumberCreationView rncv, AbstractTile old, Board b) {
		this.board = b;
		this.rncv = rncv;
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
		if(oldTile.getTileType().equals("release")){return true;}
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
