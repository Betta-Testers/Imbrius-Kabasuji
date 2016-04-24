/**
 * 
 */
package controllers.builder;

import javax.swing.JSpinner;

import controllers.common.Move;
import model.LightningLevel;

/**
 * @author hejohnson
 * @author dfontana
 *
 */
public class SetLightningTimeMove extends Move {
	LightningLevel ll;
	JSpinner timeSpin;
	int time;
	int previousTime;
	
	public SetLightningTimeMove (LightningLevel ll, JSpinner timeSpin) {
		this.timeSpin = timeSpin;
		this.ll = ll;
		this.time = (int)timeSpin.getValue();
		this.previousTime = ll.getTotalTime();
	}

	@Override
	public boolean doMove() {
		if (isValid()) {
			ll.setTotalTime(time);
			return true;
		}
		return false;
	}

	@Override
	public boolean isValid() {
		return time >= 0 && time != previousTime;
	}

	@Override
	public boolean undo() {
		ll.setTotalTime(previousTime);
		timeSpin.setValue(previousTime);
		return false;
	}

	@Override
	public boolean redo() {
		ll.setTotalTime(time);
		timeSpin.setValue(previousTime);
		return false;
	}

}
