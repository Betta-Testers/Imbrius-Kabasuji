package controllers.builder;

import controllers.common.IMove;
import model.AbstractTile;
import model.Board;
import model.BoardTile;
import view.BoardView;
import view.LevelPropertiesView;

/**
 * Move class for the swapping of an empty tile to a board tile on the board.
 * 
 * @author awharrison
 * @author dfontana
 */
public class SwapTileEmptyToBoardMove implements IMove {
	/**Board whose tiles are being swapped in the move**/
	Board board;
	/**The tile who was clicked on to be swapped**/
	AbstractTile oldTile;
	/**The tile that was created to replace the oldTile**/
	BoardTile newTile;
	/** LevelPropertiesView whose tile count is affected by the move**/
	LevelPropertiesView lpv;
	/**Updates the view of the board**/
	BoardView bv;

	/**
	 * Constructs a empty to board move
	 * @param old - Tile clicked
	 * @param b - Board being modified
	 * @param lpv - LevelProperties view being updated
	 * @param bv - view of board being redrawn
	 */
	public SwapTileEmptyToBoardMove (AbstractTile old, Board b, LevelPropertiesView lpv, BoardView bv) {
		this.board = b;
		this.oldTile = old;
		this.lpv = lpv;
		this.bv = bv;
	}

	/**
	 * To do the move a new tile is generated at the location of the old tile.
	 * The new tile is then swapped with the old tile
	 * The levelpropertiesview then updates its tile count
	 * @return true if the move is done.
	 */
	@Override
	public boolean doMove() {
		if(isValid()) {
			this.newTile = new BoardTile(oldTile.getRow(), oldTile.getCol());
			board.swapTile(newTile); // may want to throw runtime exception if this does not return a copy of the old tile
			lpv.adjustTileCount(1);
			
			//Redraw
			bv.redraw();
			bv.repaint();
			return true;
		}
		return false;
	}

	/**
	 * The move is valid if the tile type passed into the constructor is an empty tile
	 * @return true if the move can be done
	 */
	@Override
	public boolean isValid() {
		if(oldTile.getTileType().equals("empty")){return true;}
		return false;
	}

	/**
	 * Undoes the move by swapping the tiles back with one another and decrementing
	 * the tile count in the levelPropertiesView.
	 * @return true
	 */
	@Override
	public boolean undo() {
		board.swapTile(oldTile);
		lpv.adjustTileCount(-1);
		
		//Redraw
		bv.redraw();
		bv.repaint();
		return true;
	}

	/**
	 * Redoes the move by swapping the tiles again, and adjusting the the tile count 
	 * int the levelPropertiesView
	 * @return true
	 */
	@Override 
	public boolean redo() {
		board.swapTile(newTile);
		lpv.adjustTileCount(1);
		
		//Redraw
		bv.redraw();
		bv.repaint();
		return true;
	}
}
