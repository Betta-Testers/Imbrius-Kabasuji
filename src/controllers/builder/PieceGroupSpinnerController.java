package controllers.builder;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import app.UndoManager;
import controllers.common.Move;
import model.Bullpen;
import model.PieceGroup;
import view.PiecePanel;

/**
 * Controls the actions performed on a PieceGroup spinner in builder mode that increments and decrements its number of pieces 
 * 
 * @author awharrison
 * @author Dylan
 *
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
		Move move = new PieceGroupSpinnerMove(pieceGroup, spinner);
		if(move.doMove()){
			UndoManager.getInstance().pushMove(move);
		}
	}


}
