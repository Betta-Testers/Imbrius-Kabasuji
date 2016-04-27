package model;

import java.awt.Color;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;


/**
 * @author ejbosia
 * @author hejohnson
 * @author dfontana
 */
public class Piece implements Serializable{
	private static final long serialVersionUID = -5341675534216265771L;
	
	/**Stores each tile that makes up the piece.*/
	transient ArrayList<PieceTile> tiles;
	
	/**Stores the ID of the piece.*/
	int ID;
	
	/**Stores the color of the piece.*/
	Color color;
	
	/**
	 * Creates a piece given an ID. Sets up color and distribution of tiles based off of the ID.
	 * @param ID - int
	 */
	public Piece(int ID){
		this.ID = ID;
		this.tiles = new ArrayList<PieceTile>();
		this.tiles.add(new PieceTile(0, 0, this));
		//generatePiece(ID);
	}
	
	/**
	 * @param c
	 */
	public void setColor(Color c) {
		this.color = c;
		for (PieceTile pt : tiles) {
			pt.updateColor();
		}
	}
	
	/**
	 * @param pt The piece tile to add
	 */
	public void addTile(PieceTile pt) {
		tiles.add(pt);
	}

	/**
	 * Returns the string representation of this piece.
	 * @return string representation of the piece - String
	 */
	@Override
	public String toString(){
		String out = "";
		for (PieceTile pt : tiles) {
			out = out.concat(pt.toString());
			out = out.concat(", ");
		}
		return out + ID + "," + color.toString();
	}
	
//	public String toString(){
//		return "[ID:"+ID+" "+ tiles[0].toString() + " " + tiles[1].toString() + " " + tiles[2].toString() + " " +
//				tiles[3].toString() + " " + tiles[4].toString() + " " + tiles[5].toString()+"]";
//	}

	/**
	 * Returns ID of this piece.
	 * @return ID - int
	 */
	public int getID(){
		return ID;
	}

	/**
	 * Changes orientation of the piece as if it was rotated counter-clockwise.
	 */
	public void rotateLeft(){
		for (PieceTile tile : tiles) {
			int row = tile.getRowInPiece();
			int col = tile.getColInPiece();
			tile.updateRowInPiece(-col);
			tile.updateColInPiece(row);
		}
	}

	/**
	 * Changes orientation of the piece as if it was rotated clockwise.
	 */
	public void rotateRight(){
		for (PieceTile tile : tiles) {
			int row = tile.getRowInPiece();
			int col = tile.getColInPiece();
			tile.updateRowInPiece(col);
			tile.updateColInPiece(-row);
		}
	}

	/**
	 * Changes orientation of the piece as if it was flipped horizontally.
	 */
	public void flipH(){
		for (PieceTile tile : tiles) {
			tile.updateColInPiece(-1*tile.getColInPiece());
		}
	}

	/**
	 * Changes orientation of the piece as if it was flipped horizontally.
	 */
	public void flipV(){
		for (PieceTile tile : tiles) {
			tile.updateRowInPiece(-1*tile.getRowInPiece());
		}
	}

	/**
	 * Returns color of this piece.
	 * @return color - Color
	 */
	Color getColor(){
		return color;
	}

	/**
	 * Returns a copy of the piece.
	 * @return new Piece with the same ID as this Piece - Piece
	 */
	public Piece makeCopy(){
		Piece p = new Piece(ID);
		for (PieceTile pt : this.tiles) {
			if (!(pt.rowInPiece == 0 && pt.colInPiece == 0)) {
				p.addTile(new PieceTile(pt.getRowInPiece(), pt.getColInPiece(), p));
			}
		}
		p.setColor(this.color);
		return p;
	}

	/** 
	 * Place piece on the board at specified location. Sets origin location and updates all component tiles.
	 * @param row - int
	 * @param col - int
	 */
	public void setLocation(int row, int col) {
		this.tiles.get(0).setLocation(row, col);
		for (PieceTile pt : tiles) {
			if (pt != tiles.get(0)) {
				pt.updateBoardPosition();
			}
		}
	}

	/**
	 * Returns the column location of the origin.
	 * @return column location of tiles[0] (origin) - int
	 */
	public int getOriginCol(){
		return tiles.get(0).getCol();
	}

	/**
	 * Returns the row location of the origin.
	 * @return row location of tiles[0] (origin) - int
	 */
	public int getOriginRow(){
		return tiles.get(0).getRow();
	}

	/**
	 * Returns the origin tile.
	 * @return tiles[0] (origin) - PieceTile
	 */
	public PieceTile getOriginTile() {
		if (tiles.size() == 0) {
			return null;
		}
		return tiles.get(0);
	}

	/**
	 * Returns the previous tiles.
	 * @return prevTiles - ArrayList<AbstractTile>
	 */
	public ArrayList<AbstractTile> getPreviousTiles() {
		ArrayList<AbstractTile> prevTiles = new ArrayList<AbstractTile>();
		for (PieceTile p : tiles) {
			prevTiles.add(p.getPreviousTile());
		}
		return prevTiles;
	}
	
