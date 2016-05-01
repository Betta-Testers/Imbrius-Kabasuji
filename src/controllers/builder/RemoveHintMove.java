package controllers.builder;

import java.util.ArrayList;

import controllers.common.IMove;
import model.AbstractTile;
import model.Board;
import model.BoardTile;
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
	/**ArrayList of board tiles that has been found to be the model array for the hint**/
	ArrayList<BoardTile> hintModel;
	/**Updates the view of the board**/
	BoardView bv;

	/**
	 * Constructor for making a RemoveHintMove
	 * @param source - supposed hint tile that was clicked
	 * @param b - board that is being modified
	 * @param bv - view of board being redrawn
	 */
	public RemoveHintMove(AbstractTile source, Board b, BoardView bv){
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
			for(BoardTile t: hintModel){
				t.setHint(false);
			}
			b.removeHint(hintModel);
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
	 * Method to help the move know what hint array model to use. 
	 * Searches the arrays of the hints array for the row/col coordinates 
	 * of the source tile. It is guarenteed to be in the array, so when it
	 * is found the loop breaks.
	 */
	void findHintModel(){
		for(ArrayList<BoardTile> abt: b.getHintPieces()){
			if(searchPiece(abt)){ break;}
		}
	}
	
	/**
	 * Method to help the findHintModel method. Searches a given array's
	 * tiles for the source tile. When found, it sets the class's modelHint 
	 * field and returns true to notify findHintModel() the search is over.
	 * @param abt - the array currently being checked
	 * @return true if the array is found
	 */
	boolean searchPiece(ArrayList<BoardTile> abt){
		for(BoardTile t: abt){
			if(t.getRow() == source.getRow() && t.getCol() == source.getCol()){
				this.hintModel = abt;
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
		for(BoardTile t: hintModel){
			t.setHint(true);
		}
		b.addHint(hintModel);
		
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
		for(BoardTile t: hintModel){
			t.setHint(false);
		}
		b.removeHint(hintModel);
		
		//Redraw
		bv.redraw();
		bv.repaint();
		return true;
	}
}
