package model;

import java.util.ArrayList;
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
	}
	
	/**
	 * Create a Bullpen containing a specified number of random pieces
	 * @param sizeOfBullpen
	 */
	public Bullpen(int sizeOfBullpen) {
		for(int i = 0; i < sizeOfBullpen; i++) {
			this.playablePieces.add(new PieceGroup(new Random().nextInt(36), 0));
		}
	}
	
	/**
	 * Add a specified number of random pieces to this bullpen
	 * @param numPieces
	 */
	public void addRandomPieces(int numPieces) {
		for(int i = 0; i < numPieces; i++) {
			this.playablePieces.add(new PieceGroup(new Random().nextInt(36), 1));
		}
	}
	
	/**
	 * remove a piece has the given ID from this bullpen's playable pieces
	 * @param ID
	 */
	public void removeSinglePiece(int ID) {
		int temp;
		for(int i = 0; i < this.playablePieces.size(); i++) {
			if(this.playablePieces.get(i).piece.ID == ID) {
				this.playablePieces.remove(i);
				break;
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
}
