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
		levelModel.getBullpen().addSinglePiece(piece.getID());
		levelModel.updateProgress();
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
		levelModel.getBullpen().removeSinglePiece(piece.getID());
		levelModel.getBoard().putPieceOnBoard(piece, piece.getOriginRow(), piece.getOriginCol());
		return true;
	}

}
