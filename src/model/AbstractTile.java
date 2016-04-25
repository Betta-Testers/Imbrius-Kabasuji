package model;

import java.awt.Color;
import java.io.Serializable;

/**
 * Abstract class governing tile creation. A tile is a single unit of a board and piece.
 * @author hejohnson
 *
 */

public abstract class AbstractTile implements Serializable{
	private static final long serialVersionUID = 6566817267314437128L;
	
	/**The row that the tile is located at on the board (0 based indexing)**/
	int rowOnBoard;
	/**The row that the tile is located at on the board (0 based indexing)**/
	int colOnBoard;
	/**The type of the tile. This value can be: 'board' 'empty' 'release' 'puzzle' 'lightning'**/
	String tileType;
	/**The color of the tile in its current state.**/
	Color color;
	/**The color of the tile as it wants to be by default.**/
	Color defaultColor;

	/**
	 * Abstract constructor for all types of tiles to use. Creates a tile at the specified location
	 * @param row Row on the board
	 * @param col Column on the board
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
	 * Returns the row this tile is located at on the board
	 * @return int >= 0 and < 12
	 */
	public int getRow() {
		return this.rowOnBoard;
	}
	
	/**
	 * Returns the col this tile is located at on the board
	 * @return int >= 0 and < 12
	 */
	public int getCol() {
		return this.colOnBoard;
	}
	
	/**
	 * Returns the current color of this tile
	 * @return Color object, of current state
	 */
	public Color getColor() {
		return this.color;
	}
	
	/**
	 * Returns the number displayed on this tile
	 * @return int representation of a tile. -1 if not a ReleaseTile
	 */
	public int getNumber() {
		return -1;
	}
	
	/**
	 * Changes the color of the tile if the tile's view is included in a piece flyby
	 * @param isValidLocation Set the color to reflect to the user if it is a valid placement
	 */
	public void setMouseOverColor(boolean isValidLocation) {
		if (isValidLocation) {
			this.color = Color.GREEN;
		} else {
			this.color = Color.RED;
		}
	}
	
	/**
	 * Resets the tile's color if it was mousedOver
	 */
	public void resetColor() {
		this.color = this.defaultColor;
	}
	
	/**
	 * @return the type of the tile
	 */
	public String getTileType() {
		return this.tileType;
	}
}
