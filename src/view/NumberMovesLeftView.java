package view;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class NumberMovesLeftView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextPane numberMoves;
	JLabel lblTitle;
	// TODO AbstractLevelModel m
	public NumberMovesLeftView() {
		
		numberMoves = new JTextPane();
		numberMoves.setFont(new Font("Tahoma", Font.PLAIN, 24));
		numberMoves.setText("4");
		
		lblTitle = new JLabel("Moves Remaining");
		
		setupLayout();
		
	}
	
	private void setupLayout() {
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblTitle))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(45)
							.addComponent(numberMoves, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addComponent(lblTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(numberMoves, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
}
