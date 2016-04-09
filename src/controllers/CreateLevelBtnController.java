package controllers;

import java.awt.event.ActionEvent;

import view.LevelTypeSelectView;
import view.BuilderView;

public class CreateLevelBtnController implements java.awt.event.ActionListener {
	int nextLevel;
	LevelTypeSelectView ltsv;
	BuilderView bv;
	
	
	//TODO Added a BV to the parameters
	public CreateLevelBtnController (LevelTypeSelectView ltsv, BuilderView bv) {
		this.ltsv = ltsv;
		this.bv = bv;
		this.nextLevel = this.ltsv.getHighestExistingLevel()+1;
	}
	
	/**
	 * Gets the selected level type from the LevelTypeSelectView and prepares the boardView for it.
	 * TODO: Set the generate a level model for the BV in this switch and set it.
	 */
	public void actionPerformed(ActionEvent ae) {
		//Prepare the Builder View to display only the relevant sections of the editor
		switch(ltsv.getSelectedLevelType()){
			case "Puzzle":
				bv.prepPuzzle();
				break;
			case "Lightning":
				bv.prepLightning();
				break;
			case "Release":
				bv.prepRelease();
				break;
		}
		
		System.out.println("Create new level #"+nextLevel+" of type "+this.ltsv.getSelectedLevelType());
		
		//Set the builder to Visible and the Selection screen to hidden.
		bv.setVisible(true);
		ltsv.setVisible(false);
		
	}
}
