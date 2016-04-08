package controllers;

import java.awt.event.ActionEvent;

public class CreateLevelBtnController implements java.awt.event.ActionListener {
	int nextLevel;
	public CreateLevelBtnController (int highestLevel) {
		this.nextLevel = highestLevel+1;
	}
	
	public void actionPerformed(ActionEvent ae) {
		//do something
		System.out.println("Create new level #"+nextLevel);
	}
}
