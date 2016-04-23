package controllers.builder;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controllers.common.Move;
import view.LevelPropertiesView;

/**
 * Handles setting the bullpenSize for a lightning level
 * 
 * @author dfontana
 */
public class SetBullpenSizeSpinnerController implements ChangeListener {
	/**The Level Properties View being manipulated**/
	LevelPropertiesView lpv;
	
	public SetBullpenSizeSpinnerController(LevelPropertiesView lpv) {
		this.lpv = lpv;
	}
	
	/**
	 * Creates a move when the spinner is changed, and pushes that move to the
	 * undo/redo manager.
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		JSpinner spinBullpenSize = (JSpinner)e.getSource();
		Move m = new SetBullpenSizeMove(lpv, spinBullpenSize);
		if (m.doMove()) {
			//push onto stack
		}
	}
	
	
}
