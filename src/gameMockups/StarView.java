package gameMockups;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

public class StarView extends JPanel {

	/**
	 * Create the panel.
	 */
	public StarView() {
		
		JLabel lblStar1 = new JLabel("");
		lblStar1.setIcon(new ImageIcon(StarView.class.getResource("/icons/star.png")));
		
		JLabel lblStar2 = new JLabel("");
		lblStar2.setIcon(new ImageIcon(StarView.class.getResource("/icons/outline_star.png")));
		
		JLabel lblStar3 = new JLabel("");
		lblStar3.setIcon(new ImageIcon(StarView.class.getResource("/icons/outline_star.png")));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblStar1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblStar2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblStar3)
					.addContainerGap(33, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStar1)
						.addComponent(lblStar2)
						.addComponent(lblStar3))
					.addContainerGap(122, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

}
