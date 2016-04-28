package controllers.common;

import model.Bullpen;
import model.Piece;
import view.SelectedPieceView;

/**
 * Move class for rotating a piece to the right
 * @author hejohnson
 */
public class RotateRightMove implements IMove {
	/** The piece to be rotated **/
	Piece p;
	/** The bullpen that contains the piece **/
	Bullpen bp;
	/**Updates the view after the move is done/undone**/
	SelectedPieceView spv;

	/**
	 * Rotates a piece and provides undo/redo functionality for the builder
	 * @param p The selected piece to be rotated
	 * @param bp The bullpen that contains the selected piece
	 */
	RotateRightMove (Piece p, Bullpen bp, SelectedPieceView spv) {
		this.p = p;
		this.bp = bp;
		this.spv = spv;
	}

	/**
	 * Executes the move by rotating the passed piece right 90 degrees around the origin tile
	 * @return True if the move is valid and was executed
	 */
	@Override
	public boolean doMove() {
		if (isValid()) {
			p.rotateRight();
			spv.getPiecePanel().redraw();
			spv.getPiecePanel().repaint();
			return true;
		}
		return false;
	}

	/**
	 * Checks if the selected piece in the bullpen is the same as the one
	 * being manipulated.
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
		p.rotateLeft();
		spv.getPiecePanel().redraw();
		spv.getPiecePanel().repaint();
		return true;
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
