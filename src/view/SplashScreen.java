package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;

import java.io.*;
import javax.sound.sampled.*;

/**
 * Shows a screen with the name of the application and the authors. Everything set to comic sans for fun :).
 * @author bwoconnor
 * 
 */
public class SplashScreen extends JFrame {
	private static final long serialVersionUID = 1L;
	/**Panel for the SplashScreen.**/
	private JPanel contentPane;
	/**Shows the name of the game, set to "Kabasuji".**/
	JLabel lblGameName;
	/**Shows the name of the group, set to "Team Imbrius".**/
	JLabel lblGroupName;
	/**Shows the name of each group member (one for each JLabel).**/
	JLabel lblName1;
	JLabel lblName2;
	JLabel lblName3;
	JLabel lblName4;
	JLabel lblName5;

	
	/**
	 * Create the SplashScreen.
	 */
	public SplashScreen() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblGameName = new JLabel("Kabasuji");
		lblGameName.setFont(new Font("Comic Sans MS", Font.PLAIN, 99));
		
		lblGroupName = new JLabel("Team Imbrius");
		lblGroupName.setFont(new Font("Comic Sans MS", Font.PLAIN, 45));
		
		lblName1 = new JLabel("Abby Harrison");
		lblName1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		lblName2 = new JLabel("Brendan O'Connor");
		lblName2.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		
		lblName3 = new JLabel("Dylan Fontana");
		lblName3.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		
		lblName4 = new JLabel("Evan Bosia");
		lblName4.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		
		lblName5 = new JLabel("Hans Johnson");
		lblName5.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		setupLayout();
		setVisible(true);

	}
	
	/**
	 * Sets up the layout of the SplashScreen.
	 */
	public void setupLayout() {
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(118, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblGameName)
							.addGap(108))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblGroupName)
							.addGap(155))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblName1)
							.addGap(208))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblName2)
							.addGap(175))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblName3)
							.addGap(204))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblName4)
							.addGap(229))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblName5)
							.addGap(205))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblGameName)
					.addGap(18)
					.addComponent(lblGroupName)
					.addGap(18)
					.addComponent(lblName1)
					.addGap(18)
					.addComponent(lblName2)
					.addGap(18)
					.addComponent(lblName3)
					.addGap(18)
					.addComponent(lblName4)
					.addGap(18)
					.addComponent(lblName5)
					.addContainerGap(60, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	

}
