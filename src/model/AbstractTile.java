package model;

import java.awt.Color;

/**
 * 
 * @author hejohnson
 *
 */

public abstract class AbstractTile {
	int rowOnBoard;
	int colOnBoard;
	String tileType;
	Color color;
	
	/**
	 * Abstract constructor for all types of tiles to use. Creates a tile at the specified location
	 * @param row Row on the board
	 * @param col Column on the board
	 */
	public AbstractTile (int row, int col) {
		this.rowOnBoard = row;
		this.colOnBoard = col;
	}
	
	/**
	 * @return The type of tile (lowercase)
	 */
	public String toString() {
		return this.tileType;
	}
	
	public int getRow() {
		return this.rowOnBoard;
	}
	
	public int getCol() {
		return this.colOnBoard;
	}
}
