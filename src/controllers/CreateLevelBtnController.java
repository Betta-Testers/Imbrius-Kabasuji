package controllers;

import java.awt.event.ActionEvent;

import app.Builder;
import view.LevelTypeSelectView;

/**
 * 
 * @author hejohnson
 *
 */

/**
 * 
 * @author hejohnson
 *
 */

public class CreateLevelBtnController implements java.awt.event.ActionListener {	
	Builder b;
	LevelTypeSelectView ltsv;

	/**
	 * Controller for the button on the level type select screen of the builder to create a new level
	 * @param b The builder object that this is a part of
	 */

	public CreateLevelBtnController (Builder b, LevelTypeSelectView ltsv) {
		this.b = b;
		this.ltsv = ltsv;
	}
	
	/**
	 * When the create level button is hit, Builder is notified through setModelLevel().
	 * The BuilderView is then set visible
	 * The LevelTypeSelectView is then hidden.
	 * @param ae The event that triggered this controller
	 */
	public void actionPerformed(ActionEvent ae) {
		b.setModelLevelCreation(ltsv.getSelectedLevelType());
		b.setBuilderViewVisible(true);
		b.setLevelTypeSelectViewVisible(false);
	}
}
