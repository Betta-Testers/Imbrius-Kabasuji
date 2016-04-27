package controllers.builder;

import java.util.ArrayList;

import controllers.common.IMove;
import model.AbstractTile;
import model.Board;
import model.BoardTile;
import model.Piece;
import model.PieceTile;
import view.BoardView;

/**
 * Move class for removing a hint on the board.
 * @author dfontana
 */
public class RemoveHintMove implements IMove {
	/**Board in which the move is taking place **/
	Board b;
	/**The tile that was clicked. Expected to be a hint tile. **/
	AbstractTile source;
	/**Known hints on the board**/
	ArrayList<Piece>hintPieces;
	/**Piece that has been found to be the model piece for the hint**/
	Piece p;
	/**Updates the view of the board**/
	BoardView bv;

	/**
	 * Constructor for making a RemoveHintMove
	 * @param hintPieces - known pieces that are hints
	 * @param source - supposed hint tile that was clicked
	 * @param b - board that is being modified
	 * @param bv - view of board being redrawn
	 */
	public RemoveHintMove(ArrayList<Piece>hintPieces, AbstractTile source, Board b, BoardView bv){
		this.hintPieces = hintPieces;
		this.source = source;
		this.b = b;
		this.bv = bv;
	}
	
	/**
	 * The move finds the piece the hint belongs to, then setting all
	 * locations inside of that piece to no longer be hints.
	 * Then the piece is removed from the hintPieces array, since it is
	 * no longer a hint on the board.
	 * Finally, the piecePreview is cleared to render the color correctly.
	 * @return boolean - true if the move was successful
	 */
	@Override
	public boolean doMove() {
		if(isValid()) {
			findHintModel();
			for(PieceTile t: p.getTiles()){
				((BoardTile)b.getTileAt(t.getCol()*32, t.getRow()*32)).setHint(false);
			}
			removeFromList(p);
			b.clearPiecePreview();
			
			//Redraw
			bv.redraw();
			bv.repaint();
			return true;
		}
		return false;
	}

	/**
	 * Checks if the tile passed in is a board tile or release tile.
	 * Then checks if the source tile is a hint tile. 
	 * @return boolean - true if the above two conditions are true
	 */
	@Override
	public boolean isValid() {
		if(source.getTileType().equals("board") || source.getTileType().equals("release")){
			if(((BoardTile) source).isHint()){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Method to help the move know what piece model to use. 
	 * Searches the pieces of the array for the row/col coordinates 
	 * of the source tile. It is guarenteed to be in the array, so when it
	 * is found the loop breaks.
	 */
	void findHintModel(){
		for(Piece p: hintPieces){
			if(searchPiece(p)){ break;}
		}
	}
	
	/**
	 * Method to help the findHintModel method. Searches a given piece's
	 * tiles for the source tile. When found, it sets the class's piece 
	 * field and returns true to notify findHintModel() the search is over.
	 * @param p - the piece currently being checked
	 * @return true if the piece is found
	 */
	boolean searchPiece(Piece p){
		for(PieceTile t: p.getTiles()){
			if(t.getRow() == source.getRow() && t.getCol() == source.getCol()){
				this.p = p;
				return true;
			}
		}
		return false;
	}

	/**
	 * Undoes the move by putting the hint back on the board and readding it to the array.
	 * @return true
	 */
	@Override
	public boolean undo() {
		for(PieceTile t: p.getTiles()){
			((BoardTile)b.getTileAt(t.getCol()*32, t.getRow()*32)).setHint(true);
		}
		hintPieces.add(p);
		
		//Redraw
		bv.redraw();
		bv.repaint();
		return true;
	}
	
	/**
	 * Redoes the move by removing the hint from the board again and removing it from the array.
	 * @return true
	 */
	@Override 
	public boolean redo() {
		for(PieceTile t: p.getTiles()){
			((BoardTile)b.getTileAt(t.getCol()*32, t.getRow()*32)).setHint(false);
		}
		removeFromList(p);
		
		//Redraw
		bv.redraw();
		bv.repaint();
		return true;
	}
	
	/**
	 * Removes a Piece from the hintPieces arrayList based on if two piece's tile's coordinates 
	 * are the same. Uses a helper method to determine if two pieces are the same.
	 * @param p - Piece to be removed
	 */
	void removeFromList(Piece p) {
		for(int i = 0; i < hintPieces.size(); i++){
			if(hintPieces.get(i).occupiesSameCoorindates(p)){
				hintPieces.remove(i);
				break;
			}
		}
	}
}
