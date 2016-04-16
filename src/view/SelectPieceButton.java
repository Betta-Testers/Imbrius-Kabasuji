/**
 * 
 */
package view;

import javax.swing.JButton;

/**
 * @author hejohnson
 *
 */
public class SelectPieceButton extends JButton {
	int pieceID;
	SelectPieceButton(int id) {
		super();
		this.pieceID = id;
	}
	
	public int getPieceID() {
		return this.pieceID;
	}
}
