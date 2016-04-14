package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Records the state of a bullpen for for persistent storage.
 * @author Dylan
 */
public class MomentoBullpen implements Serializable{
	/**
	 * Unique tag for momentos of this type on disk
	 */
	private static final long serialVersionUID = 5239958016301296619L;
	
	/**
	 * Stores all piece groups via their ID and count. This allows the ability to recreate them from a momento, without storing them in individual momentos.
	 * This does, however, mean needing to convert an arraylist to TreeMap. It comes with a benefit of being sorted, however.
	 */
	TreeMap<Integer, Integer> pieceGroups = new TreeMap<Integer, Integer>();

	/**
	 * Parameters that need to be stored are passed as copies and stored in
	 * local, package protected fields. This information can then later be
	 * reconstituted. 
	 * @param playablePieces is an arrayList of all playable PieceGroups of that bullpen
	 */
	public MomentoBullpen(ArrayList<PieceGroup> playablePieces) {
		for(PieceGroup p: playablePieces){
			pieceGroups.put(p.getPiece().getID(), p.getNumPieces());
		}
	}
}
