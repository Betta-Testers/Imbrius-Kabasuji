package controllers.player;

import java.awt.event.ActionEvent;

import app.Game;
import view.LevelSelectionView;

public class PlayLevelButtonController implements java.awt.event.ActionListener {
	LevelSelectionView selectLevel;
	Game model;
	
	/**The ID of the level associated with this controller**/
	int levelID;
	
	public PlayLevelButtonController (LevelSelectionView selectLevel, Game g, int levelID) {
		this.selectLevel = selectLevel;
		this.model = g;
		this.levelID = levelID;
	}
	
	/**
	 * When the player clicks the button of the level they want to play,
	 * the game needs to initialize the view for that level, and the
	 * associated controllers.
	 */
	public void actionPerformed(ActionEvent ae) {
		model.getExitView().setStars(0);
		this.selectLevel.setVisible(false);
		model.displayLevel(levelID);
		//model.getLevelView().setVisible(true);
	}
}
