package controllers;

import java.awt.event.ActionEvent;

import view.LevelTypeSelectView;

public class CreateLevelBtnController implements java.awt.event.ActionListener {
	int nextLevel;
	LevelTypeSelectView ltsv;
	public CreateLevelBtnController (LevelTypeSelectView ltsv) {
		this.ltsv = ltsv;
		this.nextLevel = this.ltsv.getHighestExistingLevel()+1;
	}
	
	public void actionPerformed(ActionEvent ae) {
		//do something
		System.out.println("Create new level #"+nextLevel);
	}
}
