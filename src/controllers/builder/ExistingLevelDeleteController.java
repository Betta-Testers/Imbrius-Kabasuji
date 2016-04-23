package controllers.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.ExistingLevelView;
import app.Builder;

/**
 * Deletes an existing level in the Builder application
 * @author hejohnson
 *
 */
public class ExistingLevelDeleteController implements ActionListener {
	Builder b;
	
	public ExistingLevelDeleteController (Builder b) {
		this.b = b;
	}

	/**
	 * Reads the source button for the level ID to be deleted, and tells the builder to remove it
	 */
	public void actionPerformed(ActionEvent ae) {
		JButton sourceButton = (JButton) ae.getSource();
		ExistingLevelView elv = (ExistingLevelView) sourceButton.getParent();
		int levelID = elv.getLevelNumber();
		b.deleteLevel(levelID);
	}
}