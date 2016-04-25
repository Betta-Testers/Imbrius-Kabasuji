package controllers.builder;

import controllers.common.Move;
import model.AbstractTile;
import model.Board;
import model.BoardTile;
import model.Bullpen;
import model.Piece;
import view.BullpenView;

/**
 * Represents using a placed piece to make a hint in builder
 * 
 * @author Evan
 * @author Dylan
 *
 */

public class PieceToHintMove extends Move{
	/** Bullpen model in the level**/
	Bullpen bp;
	/** Board model in the level **/
	Board board;
	/** Piece that the hint is made from **/
	Piece p;
	/** Tile that was clicked to make the hint on, origin of piece centered here **/
	AbstractTile source;
	/** View of the bullpen, has the selected piece view **/
	BullpenView bpv;
	
	/**
	 * 
	 * @param bp Bullpen containing the piece to make the hint from
	 * @param board Board to place the hint on
	 * @param source The tile that was clicked on, the location to place the origin tile of the piece at
	 * @param bpv View of the bullpen, containing the selected piece view, to update
	 */
	public PieceToHintMove (Bullpen bp, Board board, AbstractTile source, BullpenView bpv) {
		this.bpv = bpv;
		this.bp = bp;
		this.board = board;
		this.source = source;
		this.p = bp.getSelectedPiece();
		
	}
	
	public boolean doMove() {
		if (isValid()) {
			p.setLocation(source.getRow(), source.getCol());
			for(int i = 0; i < 6; i++){
				((BoardTile) board.getTileAt(p.getTiles()[i].getCol()*32, p.getTiles()[i].getRow()*32)).setHint(true);
			}
			bp.clearSelectedPiece();
			return true;
		}
		return false;
	}
	
	public boolean isValid() {
		if(bp.getSelectedPiece() != null){
			if(board.willFit(p, source.getRow(), source.getCol())){
				return true;
			}
		}
		return false;
	}
	
	public boolean undo() {
		for(int i = 0; i < 6; i++){
			((BoardTile) board.getTileAt(p.getTiles()[i].getCol()*32, p.getTiles()[i].getRow()*32)).setHint(false);
		}
		bp.setSelectedPiece(p.getID());
		return true;
	}
	
	public boolean redo() {
		doMove();
		return true;
	}
	
	public Piece getPlacedPiece() {
		return this.p;
	}
}
