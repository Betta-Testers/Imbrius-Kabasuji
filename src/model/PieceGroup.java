package model;

public class PieceGroup {
	/**
	 * @author awharrison
	 */
	Piece piece;
	int numPieces;
	
	/**
	 * create a PieceGroup consisting of a piece with the given ID and the quantity of those pieces available
	 * @param ID
	 * @param count
	 */
	public PieceGroup(int ID, int count) {
		this.piece = new Piece(ID);
		this.numPieces = count;
	}
	
	/**
	 * increase the number of pieces by 1
	 * @return
	 */
	public boolean incrementCount() {
		this.numPieces++;
		return true;
	}
	/**
	 * decrease the number of pieces by 1
	 * @return
	 */
	public boolean decrementCount() {
		if(this.numPieces <= 0) {
			return false;
		} else {
			this.numPieces--;
			return true;
		}
	}
	
	/**
	 * returns the piece type of this group
	 * @return
	 */
	public Piece getPiece() {
		return this.piece;
	}
	
	/**
	 * returns the number of pieces available
	 * @return
	 */
	public int getNumPieces() {
		return this.numPieces;
	}
}
