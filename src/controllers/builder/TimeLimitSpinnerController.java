package controllers.builder;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import app.UndoManager;
import controllers.common.Move;
import model.LightningLevel;

/**
 * Handles setting the time limit for a lightning level in builder mode.
 * 
 * @author awharrison
 * @author hejohnson
 */
public class TimeLimitSpinnerController implements ChangeListener {
	/**Lightning level whose time limit is being set**/
	LightningLevel ll;
	
	/**
	 * Creates the controller 
	 * @param ll - lightning level whose time limit is being set
	 */
	public TimeLimitSpinnerController(LightningLevel ll) {
		this.ll = ll;
	}
	
	/**
	 * When the state is changed a move is triggered, which is successful
	 * the undo manager is notified of it.
	 * @param ChangeEvent the value of the spinner is changed
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		JSpinner timeSpin = (JSpinner)e.getSource();
		Move m = new SetLightningTimeMove(ll, timeSpin);
		if (m.doMove()) {
			UndoManager.getInstance().pushMove(m);
		}
	}
}
