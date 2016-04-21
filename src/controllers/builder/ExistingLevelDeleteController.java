package controllers.builder;

import java.awt.event.ActionEvent;

import view.ExistingLevelView;

import app.Builder;

public class ExistingLevelDeleteController implements java.awt.event.ActionListener {
	Builder b;
	
	public ExistingLevelDeleteController (Builder b) {
		this.b = b;
	}

	/**
	 * Reads the source button for the level to be read into file and launched
	 * in the editor. Directs flow of information in the builder. When all is done
	 * the level should be displayed in the editor and the type select hidden
	 * from view.
	 */
	public void actionPerformed(ActionEvent ae) {
		ExistingLevelView sourceButton = (ExistingLevelView) ae.getSource();
		int levelID = sourceButton.getLevelNumber();
		b.deleteLevel(levelID);
	}
}