package controllers.builder;

import view.ReleaseNumberCreationView;
import controllers.common.Move;
import model.AbstractTile;
import model.Board;
import model.ReleaseTile;

/**
 * Move class for swapping a Board Tile to Release Tile.
 * 
 * @author awharrison
 * @author dfontana
 */
public class SwapTileBoardToReleaseMove extends Move {
	/** Board in which the move is taking place **/
	Board board;

	/** Used to find the color and number selected when making a new release tile**/
	ReleaseNumberCreationView rncv;

	/** The tile passed into the constructor. Should be a board tile (this is checked) **/
	AbstractTile oldTile;

	/** The tile that is created to replace the oldTile **/
	ReleaseTile newTile;


	public  SwapTileBoardToReleaseMove (ReleaseNumberCreationView rncv, AbstractTile old, Board b) {
		this.board = b;
		this.rncv = rncv;
		this.oldTile = old;
	}

	/**
	 * The move creates a new Release tile with same location as the old tile and the current selected number/color.
	 * It then swaps the old and new Tiles. 
	 * @return boolean - true if the move was successful
	 */
	@Override
	public boolean doMove() {
		if(isValid()) {
			this.newTile = new ReleaseTile(oldTile.getRow(), oldTile.getCol(), rncv.getNumberSelected(), rncv.getColorSelected());
			board.swapTile(newTile); // may want to throw runtime exception if this does not return a copy of the old tile
			return true;
		}
		return false;
	}

	/**
	 * Checks if the tile passed in is a board tile.
	 * @return boolean - true if the move can be made
	 */
	@Override
	public boolean isValid() {
		if(this.oldTile.getTileType().equals("board")){return true;}
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
