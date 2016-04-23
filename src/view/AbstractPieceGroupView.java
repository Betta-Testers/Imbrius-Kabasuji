package view;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import model.PieceGroup;

/**
 * Abstract class to show each piece in the bullpen. The player and builder versions extend this and differ slightly
 * @author hejohnson
 * @author awharrison
 *
 */
public abstract class AbstractPieceGroupView extends JPanel{
	private static final long serialVersionUID = 1L;
	SelectPieceButton button;
	PieceGroup pieceGroup;
	ActionListener selectPieceHandler;
	
	
	public AbstractPieceGroupView(PieceGroup pieceGroup){
		setPreferredSize(new Dimension(72, 35));
		this.pieceGroup = pieceGroup;
		button = new SelectPieceButton(pieceGroup);
		button.setIcon(new ImageIcon(AbstractPieceGroupView.class.getResource("/pieces/"+pieceGroup.getPiece().getID()+".png")));
	}
	
	void setupLayout(){}
	
	/**
	 * Set action listener for the button in the piece group view. Clicking this button the corresponding piece as the selected piece in the preview area
	 * @param al The action listener to add to this button
	 */
	public void addSelectButtonActionListener (ActionListener al) {
		this.selectPieceHandler = al;
		this.button.addActionListener(al);
	}
	
	public ActionListener getPieceSelectHandler () {
		return this.selectPieceHandler;
	}
	
	public PieceGroup getPieceGroup(){
		return this.pieceGroup;
	}

	 abstract void updateCount();
}
