package controllers.common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.UndoManager;
import model.Bullpen;
import view.SelectPieceButton;
import view.SelectedPieceView;

/**
 * Controller for selecting a piece from the bullpen and placing it into the selected piece preview.
 * @author hejohnson
 */

public class BullpenPieceSelectController implements ActionListener {
	/**Bullpen whose piece is being set to selected**/
	Bullpen bp;
	/**View of the piece that is selected, getting set and repainted**/
	SelectedPieceView selectedPieceView;
	
	/**
	 * Creates the selected piece controller
	 * @param bp - Bullpen whose piece is being selected
	 * @param selectedPieceView - View displaying the selected piece
	 */
	public BullpenPieceSelectController (Bullpen bp, SelectedPieceView selectedPieceView) {
		this.bp = bp;
		this.selectedPieceView = selectedPieceView;
	}
	
	/**
	 * When a piece's button is pressed, that piece is placed into the selected field of the
	 * bullpen and the displayed/repainted in the piece panel.
	 * @param ActionEvent button press
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		SelectPieceButton source  = (SelectPieceButton) ae.getSource();
		IMove m = new SelectPieceFromBullpenMove(source, bp);
		if (m.doMove()) {
			UndoManager.getInstance().pushMove(m);
		}
		selectedPieceView.getPiecePanel().redraw();
		selectedPieceView.getPiecePanel().repaint();
	}
}
