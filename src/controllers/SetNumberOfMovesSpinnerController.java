/**
 * 
 */
package controllers;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.AbstractLevelModel;
import model.PuzzleLevel;
import view.BuilderView;
import view.LevelPropertiesView;

/**
 * @author hejohnson
 *
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
		levelModel.setNumberMoves(moves);
	}
}
