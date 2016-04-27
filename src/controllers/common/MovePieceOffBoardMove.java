package controllers.common;

import model.AbstractLevelModel;
import model.Board;
import model.Bullpen;
import model.Piece;
import view.BoardView;
import view.BullpenView;

/**
 * Move for taking a piece off the board. When moving a piece off the board, it adds it back to the 
 * bullpen. The View of the bullpen is updated to account for this.
 * @author hejohnson
 * @author dfontana
 */
public class MovePieceOffBoardMove implements IMove {	
	/**The piece being dragged in this move**/
	Piece piece;
	/**The Bullpen view to update**/
	BullpenView bpv;
	/**Board being acted upon**/
	Board board;
	/**Bullpen being updated**/
	Bullpen bullpen;
	/**BoardView being redrawn/repainted**/
	BoardView bv;
	
	/**
	 * Creates the PieceOffBoardMove
	 * @param lm - level whose board is having peice is being removed and bullpen being updated
	 * @param bpv - view of the bullpen being updated
	 * @param bv - view of the board being drawn
	 */
	public MovePieceOffBoardMove (AbstractLevelModel lm, BullpenView bpv, BoardView bv) {
		this.bpv = bpv;
		this.board = lm.getBoard();
		this.bullpen = lm.getBullpen();
		this.piece = lm.getBoard().getDraggedPiece();
		this.bv = bv;
	}
	
	/**
	 * Executes the move if it is valid. It increments the bullpen's count of the piece,
	 * Sets the draggedPiece to null, and updates the view of that piece in the BullpenView.
	 * @return boolean - true if the move completed.
	 */
	@Override
	public boolean doMove() {
		if(!isValid()){ return false;}
		//board.removePiece(piece);
		bullpen.incrementPiece(piece.getID());
		board.setDraggedPiece(null);
		bpv.updatePieceGroup(piece);
		
		//Redraw
		board.clearPiecePreview();
		bv.redraw();
		bv.repaint();
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
		bullpen.decrementPiece(piece.getID());
		board.putPieceOnBoard(piece, piece.getOriginRow(), piece.getOriginCol());
		bpv.updatePieceGroup(piece);
		
		//Redraw
		board.clearPiecePreview();
		bv.redraw();
		bv.repaint();
		return true;
	}
	
	/**
	 * To redo this move, the move can't be executed again because the
	 * piece needs to be removed from the board: the pressed event does that in
	 * the controller. Otherwise, redo is the same as dOmove
	 * @return boolean - returns true if the move could be done.
	 */
	@Override
	public boolean redo() {
		bullpen.incrementPiece(piece.getID());
		board.setDraggedPiece(null);
		board.removePiece(piece);
		bpv.updatePieceGroup(piece);
		
		//Redraw
		board.clearPiecePreview();
		bv.redraw();
		bv.repaint();
		return true;
	}

}
