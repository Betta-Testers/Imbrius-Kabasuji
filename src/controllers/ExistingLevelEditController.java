package controllers;

import java.awt.event.ActionEvent;

public class ExistingLevelEditController implements java.awt.event.ActionListener {
	int levelNumber;
	public ExistingLevelEditController (int levelNumber) {
		this.levelNumber = levelNumber;
	}
	
	public void actionPerformed(ActionEvent ae) {
		//do something
		System.out.println("Button " + levelNumber);
	}
}
