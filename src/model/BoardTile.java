package model;

import java.awt.Color;

/**
 * 
 * @author hejohnson
 *
 */

public class BoardTile extends AbstractTile{
	/**
	 * Create a BoardTile at the specified location on the board
	 * @param row
	 * @param col
	 */
	public BoardTile (int row, int col) {
		super(row, col);
		this.color = Color.WHITE;
		this.tileType = "board";
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
		this.color = Color.WHITE;
	}
}
