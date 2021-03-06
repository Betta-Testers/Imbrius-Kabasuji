/**
 * 
 */
package controllers.common;

import controllers.common.IMove;
import model.Bullpen;
import model.Piece;
import model.PieceFactory;
import view.SelectPieceButton;

/**
 * Move class for handling the movement of a piece from the bullpen to the selected piece
 * field of the bullpen (for viewing, rotating, placing...).
 * @author hejohnson
 */
public class SelectPieceFromBullpenMove implements IMove {
	/** ID of the piece that is desired to be selected **/
	int ID;
	/** The bullpen that contains the piece and will hold the selected piece **/
	Bullpen bp;
	/** The piece created in this move **/
	Piece p;
	
	/**
	 * Creates the move
	 * @param spb - the button being pressed tied to a piece ID
	 * @param bp - the bullpen being modified
	 */
	SelectPieceFromBullpenMove (SelectPieceButton spb, Bullpen bp) {
		this.ID = spb.getPieceID();
		this.bp = bp;
		this.p = PieceFactory.getInstance().getPiece(ID);
	}
	
	/**
	 * Sets the piece selected by the button as the selected piece
	 * @return  true if the move can be done
	 */
	@Override
	public boolean doMove() {
		if (isValid()) {
			bp.setSelectedPiece(p);
			return true;
		}
		return false;
	}

	/**
	 * Checks with the bullpen to see if the piece can be selected (having a count of greater than 0)
	 * @return True if the piece can be selected
	 */
	@Override
	public boolean isValid() {
		return bp.isSelectable(ID);
	}

	/**
	 * Clears the selected piece
	 * @return Will always return true
	 */
	@Override
	public boolean undo() {
		bp.clearSelectedPiece();
		return true;
	}

	/** 
	 * Does move again (reselects piece)
	 * @return true if the move could be done
	 */
	@Override
	public boolean redo() {
		return doMove();
	}

}
