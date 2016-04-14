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
	public Piece(int ID){
		this.ID = ID;
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
	 * Place piece on the board at specified location. Sets origin location and updates all component tiles
	 * @param row
	 * @param col
	 */
	public void setLocation(int row, int col) {
		this.origin.setLocation(row, col);
		for (PieceTile p : tiles) {
			p.updateBoardPosition();
		}
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
			color = new Color(240, 0, 0);
			break;
		case 1:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(0, 2, this);
			tiles[3] = new PieceTile(1, 2, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			color = new Color(240, 100, 100);
			break;
		case 2:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(0, 2, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			color = new Color(240, 80, 0);
			break;
		case 3:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(0, 2, this);
			tiles[3] = new PieceTile(1, 0, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			color = new Color(240, 120, 0);
			break;
		case 4:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(1, 2, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			color = new Color(240, 160, 0);
			break;
		case 5:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(1, 0, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			color = new Color(240, 200, 0);
			break;
		case 6:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(1, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			color = new Color(240, 240, 0);
			break;
		case 7:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(1, -2, this);
			color = new Color(200, 240, 0);
			break;
		case 8:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 0, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(1, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			color = new Color(160, 240, 0);
			break;
		case 9:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(2, 1, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			color = new Color(120, 240, 0);
			break;
		case 10:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 0, this);
			tiles[3] = new PieceTile(2, 0, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			color = new Color(120, 240, 0);
			break;
		case 11:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(-1, 1, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			color = new Color(80, 240, 0);
			break;
		case 12:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(-1, 0, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			color = new Color(40, 240, 0);
			break;
		case 13:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(-1, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			color = new Color(0, 240, 0);
			break;
		case 14:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(-1, -2, this);
			color = new Color(0, 240, 40);
			break;
		case 15:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 0, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(-1, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			color = new Color(0, 240, 80);
			break;
		case 16:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 0, this);
			tiles[3] = new PieceTile(-1, 0, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			color = new Color(0, 240, 120);
			break;
		case 17:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(2, 0, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			color = new Color(0, 240, 160);
			break;
		case 18:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(0, -2, this);
			tiles[5] = new PieceTile(1, -2, this);
			color = new Color(0, 240, 200);
			break;
		case 19:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(1, 2, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			color = new Color(0, 240, 240);
			break;
		case 20:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(1, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			color = new Color(0, 200, 240);
			break;
		case 21:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(0, 1, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(1, -1, this);
			color = new Color(0, 160, 240);
			break;
		case 22:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(-1, 0, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			color = new Color(0, 120, 240);
			break;
		case 23:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(-1, 1, this);
			tiles[4] = new PieceTile(0, 1, this);
			tiles[5] = new PieceTile(0, -1, this);
			color = new Color(0, 80, 240);
			break;
		case 24:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(-1, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			color = new Color(0, 40, 240);
			break;
		case 25:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(-1, 0, this);
			tiles[4] = new PieceTile(-1, -1, this);
			tiles[5] = new PieceTile(-1, -2, this);
			color = new Color(0, 0, 240);
			break;
		case 26:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(-1, 0, this);
			tiles[4] = new PieceTile(-1, -1, this);
			tiles[5] = new PieceTile(-1, -2, this);
			color = new Color(40, 0, 240);
			break;
		case 27:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(2, 1, this);
			tiles[4] = new PieceTile(2, 0, this);
			tiles[5] = new PieceTile(0, -1, this);
			color = new Color(80, 0, 240);
			break;
		case 28:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(-1, 0, this);
			tiles[4] = new PieceTile(-1, 1, this);
			tiles[5] = new PieceTile(-1, -1, this);
			color = new Color(120, 0, 240);
			break;
		case 29:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(-1, 0, this);
			tiles[4] = new PieceTile(-1, 1, this);
			tiles[5] = new PieceTile(0, -1, this);
			color = new Color(160, 0, 240);
			break;
		case 30:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(-1, -1, this);
			tiles[5] = new PieceTile(-1, -2, this);
			color = new Color(200, 0, 240);
			break;
		case 31:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(-1, 0, this);
			tiles[2] = new PieceTile(-1, 1, this);
			tiles[3] = new PieceTile(-1, -1, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(1, -1, this);
			color = new Color(240, 0, 240);
			break;
		case 32:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 0, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(-1, 0, this);
			tiles[5] = new PieceTile(-1, -1, this);
			color = new Color(240, 0, 200);
			break;
		case 33:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(-1, 0, this);
			tiles[5] = new PieceTile(-1, -1, this);
			color = new Color(240, 0, 160);
			break;
		case 34:
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(-1, -1, this);
			tiles[5] = new PieceTile(-1, -2, this);
			color = new Color(240, 0, 120);
			break;
		default:
			throw new RuntimeException("Incorrect ID");
		}
		
	}
	
}
