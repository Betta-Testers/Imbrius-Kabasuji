package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JToggleButton;
import model.Board;
import view.ReleaseNumberCreationView;

/**
 * 
 * @author awharrison
 *
 */
public class SetNumberTileController implements ActionListener {
	JToggleButton rncv; // TODO pretty sure that this will just be a JToggle Button from the ReleaseNumberCreationView class
	Board model;
	
	public SetNumberTileController(JToggleButton rncv, Board model) {
		this.rncv = rncv;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String stringValue = ((JToggleButton) e.getSource()).getText();
		int value = Integer.parseInt(stringValue);
		model.toggleReleaseNumber(value);
	}

	
}
