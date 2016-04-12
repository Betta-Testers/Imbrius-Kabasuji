package controllers;

import java.awt.event.ActionEvent;

import view.LevelTypeSelectView;
import view.LevelTypeToggle;

/**
 * 
 * @author hejohnson
 *
 */

public class NewLevelTypeController implements java.awt.event.ActionListener {
	String newLevelType;
	LevelTypeToggle clickSource;
	LevelTypeSelectView ltsv;
	/**
	 * Controller to change the text displayed in the level type description box
	 * @param ltsv The view that holds the text box
	 * @author hejohnson
	 */
	public NewLevelTypeController (LevelTypeSelectView ltsv) {
		this.ltsv = ltsv;
	}
	
	/**
	 * Sets the text in the text area to describe the type of level selected
	 * @param ae the event that triggered this controller. Source of this event is used to determine the text to display
	 * @author hejohnson
	 */
	public void actionPerformed(ActionEvent ae) {
		//do something
		clickSource = (LevelTypeToggle) ae.getSource();
		ltsv.getLevelDescriptionBox().setText(clickSource.getLevelType());
		ltsv.getCreateLevelBtn().setEnabled(true);
		//System.out.println("Button " + clickSource.getLevelType());
	}
}