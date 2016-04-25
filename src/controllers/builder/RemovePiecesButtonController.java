package controllers.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.UndoManager;
import controllers.common.Move;
import model.Board;
import model.Bullpen;
import view.BoardView;
import view.BullpenView;

/**
 * Controller to remove all pieces from the board. Executes the RemoveAllPiecesMove
 * @author awharrison
 * @author Dylan
 *
 */

public class RemovePiecesButtonController implements ActionListener{
	Board b;
	BoardView bv;
	Bullpen bp;
	BullpenView bpv;
	
	/**
	 * @param b Current Board
	 * @param bv View of the current board
	 * @param bp 
	 * @param bpv
	 */
	public RemovePiecesButtonController(Board b, BoardView bv, Bullpen bp, BullpenView bpv) {
		this.b = b;
		this.bv = bv;
		this.bp = bp;
		this.bpv = bpv;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		Move m = new RemoveAllPiecesMove(b, bp, bpv);
		if(m.doMove()){
			UndoManager.getInstance().pushMove(m);
			bv.redraw();
			bv.repaint();
		}
	}
}
