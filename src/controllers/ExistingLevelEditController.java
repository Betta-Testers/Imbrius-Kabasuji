package controllers;

import java.awt.event.ActionEvent;

import view.ExistingLevelView;

import app.Builder;

public class ExistingLevelEditController implements java.awt.event.ActionListener {
	Builder b;
	
	public ExistingLevelEditController (Builder b) {
		this.b = b;
	}

	/*
	 * Actions to take:
	 * Determine Level type and number from the button pressed
	 * Open the file.
	 * Initialize the model.
	 * Set the BV model
	 * Set the BV to display the right information for that level type
	 * Show the builderView
	 * Hide the levelTypeSelect
	 * 
	 * It will need to take a Builder object in the constructor to get the BV model
	 */

	public void actionPerformed(ActionEvent ae) {
		//1) Read find the level type and ID from the Source button
		ExistingLevelView sourceButton = (ExistingLevelView) ae.getSource();
		int levelID = sourceButton.getLevelNumber();
		String levelType = b.lookupLevelType(levelID);

		//2) Code for reading a level, DOES NOT belong here, this is a level thing.
		//   Instead, pass the constructor the fileName and put this in level model
		String fileName = levelID+"_"+levelType+".txt";
		b.setModelLevelEditing(fileName);
		



		//do something

		System.out.println("Button " + sourceButton.getLevelNumber());
	}
}
