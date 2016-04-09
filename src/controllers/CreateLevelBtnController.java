package controllers;

import java.awt.event.ActionEvent;

import app.Builder;
import view.LevelTypeSelectView;
import view.BuilderView;

public class CreateLevelBtnController implements java.awt.event.ActionListener {
	int nextLevel;
	LevelTypeSelectView ltsv;
	
	//TODO Added bv and b attributes
	BuilderView bv;
	Builder b;
	
	
	//TODO Added a BV to the parameters
	public CreateLevelBtnController (LevelTypeSelectView ltsv, Builder b, BuilderView bv) {
		this.ltsv = ltsv;
		this.nextLevel = this.ltsv.getHighestExistingLevel()+1;
		
		//TODO Added lines
		this.bv = bv;
		this.b = b;
	}
	
	/**
	 * Gets the selected level type from the LevelTypeSelectView and prepares the boardView for it.
	 * TODO: Set the generate a level model for the BV in this switch and set it.
	 */
	public void actionPerformed(ActionEvent ae) {
		//Prepare the Builder View to display only the relevant sections of the editor
		switch(ltsv.getSelectedLevelType()){
			case "Puzzle":
				/** TODO Add these Lines when PuzzleLevel implemented
				 * PuzzleLevel pl = new PuzzleLevel();
				 * b.setModelLevel(pl);
				 * bv.setModelLevel(pl);
				 */
				bv.prepPuzzle();
				break;
			case "Lightning":
				/** TODO Add these lines when LightningLevel implemented
				 * LightningLevel ll = new LightningLevel();
				 * b.setModelLevel(ll);
				 * bv.setModelLevel(ll);
				 */
				bv.prepLightning();
				break;
			case "Release":
				/** TODO Add these lines when ReleaseLevel implemented
				 * ReleaseLevel rl = new ReleaseLevel();
				 * b.setModelLevel(rl);
				 * bv.setModelLevel(rl);
				 */
				bv.prepRelease();
				break;
		}
		
		System.out.println("Create new level #"+nextLevel+" of type "+this.ltsv.getSelectedLevelType());
		
		//Set the builder to Visible and the Selection screen to hidden.
		bv.setVisible(true);
		ltsv.setVisible(false);
		
	}
}
