package controllers.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;

/**
 * ActionListener for the PlacePieces Toggle button. Sets the two other buttons that manipulates
 * piece placement enabled or disabled depending on the state of this button. Additionally,
 * it clears the selection whenever toggled, to prevent accidental placements
 * @author dfontana
 */
public class PlacePieceToggleListener implements ActionListener {
	/**Toggle button for placing boardTiles, gets set enabled/disabled**/
	JToggleButton placeBoard;
	/**Toggle button for placing hints, gets set enabled/disabled**/
	JToggleButton placeHint;
	/**Button group that holds the hint and board toggle buttons**/
	ButtonGroup group;

	/**
	 * Creates the listener
	 * @param tglbtnPlaceBoard - toggle button for placing board tiles from pieces
	 * @param tglbtnPlaceHints - toggle button for placing hints from pieces
	 * @param group - button group that groups the buttons passed
	 */
	public PlacePieceToggleListener(JToggleButton tglbtnPlaceBoard, JToggleButton tglbtnPlaceHints, ButtonGroup group) {
		this.placeBoard = tglbtnPlaceBoard;
		this.placeHint = tglbtnPlaceHints;
		this.group = group;
	}

	/**
	 * When toggled, the group's selection is cleared and the hint/board toggles are enabled for clicking
	 * Regulates movements in the views
	 * @param ActionEvent of button press
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		JToggleButton source = (JToggleButton) ae.getSource();
		boolean selected = source.getModel().isSelected();
		
		placeBoard.setEnabled(selected);
		placeHint.setEnabled(selected);
		group.clearSelection();
	}
}
