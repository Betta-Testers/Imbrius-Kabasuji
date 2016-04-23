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
public class SetBullpenSizeMove extends Move {
	/**Level whose field is being updated**/
	LightningLevel levelModel;
	
	JSpinner spinBullpenSize;
	int newSize;
	int oldSize;
	
	public SetBullpenSizeMove (LightningLevel levelModel, JSpinner spinBullpenSize) {
		this.spinBullpenSize = spinBullpenSize;
		this.levelModel = levelModel;
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
