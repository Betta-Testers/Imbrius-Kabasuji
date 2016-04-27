package controllers.builder;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import app.UndoManager;
import controllers.common.IMove;
import model.Bullpen;
import model.PieceGroup;
import view.PiecePanel;

/**
 * Controls the actions performed on a PieceGroup spinner in builder mode that 
 * increments and decrements its number of pieces 
 * @author awharrison
 * @author dfontana
 */
public class PieceGroupSpinnerController implements ChangeListener {
	/**Spinner being operated on in the move**/
	JSpinner spinner;
	/**pieceGroup being operated on in the move**/
	PieceGroup pieceGroup;
	/**Redraws when the piece group's count drops to 0 of the piece in the panel**/
	PiecePanel piecePanel;
	/**Used to clear the selectedPiece when the piece group's count drops to 0 of the piece in the panel**/
	Bullpen bp;

	/**
	 * Creates the controller
	 * @param spinner - spinner that is being manipulated for the given piecegroup
	 * @param pieceGroup - piecegroup model being manipulated
	 * @param bp - bullpen whose piece group is being worked on.
	 * @param piecePanel - preview area for the piece group
	 */
	public PieceGroupSpinnerController(JSpinner spinner, PieceGroup pieceGroup, Bullpen bp, PiecePanel piecePanel) {
		this.spinner = spinner;
		this.pieceGroup = pieceGroup;
		this.piecePanel = piecePanel;
		this.bp = bp;
	}

	/**
	 * When the spinner is changed, the controller detects it and logs the 
	 * change as a move so it can be undone/redone. If the spinner's value of the piece currently selected 
	 * drops to 0, the bp is cleared of the selected piece and then redraws the piecePanel.
	 * @param e when the value of spinner is changed
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		if((int)spinner.getValue() == 0 && bp.getSelectedPiece() != null){
			if(bp.getSelectedPiece().equals(pieceGroup.getPiece())){
				bp.clearSelectedPiece();
				piecePanel.redraw();
				piecePanel.repaint();
			}
		}
		IMove move = new PieceGroupSpinnerMove(pieceGroup, spinner);
		if(move.doMove()){
			UndoManager.getInstance().pushMove(move);
		}
	}
}
