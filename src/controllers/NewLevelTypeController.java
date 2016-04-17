package controllers;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JTextArea;
import view.LevelTypeToggle;

/**
 * 
 * @author hejohnson
 *
 */

public class NewLevelTypeController implements java.awt.event.ActionListener {
	String newLevelType;
	LevelTypeToggle clickSource;
	JButton createLevel;
	JTextArea levelDescription;
	
	/**
	 * Controller to change the text displayed in the level type description box
	 * @param levelDescription - JTextArea being updated
	 * @param createLevel - CreateLevelButton being set enabled/disabled
	 * @author dfontana
	 */
	public NewLevelTypeController (JTextArea levelDescription, JButton createLevel) {
		this.levelDescription = levelDescription;
		this.createLevel = createLevel;
	}
	
	/**
	 * Sets the text in the text area to describe the type of level selected
	 * @param ae the event that triggered this controller. Source of this event is used to determine the text to display
	 * @author hejohnson
	 */
	public void actionPerformed(ActionEvent ae) {
		clickSource = (LevelTypeToggle) ae.getSource();
		levelDescription.setText(clickSource.getLevelType());
		createLevel.setEnabled(true);
	}
}