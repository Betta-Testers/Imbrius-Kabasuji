package builderMockups;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TileCreationView extends JPanel{
	public TileCreationView(){
		setPreferredSize(new Dimension(100, 140));
		JLabel lblTitle = new JLabel("Tile Creation");
		JButton btn1 = new JButton("1");
		JButton btn2 = new JButton("2");
		JButton btn3 = new JButton("3");
		JButton btn4 = new JButton("4");
		JButton btn5 = new JButton("5");
		JButton btn6 = new JButton("6");
		JLabel lblColor = new JLabel("Color:");
		JSpinner spinner = new JSpinner();
		
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn1.setForeground(Color.BLACK);
		btn1.setBackground(Color.BLUE);
		btn2.setForeground(Color.BLACK);
		btn2.setBackground(Color.BLUE);
		btn3.setForeground(Color.BLACK);
		btn3.setBackground(Color.BLUE);
		btn4.setForeground(Color.BLACK);
		btn4.setBackground(Color.BLUE);
		btn5.setForeground(Color.BLACK);
		btn5.setBackground(Color.BLUE);
		btn6.setForeground(Color.BLACK);
		btn6.setBackground(Color.BLUE);
		spinner.setModel(new SpinnerListModel(new String[] {"Blue", "Yellow", "Red"}));
		
		GroupLayout gl_panelTileCreation = new GroupLayout(this);
		gl_panelTileCreation.setHorizontalGroup(
				gl_panelTileCreation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTileCreation.createSequentialGroup()
						.addGroup(gl_panelTileCreation.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelTileCreation.createSequentialGroup()
										.addContainerGap()
										.addComponent(lblTitle))
								.addGroup(gl_panelTileCreation.createSequentialGroup()
										.addGap(8)
										.addGroup(gl_panelTileCreation.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panelTileCreation.createSequentialGroup()
														.addComponent(btn5)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(btn6))
												.addGroup(gl_panelTileCreation.createSequentialGroup()
														.addComponent(btn3)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(btn4))
												.addGroup(gl_panelTileCreation.createSequentialGroup()
														.addComponent(btn1)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(btn2))))
								.addGroup(gl_panelTileCreation.createSequentialGroup()
										.addGap(8)
										.addComponent(lblColor)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		gl_panelTileCreation.setVerticalGroup(
				gl_panelTileCreation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTileCreation.createSequentialGroup()
						.addGap(5)
						.addComponent(lblTitle)
						.addGroup(gl_panelTileCreation.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelTileCreation.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btn1))
								.addGroup(gl_panelTileCreation.createSequentialGroup()
										.addGap(6)
										.addComponent(btn2)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelTileCreation.createParallelGroup(Alignment.BASELINE)
								.addComponent(btn3)
								.addComponent(btn4))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelTileCreation.createParallelGroup(Alignment.BASELINE)
								.addComponent(btn5)
								.addComponent(btn6))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelTileCreation.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblColor)
								.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		this.setLayout(gl_panelTileCreation);
	}
}
