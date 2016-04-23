/**
 * 
 */
package controllers.builder;

import javax.swing.JSpinner;

import controllers.common.Move;
import model.LightningLevel;
import view.LevelPropertiesView;

/**
 * @author hejohnson
 *
 */
public class SetLightningTimeMove extends Move {
	LightningLevel level;
	LevelPropertiesView lpv;
	JSpinner timeSpin;
	int time;
	int previousTime;
	
	public SetLightningTimeMove (LevelPropertiesView lpv, JSpinner timeSpin) {
		this.lpv = lpv;
		this.timeSpin = timeSpin;
		this.level = (LightningLevel)lpv.getLevelModel();
		this.time = (int)timeSpin.getValue();
		this.previousTime = level.getTotalTime();
	}

	@Override
	public boolean doMove() {
		if (isValid()) {
			level.setTotalTime(time);
			System.out.println(time);
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
		level.setTotalTime(previousTime);
		timeSpin.setValue(previousTime);
		return false;
	}

	@Override
	public boolean redo() {
		level.setTotalTime(time);
		timeSpin.setValue(previousTime);
		return false;
	}

}
