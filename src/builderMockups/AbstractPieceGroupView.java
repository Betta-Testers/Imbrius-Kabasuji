package builderMockups;

import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class AbstractPieceGroupView extends JPanel{
	GroupLayout layout;
	JButton button;
	
	public AbstractPieceGroupView(int id){
		setPreferredSize(new Dimension(72, 35));
		button = new JButton("");
		
		if(id > 35 || id < 1){
			button.setText("N/A");
		}else{
			button.setIcon(new ImageIcon(AbstractPieceGroupView.class.getResource("/pieces/"+id+".png")));
		}
	}
	
	void setupLayout(){}
}
