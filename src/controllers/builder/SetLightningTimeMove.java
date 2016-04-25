package controllers.builder;

import javax.swing.JSpinner;

import controllers.common.IMove;
import model.LightningLevel;

/**
 * Move class handling the setting of the timer in the lightning level builder
 * @author hejohnson
 * @author dfontana
 */
public class SetLightningTimeMove implements IMove {
	/**Lightning level whose time is being set**/
	LightningLevel ll;
	/**Spinner that is manipulating the time**/
	JSpinner timeSpin;
	/**Current time set**/
	int time;
	/**Previous time that was set**/
	int previousTime;
	
	/**
	 * Creates the move
	 * @param ll - lightninglevel whose time is being manipulated
	 * @param timeSpin - spinner that is manipulating the timer
	 */
	public SetLightningTimeMove (LightningLevel ll, JSpinner timeSpin) {
		this.timeSpin = timeSpin;
		this.ll = ll;
		this.time = (int)timeSpin.getValue();
		this.previousTime = ll.getTotalTime();
	}

	/**
	 * The move is done by setting the time of the level based on the time read from the spinner
	 * @return true if the move can be made
	 */
	@Override
	public boolean doMove() {
		if (isValid()) {
			ll.setTotalTime(time);
			return true;
		}
		return false;
	}

	/**
	 * The move is valid if the time is non-negative and not same as the previous time
	 * @return true if the move is valid
	 */
	@Override
	public boolean isValid() {
		return time >= 0 && time != previousTime;
	}

	/**
	 * The move is undone by setting the level and spinner value back to the previous
	 * time value.
	 * @return true - the move can always be undone
	 */
	@Override
	public boolean undo() {
		ll.setTotalTime(previousTime);
		timeSpin.setValue(previousTime);
		return true;
	}

	/**
	 * The move is redone by setting the time of the level to the spinner's value
	 * and setting the spinner back to the current time
	 * @return true - the move can always be redone
	 */
	@Override
	public boolean redo() {
		ll.setTotalTime(time);
		timeSpin.setValue(time);
		return true;
	}

}
