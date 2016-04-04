package gameMockups;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GameExitScreen {

	private JFrame frmGameOver;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameExitScreen window = new GameExitScreen();
					window.frmGameOver.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameExitScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGameOver = new JFrame();
		frmGameOver.setTitle("GAME OVER");
		frmGameOver.setBounds(100, 100, 260, 175);
		frmGameOver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnReturnToLevel = new JButton("Return to Level Select");
		
		StarView starView = new StarView();
				
		GroupLayout groupLayout = new GroupLayout(frmGameOver.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addComponent(btnReturnToLevel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addComponent(starView, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(starView, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(btnReturnToLevel)
					.addContainerGap())
		);
		frmGameOver.getContentPane().setLayout(groupLayout);
	}
}
