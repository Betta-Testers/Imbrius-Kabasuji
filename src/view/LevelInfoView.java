package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.SwingConstants;

/**
 * Shows the stars and level number associated to each level in the level selection screen.
 * @author awharrison
 *
 */
public class LevelInfoView extends JPanel {
	private static final long serialVersionUID = 1L;
	
	/**Displays the stars for the LevelInfoView.**/
	StarView starView;
	/**Displays the level number for the LevelInfoView.**/
	JLabel lblLevelNumber;
	
	/**
	 * Creates a new LevelInfoView with a given levelID.
	 * @param levelID - int
	 */
	public LevelInfoView(int levelID) {
		this.setPreferredSize(new Dimension(145, 80));
		starView = new StarView();
		lblLevelNumber = new JLabel("Level "+levelID);
		
		setupLayout();
	}
	
	/**
	 * Sets up the layout for the LevelInfoView.
	 */
	private void setupLayout() {
		
		lblLevelNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevelNumber.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(37)
							.addComponent(lblLevelNumber))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(starView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblLevelNumber)
					.addGap(5)
					.addComponent(starView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(39, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	/**
	 * Sets the stars for the LevelInfoView from an int input.
	 * @param numStars - int
	 */
	public void setStars(int numStars) {
		starView.setNumStars(numStars);
	}

}
