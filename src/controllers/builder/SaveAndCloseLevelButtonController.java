package controllers.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.Builder;

/**
 * Controller listening for a Save Button action. On save the builder is told to save
 * the level, the BuilderView is hidden and the LTSV is displayed
 * @author hejohnson
 * @author Dylan
 */
public class SaveAndCloseLevelButtonController implements ActionListener {
	Builder builder;
	public SaveAndCloseLevelButtonController (Builder b) {
		this.builder = b;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		builder.saveLevel();
		builder.getBuilderView().setVisible(false);
		builder.getLevelTypeSelectView().setVisible(true);
	}
}
