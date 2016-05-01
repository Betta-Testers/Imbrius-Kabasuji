package controllers.builder;

import controllers.common.IMove;
import model.AbstractTile;
import model.Board;
import model.EmptyTile;
import view.BoardView;
import view.LevelPropertiesView;

/**
 * Move class for swapping a Board Tile to an Empty Tile in the builder.
 * @author awharrison
 * @author dfontana
 */
public class SwapTileBoardToEmptyMove implements IMove {
	/** Board in which the move is taking place **/
	Board board;
	/** The tile passed into the constructor. Should be a board tile (this is checked) **/
	AbstractTile oldTile;
	/** The tile that is created to replace the oldTile **/
	EmptyTile newTile;
	/** LevelPropertiesView whose tile count is affected by the move**/
	LevelPropertiesView lpv;
	/**Updates the view of the board**/
	BoardView bv;
	
	/**
	 * Constructor to make a board to empty tile move.
	 * @param old - tile that is being replaced by the move
	 * @param b - board being modified
	 * @param lpv - levelPropertiesView whose tile count is being updated
	 * @param bv - view of board being redrawn
	 */
	SwapTileBoardToEmptyMove (AbstractTile old, Board b, LevelPropertiesView lpv, BoardView bv) {
		this.board = b;
		this.oldTile = old;
		this.lpv = lpv;
		this.bv = bv;
	}
	
	/**
	 * The move creates a new empty tile with same location as the old tile.
	 * It then swaps the old and new Tiles. 
	 * Decrements the tile count in the levelPropertiesView
	 * @return boolean - true if the move was successful
	 */
	@Override
	public boolean doMove() {
		if(isValid()) {
			this.newTile = new EmptyTile(oldTile.getRow(), oldTile.getCol());
			board.swapTile(newTile);
			lpv.adjustTileCount(-1);
			
			//Redraw
			bv.redraw();
			bv.repaint();
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

	/**
	 * Undoes the move by swapping the replacing tile with the old, original tile.
	 * Also adjusts the tile count to be +1.
	 * @return true if the undo was completed
	 */
	@Override
	public boolean undo() {
		board.swapTile(oldTile);
		lpv.adjustTileCount(1);
		
		//Redraw
		bv.redraw();
		bv.repaint();
		return true;
	}
	
	/**
	 * Redoes the move, by swapping the tile from the board with the new tile generated in the original move.
	 * Decrements the tile count.
	 * @return true if the redo succeeds
	 */
	@Override 
	public boolean redo() {
		board.swapTile(newTile);
		lpv.adjustTileCount(-1);
		
		//Redraw
		bv.redraw();
		bv.repaint();
		return true;
	}
}
