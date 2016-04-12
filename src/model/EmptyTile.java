package model;

import java.awt.Color;

public class EmptyTile extends AbstractTile {

	public EmptyTile(int row, int col) {
		super(row, col);
		this.color = Color.LIGHT_GRAY;
		this.tileType = "empty";
	}
}
