package controllers;

import java.awt.event.ActionEvent;

import view.LevelTypeSelectView;
import view.SelectLevel;

public class PlayLevelButtonController implements java.awt.event.ActionListener {
	SelectLevel selectLevel;
	
	public PlayLevelButtonController (SelectLevel selectLevel) {
		this.selectLevel = selectLevel;
	}
	
	public void actionPerformed(ActionEvent ae) {
		//do something
		System.out.println("IT WORKED!");
	}
}
