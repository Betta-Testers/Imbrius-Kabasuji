package controllers.builder;

import controllers.common.IMove;
import model.AbstractTile;
import model.Board;
import model.BoardTile;
import view.BoardView;


/**
 * Move class for swapping a Release Tile to a Board Tile.
 * 
 * @author awharrison
 * @author dfontana
 */
public class SwapTileReleaseToBoardMove implements IMove {
	/** Board in which the move is taking place **/
	Board board;
	/** The tile passed into the constructor. Should be a Release tile (this is checked) **/
	AbstractTile oldTile;
	/** The tile that is created to replace the oldTile **/
	BoardTile newTile;
	/**Updates the view of the board**/
	BoardView bv;
	
	/**
	 * Creates the move
	 * @param old - tile that was clicked
	 * @param b - board whose tiles are being swapped
	 * @param bv - view of board being redrawn
	 */
	public  SwapTileReleaseToBoardMove(AbstractTile old, Board b, BoardView bv) {
		this.board = b;
		this.oldTile = old;
		this.bv = bv;
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
			
			//Redraw
			bv.redraw();
			bv.repaint();
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
		if(oldTile.getTileType().equals("release")){ return true;}
		return false;
	}

	/**
	 * Undoes the move by swapping the tiles
	 * @return true - the move can always be undone
	 */
	@Override
	public boolean undo() {
		board.swapTile(oldTile);
		
		//Redraw
		bv.redraw();
		bv.repaint();
		return true;
	}

	/**
	 * Redoes the move by swapping the tiles again
	 * @return true - the move can always be redone
	 */
	@Override 
	public boolean redo() {
		board.swapTile(newTile);
		
		//Redraw
		bv.redraw();
		bv.repaint();
		return true;
	}
}
