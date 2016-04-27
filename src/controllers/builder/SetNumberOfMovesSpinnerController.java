package controllers.builder;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import app.UndoManager;
import controllers.common.IMove;
import model.PuzzleLevel;

/**
 * Handles setting the number of moves in a Puzzle level.
 * 
 * @author hejohnson
 * @author dfontana
 */
public class SetNumberOfMovesSpinnerController implements ChangeListener {
	/**Puzzle level whose number of moves is being set**/
	PuzzleLevel pl;
	
	/**
	 * Creates the controller
	 * @param pl - level whose move limit is being set
	 */
	public SetNumberOfMovesSpinnerController(PuzzleLevel pl) {
		this.pl = pl;
	}
	
	/**
	 * When the state is changed in the spinner attatched to this, a move is 
	 * triggered. If successful, the undo manager is notified.
	 * @param ce updating of spinner's value
	 */
	public void stateChanged(ChangeEvent ce) {
		JSpinner spinMoves = (JSpinner)ce.getSource();
		IMove m = new SetNumberOfMovesMove(pl, spinMoves);
		if (m.doMove()) {
			UndoManager.getInstance().pushMove(m);
		}
	}
}
