/**
 * 
 */
package controllers.builder;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import app.UndoManager;
import controllers.common.Move;
import model.PuzzleLevel;

/**
 * Handles setting the number of moves in a Puzzle level
 * 
 * @author hejohnson
 * @author dfontana
 */
public class SetNumberOfMovesSpinnerController implements ChangeListener {
	PuzzleLevel pl;
	
	public SetNumberOfMovesSpinnerController(PuzzleLevel pl) {
		this.pl = pl;
	}
	
	public void stateChanged(ChangeEvent ce) {
		JSpinner spinMoves = (JSpinner)ce.getSource();
		Move m = new SetNumberOfMovesMove(pl, spinMoves);
		if (m.doMove()) {
			UndoManager.getInstance().pushMove(m);
		}
	}
}
