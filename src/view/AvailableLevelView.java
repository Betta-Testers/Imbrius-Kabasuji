package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.border.LineBorder;

import java.awt.Color;

/**
 * Shows the amount of stars, the level name, and a button to allow the user to play a level. This is used on the level selection screen in game.
 * @author dfontana
 *
 */

public class AvailableLevelView extends JPanel {

	private static final long serialVersionUID = 1L;
	GroupLayout layout;
	StarView starView;
	JButton btnSelectLevel;
	int levelID;
	String lvlname;
	

	/**
	 * Creates a new AvailableLevelView with a given levelID.
	 * @param levelID - int
	 */
	AvailableLevelView(int levelID) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setPreferredSize(new Dimension(148, 100));
		btnSelectLevel = new JButton("");
		btnSelectLevel.setEnabled(false);
		btnSelectLevel.setIcon(new ImageIcon(AvailableLevelView.class.getResource("/icons/LockIcon.png")));
		btnSelectLevel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lvlname = "Level "+levelID;
		starView = new StarView();
		this.levelID = levelID;
		
		setupLayout();
		this.setBackground(Color.WHITE);
	}
	
	/**
	 * Returns the levelID associated to the AvailableLevelView.
	 * @return levelID - int
	 */
	public int getLevelID() {
		return this.levelID;
	}
	
	/**
	 * Sets the number of stars displayed for this level to the specified number
	 * @param starsEarned - number of stars to display. Any number other than 1-3 will not change stars
	 */
	void updateStars(int starsEarned){
		if(starsEarned==1){
			starView.lblStar1.setIcon(new ImageIcon(StarView.class.getResource("/icons/star.png")));
		}
		if(starsEarned==2){
			starView.lblStar1.setIcon(new ImageIcon(StarView.class.getResource("/icons/star.png")));
			starView.lblStar2.setIcon(new ImageIcon(StarView.class.getResource("/icons/star.png")));
		}
		if(starsEarned==3){
			starView.lblStar1.setIcon(new ImageIcon(StarView.class.getResource("/icons/star.png")));
			starView.lblStar2.setIcon(new ImageIcon(StarView.class.getResource("/icons/star.png")));
			starView.lblStar3.setIcon(new ImageIcon(StarView.class.getResource("/icons/star.png")));
		}
	}
	
	/**
	 * Method for enabling the button to the user. This sets the level to be "unlocked"
	 * By default a button has an icon set, is disabled, and text is not set.
	 * Passing it an integer 1,2 or 3 will also display the correct number of stars for the
	 * level!
	 * Entering a 0 will unlock the level and set the stars to 0 by default
	 * @param i - int
	 */
	void unlockLevel(int i){
		btnSelectLevel.setText(lvlname);
		btnSelectLevel.setIcon(null);
		btnSelectLevel.setEnabled(true);
		starView.setNumStars(i);
	}
	
	/**
	 * Returns the select level button.
	 * @return btnSelectLevel - JButton
	 */
	public JButton getPlayButton(){
		return btnSelectLevel;
	}
	
	/**
	 * Method for setting up the layout for the AvailableLevelView.
	 */
	void setupLayout(){
		layout = new GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(1)
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnSelectLevel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(starView, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(btnSelectLevel, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(starView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		this.setLayout(layout);
	}

}
