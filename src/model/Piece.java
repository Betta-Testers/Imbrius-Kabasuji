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
	
	
	
	
	PieceTile[] tiles = new PieceTile[6];
	int ID;
	PieceTile origin;
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
	
	Color getColor(){
		return color;
	}
	
	PieceTile getOrigin(){
		return origin;
	}
	
	int getOriginRow(){
		return origin.rowInPiece;
	}
	
	int getOriginCol(){
		return origin.colInPiece;
	}
	
	void setOrigin(PieceTile origin){
		this.origin = origin;
	}
	
	protected void generatePiece(int ID) throws RuntimeException{
		switch(ID){
		case 0:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(0, 2, this);
			tiles[3] = new PieceTile(0, 3, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			break;
		case 1:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(0, 2, this);
			tiles[3] = new PieceTile(1, 2, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			break;
		case 2:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(0, 2, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			break;
		case 3:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(0, 2, this);
			tiles[3] = new PieceTile(1, 0, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			break;
		case 4:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(1, 2, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			break;
		case 5:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(1, 0, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			break;
		case 6:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(1, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			break;
		case 7:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(1, -2, this);
			break;
		case 8:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 0, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(1, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			break;
		case 9:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(2, 1, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			break;
		case 10:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 0, this);
			tiles[3] = new PieceTile(2, 0, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			break;
		case 11:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(-1, 1, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			break;
		case 12:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(-1, 0, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			break;
		case 13:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(-1, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			break;
		case 14:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(-1, -2, this);
			break;
		case 15:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 0, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(-1, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			break;
		case 16:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 0, this);
			tiles[3] = new PieceTile(-1, 0, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			break;
		case 17:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(2, 0, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			break;
		case 18:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(0, -2, this);
			tiles[5] = new PieceTile(1, -2, this);
			break;
		case 19:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(1, 2, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			break;
		case 20:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(1, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			break;
		case 21:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(0, 1, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(1, -1, this);
			break;
		case 22:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(-1, 0, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			break;
		case 23:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(-1, 1, this);
			tiles[4] = new PieceTile(0, 1, this);
			tiles[5] = new PieceTile(0, -1, this);
			break;
		case 24:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(-1, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			break;
		case 25:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(-1, 0, this);
			tiles[4] = new PieceTile(-1, -1, this);
			tiles[5] = new PieceTile(-1, -2, this);
			break;
		case 26:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(-1, 0, this);
			tiles[4] = new PieceTile(-1, -1, this);
			tiles[5] = new PieceTile(-1, -2, this);
			break;
		case 27:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(2, 1, this);
			tiles[4] = new PieceTile(2, 0, this);
			tiles[5] = new PieceTile(0, -1, this);
			break;
		case 28:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(-1, 0, this);
			tiles[4] = new PieceTile(-1, 1, this);
			tiles[5] = new PieceTile(-1, -1, this);
			break;
		case 29:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(-1, 0, this);
			tiles[4] = new PieceTile(-1, 1, this);
			tiles[5] = new PieceTile(0, -1, this);
			break;
		case 30:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(-1, -1, this);
			tiles[5] = new PieceTile(-1, -2, this);
			break;
		case 31:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(-1, 0, this);
			tiles[2] = new PieceTile(-1, 1, this);
			tiles[3] = new PieceTile(-1, -1, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(1, -1, this);
			break;
		case 32:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 0, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(-1, 0, this);
			tiles[5] = new PieceTile(-1, -1, this);
			break;
		case 33:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(-1, 0, this);
			tiles[5] = new PieceTile(-1, -1, this);
			break;
		case 34:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(-1, -1, this);
			tiles[5] = new PieceTile(-1, -2, this);
			break;
		default:
			throw new RuntimeException("Incorrect ID");
		}
		
	}
	
}
