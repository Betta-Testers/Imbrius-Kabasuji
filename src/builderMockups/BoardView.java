package builderMockups;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

public class BoardView extends JPanel{
	
	public BoardView(){
		setPreferredSize(new Dimension(384, 384));
		setBackground(Color.WHITE);
		
		setupLayout();
	}
	
	private void setupLayout(){
	}
}
