package model;

import java.awt.Color;
import java.io.Serializable;

/**
 * Extends AbstractTile, represents a tile that can be covered by a piece during gameplay.
 * @author hejohnson
 *
 */

public class BoardTile extends AbstractTile implements Serializable{
	private static final long serialVersionUID = 3175118024513838593L;

	/**Stores if the tile is a hint.**/
	boolean isHint = false;
	
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
	
	/**
	 * Sets the tile's isHint attribute.
	 * @param isHint - boolean
	 */
	public void setHint(boolean isHint) {
		this.isHint = isHint;
		if (isHint) {
			this.defaultColor = Color.YELLOW;
		} else {
			this.defaultColor = Color.WHITE;
		}
	}
	
	/**
	 * Returns if the tile is a hint or not.
	 * @return isHint - boolean
	 */
	public boolean isHint() {
		return this.isHint;
	}

}
