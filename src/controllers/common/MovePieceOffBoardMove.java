/**
 * 
 */
package controllers.common;

import model.AbstractLevelModel;
import model.Piece;
import view.BullpenView;

/**
 * @author hejohnson
 * @author dfontana
 */
public class MovePieceOffBoardMove extends Move {
	AbstractLevelModel levelModel;
	Piece piece;
	BullpenView bpv;
	public MovePieceOffBoardMove (AbstractLevelModel lm, BullpenView bpv) {
		this.bpv = bpv;
		this.levelModel = lm;
		this.piece = levelModel.getBoard().getDraggedPiece();
	}
	/* (non-Javadoc)
	 * @see controllers.Move#doMove()
	 */
	@Override
	public boolean doMove() {
		System.out.println("About to increment in dragged off borad move");
		levelModel.getBullpen().incrementPiece(piece.getID());
		//levelModel.getBoard().removePiece(piece);
		levelModel.getBoard().setDraggedPiece(null);
		bpv.updatePieceGroup(piece);
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
		bpv.updatePieceGroup(piece);
		return true;
	}
	
	@Override
	public boolean redo() {
		doMove();
		return true;
	}

}
