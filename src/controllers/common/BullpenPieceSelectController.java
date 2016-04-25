/**
 * 
 */
package controllers.common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.UndoManager;
import model.Bullpen;
import view.SelectPieceButton;
import view.SelectedPieceView;

/**
 * @author hejohnson
 *
 */

public class BullpenPieceSelectController implements ActionListener {
	Bullpen bp;
	SelectedPieceView selectedPieceView;
	public BullpenPieceSelectController (Bullpen bp, SelectedPieceView selectedPieceView) {
		this.bp = bp;
		this.selectedPieceView = selectedPieceView;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		//TODO Make into move
		SelectPieceButton source  = (SelectPieceButton) ae.getSource();
		Move m = new SelectPieceFromBullpenMove(source, bp);
		if (m.doMove()) {
			UndoManager.getInstance().pushMove(m);
		}
		selectedPieceView.getPiecePanel().redraw();
		selectedPieceView.getPiecePanel().repaint();
	}
}
