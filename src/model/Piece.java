package model;

import java.awt.Color;

public class Piece {
	
	/*
	 * TO DO
	 * 
	 * add toString for saving - look at group meeting notes 4/12
	 * add pieces based off of IDs
	 * add methods that takes in string and returns object with those values
	 */
	
	
	
	
	//PieceTile[] tiles = new PieceTile[6];
	int ID;
	//PieceTile origin;
	Color color;
	public Piece(int ID, Color color){
		this.ID = ID;
		this.color = color;
		generatePiece(ID);
	}
	
	//PieceTile getOrigin(){
	//	return origin;
	//}
	
	int getID(){
		return ID;
	}
	
	void rotateLeft(){
		
	}
	
	void rotateRight(){
		
	}
	
	void flipH(){
		
	}
	
	void flipL(){
		
	}
	
	private void generatePiece(int ID){
		switch(ID){
		case 0:
			tiles[0] = new PieceTile(/* row, col, rowinpiece, colinpiece, this */);
			tiles[1] = new PieceTile();
			tiles[2] = new PieceTile();
			tiles[3] = new PieceTile();
			tiles[4] = new PieceTile();
			tiles[5] = new PieceTile();
			origin = tile[3];
			break;
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			break;
		case 10:
			break;
		case 11:
			break;
		case 12:
			break;
		}
	}
	
}
