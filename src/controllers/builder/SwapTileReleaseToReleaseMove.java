package controllers.builder;

import view.ReleaseNumberCreationView;
import controllers.common.IMove;
import model.AbstractTile;
import model.Board;
import model.ReleaseTile;

/**
 * Move class for swapping a Release Tile to an Release Tile.
 * 
 * @author awharrison
 * @author dfontana
 */
public class SwapTileReleaseToReleaseMove implements IMove {
	/** Board in which the move is taking place **/
	Board board;
	
	/** Used to determine what color/number to use when making new release tile**/
	ReleaseNumberCreationView rncv;
	
	/** The tile passed into the constructor. Should be a board tile (this is checked) **/
	AbstractTile oldTile;
	
	/** The tile that is created to replace the oldTile **/
	ReleaseTile newTile;

	/**
	 * Creates the tile swap move
	 * @param rncv - View of the release tile creation
	 * @param old - tile that was clicked
	 * @param b - board whose tiles are being swapped
	 */
	public  SwapTileReleaseToReleaseMove (ReleaseNumberCreationView rncv, AbstractTile old, Board b) {
		this.board = b;
		this.rncv = rncv;
		this.oldTile = old;
	}
	
	/**
	 * The move creates a new Release tile with same location as the old tile.
	 * It then swaps the old and new Tiles. 
	 * @return boolean - true if the move was successful
	 */
	@Override
	public boolean doMove() {
		if(isValid()) {
			this.newTile = new ReleaseTile(oldTile.getRow(), oldTile.getCol(), rncv.getNumberSelected(), rncv.getColorSelected());
			board.swapTile(newTile); 
			return true;
		}
		return false;
	}

	/**
	 * Checks if the tile passed in is a Release tile.
	 * @return boolean - true if the move can be made
	 */
	@Override
	public boolean isValid() {
		if(oldTile.getTileType().equals("release")){return true;}
		return false;
	}

	/**
	 * Undoes the move by swapping the tiles back to the way they were
	 * @return true - the move can always be undone
	 */
	@Override
	public boolean undo() {
		board.swapTile(oldTile);
		return true;
	}
	
	/**
	 * Redoes the move by swapping the tiles again
	 * @return true - the move can always be redone
	 */
	@Override 
	public boolean redo() {
		board.swapTile(newTile);
		return true;
	}

}
