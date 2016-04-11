package view;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import controllers.QuitGameButtonController;
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
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnReturnToLevel = new JButton("Return to Level Select");
		btnReturnToLevel.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		setupLayout();

		//add Game to constructor
		//btnReturnToLevel.addActionListener(new QuitGameButtonController(this));
	}
	
	public JButton getExitButton() {
		return this.btnReturnToLevel;
	}

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
	
	
	//return "Return to Level Select" Button
	JButton getBtnReturnToLevel(){
		return btnReturnToLevel;
	}
	
	//return StarView
	StarView getStars(){
		return stars;
	}
	
	//set StarView
	void setStars(StarView stars){
		this.stars = stars;
	}
}
