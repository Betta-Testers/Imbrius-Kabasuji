package controllers.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controllers.common.Move;
import model.Board;
import model.Bullpen;
import view.BoardView;
import view.BullpenView;

/**
 * 
 * @author awharrison
 * @author Dylan
 *
 */

public class RemovePiecesButton implements ActionListener{
	Board b;
	BoardView bv;
	Bullpen bp;
	BullpenView bpv;
	
	public RemovePiecesButton(Board b, BoardView bv, Bullpen bp, BullpenView bpv) {
		this.b = b;
		this.bv = bv;
		this.bp = bp;
		this.bpv = bpv;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		Move m = new RemoveAllPiecesMove(b, bp, bpv);
		if(m.doMove()){
			bv.redraw();
			bv.repaint();
		}
	}
}
