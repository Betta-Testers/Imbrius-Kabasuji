package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;


/**
 * @author ejbosia
 * @author hejohnson
 * @author dfontana
 */
public class Piece{
	
	/**Stores each tile that makes up the piece.*/
	ArrayList<PieceTile> tiles;
	
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
	}
	
	/**
	 * Sets the color of the piece. Updates the color and the default color of all the component piece tiles
	 * @param c The color to set the piece to
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
	 * @throws NullPointerException if this piece did not deserialize properly, or it's tiles aren't initialized
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
	 * @return An icon of this piece
	 */
	public ImageIcon generateIcon() {
		BufferedImage iconImg = new BufferedImage(35, 35, BufferedImage.TYPE_INT_ARGB);
	      Graphics2D g2 = iconImg.createGraphics();
	      for (PieceTile pt : tiles) {
	    	  g2.setColor(color);
	    	  g2.fillRect(16+pt.getColInPiece()*4, 14+pt.getRowInPiece()*4, 4, 4);
	    	  g2.setColor(Color.black);
	    	  g2.drawRect(16+pt.getColInPiece()*4, 14+pt.getRowInPiece()*4, 4, 4);
	      }
	      return new ImageIcon(iconImg);
	}
}
