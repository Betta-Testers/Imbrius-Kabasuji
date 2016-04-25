/**
 * 
 */
package controllers.common;

import model.Bullpen;
import model.Piece;

/**
 * @author hejohnson
 *
 */
public class RotateRightMove extends Move {
	/** The piece to be rotated **/
	Piece p;
	/** The bullpen that contains the piece **/
	Bullpen bp;
	
	/**
	 * Rotates a piece and provides undo/redo functionality for the builder
	 * @param p The selected piece to be rotated
	 * @param bp The bullpen that contains the selected piece
	 */
	RotateRightMove (Piece p, Bullpen bp) {
		this.p = p;
		this.bp = bp;
	}

	/**
	 * Executes the move by rotating the passed piece right 90 degrees around the origin tile
	 * @return True if the move is valid and was executed
	 */
	@Override
	public boolean doMove() {
		if (isValid()) {
			p.rotateRight();
			return true;
		}
		return false;
	}

	/**
	 * @return True if the piece is the selected piece
	 */
	@Override
	public boolean isValid() {
		return bp.getSelectedPiece().equals(p);
	}

	/**
	 * Ensures that the piece is the selected piece using isValid(), then rotates left
	 * @return True if the undo was valid and executed properly
	 */
	@Override
	public boolean undo() {
		if (isValid()) {
			p.rotateLeft();
			return true;
		}
		return false;
	}

	/**
	 * Executes the move again
	 * @return True if the undo is valid and executed properly
	 */
	@Override
	public boolean redo() {
		return doMove();
	}

}
