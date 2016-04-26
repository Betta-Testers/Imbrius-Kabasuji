package controllers.player;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import app.Game;
import view.LevelView;

public class ExitLevelButtonController extends WindowAdapter{
	Game game;
	LevelView view;
	
	public ExitLevelButtonController(LevelView v, Game g) {
		this.view = v;
		this.game = g;
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		game.updateStars(game.getCurrentLevel().getID(), game.getCurrentLevel().getStarsEarned());
		game.getSelectView().updateStarsForLevel(game.getCurrentLevel().getID(), game.getCurrentLevel().getStarsEarned());
		System.out.println(game.highestUnlockedID());
		if (game.highestUnlockedID() == game.getCurrentLevel().getID()) {
			game.unlockNextLevel();
		}
		game.getExitView().setStars(game.getCurrentLevel().getStarsEarned());
		game.getExitView().setVisible(true);
		view.dispose();
	}
}
