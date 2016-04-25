package model;

import java.awt.Color;
import java.io.Serializable;

/**
 * Extends BoardTile, represents the release number tile.
 * @author hejohnson
 *
 */

public class ReleaseTile extends BoardTile implements Serializable{
	private static final long serialVersionUID = 2811431284595128127L;
	
	/**Stores the numerical value (1-6) of the ReleaseTile. **/
	int value;
	
	/**Stores the color of the ReleaseTile. **/
	Color colorSet;
	
	/**
	 * Creates a new ReleaseTile.
	 * @param row (row location on board) - int
	 * @param col (col location on board) - int
	 * @param value (number associated to the ReleaseTile) - int
	 * @param cs (color associated to the ReleaseTile) - Color
	 */
	public ReleaseTile(int row, int col, int value, Color cs) {
		super(row, col);
		this.tileType = "release";
		this.value = value;
		this.colorSet = cs;
	}
	
	/**
	 * Returns the color associated to the tile.
	 * @return colorSet - Color
	 */
	public Color getColorSet () {
		return this.colorSet;
	}
	
	/**
	 * Returns the number associated to the tile.
	 * @return value - int
	 */
	@Override
	public int getNumber() {
		return this.value;
	}

}
