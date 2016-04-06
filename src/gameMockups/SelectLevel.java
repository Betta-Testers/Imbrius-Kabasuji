package gameMockups;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Font;

public class SelectLevel extends JFrame {

	JPanel contentPane;
	JLabel lblTitle;
	JScrollPane availableLevels;
	AvailableLevelView levels[];
	//Game game;
	/**
	 * Create the frame.
	 */
	public SelectLevel() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 640);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		
		lblTitle = new JLabel("Level Select");
		lblTitle.setFont(new Font("Comic Sans MS", Font.PLAIN, 64));
		
		availableLevels = new JScrollPane();
		availableLevels.setAutoscrolls(true);
		availableLevels.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		availableLevels.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JPanel scrollablePanel = new JPanel();
		availableLevels.setViewportView(scrollablePanel);
		
		levels = new AvailableLevelView[15];
		
		for(int i = 0; i < 15; i++){
			levels[i] = new AvailableLevelView("Level "+(i+1));
			scrollablePanel.add(levels[i]);
		}
		
		levels[0].unlockLevel(2);
		levels[1].unlockLevel(3);
		levels[2].unlockLevel(0);
		
		setupLayout();
		
	}
	
	void setupLayout() {
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(128)
							.addComponent(lblTitle))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(availableLevels, GroupLayout.PREFERRED_SIZE, 594, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(45)
					.addComponent(lblTitle)
					.addGap(102)
					.addComponent(availableLevels, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addGap(229))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
