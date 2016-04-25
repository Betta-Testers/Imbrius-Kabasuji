package controllers.builder;

import java.util.ArrayList;

import controllers.common.Move;
import model.AbstractTile;
import model.Board;
import model.BoardTile;
import model.Bullpen;
import model.Piece;

/**
 * Move class for converting a piece into a hint on the board
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
	 * @param hintPieces - pieces known to be hints on the board
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
	 * The move is redone by executing the move again.
	 * @return true
	 */
	public boolean redo() {
		doMove();
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
