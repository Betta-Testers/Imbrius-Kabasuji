package model;

import java.io.Serializable;

/**
 * @author awharrison
 */
public class PieceGroup implements Comparable<PieceGroup>, Serializable{
	private static final long serialVersionUID = 4819970575743912382L;
	
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
	 * allows collections of PieceGroup to be easily sorted
	 */
	public int compareTo(PieceGroup other) {
		return Integer.compare(this.getPiece().ID, other.getPiece().ID);
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
	
	public String toString(){
		return "ID:"+this.piece.getID();
	}
}
