package gameMockups;

import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class AbstractPieceGroupView extends JPanel{
	GroupLayout layout;
	JButton button;
	
	//TODO: Change AbstractPieceGroupView contructor to take in a piece group. Get the Piece ID from the piece in the PieceGroup
	public AbstractPieceGroupView(int id){
		setPreferredSize(new Dimension(72, 35));
		button = new JButton("");
		button.setIcon(new ImageIcon(AbstractPieceGroupView.class.getResource("/pieces/"+id+".png")));
	}
	
	void setupLayout(){}
}
