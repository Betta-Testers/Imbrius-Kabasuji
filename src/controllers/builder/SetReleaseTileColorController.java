/**
 * 
 */
package controllers.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
