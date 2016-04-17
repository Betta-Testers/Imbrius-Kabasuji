package model;

import java.awt.Color;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;


/**
 * @author ejbosia
 */

public class Piece implements Serializable{
	private static final long serialVersionUID = -5341675534216265771L;
	
	transient PieceTile[] tiles;
	int ID;
	Color color;
	public Piece(int ID){
		this.ID = ID;
		this.tiles = new PieceTile[6];
		generatePiece(ID);
	}
	
	
	/**
	 * Method used to break down Piece into a for saving
	 * @return String
	 */
	public String toString(){
		return tiles[0].toString() + "," + tiles[1].toString() + "," + tiles[2].toString() + "," +
				tiles[3].toString() + "," + tiles[4].toString() + "," + tiles[5].toString() + "," +
				ID + "," + tiles[0].toString() + "," + color.toString();
	}

	/**
	 * Method used to return ID of piece
	 * @return int
	 */
	
	public int getID(){
		return ID;
	}
	
	/**
	 * Method used to change orientation of the piece as if it was flipped vertically
	 */

	public void rotateLeft(){
		for (int i=1; i<6; i++) {
			PieceTile pt = tiles[1];
			int row = pt.getRowInPiece();
			int col = pt.getColInPiece();
			if (pt.getColInPiece() >= 0 && pt.getRowInPiece() >= 0) {
				pt.updateRowInPiece(-1*col);
				pt.updateColInPiece(row);
			} else if (pt.getColInPiece() >= 0 && pt.getRowInPiece() <= 0) {
				pt.updateRowInPiece(-1*col);
				pt.updateColInPiece(-1*row);
			} else if (pt.getColInPiece() <= 0 && pt.getRowInPiece() <= 0) {
				pt.updateRowInPiece(col);
				pt.updateColInPiece(row);
			} else if (pt.getColInPiece() <= 0 && pt.getRowInPiece() >= 0) {
				pt.updateRowInPiece(-1*col);
				pt.updateColInPiece(row);	
			}
		}
	}
	
	public void rotateRight(){
		for (int i=1; i<6; i++) {
			PieceTile pt = tiles[1];
			int row = pt.getRowInPiece();
			int col = pt.getColInPiece();
			if (pt.getColInPiece() >= 0 && pt.getRowInPiece() >= 0) {
				pt.updateRowInPiece(col);
				pt.updateColInPiece(-1*row);
			} else if (pt.getColInPiece() >= 0 && pt.getRowInPiece() <= 0) {
				pt.updateRowInPiece(col);
				pt.updateColInPiece(-1*row);
			} else if (pt.getColInPiece() <= 0 && pt.getRowInPiece() <= 0) {
				pt.updateRowInPiece(-1*col);
				pt.updateColInPiece(-1*row);
			} else if (pt.getColInPiece() <= 0 && pt.getRowInPiece() >= 0) {
				pt.updateRowInPiece(col);
				pt.updateColInPiece(row);
			}
		}
	}
	
	public void flipH(){
		for (int i=1; i<6; i++) {
			tiles[i].updateColInPiece(-1*tiles[i].getColInPiece());
		}
	}
	
	public void flipV(){
		for (int i=1; i<6; i++) {
			tiles[i].updateRowInPiece(-1*tiles[i].getRowInPiece());
		}
	}
	
	/**
	 * Method used to return color of piece
	 * @return Color
	 */
	Color getColor(){
		return color;
	}

	/** 
	 * Place piece on the board at specified location. Sets origin location and updates all component tiles
	 * @param row
	 * @param col
	 */
	public void setLocation(int row, int col) {
		this.tiles[0].setLocation(row, col);
		for (PieceTile pt : tiles) {
			pt.updateBoardPosition();
		}
	}
	
	/**
	 * Method used to get the column location of the origin
	 * @return int
	 */
	public int getOriginCol(){
		return tiles[0].getCol();
	}
	
	public int getOriginRow(){
		return tiles[0].getRow();
	}
	
	public PieceTile getOriginTile() {
		return tiles[0];
	}
	
