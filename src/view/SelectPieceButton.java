/**
 * 
 */
package view;

import javax.swing.JButton;

import model.PieceGroup;

/**
 * @author hejohnson
 *
 */
public class SelectPieceButton extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int pieceID;
	SelectPieceButton(PieceGroup pieceGroup) {
		super();
		this.pieceID = pieceGroup.getPiece().getID();
	}
	
	public int getPieceID() {
		return this.pieceID;
	}
}
