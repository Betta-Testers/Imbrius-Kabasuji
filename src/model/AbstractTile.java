package model;

import java.awt.Color;
import java.io.Serializable;

/**
 * AbstractTile is the parent class for all variations of tiles.
 * @author hejohnson
 *
 */

public abstract class AbstractTile implements Serializable{
	private static final long serialVersionUID = 6566817267314437128L;
	
	/**The rowOnBoard of a tile is its row location on the board, with higher values farther down the board.**/
	int rowOnBoard;
	
	/**The colOnBoard of a tile is its column location on the board, with higher values farther to the right of the board.**/
	int colOnBoard;
	
	/**The tileType of a tile is determined by the subclasses of AbstractTile.**/
	String tileType;
	
	/**The color of a tile is determined by changes on the board.**/
	Color color;
	
	/**The default color of a tile is determined by the subclasses of AbstractTile.**/
	Color defaultColor;

	/**
	 * Abstract constructor for all types of tiles to use. Creates a tile at the specified location.
	 * @param row (row on the board) - int
	 * @param col (column on the board) - int
	 */
	public AbstractTile (int row, int col) {
		this.rowOnBoard = row;
		this.colOnBoard = col;
	}
	
	/**
	 * @return The type of tile (lowercase) followed by its row location followed by column location
	 */
	public String toString() {
		return this.tileType + " r:" + this.rowOnBoard + " c:" + this.colOnBoard;
	}
	
	/**
	 * Return the row location of the tile.
	 * @return rowOnBoard - int
	 */
	public int getRow() {
		return this.rowOnBoard;
	}
	
	/**
	 * Return the column location of the tile.
	 * @return colOnBoard - int
	 */
	public int getCol() {
		return this.colOnBoard;
	}
	
	/**
	 * Return the column location of the tile. Note that this is determined by the subclasses of abstractTile.
	 * @return color - Color
	 */
	public Color getColor() {
		return this.color;
	}
	
	/**
	 * Returns the number displayed on this tile. Because an abstractTile is not a releaseTile, -1 is returned.
	 * @return -1 - int
	 */
	public int getNumber() {
		return -1;
	}
	
	/**
	 * Changes the color of the tile if the tile's view is included in a piece flyby. The parameter isValidLocation determines what color the tile will be.
	 * @param isValidLocation - boolean
	 */
	public void setMouseOverColor(boolean isValidLocation) {
		if (isValidLocation) {
			this.color = Color.GREEN;
		} else {
			this.color = Color.RED;
		}
	}
	
	/**
	 * Resets the pieces color if it was mousedOver.
	 */
	public void resetColor() {
		this.color = this.defaultColor;
	}
	
	/**
	 * Returns the type of the tile. Note that this is determined by the subclasses of abstractTile.
	 * @return tileType - String
	 */
	public String getTileType() {
		return this.tileType;
	}
}
