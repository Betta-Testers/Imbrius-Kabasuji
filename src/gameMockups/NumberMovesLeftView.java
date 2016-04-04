package gameMockups;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class NumberMovesLeftView extends JPanel {
	public NumberMovesLeftView() {
		
		JTextPane textPaneMoves = new JTextPane();
		textPaneMoves.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textPaneMoves.setText("4");
		
		JLabel lblMovesRemaining = new JLabel("Moves Remaining");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblMovesRemaining))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(45)
							.addComponent(textPaneMoves, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addComponent(lblMovesRemaining)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPaneMoves, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
}
