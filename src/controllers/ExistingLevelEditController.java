package controllers;

import java.awt.event.ActionEvent;
import view.ExistingLevelView;
import javax.swing.JButton;

public class ExistingLevelEditController implements java.awt.event.ActionListener {
	int levelNumber;
	public ExistingLevelEditController () {
	}
	
	//TODO Add builder stuff
	public void actionPerformed(ActionEvent ae) {
		//do something
		ExistingLevelView sourceButton = (ExistingLevelView) ae.getSource();
		System.out.println("Button " + sourceButton.getLevelNumber());
	}
}
