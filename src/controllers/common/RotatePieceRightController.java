/**
 * 
 */
package controllers.common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.UndoManager;
import model.Bullpen;
import model.Piece;
import view.SelectedPieceView;

/**
 * @author hejohnson
 *
 */
public class RotatePieceRightController implements ActionListener {
	Bullpen bullpen;
	Piece p;
	SelectedPieceView selectedPieceView;
	public RotatePieceRightController(Bullpen bp, SelectedPieceView spv) {
		this.bullpen = bp;
		this.selectedPieceView = spv;
	}
	
	public void actionPerformed(ActionEvent ae) {
		p = bullpen.getSelectedPiece();
		if (p != null) {
			Move m = new RotateRightMove(p, bullpen);
			if (m.doMove()) {
				UndoManager.getInstance().pushMove(m);
			}
			selectedPieceView.getPiecePanel().redraw();
			selectedPieceView.getPiecePanel().repaint();
		}
	}
}
 