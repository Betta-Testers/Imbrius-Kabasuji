package model;

import java.io.Serializable;

/**
 * Represents a group of one kind of piece. Used to keep track of how many of each piece can be used.
 * @author awharrison
 */
public class PieceGroup implements Comparable<PieceGroup>, Serializable{
	private static final long serialVersionUID = 4819970575743912382L;

	/**Stores the type of piece in the PieceGroup (each PieceGroup has one type of piece).**/
	Piece piece;
	
	/**Stores the number of pieces in the PieceGroup**/
	int numPieces;

	/**
	 * Creates a PieceGroup consisting of a piece with the given ID and the quantity of those pieces available
	 * @param ID - int
	 * @param count - int
	 */
	public PieceGroup(int ID, int count) {
		this.piece = PieceFactory.getInstance().getPiece(ID);
		this.numPieces = count;
	}

	/**
	 * Increases the number of pieces by 1
	 * @return true - boolean
	 */
	public boolean incrementCount() {
		this.numPieces++;
		return true;
	}
	/**
	 * Decreases the number of pieces by 1. If the number of pieces is 0 or lower, it does not decrement.
	 * @return if numPieces > 0 - boolean
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
	 * Allows collections of PieceGroup to be easily sorted.
	 * @returns comparison of IDs - int
	 */
	public int compareTo(PieceGroup other) {
		return Integer.compare(this.getPiece().ID, other.getPiece().ID);
	}

	/**
	 * Returns the piece type of this group.
	 * @return copy of piece - Piece
	 */
	public Piece getPiece() {
		return this.piece.makeCopy();
	}

	/**
	 * Returns the number of pieces available.
	 * @return numPieces - int
	 */
	public int getNumPieces() {
		return this.numPieces;
	}

	/**
	 * Checks if the ID of the inputted object is equal to the ID of the PieceGroup.
	 * @returns if the IDs are equal - boolean
	 */
	@Override
	public boolean equals(Object o){
		if(o == null){ return false;}
		if(o instanceof PieceGroup){
			if(this.piece.getID() == ((PieceGroup) o).getPiece().getID()){
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the string representation of the PieceGroup. Format: ID:Count.
	 * @return string representation of this piecegroup - String
	 */
	public String toString(){
		return "ID:"+this.piece.getID()+"Count:"+this.numPieces;
	}

	/**
	 * Sets the number of pieces within the PieceGroup.
	 * @param numPieces - int
	 */
	public void setCount(int numPieces) {
		this.numPieces = numPieces;
	}
}
