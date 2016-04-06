package gameMockups;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class TimeRemainingView extends JPanel {
	public TimeRemainingView() {
		
		JTextPane textPaneTime = new JTextPane();
		textPaneTime.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textPaneTime.setText("0:00");
		
		JLabel lblTitle = new JLabel("Time Remaining");
		
		// TODO setupLayout
		// TODO setupLayout and consumes AbstractLevelModel
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(textPaneTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTitle))
					.addContainerGap(45, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPaneTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
}
