package model;

import java.util.ArrayList;
import java.util.Random;

public class Bullpen {
	ArrayList<PieceGroup> playablePieces;
	Piece selectedPiece;
	
	public Bullpen(ArrayList<PieceGroup> pieces) {
		this.playablePieces = pieces;
	}
	
	public Bullpen(int sizeOfBullpen) {
		for(int i = 0; i < sizeOfBullpen; i++) {
			this.playablePieces.add(new PieceGroup(new Random().nextInt(36), 0));
		}
	}

	public void addRandomPieces(int numPieces) {
		for(int i = 0; i < numPieces; i++) {
			this.playablePieces.add(new PieceGroup(new Random().nextInt(36), 1));
		}
	}
	
	public void removeSinglePiece(int ID) {
		int temp;
		for(int i = 0; i < this.playablePieces.size(); i++) {
			if(this.playablePieces.get(i).piece.ID == ID) {
				this.playablePieces.remove(i);
				break;
			}
		}
	}
	
	public void addSinglePiece(int ID) {
		PieceGroup newPieceGroup = new PieceGroup(ID, 1);
		this.playablePieces.add(newPieceGroup);
	}
}
