package model;

import java.awt.Color;

public class PieceTile extends AbstractTile {
	//Piece piece;
	int colInPiece;
	int rowInPiece;
	public PieceTile(int row, int col, int rinPiece, int cInPiece) {
		super(row, col);
		this.tileType = "piece";
		//this.piece = p;
		//this.color = p.getColor();
		this.colInPiece = cInPiece;
		this.rowInPiece = rinPiece;
	}

}
