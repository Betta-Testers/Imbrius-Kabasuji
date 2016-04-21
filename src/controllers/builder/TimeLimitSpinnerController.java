package controllers.builder;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.LightningLevel;
import view.BuilderView;

/**
 * Handles setting the time limit for a lightning level in builder mode
 * 
 * @author awharrison
 *
 */
public class TimeLimitSpinnerController implements ChangeListener {
	BuilderView app;
	LightningLevel model;
	
	public TimeLimitSpinnerController(BuilderView app, LightningLevel model) {
		this.app = app;
		this.model = model;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO make this compatible with the timing objects used to calculate time
		int timeVal = (int)((JSpinner)e.getSource()).getValue();
		model.setTotalTime(timeVal);
	}
	
	
}
