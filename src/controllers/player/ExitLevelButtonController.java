package controllers.player;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import app.Game;
import view.LevelView;

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
		game.getExitView().setStars(game.getCurrentLevel().getStarsEarned());
		game.getExitView().setVisible(true);
		view.dispose();
		
	}
}
