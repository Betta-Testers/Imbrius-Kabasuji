package model;

public class PieceGroup {
	Piece piece;
	int numPieces;
	
	public PieceGroup(int ID, int count) {
		this.piece = new Piece(ID);
		this.numPieces = count;
	}
	
	boolean incrementCount() {
		this.numPieces++;
		return true;
	}
	
	boolean decrementCount() {
		if(this.numPieces <= 0) {
			return false;
		} else {
			this.numPieces--;
			return true;
		}
	}
}
