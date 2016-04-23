package controllers.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;

/**
 * ActionListener for the PlacePieces Toggle button. Sets the two other buttons that manipulates
 * piece placement enabled or disabled depending on the state of this button. Additionally,
 * it clears the selection whenever toggled, to prevent accidental placements
 * @author Dylan
 *
 */
public class PlacePieceToggleListener implements ActionListener {
	JToggleButton placeBoard;
	JToggleButton placeHint;
	ButtonGroup group;

	public PlacePieceToggleListener(JToggleButton tglbtnPlaceBoard, JToggleButton tglbtnPlaceHints, ButtonGroup group) {
		this.placeBoard = tglbtnPlaceBoard;
		this.placeHint = tglbtnPlaceHints;
		this.group = group;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		JToggleButton source = (JToggleButton) ae.getSource();
		boolean selected = source.getModel().isSelected();
		
		placeBoard.setEnabled(selected);
		placeHint.setEnabled(selected);
		group.clearSelection();
	}
}
