package controllers;

import java.awt.event.ActionEvent;

import view.ExistingLevelView;

import app.Builder;

public class ExistingLevelEditController implements java.awt.event.ActionListener {
	Builder b;
	
	/**
	 * Controller to open an existing level for editing
	 * @param b The builder object that this is a part of
	 * @author hejohnson
	 */
	public ExistingLevelEditController (Builder b) {
		this.b = b;
	}

	/**
	 * Reads the source button for the level to be read into file and launched
	 * in the editor. Directs flow of information in the builder. When all is done
	 * the level should be displayed in the editor and the type select hidden
	 * from view.
	 * @param ae The event that triggered this controller. Used to determine the level to open
	 * @author hejohnson
	 */
	public void actionPerformed(ActionEvent ae) {
		ExistingLevelView sourceButton = (ExistingLevelView) ae.getSource();
		int levelID = sourceButton.getLevelNumber();
		b.setModelLevelEditing(levelID);
		b.setBuilderViewVisible(true);
		b.setLevelTypeSelectViewVisible(false);
	}
}
