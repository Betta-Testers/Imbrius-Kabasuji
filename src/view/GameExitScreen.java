package view;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;

public class GameExitScreen extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton btnReturnToLevel;
	StarView stars;

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
	
	public JButton getExitButton() {
		return this.btnReturnToLevel;
	}
	/**
	 * Method for setting up the layout for the GameExitScreen
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
	 * A method used by outside objects/classes to retrieve the button to return to a level
	 * @return JButton the button used to return to a level
	 */
	JButton getBtnReturnToLevel(){
		return btnReturnToLevel;
	}
	
	/**
	 * A method used by outside objects/classes to retrieve the StarView of a GameExitScreen
	 * @return StarView the StarView associated with the level being exited
	 */
	StarView getStars(){
		return stars;
	}
	
	/**
	 * A method used by outside objects/classes to set the number of stars associated with this GameExitScreen
	 * @param stars the number of stars to set the GameExitScreens star parameter
	 */
	void setStars(StarView stars){
		this.stars = stars;
	}
}
