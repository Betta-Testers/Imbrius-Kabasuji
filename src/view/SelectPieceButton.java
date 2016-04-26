/**
 * 
 */
package view;

import javax.swing.JButton;

import model.PieceGroup;

/**
 * Only difference from a JButton is that a SelectedPieceButton stores the pieceID of the PieceGroup associated with it.
 * @author hejohnson
 *
 */
public class SelectPieceButton extends JButton {
	private static final long serialVersionUID = 1L;
	/**Stores the ID of the PieceGroup associated with this.**/
	int pieceID;
	
	/**
	 * Creates a SelectedPieceButton.
	 * @param pieceGroup - PieceGroup
	 */
	SelectPieceButton(PieceGroup pieceGroup) {
		super();
		this.pieceID = pieceGroup.getPiece().getID();
	}
	
	/**
	 * Returns the pieceID.
	 * @return pieceID - int
	 */
	public int getPieceID() {
		return this.pieceID;
	}
}