	/**
	 * Returns the array of tiles that makes up the piece.
	 * @return tiles - PieceTile[]
	 */
	public ArrayList<PieceTile> getTiles() {
		return tiles;
	}
	/**
	 * Checks if two pieces are equals based on the coordinates of their tiles,
	 * not the actual tiles themselves.
	 * @param o - comparison piece
	 * @return true if the two have matching coordinates
	 */
	public boolean occupiesSameCoorindates(Piece o){
		for(PieceTile pt: this.getTiles()){
			for(int i = 0; i < o.getTiles().size(); i++){
				if(pt.getRow() == o.getTiles().get(i).getRow() && pt.getCol() == o.getTiles().get(i).getCol()){
					break;
				}else if(i ==  o.getTiles().size()-1){ //Entire second piece couldnt find tile with those coordinates
					return false;
				}
			}
		}
		return true;
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
		this.tiles = new ArrayList<PieceTile>();
		//generatePiece(this.ID);
	}

	/**
	 * Generates the correct tile placement of the piece given its ID. Also sets the color of the piece.
	 * @param ID - int
	 * @throws RuntimeException
	 */
	/*protected void generatePiece(int ID) throws RuntimeException{
		switch(ID){
		case 1:
			color = new Color(150, 100, 50);
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
			tiles[3] = new PieceTile(-2, 1, this);
			tiles[4] = new PieceTile(-1, 0, this);
			tiles[5] = new PieceTile(-2, 0, this);
			break;
		case 3:
			color = new Color(240, 80, 0);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(-1, 0, this);
			tiles[2] = new PieceTile(-1, 1, this);
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
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(-1, 1, this);
			tiles[3] = new PieceTile(-2, 1, this);
			tiles[4] = new PieceTile(-1, 0, this);
			tiles[5] = new PieceTile(2, 0, this);
			break;
		case 6:
			color = new Color(240, 200, 0);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(-1, 1, this);
			tiles[3] = new PieceTile(-2, 1, this);
			tiles[4] = new PieceTile(-1, 0, this);
			tiles[5] = new PieceTile(-2, 0, this);
			break;
		case 7:
			color = new Color(150, 160, 50);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(0, 1, this);
			tiles[3] = new PieceTile(-2, 1, this);
			tiles[4] = new PieceTile(-1, 0, this);
			tiles[5] = new PieceTile(-2, 0, this);
			break;
		case 8:
			color = new Color(200, 240, 0);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(-1, 0, this);
			tiles[4] = new PieceTile(-2, 0, this);
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
			color = new Color(255, 200, 255);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(-2, 0, this);
			tiles[2] = new PieceTile(-2, 1, this);
			tiles[3] = new PieceTile(-2, 2, this);
			tiles[4] = new PieceTile(-1, 0, this);
			tiles[5] = new PieceTile(1, 0, this);
			break;
		case 11:
			color = new Color(250, 200, 150);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(-2, 0, this);
			tiles[2] = new PieceTile(-1, 1, this);
			tiles[3] = new PieceTile(-1, 2, this);
			tiles[4] = new PieceTile(-1, 0, this);
			tiles[5] = new PieceTile(1, 0, this);
			break;
		case 12:
			color = new Color(80, 240, 0);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(-2, 0, this);
			tiles[2] = new PieceTile(-2, 1, this);
			tiles[3] = new PieceTile(-2, -1, this);
			tiles[4] = new PieceTile(-1, 0, this);
			tiles[5] = new PieceTile(1, 0, this);
			break;
		case 13:
			color = new Color(110, 40, 140);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(-2, 0, this);
			tiles[2] = new PieceTile(-2, 1, this);
			tiles[3] = new PieceTile(-1, -1, this);
			tiles[4] = new PieceTile(-1, 0, this);
			tiles[5] = new PieceTile(1, 0, this);
			break;
		case 14:
			color = new Color(255, 190, 255);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(-2, 0, this);
			tiles[2] = new PieceTile(-2, 1, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(-1, 0, this);
			tiles[5] = new PieceTile(1, 0, this);
			break;
		case 15:
			color = new Color(255, 192, 192);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, -1, this);
			tiles[3] = new PieceTile(-1, 0, this);
			tiles[4] = new PieceTile(-2, 0, this);
			tiles[5] = new PieceTile(-2, 1, this);
			break;
		case 16:
			color = new Color(190, 200, 255);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(0, -1, this);
			tiles[3] = new PieceTile(-1, 0, this);
			tiles[4] = new PieceTile(-2, 0, this);
			tiles[5] = new PieceTile(-1, 1, this);
			break;
		case 17:
			color = new Color(0, 240, 80);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(-1, 1, this);
			tiles[2] = new PieceTile(1, 0, this);
			tiles[3] = new PieceTile(-1, 0, this);
			tiles[4] = new PieceTile(-1	, -1, this);
			tiles[5] = new PieceTile(-2, 0, this);
			break;
		case 18:
			color = new Color(0, 240, 160);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(-1, 0, this);
			tiles[3] = new PieceTile(-1, 1, this);
			tiles[4] = new PieceTile(-1, 2, this);
			tiles[5] = new PieceTile(-2, 1, this);
			break;
		case 19:
			color = new Color(0, 240, 200);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(-1, 0, this);
			tiles[4] = new PieceTile(-1, 1, this);
			tiles[5] = new PieceTile(-2, 1, this);
			break;
		case 20:
			color = new Color(0, 240, 240);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(-1, 1, this);
			tiles[3] = new PieceTile(-2, 1, this);
			tiles[4] = new PieceTile(1, 0, this);
			tiles[5] = new PieceTile(2, 0, this);
			break;
		case 21:
			color = new Color(0, 200, 240);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(-1, 1, this);
			tiles[2] = new PieceTile(1, 0, this);
			tiles[3] = new PieceTile(-1, 0, this);
			tiles[4] = new PieceTile(0, 1, this);
			tiles[5] = new PieceTile(-2, 1, this);
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
			tiles[1] = new PieceTile(-1, 1, this);
			tiles[2] = new PieceTile(1, 0, this);
			tiles[3] = new PieceTile(-1, 0, this);
			tiles[4] = new PieceTile(-1, -1, this);
			tiles[5] = new PieceTile(-2, 1, this);
			break;
		case 24:
			color = new Color(0, 80, 240);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(-1, 1, this);
			tiles[2] = new PieceTile(1, 0, this);
			tiles[3] = new PieceTile(-1, 0, this);
			tiles[4] = new PieceTile(-1, -1, this);
			tiles[5] = new PieceTile(0, 1, this);
			break;
		case 25:
			color = new Color(140, 200, 190);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(-1, 1, this);
			tiles[2] = new PieceTile(1, 0, this);
			tiles[3] = new PieceTile(-1, 0, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(-2, 1, this);
			break;
		case 26:
			color = new Color(170, 170, 240);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(-1, 0, this);
			tiles[3] = new PieceTile(-1, 1, this);
			tiles[4] = new PieceTile(-1, 2, this);
			tiles[5] = new PieceTile(-2, 2, this);
			break;
		case 27:
			color = new Color(40, 0, 240);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(-1, 0, this);
			tiles[3] = new PieceTile(-1, 1, this);
			tiles[4] = new PieceTile(-2, 1, this);
			tiles[5] = new PieceTile(-2, 2, this);
			break;
		case 28:
			color = new Color(80, 0, 240);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(-1, 0, this);
			tiles[3] = new PieceTile(-1, 1, this);
			tiles[4] = new PieceTile(-1, 2, this);
			tiles[5] = new PieceTile(0, 2, this);
			break;
		case 29:
			color = new Color(120, 0, 240);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, 1, this);
			tiles[2] = new PieceTile(-1, 1, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(1, -1, this);
			tiles[5] = new PieceTile(-1, -1, this);
			break;
		case 30:
			color = new Color(160, 0, 240);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(0, -1, this);
			tiles[3] = new PieceTile(0, 1, this);
			tiles[4] = new PieceTile(-1, -1, this);
			tiles[5] = new PieceTile(-1, 1, this);
			break;
		case 31:
			color = new Color(200, 0, 240);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, -1, this);
			tiles[2] = new PieceTile(1, -1, this);
			tiles[3] = new PieceTile(-1, 0, this);
			tiles[4] = new PieceTile(-2, 0, this);
			tiles[5] = new PieceTile(-2, 1, this);
			break;
		case 32:
			color = new Color(240, 0, 240);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, 1, this);
			tiles[3] = new PieceTile(1, -1, this);
			tiles[4] = new PieceTile(0, -1, this);
			tiles[5] = new PieceTile(-1, -1, this);
			break;
		case 33:
			color = new Color(240, 0, 200);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(0, 1, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(-1, 0, this);
			tiles[5] = new PieceTile(1, -1, this);
			break;
		case 34:
			color = new Color(240, 0, 160);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(1, 0, this);
			tiles[2] = new PieceTile(1, -1, this);
			tiles[3] = new PieceTile(0, -1, this);
			tiles[4] = new PieceTile(0, 1, this);
			tiles[5] = new PieceTile(-1, 1, this);
			break;
		case 35:
			color = new Color(240, 0, 120);
			tiles[0] = new PieceTile(0, 0, this);
			tiles[1] = new PieceTile(0, -1, this);
			tiles[2] = new PieceTile(1, -1, this);
			tiles[3] = new PieceTile(-1, 0, this);
			tiles[4] = new PieceTile(-1, 1, this);
			tiles[5] = new PieceTile(-2, 1, this);
			break;
		default:
			throw new RuntimeException("Incorrect ID");
		}

	}*/

}
