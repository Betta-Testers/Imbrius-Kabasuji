package controllers.player;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import app.Game;
import view.LevelView;

/**
 * Handles all the operations that occur when a level is exited (whether by user input or 3 stars being earned)
 * 
 * @author hejohnson
 * @author awharrison
 */
public class ExitLevelController extends WindowAdapter{
	/** The game object that holds all the window views and the level data **/
	Game game;
	
	/**
	 * @param g The current game
	 */
	public ExitLevelController(Game g) {
		this.game = g;
	}
	
	/**
	 * Updates the stars for the level that was being played, updates the stars on the level select and the exit screen
	 * If this level was the highest unlocked level, it unlocks the next level
	 * Then closes the gameplay window and launches the end of game window
	 * @param we The window event that triggered the controller
	 */
	@Override
	public void windowClosing(WindowEvent we) {
		game.updateStars(game.getCurrentLevel().getID(), game.getCurrentLevel().getStarsEarned());
		game.getSelectView().updateStarsForLevel(game.getCurrentLevel().getID(), game.getCurrentLevel().getStarsEarned());
		if (game.highestUnlockedID() == game.getCurrentLevel().getID()) {
			game.unlockNextLevel();
		}
		game.getExitView().setStars(game.getCurrentLevel().getStarsEarned());
		game.getExitView().setVisible(true);
		game.getLevelView().dispose();
	}
}
