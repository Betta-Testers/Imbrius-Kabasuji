package model;

import java.awt.Color;
import java.io.Serializable;

/**
 * Extends AbstractTile, represents a tile that has been covered during lightning level gameplay.
 * @author hejohnson
 *
 */

public class LightningTile extends AbstractTile implements Serializable{
	private static final long serialVersionUID = -3635072059517548496L;

	/**
	 * Creates LightningTile at a given location (row column coordinates).
	 * @param row - int
	 * @param col - int
	 */
	public LightningTile(int row, int col) {
		super(row, col);
		this.color = Color.BLUE;
		this.defaultColor = color;
		this.tileType = "lightning";
	}

}
