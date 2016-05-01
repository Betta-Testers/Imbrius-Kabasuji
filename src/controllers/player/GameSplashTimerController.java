package controllers.player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import app.Game;
import view.SplashScreen;

/**
 * The controller to close the splash screen and launch the level select
 * @author dfontana
 *
 */
public class GameSplashTimerController implements ActionListener{
	/** The splash screen **/
	SplashScreen view;
	/** The game object that will be used to play levels in **/
	Game g;
	
	/**
	 * Creates a controller to close the splash screen and display the level select view
	 * @param view The splash screen
	 * @param g The game object
	 */
	public GameSplashTimerController(SplashScreen view, Game g){
		this.view = view;
		this.g = g;
	}
	
	/**
	 * Closes the splash screen and shows the level select screen
	 * @param e - button click event
	 */
	public void actionPerformed(ActionEvent e){
		view.dispose();
		g.getSelectView().setVisible(true);
	}
}
