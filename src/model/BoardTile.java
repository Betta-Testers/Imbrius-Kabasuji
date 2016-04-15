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
		this.defaultColor = color;
		this.tileType = "board";
	}
}
