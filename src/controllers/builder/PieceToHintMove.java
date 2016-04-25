package controllers.builder;

import java.util.ArrayList;

import controllers.common.Move;
import model.AbstractTile;
import model.Board;
import model.BoardTile;
import model.Bullpen;
import model.Piece;
import model.PieceTile;

/**
 * Move class for converting a piece into a hint on the board
 * 
 * @author Evan
 * @author Dylan
 */
public class PieceToHintMove extends Move{
	/**Bullpen whose piece is being used to make the hint**/
	Bullpen bp;
	/**Board that is having a hint placed on it**/
	Board b;
	/**Piece being used to make the hint**/
	Piece p;
	/**Tile that was clicked**/
	AbstractTile source;
	/**Known hints to be on the board**/
	ArrayList<Piece> hintPieces;
	
	/**
	 * Constructs a Piece to Hint Move
	 * @param hintPieces 
	 * @param bp - Bullpen being modified
	 * @param b - Board having a hint placed on it
	 * @param source - Tile that was clicked
	 */
	public PieceToHintMove(ArrayList<Piece> hintPieces, Bullpen bp, Board b, AbstractTile source) {
		this.bp = bp;
		this.b = b;
		this.source = source;
		this.p = bp.getSelectedPiece();	
		this.hintPieces = hintPieces;
	}
	
	/**
	 * To do the move the location of the piece is set to where the tile clicked was
	 * Then the tiles of the piece occupies are set to be hint tiles and the piece is
	 * added to the known hints on the board.
	 * Finally the selected piece of the bullpen is cleared
	 * @return true if the move could be done
	 */
	public boolean doMove() {
		if (isValid()) {
			p.setLocation(source.getRow(), source.getCol());
			for(int i = 0; i < 6; i++){
				((BoardTile) b.getTileAt(p.getTiles()[i].getCol()*32, p.getTiles()[i].getRow()*32)).setHint(true);
			}
			hintPieces.add(p);
			b.clearPiecePreview();
			bp.clearSelectedPiece();
			return true;
		}
		return false;
	}
	
	/**
	 * The move is valid if the selected piece is not null, the piece can fit on the board,
	 * and there are no hints already within its bounds.
	 * @return true if the move can be done
	 */
	public boolean isValid() {
		if(bp.getSelectedPiece() != null){
			if(b.willFitHint(p, source.getRow(), source.getCol())){
				return true;
			}
		}
		return false;
	}

	/**
	 * The move is undone by marking all the tiles that the piece occupied as not hints.
	 * The piece is then removed from the hints that are on the board.
	 * The selected piece of the bullpen is then restored to be the piece.
	 * @return true
	 */
	public boolean undo() {
		for(int i = 0; i < 6; i++){
			((BoardTile) b.getTileAt(p.getTiles()[i].getCol()*32, p.getTiles()[i].getRow()*32)).setHint(false);
		}
		removeFromList(p);
		bp.setSelectedPiece(p.getID());
		return true;
	}
	
	/** 
	 * The move is redone by executing the mvoe again.
	 * @return true
	 */
	public boolean redo() {
		doMove();
		return true;
	}
	
	/**
	 * Returns the piece that was used to make the hint. 
	 * Necessary for the ability to remove a hint via a click 
	 * @return The model piece used to make the hint
	 */
	public Piece modelPiece(){
	 return p;
	}
	
	/**
	 * Removes a Piece from the hintPieces arrayList based on if two piece's tile's coordinates 
	 * are the same. Uses a helper method to determine if two pieces are the same.
	 * @param p - Piece to be removed
	 */
	void removeFromList(Piece p) {
		for(int i = 0; i < hintPieces.size(); i++){
			if(specialEquals(hintPieces.get(i), p)){
				hintPieces.remove(i);
				break;
			}
		}
	}

	/**
	 * Checks if two pieces are equals based on the coordinates of their tiles,
	 * not the actual tiles themselves.
	 * @param piece - piece being compared to
	 * @param p2 - comparison piece
	 * @return true if the two have matching coordinates
	 */
	boolean specialEquals(Piece piece, Piece p2) {
		for(PieceTile o: piece.getTiles()){
			for(int i = 0; i < p2.getTiles().length; i++){
				if(o.getRow() == p2.getTiles()[i].getRow() && o.getCol() == p2.getTiles()[i].getCol()){
					break;
				}else if(i ==  p2.getTiles().length-1){ //Entire second piece couldnt find tile with those coordinates
					return false;
				}
			}
		}
		return true;
	}
}
