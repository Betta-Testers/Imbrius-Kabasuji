package model;

import java.awt.Color;
import java.io.Serializable;

/**
 * 
 * @author hejohnson
 *
 */

public abstract class AbstractTile implements Serializable{
	private static final long serialVersionUID = 6566817267314437128L;
	
	int rowOnBoard;
	int colOnBoard;
	String tileType;
	Color color;
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
	 * @return The type of tile (lowercase)
	 */
	public String toString() {
		return this.tileType + " r:" + this.rowOnBoard + " c:" + this.colOnBoard;
	}
	
	public int getRow() {
		return this.rowOnBoard;
	}
	
	public int getCol() {
		return this.colOnBoard;
	}
	
	/**
	 * Get the number assigned to be displayed on the tile
	 * @return The number on the tile. -1 if no number;
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
	 * Resets the pieces color if it was mousedOver
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
	
	/**
	 * Returns the current color of the tile
	 * @return The color of the tile
	 */
	public Color getColor() {
		return this.color;
	}
}
