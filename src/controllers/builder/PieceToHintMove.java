package controllers.builder;

import controllers.common.Move;
import model.AbstractTile;
import model.Board;
import model.BoardTile;
import model.Bullpen;
import model.Piece;

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
	
	/**
	 * Constructs a Piece to Hint Move
	 * @param bp - Bullpen being modified
	 * @param b - Board having a hint placed on it
	 * @param source - Tile that was clicked
	 */
	public PieceToHintMove(Bullpen bp, Board b, AbstractTile source) {
		this.bp = bp;
		this.b = b;
		this.source = source;
		this.p = bp.getSelectedPiece();	
	}
	
	/**
	 * To do the move the location of the piece is set to where the tile clicked was
	 * Then the tiles of the piece occupies are set to be hint tiles
	 * Finally the selected piece of the bullpen is cleared
	 * @return true if the move could be done
	 */
	public boolean doMove() {
		if (isValid()) {
			p.setLocation(source.getRow(), source.getCol());
			for(int i = 0; i < 6; i++){
				((BoardTile) b.getTileAt(p.getTiles()[i].getCol()*32, p.getTiles()[i].getRow()*32)).setHint(true);
			}
			b.clearPiecePreview();
			bp.clearSelectedPiece();
			return true;
		}
		return false;
	}
	
	/**
	 * The move is valid if the selected piece is not null and the piece can git on the board
	 * @return true if the move can be done
	 */
	public boolean isValid() {
		if(bp.getSelectedPiece() != null){
			if(b.willFit(p, source.getRow(), source.getCol())){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * The move is undone by marking all the tiles that the piece occupied as not hints.
	 * The selected piece of the bullpen is then restored to be the piece.
	 * @return true
	 */
	public boolean undo() {
		for(int i = 0; i < 6; i++){
			((BoardTile) b.getTileAt(p.getTiles()[i].getCol()*32, p.getTiles()[i].getRow()*32)).setHint(false);
		}
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
}
