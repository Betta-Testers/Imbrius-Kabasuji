package controllers;

import java.awt.event.ActionEvent;

import javax.swing.JToggleButton;

import view.LevelTypeSelectView;
import view.LevelTypeToggle;

public class NewLevelTypeController implements java.awt.event.ActionListener {
	String newLevelType;
	LevelTypeToggle clickSource;
	LevelTypeSelectView ltsv;
	public NewLevelTypeController (LevelTypeSelectView ltsv) {
		this.ltsv = ltsv;
	}
	
	public void actionPerformed(ActionEvent ae) {
		//do something
		clickSource = (LevelTypeToggle) ae.getSource();
		ltsv.getLevelDescriptionBox().setText(clickSource.getLevelType());
		ltsv.getCreateLevelBtn().setEnabled(true);
		//System.out.println("Button " + clickSource.getLevelType());
	}
}