package gameMockups;

import java.awt.Dimension;

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
	JLabel lblStar1;
	JLabel lblStar2;
	JLabel lblStar3;
	
	public StarView() {
		setPreferredSize(new Dimension(144, 48));
		lblStar1 = new JLabel("");
		lblStar1.setIcon(new ImageIcon(StarView.class.getResource("/icons/outline_star.png")));
		
		lblStar2 = new JLabel("");
		lblStar2.setIcon(new ImageIcon(StarView.class.getResource("/icons/outline_star.png")));
		
		lblStar3 = new JLabel("");
		lblStar3.setIcon(new ImageIcon(StarView.class.getResource("/icons/outline_star.png")));
		setupLayout();

	}
	
	void setupLayout(){
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblStar1)
					.addComponent(lblStar2)
					.addComponent(lblStar3))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStar1)
						.addComponent(lblStar2)
						.addComponent(lblStar3)))
		);
		this.setLayout(groupLayout);
	}

}
