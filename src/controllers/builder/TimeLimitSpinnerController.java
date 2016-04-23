package controllers.builder;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controllers.common.Move;
import model.LightningLevel;
import view.BuilderView;
import view.LevelPropertiesView;

/**
 * Handles setting the time limit for a lightning level in builder mode
 * 
 * @author awharrison
 * @author hejohnson
 */
public class TimeLimitSpinnerController implements ChangeListener {
	LevelPropertiesView lpv;
	LightningLevel model;
	
	public TimeLimitSpinnerController(LevelPropertiesView lpv) {
		this.lpv = lpv;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		JSpinner timeSpin = (JSpinner)e.getSource();
		Move m = new SetLightningTimeMove(lpv, timeSpin);
		if (m.doMove()) {
			//push onto stack
		}
	}
	
	
}
