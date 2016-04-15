/**
 * 
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.AbstractLevelModel;
import model.PuzzleLevel;
import view.BuilderView;
import view.LevelPropertiesView;
import view.ReleaseNumberCreationView;

/**
 * @author hejohnson
 *
 */
public class SetReleaseTileColorController implements ActionListener {
	ReleaseNumberCreationView rncv;
	public SetReleaseTileColorController(ReleaseNumberCreationView rncv) {
		this.rncv = rncv;
	}
	
	public void actionPerformed(ActionEvent ce) {
		//TODO Move class?
		rncv.updateNumberColors();
	}
}