package view;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;

/**
 * Shows the window after the user quits the game.
 * @author ejbosia
 *
 */
public class GameExitScreen extends JFrame{
	private static final long serialVersionUID = 1L;
	
	/**Button to return to level selection screen.**/
	JButton btnReturnToLevel;
	
	/**StarView associated with the game exit screen.**/
	StarView stars;

	/**
	 * Creates a new game exit screen with a given StarView.
	 * @param stars - StarView
	 */
	public GameExitScreen(StarView stars) {
		this.stars = stars;
		this.setTitle("GAME OVER");
		this.setBounds(100, 100, 260, 175);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		btnReturnToLevel = new JButton("Return to Level Select");
		btnReturnToLevel.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		setupLayout();
		
		//add Game to constructor
		//btnReturnToLevel.addActionListener(new QuitGameButtonController(this));
	}
	
	/**
	 * Returns the button used to exit the game exit screen and return to the level selection screen.
	 * @return btnReturnToLevel - JButton
	 */
	public JButton getExitButton() {
		return this.btnReturnToLevel;
	}
	/**
	 * Sets up the layout for the GameExitScreen.
	 */
	void setupLayout(){
		GroupLayout groupLayout = new GroupLayout(this.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addComponent(btnReturnToLevel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addComponent(stars, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(stars, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(btnReturnToLevel)
					.addContainerGap())
		);
		this.getContentPane().setLayout(groupLayout);
	}
	
	
	/**
	 * Returns the button to return to a level.
	 * @return btnReturnToLevel - JButton
	 */
	JButton getBtnReturnToLevel(){
		return btnReturnToLevel;
	}
	
	/**
	 * Returns the StarView of a GameExitScreen.
	 * @return stars - StarView
	 */
	StarView getStars(){
		return stars;
	}
	
	/**
	 * Set the number of stars associated with this GameExitScreen.
	 * @param starNum number of stars being set
	 */
	public void setStars(int starNum){
		stars.setNumStars(starNum);
	}
}
