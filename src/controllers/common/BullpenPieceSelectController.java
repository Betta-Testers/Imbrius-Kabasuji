/**
 * 
 */
package controllers.common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Bullpen;
import view.SelectPieceButton;
import view.SelectedPieceView;

/**
 * @author hejohnson
 *
 */

//TODO Add view refresh stuff
public class BullpenPieceSelectController implements ActionListener {
	Bullpen bp;
	SelectedPieceView selectedPieceView;
	public BullpenPieceSelectController (Bullpen bp, SelectedPieceView selectedPieceView) {
		this.bp = bp;
		this.selectedPieceView = selectedPieceView;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		SelectPieceButton source  = (SelectPieceButton) ae.getSource();
		bp.setSelectedPiece(source.getPieceID());
		selectedPieceView.getPiecePanel().redraw();
		selectedPieceView.getPiecePanel().repaint();
	}
}
