package model;

import java.awt.Color;

/**
 * 
 * @author hejohnson
 *
 */

public class PieceTile extends AbstractTile {
	//Piece piece;
	int colInPiece;
	int rowInPiece;
	
	/**
	 * Create a piece tile, which is a part of a specified piece (once that is implemented)
	 * @param row Tile's row on the board
	 * @param col Tile's column on the board
	 * @param rinPiece Tile's row within the piece (can be negative)
	 * @param cInPiece Tile's column within the piece (can be negative)
	 */
	public PieceTile(int row, int col, int rinPiece, int cInPiece) {
		super(row, col);
		this.tileType = "piece";
		//this.piece = p;
		//this.color = p.getColor();
		this.colInPiece = cInPiece;
		this.rowInPiece = rinPiece;
	}

}
