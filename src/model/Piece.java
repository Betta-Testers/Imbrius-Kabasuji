package model;

import java.awt.Color;


/*
 * @author ejbosia
 */

public class Piece {
	
	/*
	 * TO DO
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
	
	
	/**
	 * Method used to break down Piece into a for saving
	 * @param none
	 */
	public String toString(){
		return tiles[0].toString() + "," + tiles[1].toString() + "," + tiles[2].toString() + "," +
				tiles[3].toString() + "," + tiles[4].toString() + "," + tiles[5].toString() + "," +
				ID + "," + origin.toString() + "," + color.toString();
	}
	
	
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
	
	/**
	 * Method used to get the column location of the origin
	 * @return int
	 */
	int getOriginCol(){
		return origin.colInPiece;
	}
	
	/**
	 * Method used to set the origin of the piece
	 * @param PieceTile
	 */
	void setOrigin(PieceTile origin){
		this.origin = origin;
	}
	
	/**
	 * Method used for generating the correct tile placement of the piece given its ID
	 * @param int
	 * @throws RuntimeException
	 */
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
