package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JToggleButton;
import model.ReleaseTile;
import view.ReleaseNumberCreationView;

/**
 * 
 * @author awharrison
 *
 */
public class SetNumberTileController implements ActionListener {
	ReleaseNumberCreationView rncv; // TODO pretty sure that this will just be a JToggle Button from the ReleaseNumberCreationView class
	ReleaseTile model;
	
	public SetNumberTileController(ReleaseNumberCreationView rncv, ReleaseTile model) {
		this.rncv = rncv;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String stringValue = ((JToggleButton) e.getSource()).getText();
		int value = Integer.parseInt(stringValue);
		model.setNumber(value);
	}

	
}
