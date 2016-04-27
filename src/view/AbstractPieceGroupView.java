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
	
	/**Button to select the piece. Stores the int ID of the PieceGroup.**/
	SelectPieceButton button;
	
	/**Stores a set of pieces.**/
	PieceGroup pieceGroup;
	
	/**Handles mouse events for the AbstractPieceGroupView.**/
	ActionListener selectPieceHandler;
	
	/**
	 * Creates a new AbstractPieceGroupView with an associated PieceGroup. Sets size and initializes the button.
	 * @param pieceGroup - PieceGroup
	 */
	public AbstractPieceGroupView(PieceGroup pieceGroup){
		setPreferredSize(new Dimension(72, 35));
		this.pieceGroup = pieceGroup;
		button = new SelectPieceButton(pieceGroup);
		button.setToolTipText(pieceGroup.getPiece().getID()+"");
		button.setIcon(pieceGroup.getPiece().generateIcon());
		//button.setIcon(new ImageIcon(AbstractPieceGroupView.class.getResource("/pieces/"+pieceGroup.getPiece().getID()+".png")));
	}
	
	/**
	 * Method stub for extension of JPanel.
	 */
	void setupLayout(){}
	
	/**
	 * Set action listener for the button in the piece group view. Clicking this button the corresponding piece as the selected piece in the preview area.
	 * @param al The action listener to add to this button
	 */
	public void addSelectButtonActionListener (ActionListener al) {
		this.selectPieceHandler = al;
		this.button.addActionListener(al);
	}
	
	/**
	 * Returns the selectPieceHandler ActionListener.
	 * @return selectPieceHandler - ActionListener
	 */
	public ActionListener getPieceSelectHandler () {
		return this.selectPieceHandler;
	}
	
	/**
	 * Returns the PieceGroup associated with the AbstractPieceGroupView.
	 * @return pieceGroup - PieceGroup
	 */
	public PieceGroup getPieceGroup(){
		return this.pieceGroup;
	}
	
	/**
	 * Returns the SelectPieceButton associated with the AbstractPieceGroupView.
	 * @return button - SelectPieceButton
	 */
	public SelectPieceButton getSelectPieceButton() {
		return this.button;
	}

	
	abstract void updateCount();
}
