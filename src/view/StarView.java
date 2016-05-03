package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

/**
 * This view displays the number of stars earned on a level.
 * @author awharrison
 * @author bwoconnor
 * @author hejohnson
 */
public class StarView extends JPanel {
	private static final long serialVersionUID = 1L;
	/**Shows an empty star or a filled star. One label for each of the three possible stars.**/
	JLabel lblStar1;
	JLabel lblStar2;
	JLabel lblStar3;
	
	/**
	 * Creates a StarView.
	 */
	public StarView() {
		setPreferredSize(new Dimension(144, 48));
		lblStar1 = new JLabel("");
		lblStar1.setIcon(new ImageIcon(StarView.class.getResource("/icons/outline_star.png")));
		
		lblStar2 = new JLabel("");
		lblStar2.setIcon(new ImageIcon(StarView.class.getResource("/icons/outline_star.png")));
		
		lblStar3 = new JLabel("");
		lblStar3.setIcon(new ImageIcon(StarView.class.getResource("/icons/outline_star.png")));
		setupLayout();
		this.setBackground(Color.WHITE);

	}
	
	/**
	 * Sets up the layout of StarVIew.
	 */
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
	
	/**
	 * Sets which stars to display (by changing the JLabels) from the given input of stars. This input ranges from 0 to 3.
	 * @param stars - int
	 */
	void setNumStars(int stars) {
		if(stars==0) {
			lblStar1.setIcon(new ImageIcon(StarView.class.getResource("/icons/outline_star.png")));
			lblStar2.setIcon(new ImageIcon(StarView.class.getResource("/icons/outline_star.png")));
			lblStar3.setIcon(new ImageIcon(StarView.class.getResource("/icons/outline_star.png")));
		}
		if(stars==1){
			lblStar1.setIcon(new ImageIcon(StarView.class.getResource("/icons/star.png")));
			lblStar2.setIcon(new ImageIcon(StarView.class.getResource("/icons/outline_star.png")));
			lblStar3.setIcon(new ImageIcon(StarView.class.getResource("/icons/outline_star.png")));
		}
		if(stars==2){
			lblStar1.setIcon(new ImageIcon(StarView.class.getResource("/icons/star.png")));
			lblStar2.setIcon(new ImageIcon(StarView.class.getResource("/icons/star.png")));
			lblStar3.setIcon(new ImageIcon(StarView.class.getResource("/icons/outline_star.png")));
		}
		if(stars==3){
			lblStar1.setIcon(new ImageIcon(StarView.class.getResource("/icons/star.png")));
			lblStar2.setIcon(new ImageIcon(StarView.class.getResource("/icons/star.png")));
			lblStar3.setIcon(new ImageIcon(StarView.class.getResource("/icons/star.png")));
		}
		
	}

}
