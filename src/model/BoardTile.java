package model;

import java.awt.Color;

public class BoardTile extends AbstractTile{
	int rowOnBoard;
	int colOnBoard;
	String tileType;
	Color color;
	
	public BoardTile (int row, int col) {
		super(row, col);
		this.color = Color.WHITE;
		this.tileType = "board";
	}
	
	public void setMouseOverColor(boolean isValidLocation) {
		if (isValidLocation) {
			this.color = Color.GREEN;
		} else {
			this.color = Color.RED;
		}
	}
	
	public void resetColor() {
		this.color = Color.WHITE;
	}
}
