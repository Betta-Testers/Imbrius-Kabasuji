package controllers.common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.UndoManager;
import model.Bullpen;
import model.Piece;
import view.SelectedPieceView;

/**
 * Controller connecting the button to the move for rotating the selected peice right.
 * @author hejohnson
 */
public class RotatePieceRightController implements ActionListener {
	/**Bullpen of the piece being manipulated**/
	Bullpen bullpen;
	/**Piece being rotated to the right**/
	Piece p;
	/**View that needs to be updated after rotating**/
	SelectedPieceView selectedPieceView;
	
	/**
	 * Creates the controller
	 * @param bp - the bullpen of the piece being rotated
	 * @param spv - view of the piece that needs to be repainted
	 */
	public RotatePieceRightController(Bullpen bp, SelectedPieceView spv) {
		this.bullpen = bp;
		this.selectedPieceView = spv;
	}
	
	/**
	 * After being clicked, the piece is retrieved from the selected peice of the bullpen.
	 * If the piece is null the action ends. Other wise I move is attempted. If the move
	 * could be done, the undo manager is notified. Otherwise, the panel is repainted at 
	 * end to show the piece has been rotated.
	 * @param ActionEvent button clicked
	 */
	public void actionPerformed(ActionEvent ae) {
		p = bullpen.getSelectedPiece();
		if (p != null) {
			IMove m = new RotateRightMove(p, bullpen);
			if (m.doMove()) {
				UndoManager.getInstance().pushMove(m);
			}
			selectedPieceView.getPiecePanel().redraw();
			selectedPieceView.getPiecePanel().repaint();
		}
	}
}
 