package controllers;

import java.awt.event.ActionEvent;

import app.Builder;
import view.LevelTypeSelectView;

public class CreateLevelBtnController implements java.awt.event.ActionListener {	
	Builder b;

	public CreateLevelBtnController (Builder b) {
		this.b = b;
	}
	
	/**
	 * When the create level button is hit, Builder is notified through setModelLevel().
	 * The BuilderView is then set visible
	 * The LevelTypeSelectView is then hidden.
	 */
	public void actionPerformed(ActionEvent ae) {
		b.setModelLevelCreation();
		b.setBuilderViewVisible(true);
		b.setLevelTypeSelectViewVisible(false);
	}
}
