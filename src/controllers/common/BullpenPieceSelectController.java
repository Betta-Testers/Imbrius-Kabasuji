/**
 * 
 */
package controllers.common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Bullpen;
import view.SelectPieceButton;

/**
 * @author hejohnson
 *
 */

//TODO Add view refresh stuff
public class BullpenPieceSelectController implements ActionListener {
	Bullpen bp;
	public BullpenPieceSelectController (Bullpen bp) {
		this.bp = bp;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		SelectPieceButton source  = (SelectPieceButton) ae.getSource();
		bp.setSelectedPiece(source.getPieceID());
	}
}
