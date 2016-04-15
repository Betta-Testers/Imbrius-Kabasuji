package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Bullpen {
	/**
	 * @author awharrison
	 */
	ArrayList<PieceGroup> playablePieces;
	Piece selectedPiece;
	
	/**
	 * Create a Bullpen containing a specified group of pieces
	 * @param pieces
	 */
	public Bullpen(ArrayList<PieceGroup> pieces) {
		this.playablePieces = pieces;
		sortBullpen();
	}
	
	/**
	 * Create a Bullpen containing a specified number of random pieces
	 * @param sizeOfBullpen
	 */
	public Bullpen(int sizeOfBullpen) {
		for(int i = 0; i < sizeOfBullpen; i++) {
			this.playablePieces.add(new PieceGroup(new Random().nextInt(36), 1));
		}
		sortBullpen();; // sort the bullpen by ID
	}
	
	/**
	 * Add a specified number of random pieces to this bullpen
	 * @param numPieces
	 */
	public void addRandomPieces(int numPieces) {
		for(int i = 0; i < numPieces; i++) {
			this.playablePieces.add(new PieceGroup(new Random().nextInt(36), 1));
		}
		sortBullpen();; // sort the bullpen by ID
	}
	
	/**
	 * remove a piece has the given ID from this bullpen's playable pieces
	 * @param ID
	 */
	public void removeSinglePiece(int ID) {
		for(int i = 0; i < this.playablePieces.size(); i++) {
			if(this.playablePieces.get(i).piece.ID == ID) {
				this.playablePieces.remove(i);
				break; // do not need to sort as removing a single piece from a sorted list still remains sorted
			}
		}
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
		return this.playablePieces.size();
	}
	
	/**
	 * returns true if the bullpen is empty, false if it is not empty
	 * @return
	 */
	public boolean isEmpty() {
		return (this.playablePieces.size() == 0);
	}
	
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

	public boolean empty() {
		// TODO Auto-generated method stub
		return false;
	}
}
