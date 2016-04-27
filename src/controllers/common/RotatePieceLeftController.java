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
 * Controller that links the rotate left move to the button.
 * @author hejohnson
 */
public class RotatePieceLeftController implements ActionListener {
	/**The bullpen of the piece being rotated**/
	Bullpen bullpen;
	/**The piece being rotated**/
	Piece p;
	/**The view that needs to be updated after rotation**/
	SelectedPieceView selectedPieceView;
	
	/**
	 * Creates the controller.
	 * @param bp - the bullpen who owns the piece
	 * @param spv - the view that needs to be repainted after
	 */
	public RotatePieceLeftController(Bullpen bp, SelectedPieceView spv) {
		this.bullpen = bp;
		this.selectedPieceView = spv;
	}
	
	/**
	 * On action the piece is retrieved from the bullpen's selected field. 
	 * If the piece is null the action ends, otherwise a move is made and
	 * attempted. If successful the undomanager is notified. Otherwise,
	 * the panel is repainted.
	 * @param ae button pressed
	 */
	public void actionPerformed(ActionEvent ae) {

		//TOD) Make into move
		p = bullpen.getSelectedPiece();
		if (p != null) {
			IMove m = new RotateLeftMove(p, bullpen, selectedPieceView);
			if (m.doMove()) {
				UndoManager.getInstance().pushMove(m);
			}
		}
	}
}
