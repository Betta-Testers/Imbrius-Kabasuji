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
		
		JPanel panel = new JPanel();
		StarView starView = new StarView();
		panel.add(starView);
		GroupLayout groupLayout = new GroupLayout(frmGameOver.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(43)
							.addComponent(btnReturnToLevel))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnReturnToLevel)
					.addContainerGap())
		);
		frmGameOver.getContentPane().setLayout(groupLayout);
	}
}
