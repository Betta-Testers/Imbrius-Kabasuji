package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @author awharrison
 */
public class Bullpen implements Serializable{
	private static final long serialVersionUID = 354746744366050487L;
	
	ArrayList<PieceGroup> playablePieces = new ArrayList<PieceGroup>();
	transient Piece selectedPiece;
	
	/**
	 * A blank constructor for a Bullpen, like for Board, generates a clean slate
	 * for the builder to work with. In this case, a "clean slate" is all 35 pieces
	 * with 0 count to each. The order of pieces added is increasing, 1-35
	 * @author Dylan
	 */
	public Bullpen() {
		for(int i=1; i<=35; i++){
			this.playablePieces.add(new PieceGroup(i, 0));
		}
	}
	
	/**
	 * Create a Bullpen containing a specified group of pieces
	 * @param pieces
	 */
	public Bullpen(ArrayList<PieceGroup> pieces) {
		this.playablePieces.addAll(pieces);
		sortBullpen();
	}
	
	/**
	 * Create a Bullpen containing a specified number of random pieces
	 * @param sizeOfBullpen
	 */
	public Bullpen(int sizeOfBullpen) {
		if (sizeOfBullpen < 0) {
			throw new RuntimeException("Cannot create a Bullpen with a negative number of pieces");
		}
		for(int i = 0; i < sizeOfBullpen; i++) {
			this.playablePieces.add(new PieceGroup(1+(new Random().nextInt(35)), 1));
		}
		sortBullpen(); // sort the bullpen by ID
	}
	

	/**
	 * Add a specified number of random pieces to this bullpen
	 * @param numPieces
	 */
	public void addRandomPieces(int numPieces) {
		if (numPieces < 0) {
			throw new RuntimeException("Cannot add a negative number of pieces to the Bullpen");
		}
		for(int i = 0; i < numPieces; i++) {
			this.playablePieces.add(new PieceGroup(new Random().nextInt(35), 1));
		}
		sortBullpen(); // sort the bullpen by ID
	}
	
	/**
	 * remove a piece has the given ID from this bullpen's playable pieces
	 * @param ID
	 */
	public boolean removeSinglePiece(int ID) {
		for(int i = 0; i < this.playablePieces.size(); i++) {
			if(this.playablePieces.get(i).getPiece().ID == ID) {
				this.playablePieces.remove(i);
				return true; // do not need to sort as removing a single piece from a sorted list still remains sorted
			}
		}
		return false;
	}
	
	/**
	 * add the piece with the given piece ID to the collection of playable pieces 
	 * @param ID
	 */
	public void addSinglePiece(int ID) {
		PieceGroup newPieceGroup = new PieceGroup(ID, 1);
		this.playablePieces.add(newPieceGroup);
		sortBullpen(); // sort the bullpen after adding a pieceGroup to keep ordering by ID
	}
	
	/**
	 * returns the number of pieces available in the bullpen
	 * @return
	 */
	public int numAvailablePieces() {
		int count = 0;
		for(int i = 0; i < this.playablePieces.size(); i++) {
			count += this.playablePieces.get(i).numPieces;
		}
		return count;
	}
	
	/**
	 * returns true if the bullpen is empty, false if it is not empty
	 * @return
	 */
	public boolean isEmpty() {
		return (this.playablePieces.size() == 0);
	}
	
	/**
	 * sorts the Bullpen pieceGroups in ascending order by ID
	 */
	public void sortBullpen() {
		Collections.sort(this.playablePieces);
	}
	
	/**
	 * return this bullpen's playable pieces
	 * @return
	 */
	public ArrayList<PieceGroup> getPlayablePieces() {
		return this.playablePieces;
	}
	
	/**
	 * return this bullpen's selected piece
	 * @return
	 */
	public Piece getSelectedPiece() {
		return this.selectedPiece;
	}

	/**
	 * sets the selected piece from the bullpen using a given ID
	 * returns true if the piece is available, false if not
	 * @return
	 */
	public boolean setSelectedPiece(int ID) {
		for(int i = 0; i < this.playablePieces.size(); i++) {
			if(this.playablePieces.get(i).getPiece().ID == ID) {
				this.selectedPiece = this.playablePieces.get(i).getPiece();
				return true; // do not need to sort as removing a single piece from a sorted list still remains sorted
			}
		}
		return false;
	}
	
	/**
	 * nulls the selectedPiece attribute
	 */
	public void clearSelectedPiece() {
		this.selectedPiece = null;
	}
	
	/**
	 * decrements the number of pieces in the selected pieceGroup by 1
	 */
	public void decrementSelectedPiece() {
		this.playablePieces.get(this.selectedPiece.getID()).decrementCount();
	}
}
