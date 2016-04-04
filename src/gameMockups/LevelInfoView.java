package gameMockups;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.SwingConstants;

public class LevelInfoView extends JPanel {
	public LevelInfoView() {
		
		StarView starView = new StarView();
		
		JLabel lblLevelNumber = new JLabel("Level 1");
		lblLevelNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevelNumber.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(starView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(243, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(293, Short.MAX_VALUE)
					.addComponent(lblLevelNumber)
					.addGap(78))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLevelNumber)
					.addGap(5)
					.addComponent(starView, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(184, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

}
