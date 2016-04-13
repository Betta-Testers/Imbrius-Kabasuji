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

/**
 * @author hejohnson
 *
 */
public class SetNumberOfMovesSpinnerController implements ChangeListener {
	PuzzleLevel levelModel;
	JSpinner numberMovesSpinner;
	public SetNumberOfMovesSpinnerController(PuzzleLevel levelModel, JSpinner numMovesSpinner) {
		this.levelModel = levelModel;
		this.numberMovesSpinner = numMovesSpinner;
	}
	
	public void stateChanged(ChangeEvent ce) {
		//TODO Move class?
		if ((int)numberMovesSpinner.getValue()<0) {
			numberMovesSpinner.setValue(0);
		}
		int moves = (int) numberMovesSpinner.getValue();
		levelModel.setNumberMoves(moves);
	}
}
