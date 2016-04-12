package controllers;

import java.awt.event.ActionEvent;

import app.Builder;

public class CreateLevelBtnController implements java.awt.event.ActionListener {	
	Builder b;

	/**
	 * Controller for the button on the level type select screen of the builder to create a new level
	 * @param b The builder object that this is a part of
	 * @author hejohnson
	 */
	public CreateLevelBtnController (Builder b) {
		this.b = b;
	}
	
	/**
	 * When the create level button is hit, Builder is notified through setModelLevel().
	 * The BuilderView is then set visible
	 * The LevelTypeSelectView is then hidden.
	 * @param ae The event that triggered this controller
	 * @author hejohnson
	 */
	public void actionPerformed(ActionEvent ae) {
		b.setModelLevelCreation();
		b.setBuilderViewVisible(true);
		b.setLevelTypeSelectViewVisible(false);
	}
}
