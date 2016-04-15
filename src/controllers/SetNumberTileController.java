package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ReleaseTile;
import view.ReleaseNumberCreationView;

/**
 * 
 * @author awharrison
 *
 */
public class SetNumberTileController implements ActionListener {
	ReleaseNumberCreationView rncv;
	ReleaseTile model;
	
	public SetNumberTileController(ReleaseNumberCreationView rncv, ReleaseTile model) {
		this.rncv = rncv;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO get the number from the button
		// Set that number to the number of the release tile
	}

	
}
