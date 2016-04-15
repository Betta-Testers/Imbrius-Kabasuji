/**
 * 
 */
package controllers;

import model.AbstractLevelModel;
import model.Piece;

/**
 * @author hejohnson
 *
 */
public class MovePieceOffBoardMove extends Move {
	AbstractLevelModel levelModel;
	Piece piece;
	public MovePieceOffBoardMove (AbstractLevelModel lm, Piece p) {
		this.levelModel = lm;
		this.piece = p;
	}
	/* (non-Javadoc)
	 * @see controllers.Move#doMove()
	 */
	@Override
	public boolean doMove() {
		levelModel.getBullpen().addSinglePiece(draggedPiece.getID());
		levelModel.updateLevelEndConditions();
		return true;
	}

	/* (non-Javadoc)
	 * @see controllers.Move#isValid()
	 */
	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return true;
	}

	/* (non-Javadoc)
	 * @see controllers.Move#undo()
	 */
	@Override
	public boolean undo() {
		levelModel.getBullpen().removeSinglePiece(p.getID());
		levelModel.getBoard().placePiece(p, p.getOriginRow(), p.getOriginCol());
		return true;
	}

}
