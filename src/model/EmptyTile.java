package model;

import java.awt.Color;
import java.io.Serializable;

/**
 * Extends AbstractTile, represents a tile that cannot be covered by a piece during gameplay.
 * @author hejohnson
 *
 */

public class EmptyTile extends AbstractTile implements Serializable{
	private static final long serialVersionUID = -8744970312057997685L;

	/**
	 * Create EmptyTile at a given location (row column coordinates).
	 * @param row - int
	 * @param col - int
	 */
	public EmptyTile(int row, int col) {
		super(row, col);
		this.color = Color.LIGHT_GRAY;
		this.defaultColor = color;
		this.tileType = "empty";
	}
}
