package controllers.builder;

import controllers.common.Move;
import model.AbstractTile;
import model.Board;
import model.EmptyTile;

/**
 * Move class for swapping a Board Tile to an Empty Tile.
 * 
 * @author awharrison
 * @author dfontana
 */
public class SwapTileBoardToEmptyMove extends Move {
	/** Board in which the move is taking place **/
	Board board;
	
	/** The tile passed into the constructor. Should be a board tile (this is checked) **/
	AbstractTile oldTile;
	
	/** The tile that is created to replace the oldTile **/
	EmptyTile newTile;
	
	public SwapTileBoardToEmptyMove (AbstractTile old, Board b) {
		this.board = b;
		this.oldTile = old;
	}
	
	/**
	 * The move creates a new empty tile with same location as the old tile.
	 * It then swaps the old and new Tiles. 
	 * @return boolean - true if the move was successful
	 */
	@Override
	public boolean doMove() {
		if(isValid()) {
			this.newTile = new EmptyTile(oldTile.getRow(), oldTile.getCol());
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
		if(oldTile.getTileType().equals("board")){return true;}
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
