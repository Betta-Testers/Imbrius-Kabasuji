package view;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import model.PieceGroup;

public abstract class AbstractPieceGroupView extends JPanel{
	private static final long serialVersionUID = 1L;
	SelectPieceButton button;
	PieceGroup pieceGroup;
	
	
	//TODO: Change AbstractPieceGroupView contructor to take in a piece group. Get the Piece ID from the piece in the PieceGroup
	public AbstractPieceGroupView(PieceGroup pieceGroup){
		setPreferredSize(new Dimension(72, 35));
		this.pieceGroup = pieceGroup;
		button = new SelectPieceButton(pieceGroup);
		button.setIcon(new ImageIcon(AbstractPieceGroupView.class.getResource("/pieces/"+pieceGroup.getPiece().getID()+".png")));
	}
	
	void setupLayout(){}
}
