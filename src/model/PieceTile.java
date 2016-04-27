package model;

/**
 *  While AbstractTile implements serializable, A piece tile will never be serialized. The 
 *  Board removes all piece tiles before serialization.This is a limitation of the implementation
 *  and can't be avoided.
 * @author hejohnson
 *
 */
public class PieceTile extends AbstractTile{
	private static final long serialVersionUID = 2549208174449293357L; 
	
	/**Stores what piece the tile is a part of.**/
	Piece piece;
	
	/**Stores the relative column position of the tile within the piece, measured from the origin tile of the piece.**/
	int colInPiece;
	
	/**Stores the relative row position of the tile within the piece, measured from the origin tile of the piece.**/
	int rowInPiece;
	
	/**Stores the previous tile that the PieceTile was placed on.**/
	AbstractTile previousTile;
	
	/**
	 * Create a piece tile, which is a part of a specified piece. Sets tile location and color based off of Piece.
	 * @param row Tile's row on the board - int
	 * @param col Tile's column on the board - int
	 * @param rinPiece Tile's row within the piece (can be negative) - int
	 * @param cInPiece Tile's column within the piece (can be negative) - int
	 */
	public PieceTile(int row, int col, Piece p) {
		super(row, col);
		this.tileType = "piece";
		this.piece = p;
		
		if (p.getOriginTile() == null) {
			this.colInPiece = 0;
			this.rowInPiece = 0;
			this.rowOnBoard = row;
			this.colOnBoard = col;
		} else {
			this.rowInPiece = row;
			this.colInPiece = col;
			this.rowOnBoard = p.getOriginRow() + rowInPiece;
			this.colOnBoard = p.getOriginCol() + colInPiece;
		}
		
	}
	
	/**
	 * Sets the background colors of this piece (default and current)
	 */
	public void updateColor() {
		this.color = piece.getColor();
		this.defaultColor = color;
	}

	/**
	 * Returns the row of the tile relative to the origin in the Piece.
	 * @return rowInPiece - int
	 */
	public int getRowInPiece() {
		return this.rowInPiece;
	}
	
	/**
	 * Returns the column of the tile relative to the origin in the Piece.
	 * @return colInPiece - int
	 */
	public int getColInPiece() {
		return this.colInPiece;
	}
	
	/**
	 * Updates the row position of the tile relative to the origin in the Piece.
	 * @int newRow - int
	 */
	public void updateRowInPiece(int newRow) {
		if (piece.getOriginTile() == this) {
			throw new RuntimeException("Can't update relative position of the origin tile");
		}
		this.rowInPiece = newRow;
		updateBoardPosition();
	}
	
	/**
	 * Updates the column position of the tile relative to the origin in the Piece.
	 * @int newCol - int
	 */
	public void updateColInPiece(int newCol) {
		if (piece.getOriginTile() == this) {
			throw new RuntimeException("Can't update relative position of the origin tile");
		}
		this.colInPiece = newCol;
		updateBoardPosition();
	}
	
	/**
	 * Updates the board position of the tile.
	 */
	public void updateBoardPosition() {
		this.colOnBoard = piece.getOriginCol() + this.colInPiece;
		this.rowOnBoard = piece.getOriginRow() + this.rowInPiece;
	}
	
	/**
	 * Sets the location of the tile. Will only work if the tile is the origin tile.
	 * @param row - int
	 * @param col - int
	 */
	public void setLocation(int row, int col) {
		if(piece.getOriginTile() == this) {
			this.rowOnBoard = row;
			this.colOnBoard = col;
		}
	}
	
	/**
	 * Returns the tile that this tile covered.
	 * @return previousTile - AbstractTile
	 */
	public AbstractTile getPreviousTile() {
		return this.previousTile;
	}
	
	/**
	 * Sets the tile that this tile covered.
	 * @param at - AbstractTile
	 */
	public void setPreviousTile(AbstractTile at) {
		this.previousTile = at;
	}
	
	/**
	 * Returns the piece that the tile is a part of.
	 * @return piece - Piece
	 */
	public Piece getPiece() {
		return this.piece;
	}
}
