package controllers;

import java.awt.event.ActionEvent;

import App.Game;
import view.LevelSelectionView;

public class PlayLevelButtonController implements java.awt.event.ActionListener {
	LevelSelectionView selectLevel;
	Game model;
	
	public PlayLevelButtonController (LevelSelectionView selectLevel, Game g) {
		this.selectLevel = selectLevel;
		this.model = g;
	}
	
	public void actionPerformed(ActionEvent ae) {
		//do something
		this.selectLevel.setVisible(false);
		model.getLevelView().setVisible(true);
	}
}
