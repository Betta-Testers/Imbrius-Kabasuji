package gameMockups;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;

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
		frmGameOver.setBounds(100, 100, 260, 160);
		frmGameOver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GameExitScreen.class.getResource("/gameMockups/star.png")));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(GameExitScreen.class.getResource("/gameMockups/star.png")));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(GameExitScreen.class.getResource("/gameMockups/outline_star.png")));
		
		JButton btnReturnToLevel = new JButton("Return to Level Select");
		GroupLayout groupLayout = new GroupLayout(frmGameOver.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel)
							.addGap(37)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
							.addComponent(lblNewLabel_2))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addComponent(btnReturnToLevel)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
					.addComponent(btnReturnToLevel)
					.addContainerGap())
		);
		frmGameOver.getContentPane().setLayout(groupLayout);
	}
}
