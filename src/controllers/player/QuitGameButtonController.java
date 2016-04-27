package controllers.player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import app.Game;

import view.GameExitScreen;

/**
 * Controller connecting the GameExitScreen to the LevelSelection.
 * @author awharrison
 */
public class QuitGameButtonController implements ActionListener{
	/** The exit screen that **/
	GameExitScreen view;
	/** The game that spawned the exit screen **/
	Game game;
	
	/**
	 * @param view The exit screen view
	 * @param g The game object
	 */
	public QuitGameButtonController(GameExitScreen view, Game g){
		this.view = view;
		this.game = g;

	}
	
	/** 
	 * Closes the exit screen and shows the level selector
	 * @param e The mouse event that triggered this controller
	 */
	public void actionPerformed(ActionEvent e){
	
		game.getSelectView().setVisible(true);
		view.dispose();
	}
}

