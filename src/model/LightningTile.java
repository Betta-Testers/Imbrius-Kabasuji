package model;

import java.awt.Color;

public class LightningTile extends AbstractTile {

	public LightningTile(int row, int col) {
		super(row, col);
		this.color = Color.GREEN;
		this.tileType = "lightning";
	}

}
