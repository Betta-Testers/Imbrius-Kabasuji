package controllers.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Board;
import view.BoardView;

/**
 * 
 * @author awharrison
 * @author Dylan
 *
 */

public class RemovePiecesButton implements ActionListener{
	Board b;
	BoardView bv;
	
	public RemovePiecesButton (Board b, BoardView bv) {
		this.b = b;
		this.bv = bv;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Triggered");
		b.resetBoard();
		bv.redraw();
		bv.repaint();
	}
}
