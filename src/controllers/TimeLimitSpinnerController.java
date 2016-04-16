package controllers;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.LightningLevel;
import view.BuilderView;

/**
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
