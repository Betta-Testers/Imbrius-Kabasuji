/**
 * 
 */
package controllers.builder;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.PuzzleLevel;
import view.LevelPropertiesView;

/**
 * Handles setting the number of moves in a Puzzle level
 * 
 * @author hejohnson
 * @author dfontana
 */
public class SetNumberOfMovesSpinnerController implements ChangeListener {
	LevelPropertiesView levelPropView;
	public SetNumberOfMovesSpinnerController(LevelPropertiesView levelPropView) {
		this.levelPropView = levelPropView;
	}
	
	public void stateChanged(ChangeEvent ce) {
		//TODO Move class?
		JSpinner numberMovesSpinner = (JSpinner) ce.getSource();
		if ((int)numberMovesSpinner.getValue()<0) {
			numberMovesSpinner.setValue(0);
		}
		int moves = (int) numberMovesSpinner.getValue();
		PuzzleLevel levelModel = (PuzzleLevel)levelPropView.getLevelModel();
		levelModel.setMoveLimit(moves);
	}
}
