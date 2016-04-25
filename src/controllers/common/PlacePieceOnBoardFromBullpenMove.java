/**
 * 
 */
package controllers.common;

import model.AbstractLevelModel;
import model.AbstractTile;
import model.Board;
import model.Bullpen;
import model.Piece;
import view.BullpenView;

/**
 * @author hejohnson
 * @author dylan
 */
public class PlacePieceOnBoardFromBullpenMove extends Move{
	AbstractLevelModel levelModel;
	Bullpen bullpen;
	Board board;
	
	/** Piece selected in the bullpen **/
	Piece p;
	AbstractTile sourceTile;
	BullpenView bpv;
	
	public PlacePieceOnBoardFromBullpenMove (AbstractLevelModel lm, AbstractTile tile, BullpenView bpv) {
		this.bpv = bpv;
		this.levelModel = lm;
		this.bullpen = levelModel.getBullpen();
		this.board = levelModel.getBoard();
		this.sourceTile = tile;
		this.p = bullpen.getSelectedPiece();
	}
	
	public boolean doMove() {
		if (isValid()) {
			board.clearPiecePreview();
			board.putPieceOnBoard(p, sourceTile.getRow(), sourceTile.getCol());
			bullpen.decrementPiece(p.getID());
			bpv.updatePieceGroup(p);
			bullpen.clearSelectedPiece();
			return true;
		}
		return false;
	}
	
	/**
	 * Checks to see if a piece has been selected from the bullpen. If so,
	 * it checks if the piece will fit where it is trying to go. If both
	 * check out, the move is valid.
	 * @return boolean - true if the move can be made
	 */
	public boolean isValid() {
		if(this.p != null){
			if(board.willFit(p, sourceTile.getRow(), sourceTile.getCol())){
				return true;
			}
		}
		return false;
	}
	
	public boolean undo() {
		board.removePiece(p);
		bullpen.incrementPiece(p.getID());
		bpv.updatePieceGroup(p);
		bullpen.setSelectedPiece(p.getID());
		return true;
	}
	
	@Override
	public boolean redo() {
		doMove();
		return true;
	}
	
	public Piece getPlacedPiece() {
		return this.p;
	}
}
