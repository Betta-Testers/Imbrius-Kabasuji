package builderMockups;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class PieceGroup extends JPanel{	
	JSpinner spinner;
	JButton button;
	GroupLayout layout;
	
	public PieceGroup(int pieceNumber) {
		this.setPreferredSize(new Dimension(72, 35));
		button = new JButton("");
		spinner = new JSpinner();
		
		button.setIcon(new ImageIcon(PieceGroup.class.getResource("/pieces/"+pieceNumber+".png")));
		
		layout = new GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createParallelGroup(Alignment.TRAILING)
					.addComponent(spinner, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
					.addComponent(button, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
		);
		setLayout(layout);
	}
}
