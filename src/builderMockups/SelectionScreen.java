package builderMockups;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import java.awt.Dimension;

import javax.swing.ScrollPaneConstants;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import java.awt.Color;

public class SelectionScreen {

	private JFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					SelectionScreen window = new SelectionScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SelectionScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 576, 688);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		JSplitPane levelViewerAndSelector = new JSplitPane();
		levelViewerAndSelector.setEnabled(false);
		levelViewerAndSelector.setOrientation(JSplitPane.VERTICAL_SPLIT);
		frame.getContentPane().add(levelViewerAndSelector);
		
		ExistingLevelViewer levelViewer = new ExistingLevelViewer();
		levelViewerAndSelector.setLeftComponent(levelViewer);
		
		
		
		for (int i=1; i<=5; i++){
			levelViewer.addLevelView("Puzzle", i);
			levelViewer.addLevelView("Lightning", i);
			levelViewer.addLevelView("Release", i);
		}
		
		JSplitPane levelSelectorAndCreator = new JSplitPane();
		levelSelectorAndCreator.setResizeWeight(1.0);
		levelSelectorAndCreator.setEnabled(false);
		levelSelectorAndCreator.setOrientation(JSplitPane.VERTICAL_SPLIT);
		levelViewerAndSelector.setRightComponent(levelSelectorAndCreator);
		
				
		LevelTypesAndText levelTypesAndText = new LevelTypesAndText();
		levelSelectorAndCreator.setLeftComponent(levelTypesAndText);
		
		
		JPanel createBtnPanel = new JPanel();
		levelSelectorAndCreator.setRightComponent(createBtnPanel);
				
		JButton btnCreateLevel = new JButton("Create Level");
		btnCreateLevel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		btnCreateLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			}
		});
		
		GroupLayout gl_createBtnPanel = new GroupLayout(createBtnPanel);
		gl_createBtnPanel.setAutoCreateGaps(true);
		gl_createBtnPanel.setAutoCreateContainerGaps(true);
		gl_createBtnPanel.setHorizontalGroup(
			gl_createBtnPanel.createParallelGroup(Alignment.CENTER)
				.addGroup(Alignment.CENTER, gl_createBtnPanel.createSequentialGroup()
					.addGap(256)
					.addComponent(btnCreateLevel)
					.addContainerGap(255, Short.MAX_VALUE))
		);
		gl_createBtnPanel.setVerticalGroup(
			gl_createBtnPanel.createParallelGroup(Alignment.CENTER)
				.addGroup(Alignment.CENTER, gl_createBtnPanel.createSequentialGroup()
					.addGap(10)
					.addComponent(btnCreateLevel)
					.addGap(10))
		);
		createBtnPanel.setLayout(gl_createBtnPanel);
			
	}
}


