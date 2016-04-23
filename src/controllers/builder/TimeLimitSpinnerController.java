package controllers.builder;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controllers.common.Move;
import model.LightningLevel;

/**
 * Handles setting the time limit for a lightning level in builder mode
 * 
 * @author awharrison
 * @author hejohnson
 */
public class TimeLimitSpinnerController implements ChangeListener {
	LightningLevel ll;
	
	public TimeLimitSpinnerController(LightningLevel ll) {
		this.ll = ll;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		JSpinner timeSpin = (JSpinner)e.getSource();
		Move m = new SetLightningTimeMove(ll, timeSpin);
		if (m.doMove()) {
			//push onto stack
		}
	}
	
	
}
