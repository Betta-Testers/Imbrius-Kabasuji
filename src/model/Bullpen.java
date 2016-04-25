package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @author awharrison
 * @author dfontana
 */
public class Bullpen implements Serializable{
	private static final long serialVersionUID = 354746744366050487L;

	/** playablePieces stores the piece groups that can be used in the game.**/
	ArrayList<PieceGroup> playablePieces = new ArrayList<PieceGroup>();
	
	/** selectedPiece stores what piece has been selected from the bullpen. **/
	transient Piece selectedPiece;

	/**
	 * A blank constructor for a Bullpen, like for Board, generates a clean slate
	 * for the builder to work with. In this case, a "clean slate" is all 35 pieces
	 * with 0 count to each. The order of pieces added is increasing, 1-35
	 */
	public Bullpen() {
		for(int i=1; i<=35; i++){
			this.playablePieces.add(new PieceGroup(i, 0));
		}
		sortBullpen();
	}

	/**
	 * Create a Bullpen containing a specified group of pieces.
	 * @param pieces - ArrayList<PieceGroup>
	 */
	public Bullpen(ArrayList<PieceGroup> pieces) {
		this.playablePieces.addAll(pieces);
		sortBullpen();
	}

	/**
	 * Create a Bullpen containing a specified number of random pieces.
	 * @param sizeOfBullpen - int
	 */
	public Bullpen(int sizeOfBullpen) {
		if (sizeOfBullpen < 0) {
			throw new RuntimeException("Cannot create a Bullpen with a negative number of pieces");
		}
		for(int i = 0; i < sizeOfBullpen; i++) {
			int randID = (new Random().nextInt(35))+1;
			PieceGroup result = getPieceGroupWithID(randID);
			if (result != null) {
				result.incrementCount();
			} else {
				this.playablePieces.add(new PieceGroup(randID, 1));
			}
		}
		sortBullpen(); // sort the bullpen by ID
	}
	
	/**
	 * Returns the piece group with the given ID. Returns null if PieceGroup is not found.
	 * @param ID - int
	 * @return pg (piece group linked to ID) - PieceGroup
	 */
	PieceGroup getPieceGroupWithID(int id) {
		for (PieceGroup pg : playablePieces) {
			if (pg.getPiece().getID() == id) {
				return pg;
			}
		}
		return null;
	}
	
	/**
	 * Adds a single random piece to the bullpen.
	 * Increments the count if that piece group exists.
	 * Adds the new piece group if it doesn't.
	 * @return the piece that was added - Piece
	 */
	public Piece addRandomPiece(){
		int randID = (new Random().nextInt(35))+1;
		PieceGroup result = getPieceGroupWithID(randID);
		if (result != null) {
			result.incrementCount();
			return result.getPiece();
		} else {
			PieceGroup added = new PieceGroup(randID, 1);
			this.playablePieces.add(added);
			return added.getPiece();
		}
	}
	
	/**
	 * Increments the count of the piece ID provided. If the piece exists,
	 * true is returned. If the piece could not be found, false is returned.
	 * @param id (the piece ID whose count is being incremented) - int
	 * @return if the PieceGroup could be incremented - boolean
	 */
	public boolean incrementPiece(int id) {
		PieceGroup pg = getPieceGroupWithID(id);
		if (pg != null) {
			pg.incrementCount();
			return true;
		} else {
			throw new RuntimeException("Attempted to increment non-existant pieceGroup");
		}
	}
	
	/**
	 * Decrements the count of the piece ID provided. If the piece exists,
	 * true is returned. If the piece could not be found, false is returned.
	 * This is used for undoing a RemoveAllPieces move.
	 * @param id (the piece ID whose count is being decremented) - int
	 * @return if the PieceGroup could be decremented - boolean
	 */
	public boolean decrementPiece(int id) {
		PieceGroup pg = getPieceGroupWithID(id);
		if(pg != null){
			pg.decrementCount();
			return true;
		}else{
			throw new RuntimeException("Attempted to decrement non-existant pieceGroup");
		}
	}
	
	/**
	 * Return this bullpen's playable pieces.
	 * @return playablePieces - ArrayList<PieceGroup>
	 */
	public ArrayList<PieceGroup> getPlayablePieces() {
		return this.playablePieces;
	}

	/**
	 * Return this bullpen's selected piece.
	 * @return selectedPiece - Piece.
	 */
	public Piece getSelectedPiece() {
		return this.selectedPiece;
	}

	/**
	 * Sets the selected piece from the bullpen using a given ID. Returns true if the piece is available, false if not.
	 * @return if piece was available - boolean
	 */
	public boolean setSelectedPiece(int ID) {
		for(int i = 0; i < this.playablePieces.size(); i++) {
			if(this.playablePieces.get(i).getPiece().ID == ID && this.playablePieces.get(i).getNumPieces() > 0) {
				this.selectedPiece = this.playablePieces.get(i).getPiece();
				return true; // do not need to sort as removing a single piece from a sorted list still remains sorted
			}
		}
		return false;
	}

	/**
	 * Clears the selectedPiece attribute.
	 */
	public void clearSelectedPiece() {
		this.selectedPiece = null;
	}

	/**
	 * Returns the number of pieces available in the bullpen.
	 * @return count - int
	 */
	public int numAvailablePieces() {
		int count = 0;
		for(int i = 0; i < this.playablePieces.size(); i++) {
			count += this.playablePieces.get(i).numPieces;
		}
		return count;
	}

	/**
	 * Returns true if the bullpen is empty, false if it is not empty.
	 * @return if bullpen is empty - boolean
	 */
	public boolean isEmpty() {
		return (this.playablePieces.size() == 0);
	}

	/**
	 * Sorts the Bullpen pieceGroups in ascending order by ID.
	 */
	public void sortBullpen() {
		Collections.sort(this.playablePieces);
	}
	
	/**
	 * Returns all toString() of the piecegroups that make up this bullpen.
	 * @return String representation of this bullpen - String
	 */
	public String toString(){
		StringBuilder s = new StringBuilder();
		for(PieceGroup pg: this.playablePieces){
			s.append(pg.toString());		
		}
		return s.toString();
	}
}
