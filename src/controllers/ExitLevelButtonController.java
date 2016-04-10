package controllers;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import view.LevelView;
import App.Game;

public class ExitLevelButtonController extends WindowAdapter{
	
	// TODO AbstractLevelModel m;
	Game game;
	LevelView view;
	
	public ExitLevelButtonController(LevelView v, Game g) {
		this.view = v;
		this.game = g;
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		game.getSelectView().setVisible(true);
		view.dispose();
		
	}
}
