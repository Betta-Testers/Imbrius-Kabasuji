package model;

import java.awt.Color;

/**
 * 
 * @author hejohnson
 *
 */

public class PieceTile extends AbstractTile {
	Piece piece;
	int colInPiece;
	int rowInPiece;
	AbstractTile previousTile;
	
	//TODO update when piece entity exists, including comments. Do we need to store the position within the piece?
	
	/**
	 * Create a piece tile, which is a part of a specified piece (once that is implemented)
	 * @param row Tile's row on the board
	 * @param col Tile's column on the board
	 * @param rinPiece Tile's row within the piece (can be negative)
	 * @param cInPiece Tile's column within the piece (can be negative)
	 */
<<<<<<< HEAD
	public PieceTile(int row, int col, Piece p) {
=======
	public PieceTile(int row, int col, AbstractTile previousTile) {
>>>>>>> refs/remotes/origin/Tiles
		super(row, col);
		this.tileType = "piece";
		this.piece = p;
		this.color = p.getColor();
		this.previousTile = previousTile;
		
		if (p.getOrigin() == null) {
			this.colInPiece = 0;
			this.rowInPiece = 0;
			this.rowOnBoard = row;
			this.colOnBoard = col;
			p.setOrigin(this);
		} else {
			this.rowInPiece = row;
			this.colInPiece = col;
			this.rowOnBoard = p.getOriginRow() + rowInPiece;
			this.colOnBoard = p.getOriginCol() + colInPiece;
		}
		
	}
	
	public int getRow() {
		return this.rowOnBoard;
	}
	
	public int getCol() {
		return this.colOnBoard;
	}
	
	public int getRowInPiece() {
		return this.rowInPiece;
	}
	
	public int getColInPiece() {
		return this.colInPiece;
	}
	
	public void updateRowInPiece(int newRow) {
		if (piece.getOrigin() == this) {
			throw new RuntimeException("Can't update relative position of the origin tile");
			
			//return; --> shouldn't need this with run time exception
		}
		this.rowInPiece = newRow;
		updateBoardPosition();
	}
	
	public void updateColInPiece(int newCol) {
		if (piece.getOrigin() == this) {
			throw new RuntimeException("Can't update relative position of the origin tile");
			
			//return; --> shouldn't need this with run time exception
		}
		this.colInPiece = newCol;
		updateBoardPosition();
	}
	
	public void updateBoardPosition() {
		this.colOnBoard = piece.getOriginCol() + this.colInPiece;
		this.rowOnBoard = piece.getOriginRow() + this.rowInPiece;
	}
	
	public AbstractTile getPreviousTile() {
		return this.getPreviousTile();
	}

}
