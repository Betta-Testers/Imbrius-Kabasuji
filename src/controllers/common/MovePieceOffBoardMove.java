package controllers.common;

import model.AbstractLevelModel;
import model.Piece;
import view.BullpenView;

/**
 * Move for taking a piece off the board. When moving a piece off the board, it adds it back to the 
 * bullpen. The View of the bullpen is updated to account for this.
 * @author hejohnson
 * @author dfontana
 */
public class MovePieceOffBoardMove extends Move {
	/** The level associated with this move.**/
	AbstractLevelModel levelModel;
	
	/**The piece being dragged in this move**/
	Piece piece;
	
	/**The Bullpen view to update**/
	BullpenView bpv;
	
	public MovePieceOffBoardMove (AbstractLevelModel lm, BullpenView bpv) {
		this.bpv = bpv;
		this.levelModel = lm;
		this.piece = levelModel.getBoard().getDraggedPiece();
	}
	
	/**
	 * Executes the move if it is valid. It increments the bullpen's count of the piece,
	 * Sets the draggedPiece to null, and updates the view of that piece in the BullpenView.
	 * @return boolean - true if the move completed.
	 */
	@Override
	public boolean doMove() {
		if(!isValid()){ return false;}
		levelModel.getBullpen().incrementPiece(piece.getID());
		levelModel.getBoard().setDraggedPiece(null);
		bpv.updatePieceGroup(piece);
		return true;
	}

	/**
	 * This move is valid iff there is a piece being dragged. Otherwise, the move cannot
	 * complete.
	 * @return boolean - true if there is a dragged piece in the board
	 */
	@Override
	public boolean isValid() {
		if(this.piece != null){ return true;}
		return false;
	}

	/**
	 * To undo this move, the piece is decremented from the bullpen,
	 * the piece is put back on the board, and the view is updated.
	 * Only can be done if the piece is null;
	 * @return boolean - true if this move was undone.
	 */
	@Override
	public boolean undo() {
		if(!isValid()){return false;}
		levelModel.getBullpen().decrementPiece(piece.getID());
		levelModel.getBoard().putPieceOnBoard(piece, piece.getOriginRow(), piece.getOriginCol());
		bpv.updatePieceGroup(piece);
		return true;
	}
	
	/**
	 * To redo this move, the move is executed again. As of now there is no 
	 * test to ensure a move can be redone, rather the undo manager would make
	 * sure that no other move has been executed since this move was undone.
	 * @return boolean - returns true if the move could be done.
	 */
	@Override
	public boolean redo() {
		return doMove();
	}

}
