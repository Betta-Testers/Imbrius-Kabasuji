package model;

import java.awt.Color;

public abstract class AbstractTile {
	int rowOnBoard;
	int colOnBoard;
	String tileType;
	Color color;
	
	public AbstractTile (int row, int col) {
		this.rowOnBoard = row;
		this.colOnBoard = col;
	}
	
	public String toString() {
		return this.tileType;
	}
}
