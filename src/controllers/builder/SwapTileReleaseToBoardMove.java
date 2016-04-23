package controllers.builder;

import controllers.common.Move;
import model.AbstractTile;
import model.Board;
import model.BoardTile;


/**
 * Move class for swapping a Release Tile to a Board Tile.
 * 
 * @author awharrison
 * @author dfontana
 */
public class SwapTileReleaseToBoardMove extends Move {
	/** Board in which the move is taking place **/
	Board board;
	
	/** The tile passed into the constructor. Should be a Release tile (this is checked) **/
	AbstractTile oldTile;
	
	/** The tile that is created to replace the oldTile **/
	BoardTile newTile;
	
	
	public  SwapTileReleaseToBoardMove(AbstractTile old, Board b) {
		this.board = b;
		this.oldTile = old;
	}
	
	/**
	 * The move creates a new board tile with same location as the old tile.
	 * It then swaps the old and new Tiles. 
	 * @return boolean - true if the move was successful
	 */
	@Override
	public boolean doMove() {
		if(isValid()) {
			this.newTile = new BoardTile(oldTile.getRow(), oldTile.getCol());
			board.swapTile(newTile);
			return true;
		}
		return false;
	}

	/**
	 * Checks if the tile passed in is a release tile.
	 * @return boolean - true if the move can be made
	 */
	@Override
	public boolean isValid() {
		if(this.oldTile.getTileType().equals("release"))
			return true;
		else
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