	public ArrayList<AbstractTile> getPreviousTiles() {
		ArrayList<AbstractTile> prevTiles = new ArrayList<AbstractTile>();
		for (PieceTile p : tiles) {
			prevTiles.add(p.getPreviousTile());
		}
		return prevTiles;
	}
	
	public PieceTile[] getTiles() {
		return tiles;
	}
	
	/**
	 * When serializing a Piece, the pieceTile information is not needed. Instead of serializing those,
	 * the piece serializes it's ID. Then, when read it, it generates the tiles needed using the built
	 * in generatePiece() method.
	 * @param in
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException{
		in.defaultReadObject();
		this.tiles = new PieceTile[6];
		generatePiece(this.ID);
	}
	
	/**
	 * Method used for generating the correct tile placement of the piece given its ID
	 * @param int
	 * @throws RuntimeException
	 */
	protected void generatePiece(int ID) throws RuntimeException{
		switch(ID){
		case 1:
			color = new Color(240, 0, 0);
			tiles[0] = new PieceTile(0,0, this);
			tiles[1] = new PieceTile(1,0, this);
			tiles[2] = new PieceTile(2,0, this);
			tiles[3] = new PieceTile(3,0, this);
			tiles[4] = new PieceTile(-1,0, this);
			tiles[5] = new PieceTile(-2,0, this);
			break;
		case 2:
			color = new Color(240, 100, 100);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(2, 0, this);
			tiles[3] = new PieceTile(2, 1, this);
			tiles[4] = new PieceTile(-1, 0, this);
			tiles[5] = new PieceTile(-2, 0, this);
			break;
		case 3:
			color = new Color(240, 80, 0);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(2, 0, this);
			tiles[4] = new PieceTile(1, 0, this);
			tiles[5] = new PieceTile(-2, 0, this);
			break;
		case 4:
			color = new Color(240, 120, 0);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(2, 0, this);
			tiles[3] = new PieceTile(0, 1, this);
			tiles[4] = new PieceTile(-1, 0, this);
			tiles[5] = new PieceTile(-2, 0, this);
			break;
		case 5:
			color = new Color(240, 160, 0);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(2, 1, this);
			tiles[4] = new PieceTile(-1, 0, this);
			tiles[5] = new PieceTile(-2, 0, this);
			break;
		case 6:
			color = new Color(240, 200, 0);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(0, 1, this);
			tiles[4] = new PieceTile(-1, 0, this);
			tiles[5] = new PieceTile(-2, 0, this);
			break;
		case 7:
			color = new Color(240, 240, 0);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(-1, 0, this);
			tiles[4] = new PieceTile(-1, 1, this);
			tiles[5] = new PieceTile(-2, 0, this);
			break;
		case 8:
			color = new Color(200, 240, 0);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(-1, 0, this);
			tiles[4] = new PieceTile(-1, 0, this);
			tiles[5] = new PieceTile(-2, 1, this);
			break;
		case 9:
			color = new Color(160, 240, 0);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(0, 1, this);
			tiles[3] = new PieceTile(-1, 0, this);
			tiles[4] = new PieceTile(-1, 1, this);
			tiles[5] = new PieceTile(-2, 0, this);
			break;
		case 10:
			color = new Color(120, 240, 0);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(1, 2, this);
			tiles[4] = new PieceTile(-1, 0, this);
			tiles[5] = new PieceTile(-2, 0, this);
			break;
		case 11:
			color = new Color(120, 240, 0);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(0, 1, this);
			tiles[3] = new PieceTile(0, 2, this);
			tiles[4] = new PieceTile(-1, 0, this);
			tiles[5] = new PieceTile(-2, 0, this);
			break;
		case 12:
			color = new Color(80, 240, 0);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1,0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(1, -1, this);
			tiles[4] = new PieceTile(-1, 0, this);
			tiles[5] = new PieceTile(-2, 0, this);
			break;
		case 13:
			color = new Color(40, 240, 0);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(-1, 0, this);
			tiles[5] = new PieceTile(-2, 0, this);
			break;
		case 14:
			color = new Color(0, 240, 0);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(-1, 0, this);
			tiles[4] = new PieceTile(-1, -1, this);
			tiles[5] = new PieceTile(-2, 0, this);
			break;
		case 15:
			color = new Color(0, 240, 40);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(-1, 0, this);
			tiles[4] = new PieceTile(-2, 0, this);
			tiles[5] = new PieceTile(-2, -1, this);
			break;
		case 16:
			color = new Color(0, 240, 80);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 0, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(-1, -1, this);
			tiles[5] = new PieceTile(0, -2, this);
			break;
		case 17:
			color = new Color(0, 240, 80);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 0, this);
			tiles[3] = new PieceTile(-1, 0, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(-2, 0, this);
			break;
		case 18:
			color = new Color(0, 240, 160);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(0, 2, this);
			tiles[4] = new PieceTile(-1, 0, this);
			tiles[5] = new PieceTile(-2, 0, this);
			break;
		case 19:
			color = new Color(0, 240, 200);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(0, -2, this);
			tiles[5] = new PieceTile(1, -2, this);
			break;
		case 20:
			color = new Color(0, 240, 240);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(2, 1, this);
			tiles[4] = new PieceTile(-1, 0, this);
			tiles[5] = new PieceTile(-2, 0, this);
			break;
		case 21:
			color = new Color(0, 200, 240);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(-1, 0, this);
			tiles[4] = new PieceTile(-1, 1, this);
			tiles[5] = new PieceTile(-2, 0, this);
			break;
		case 22:
			color = new Color(0, 160, 240);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(1, 0, this);
			tiles[4] = new PieceTile(-1, 0, this);
			tiles[5] = new PieceTile(-1, 1, this);
			break;
		case 23:
			color = new Color(0, 120, 240);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(-1, 0, this);
			tiles[5] = new PieceTile(-2, 0, this);
			break;
		case 24:
			color = new Color(0, 80, 240);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(1, -1, this);
			tiles[4] = new PieceTile(1, 0, this);
			tiles[5] = new PieceTile(-1, 0, this);
			break;
		case 25:
			color = new Color(0, 40, 240);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(-1, 0, this);
			tiles[4] = new PieceTile(-1, -1, this);
			tiles[5] = new PieceTile(-2, 0, this);
			break;
		case 26:
			color = new Color(0, 0, 240);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(-1, -1, this);
			tiles[5] = new PieceTile(-2, -1, this);
			break;
		case 27:
			color = new Color(40, 0, 240);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(-1, -1, this);
			tiles[5] = new PieceTile(-2, -1, this);
			break;
		case 28:
			color = new Color(80, 0, 240);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(1, 2, this);
			tiles[4] = new PieceTile(0, 2, this);
			tiles[5] = new PieceTile(-1, 0, this);
			break;
		case 29:
			color = new Color(120, 0, 240);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(1, -1, this);
			tiles[5] = new PieceTile(-1, -1, this);
			break;
		case 30:
			color = new Color(160, 0, 240);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(-1, 0, this);
			tiles[4] = new PieceTile(1, -1, this);
			tiles[5] = new PieceTile(0, -1, this);
			break;
		case 31:
			color = new Color(200, 0, 240);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(-1, 0, this);
			tiles[4] = new PieceTile(-1, -1, this);
			tiles[5] = new PieceTile(-2, -1, this);
			break;
		case 32:
			color = new Color(240, 0, 240);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, -1, this);
			tiles[2] = new PieceTile(1, -1, this);
			tiles[3] = new PieceTile(-1, -1, this);
			tiles[4] = new PieceTile(-1, 0, this);
			tiles[5] = new PieceTile(-1, 1, this);
			break;
		case 33:
			color = new Color(240, 0, 200);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(0, 1, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(-1, 0, this);
			tiles[5] = new PieceTile(-1, -1, this);
			break;
		case 34:
			color = new Color(240, 0, 160);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(-1, 0, this);
			tiles[5] = new PieceTile(-1, -1, this);
			break;
		case 35:
			color = new Color(240, 0, 120);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(-1, 0, this);
			tiles[4] = new PieceTile(-1, -1, this);
			tiles[5] = new PieceTile(-2, -1, this);
			break;
		default:
			throw new RuntimeException("Incorrect ID");
		}
		
	}
	
}