package controllers.player;

import java.awt.event.ActionEvent;

import app.Game;
import view.LevelSelectionView;

/**
 * Listener for when the play level button is pressed, launching the levelView of the
 * level associated with this controller.
 * @author awharrison
 */
public class PlayLevelButtonController implements java.awt.event.ActionListener {
	/** The view that this button is a part of **/
	LevelSelectionView selectLevel;
	/** The game object that plays the levels **/
	Game model;
	
	/**The ID of the level associated with this controller**/
	int levelID;
	
	/** 
	 * Creates a controller to play a level based on the button that was clicked
	 * @param selectLevel The window that this button is a part of
	 * @param g The game object used to play levels
	 * @param levelID The level ID that this button is associated with
	 */
	public PlayLevelButtonController (LevelSelectionView selectLevel, Game g, int levelID) {
		this.selectLevel = selectLevel;
		this.model = g;
		this.levelID = levelID;
	}
	
	/**
	 * When the player clicks the button of the level they want to play,
	 * the game needs to initialize the view for that level, and the
	 * associated controllers.
	 * @param ae - Button pressed event
	 */
	public void actionPerformed(ActionEvent ae) {
		model.getExitView().setStars(0);
		this.selectLevel.setVisible(false);
		model.displayLevel(levelID);
	}
}
