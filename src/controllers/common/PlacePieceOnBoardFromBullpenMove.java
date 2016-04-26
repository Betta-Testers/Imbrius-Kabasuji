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
 * Move that places a piece on the board from the bullpen.
 * @author hejohnson
 * @author dfontana
 */
public class PlacePieceOnBoardFromBullpenMove implements IMove{
	/**Level entity whose board and bullpen are being operated on**/
	AbstractLevelModel levelModel;
	/**The bullpen that is having a piece removed from it**/
	Bullpen bullpen;
	/**The board that is having a piece added to it**/
	Board board;
	/** Piece selected in the bullpen **/
	Piece p;
	/**The tile that was clicked, to know where the peice is being placed**/
	AbstractTile sourceTile;
	/**The view of the bullpen, which needs to be updated after the piece is removed from it**/
	BullpenView bpv;
	
	/**
	 * Creates the move
	 * @param lm - The level being modified
	 * @param tile - The tile on the board that was clicked
	 * @param bpv - The Bullpen view that needs to be repainted
	 */
	public PlacePieceOnBoardFromBullpenMove (AbstractLevelModel lm, AbstractTile tile, BullpenView bpv) {
		this.bpv = bpv;
		this.levelModel = lm;
		this.bullpen = levelModel.getBullpen();
		this.board = levelModel.getBoard();
		this.sourceTile = tile;
		this.p = bullpen.getSelectedPiece();
	}
	
	/**
	 * Performs the move by clearing the piece preview, placing the peice at the 
	 * location of the tile clicked, decrements the bullpen count of that piece, 
	 * updates the view of the bullpen and then clears the selected peice from the
	 * bullpen to signify it has been moved. 
	 * @return true if the move was be made
	 */
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
	
	/**
	 * Undoes the mvoe by removing the peice from the board, incrementing 
	 * that piece's count in the bullpen, updating it's view, and then
	 * resetting the selected peice back to that piece.
	 * @return true - the move can always be undone.
	 */
	public boolean undo() {
		board.removePiece(p);
		bullpen.incrementPiece(p.getID());
		bpv.updatePieceGroup(p);
		bullpen.setSelectedPiece(p.getID());
		return true;
	}
	
	/**
	 * Redoes the move.
	 * @return if the move could be redone.
	 */
	@Override
	public boolean redo() {
		return doMove();
	}
	
	/**
	 * Returns the piece that was placed in the move for use in the
	 * level condition checks/display (game).
	 * @return Piece that was placed.
	 */
	public Piece getPlacedPiece() {
		return this.p;
	}
}
