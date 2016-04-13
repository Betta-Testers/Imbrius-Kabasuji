/**
 * 
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.Builder;
import model.AbstractLevelModel;
import view.BuilderView;

/**
 * @author hejohnson
 *
 */
public class SaveAndCloseLevelButtonController implements ActionListener {
	Builder builder;
	public SaveAndCloseLevelButtonController (Builder b) {
		this.builder = b;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		builder.saveLevel();
		builder.setBuilderViewVisible(false);
		builder.setLevelTypeSelectViewVisible(true);
	}

}
