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
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.AbstractListModel;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JProgressBar;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;


public class SelectLevel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectLevel frame = new SelectLevel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SelectLevel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblLevelSelect = new JLabel("Level Select");
		lblLevelSelect.setFont(new Font("Comic Sans MS", Font.PLAIN, 64));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(true);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JPanel scrollablePanel = new JPanel();
		scrollPane.setViewportView(scrollablePanel);
		
		//level 1 select//
		AvailableLevelView lvl1Panel = new AvailableLevelView();
		scrollablePanel.add(lvl1Panel);
		
		//level 2 select//
		JPanel lvl2Panel = new JPanel();
		scrollablePanel.add(lvl2Panel);
		
		JToggleButton lvl2Toggle = new JToggleButton("Level 2");
		
		JLabel lvl2Stars = new JLabel("");
		lvl2Stars.setIcon(new ImageIcon("C:\\Users\\Brendan\\Desktop\\Star image2.png"));
		GroupLayout gl_lvl2Panel = new GroupLayout(lvl2Panel);
		gl_lvl2Panel.setHorizontalGroup(
			gl_lvl2Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lvl2Panel.createSequentialGroup()
					.addGap(15)
					.addGroup(gl_lvl2Panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lvl2Stars)
						.addComponent(lvl2Toggle))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		gl_lvl2Panel.setVerticalGroup(
			gl_lvl2Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_lvl2Panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lvl2Toggle)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lvl2Stars)
					.addContainerGap())
		);
		lvl2Panel.setLayout(gl_lvl2Panel);
		
		//level 3 select//
		JPanel lvl3Panel = new JPanel();
		scrollablePanel.add(lvl3Panel);
		
		JToggleButton lvl3Toggle = new JToggleButton("Level 3");
		
		JLabel lvl3Stars = new JLabel("");
		lvl3Stars.setIcon(new ImageIcon("C:\\Users\\Brendan\\Desktop\\Star image2.png"));
		GroupLayout gl_lvl3Panel = new GroupLayout(lvl3Panel);
		gl_lvl3Panel.setHorizontalGroup(
			gl_lvl3Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lvl3Panel.createSequentialGroup()
					.addGap(15)
					.addGroup(gl_lvl3Panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lvl3Stars)
						.addComponent(lvl3Toggle))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		gl_lvl3Panel.setVerticalGroup(
			gl_lvl3Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_lvl3Panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lvl3Toggle)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lvl3Stars)
					.addContainerGap())
		);
		lvl3Panel.setLayout(gl_lvl3Panel);
		
		
		//level 4 select//
		JPanel lvl4Panel = new JPanel();
		scrollablePanel.add(lvl4Panel);
		
		JToggleButton lvl4Toggle = new JToggleButton("Level 4");
		
		JLabel lvl4Stars = new JLabel("");
		lvl4Stars.setIcon(new ImageIcon("C:\\Users\\Brendan\\Desktop\\Star image2.png"));
		GroupLayout gl_lvl4Panel = new GroupLayout(lvl4Panel);
		gl_lvl4Panel.setHorizontalGroup(
			gl_lvl4Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lvl4Panel.createSequentialGroup()
					.addGap(15)
					.addGroup(gl_lvl4Panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lvl4Stars)
						.addComponent(lvl4Toggle))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		gl_lvl4Panel.setVerticalGroup(
			gl_lvl4Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_lvl4Panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lvl4Toggle)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lvl4Stars)
					.addContainerGap())
		);
		lvl4Panel.setLayout(gl_lvl4Panel);
		
		//level 5 select//
		JPanel lvl5Panel = new JPanel();
		scrollablePanel.add(lvl5Panel);
		
		JToggleButton lvl5Toggle = new JToggleButton("Level 5");
		
		JLabel lvl5Stars = new JLabel("");
		lvl5Stars.setIcon(new ImageIcon("C:\\Users\\Brendan\\Desktop\\Star image2.png"));
		GroupLayout gl_lvl5Panel = new GroupLayout(lvl5Panel);
		gl_lvl5Panel.setHorizontalGroup(
			gl_lvl5Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lvl5Panel.createSequentialGroup()
					.addGap(15)
					.addGroup(gl_lvl5Panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lvl5Stars)
						.addComponent(lvl5Toggle))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		gl_lvl5Panel.setVerticalGroup(
			gl_lvl5Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_lvl5Panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lvl5Toggle)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lvl5Stars)
					.addContainerGap())
		);
		lvl5Panel.setLayout(gl_lvl5Panel);
		
		//level 6 select//
		JPanel lvl6Panel = new JPanel();
		scrollablePanel.add(lvl6Panel);
		
		JToggleButton lvl6Toggle = new JToggleButton("Level 6");
		
		JLabel lvl6Stars = new JLabel("");
		lvl6Stars.setIcon(new ImageIcon("C:\\Users\\Brendan\\Desktop\\Star image2.png"));
		GroupLayout gl_lvl6Panel = new GroupLayout(lvl6Panel);
		gl_lvl6Panel.setHorizontalGroup(
			gl_lvl6Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lvl6Panel.createSequentialGroup()
					.addGap(15)
					.addGroup(gl_lvl6Panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lvl6Stars)
						.addComponent(lvl6Toggle))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		gl_lvl6Panel.setVerticalGroup(
			gl_lvl6Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_lvl6Panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lvl6Toggle)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lvl6Stars)
					.addContainerGap())
		);
		lvl6Panel.setLayout(gl_lvl6Panel);
		
		//level 7 select//
		JPanel lvl7Panel = new JPanel();
		scrollablePanel.add(lvl7Panel);
		
		JToggleButton lvl7Toggle = new JToggleButton("Level 7");
		
		JLabel lvl7Stars = new JLabel("");
		GroupLayout gl_lvl7Panel = new GroupLayout(lvl7Panel);
		gl_lvl7Panel.setHorizontalGroup(
			gl_lvl7Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lvl7Panel.createSequentialGroup()
					.addGroup(gl_lvl7Panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_lvl7Panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lvl7Toggle))
						.addGroup(gl_lvl7Panel.createSequentialGroup()
							.addGap(20)
							.addComponent(lvl7Stars)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_lvl7Panel.setVerticalGroup(
			gl_lvl7Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lvl7Panel.createSequentialGroup()
					.addComponent(lvl7Toggle)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lvl7Stars))
		);
		lvl7Panel.setLayout(gl_lvl7Panel);
		
		//level 8 select//
		JPanel lvl8Panel = new JPanel();
		scrollablePanel.add(lvl8Panel);
		
		JToggleButton lvl8Toggle = new JToggleButton("Level 8");
		
		JLabel lvl8Stars = new JLabel("");
		GroupLayout gl_lvl8Panel = new GroupLayout(lvl8Panel);
		gl_lvl8Panel.setHorizontalGroup(
			gl_lvl8Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lvl8Panel.createSequentialGroup()
					.addGroup(gl_lvl8Panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_lvl8Panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lvl8Toggle))
						.addGroup(gl_lvl8Panel.createSequentialGroup()
							.addGap(20)
							.addComponent(lvl8Stars)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_lvl8Panel.setVerticalGroup(
			gl_lvl8Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lvl8Panel.createSequentialGroup()
					.addComponent(lvl8Toggle)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lvl8Stars))
		);
		lvl8Panel.setLayout(gl_lvl8Panel);
		
		//level 9 select//
		JPanel lvl9Panel = new JPanel();
		scrollablePanel.add(lvl9Panel);
		
		JToggleButton lvl9Toggle = new JToggleButton("Level 9");
		
		JLabel lvl9Stars = new JLabel("");
		GroupLayout gl_lvl9Panel = new GroupLayout(lvl9Panel);
		gl_lvl9Panel.setHorizontalGroup(
			gl_lvl9Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lvl9Panel.createSequentialGroup()
					.addGroup(gl_lvl9Panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_lvl9Panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lvl9Toggle))
						.addGroup(gl_lvl9Panel.createSequentialGroup()
							.addGap(20)
							.addComponent(lvl9Stars)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_lvl9Panel.setVerticalGroup(
			gl_lvl9Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lvl9Panel.createSequentialGroup()
					.addComponent(lvl9Toggle)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lvl9Stars))
		);
		lvl9Panel.setLayout(gl_lvl9Panel);
		
		JButton btnNewButton = new JButton("Play level");
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(128)
					.addComponent(lblLevelSelect)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(233, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(222))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 594, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(45)
					.addComponent(lblLevelSelect)
					.addGap(132)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addGap(48)
					.addComponent(btnNewButton)
					.addGap(119))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
