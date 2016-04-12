package model;

import java.awt.Color;

public class PieceTile extends AbstractTile {

	public PieceTile(int row, int col, Color c) {
		super(row, col);
		this.color = c;
		this.tileType = "piece";
	}

}
