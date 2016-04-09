package controllers;

import java.awt.event.ActionEvent;

import app.Builder;
import view.LevelTypeSelectView;

public class CreateLevelBtnController implements java.awt.event.ActionListener {
	int nextLevel;
	LevelTypeSelectView ltsv;
	
	//TODO Added bv and b attributes
	Builder b;
	
	
	//TODO Added a BV to the parameters
	public CreateLevelBtnController (LevelTypeSelectView ltsv, Builder b) {
		this.ltsv = ltsv;
		
		//TODO Added lines
		this.b = b;
	}
	
	/**
	 * When the create level button is hit, Builder is notified through setModelLevel().
	 * The BuilderView is then set visible
	 * The LevelTypeSelectView is then hidden.
	 */
	public void actionPerformed(ActionEvent ae) {
		
		//TODO Verify lines
		b.setModelLevel();
		b.setBuilderViewVisible(true);
		b.setLevelTypeSelectViewVisible(false);
		ltsv.setHighestExistingLevel(b.getHighestLevelID());
	}
}
