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
public class FlipPieceHorizontalController implements ActionListener {
	Bullpen bullpen;
	SelectedPieceView selectedPieceView;
	Piece p;
	public FlipPieceHorizontalController(Bullpen bp, SelectedPieceView spv) {
		this.bullpen = bp;
		this.selectedPieceView = spv;
	}
	
	public void actionPerformed(ActionEvent ae) {
		//TODO Make into move
		p = bullpen.getSelectedPiece();
		if (p != null) {
			Move m = new FlipHorizontalMove(p, bullpen);
			if (m.doMove()) {
				UndoManager.getInstance().pushMove(m);
			}
			selectedPieceView.getPiecePanel().redraw();
			selectedPieceView.getPiecePanel().repaint();
		}
		
	}
}
