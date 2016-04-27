package controllers.common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.UndoManager;
import model.Bullpen;
import model.Piece;
import view.SelectedPieceView;

/**
 * Controller handling the vertical flipping of the selected piece in the bullpen.
 * @author hejohnson
 */
public class FlipPieceVerticalController implements ActionListener {
	/**Bullpen whose piece is being flipped in the selected piece field**/
	Bullpen bullpen;
	/**View that is being updated after the flip**/
	SelectedPieceView selectedPieceView;
	/**Piece that is being flipped**/
	Piece p;
	
	/**
	 * Creates the controller
	 * @param bp - bullpen whose piece is being flipped (retrieves the selected piece)
	 * @param spv - View being updated after flip
	 */
	public FlipPieceVerticalController(Bullpen bp, SelectedPieceView spv) {
		this.bullpen = bp;
		this.selectedPieceView = spv;
	}
	
	/**
	 * When button is pressed the piece is retrieved from the bullpen's selected piece
	 * field. If the piece is null, the action ends. Otherwise, the piece is flipped
	 * and the view is redrawn/painted.
	 * @param ae button press
	 */
	public void actionPerformed(ActionEvent ae) {
		p = bullpen.getSelectedPiece();
		if (p != null) {
			IMove m = new FlipVerticalMove(p, bullpen, selectedPieceView);
			if (m.doMove()) {
				UndoManager.getInstance().pushMove(m);
			}
		}
	}
}
