package model;

import java.awt.Color;
import java.io.Serializable;

/**
 * 
 * @author hejohnson
 *
 */

public class BoardTile extends AbstractTile implements Serializable{
	private static final long serialVersionUID = 3175118024513838593L;

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
