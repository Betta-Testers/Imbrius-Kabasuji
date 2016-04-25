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
 * Controller handling the horizontal flipping of a piece in the selected piece view.
 * @author hejohnson
 */
public class FlipPieceHorizontalController implements ActionListener {
	/**Bullpen that contains the piece being flipped in the selected piece field**/
	Bullpen bullpen;
	/**View of the selected piece being updated after the flip**/
	SelectedPieceView selectedPieceView;
	/**Piece being flipped**/
	Piece p;
	
	/**
	 * Creates the controller.
	 * @param bp - the bullpen who holds the the piece being flipped
	 * @param spv - view of the piece being flipped
	 */
	public FlipPieceHorizontalController(Bullpen bp, SelectedPieceView spv) {
		this.bullpen = bp;
		this.selectedPieceView = spv;
	}
	
	/**
	 * On button press the piece is retrieved from the bullpen. If it's null,
	 * the action ends, otherwise the piece is flipped.
	 * @param ActionEvent button press
	 */
	public void actionPerformed(ActionEvent ae) {
		p = bullpen.getSelectedPiece();
		if (p != null) {
			p.flipV(); //TODO why V? This is H!
			selectedPieceView.getPiecePanel().redraw();
			selectedPieceView.getPiecePanel().repaint();
		}
		
	}
}
