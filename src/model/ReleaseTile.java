package model;

import java.awt.Color;

/**
 * 
 * @author hejohnson
 *
 */

public class ReleaseTile extends BoardTile {
	int value;
	Color colorSet;
	
	public ReleaseTile(int row, int col, int value, Color cs) {
		super(row, col);
		this.tileType = "release";
		this.value = value;
		this.colorSet = cs;
	}
	
	/**
	 * @return The color set that this tile is a part of (R/Y/G)
	 */
	public Color getColorSet () {
		return this.colorSet;
	}
	
	/**
	 * @return The number assigned to this tile within it's color set
	 */
	public int getNumber() {
		return this.value;
	}

}
