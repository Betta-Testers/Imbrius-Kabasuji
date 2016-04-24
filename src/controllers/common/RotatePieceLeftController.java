/**
 * 
 */
package controllers.common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Bullpen;
import model.Piece;
import view.SelectedPieceView;

/**
 * @author hejohnson
 *
 */
public class RotatePieceLeftController implements ActionListener {
	Bullpen bullpen;
	Piece p;
	SelectedPieceView selectedPieceView;
	public RotatePieceLeftController(Bullpen bp, SelectedPieceView spv) {
		this.bullpen = bp;
		this.selectedPieceView = spv;
	}
	
	public void actionPerformed(ActionEvent ae) {
		p = bullpen.getSelectedPiece();
		if (p != null) {
			p.rotateLeft();
			selectedPieceView.getPiecePanel().redraw();
			selectedPieceView.getPiecePanel().repaint();
		}
	}
}
