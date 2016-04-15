/**
 * 
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Bullpen;
import model.Piece;

/**
 * @author hejohnson
 *
 */
public class FlipPieceVerticalController implements ActionListener {
	Bullpen bullpen;
	Piece p;
	FlipPieceVerticalController(Bullpen bp) {
		this.bullpen = bp;
	}
	
	//TODO add redraw stuff
	public void actionPerformed(ActionEvent ae) {
		p = bullpen.getSelectedPiece();
		p.flipH();
	}
}
