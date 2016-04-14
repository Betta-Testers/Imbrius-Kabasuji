package model;

import java.awt.Color;

/**
 * 
 * @author hejohnson
 *
 */

public class LightningTile extends AbstractTile {

	public LightningTile(int row, int col) {
		super(row, col);
		this.color = Color.GREEN;
		this.defaultColor = color;
		this.tileType = "lightning";
	}

}
