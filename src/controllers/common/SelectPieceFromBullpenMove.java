/**
 * 
 */
package controllers.common;

import controllers.common.IMove;
import model.Bullpen;
import view.SelectPieceButton;

/**
 * @author hejohnson
 *
 */
public class SelectPieceFromBullpenMove implements IMove {
	/** ID of the piece that is desired to be selected **/
	int ID;
	/** The bullpen that contains the piece and will hold the selected piece **/
	Bullpen bp;
	
	SelectPieceFromBullpenMove (SelectPieceButton spb, Bullpen bp) {
		this.ID = spb.getPieceID();
		this.bp = bp;
	}
	
	/**
	 * Sets the piece selected by the button as the selected piece
	 * @return 
	 */
	@Override
	public boolean doMove() {
		if (isValid()) {
			return bp.setSelectedPiece(ID);
		}
		return false;
	}

	/**
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
		return false;
	}

	/** 
	 * Does move again (reselects piece)
	 */
	@Override
	public boolean redo() {
		return doMove();
	}

}
