/**
 * 
 */
package controllers;

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
public class SetReleaseTileColorController implements ChangeListener {
	ReleaseNumberCreationView rncv;
	public SetReleaseTileColorController(ReleaseNumberCreationView rncv) {
		this.rncv = rncv;
	}
	
	public void stateChanged(ChangeEvent ce) {
		//TODO Move class?
		rncv.updateNumberColors();
	}
}
