package model;

import java.awt.Color;

public class ReleaseTile extends BoardTile {
	int value;
	Color colorSet;
	
	public ReleaseTile(int row, int col, int value, Color cs) {
		super(row, col);
		this.tileType = "release";
		this.value = value;
		this.colorSet = cs;
	}
	
	public Color getColorSet () {
		return this.colorSet;
	}
	
	public int getNumber() {
		return this.value;
	}

}
