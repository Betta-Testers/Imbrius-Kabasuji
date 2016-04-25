package controllers.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.UndoManager;
import controllers.common.IMove;
import model.Board;
import model.Bullpen;
import view.BoardView;
import view.BullpenView;

/**
 * Controller to remove all pieces from the board. Executes the RemoveAllPiecesMove
 * @author awharrison
 * @author dfontana
 */

public class RemovePiecesButtonController implements ActionListener{
	/**Board whose pieces are being removed**/
	Board board;
	/**View of the board that is being updated**/
	BoardView bv;
	/**Bullpen that is having pieces returned to it**/
	Bullpen bp;
	/**Bullpen View that is being updated**/
	BullpenView bpv;
	
	/**
	 * Creates the controller
	 * @param b Current Board being manipulated
	 * @param bv View of the current board
	 * @param bp Bullpen being updated
	 * @param bpv View of bullpen being updated
	 */
	public RemovePiecesButtonController(Board board, BoardView bv, Bullpen bp, BullpenView bpv) {
		this.board = board;
		this.bv = bv;
		this.bp = bp;
		this.bpv = bpv;
	}
	
	/**
	 * When button is pressed, the move is performed. If successful, the undo manager
	 * recieves the move and the view is redrawn/updated
	 * @param ActionEvent button click
	 */
	public void actionPerformed(ActionEvent arg0) {
		IMove m = new RemoveAllPiecesMove(board, bp, bpv);
		if(m.doMove()){
			UndoManager.getInstance().pushMove(m);
			bv.redraw();
			bv.repaint();
		}
	}
}
