package controllers.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ReleaseNumberCreationView;

/**
 * Controller for setting the color of the release tiles being made
 * @author hejohnson
 */
public class SetReleaseTileColorController implements ActionListener {
	/**View that is creating tiles**/
	ReleaseNumberCreationView rncv;
	
	/**
	 * Creates the controller
	 * @param rncv - View for creating the release tiles
	 */
	public SetReleaseTileColorController(ReleaseNumberCreationView rncv) {
		this.rncv = rncv;
	}
	
	/**
	 * When the button is pressed, the view updates which set of colored tiles it
	 * is displaying for creation.
	 * @param ce button pressed in drop down
	 */
	public void actionPerformed(ActionEvent ce) {
		rncv.updateNumberColors();
	}
}
