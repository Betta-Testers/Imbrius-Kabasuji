package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import controllers.CreateLevelBtnController;

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
import java.awt.Container;

public class LevelTypeSelectView extends JFrame {

	ViewAndEditLevels viewerAndEditor;
	LevelTypesAndText levelTypesAndText;
	JButton createLevelBtn;
	JPanel createBtnPanel;
	int highestExistingLevel;

	/**
	 * Create the application.
	 */
	public LevelTypeSelectView(int highestExistingLevel) {
		super();
		this.highestExistingLevel = highestExistingLevel;
		viewerAndEditor = new ViewAndEditLevels();
		levelTypesAndText = new LevelTypesAndText();
		createLevelBtn = new JButton("Create Level");
		createBtnPanel = new JPanel();
		
		initialize();
		setupLayout();
		initializeControllers();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		this.setResizable(false);
		this.setBounds(100, 100, 576, 688);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
		
		JSplitPane levelViewerAndSelector = new JSplitPane();
		levelViewerAndSelector.setEnabled(false);
		levelViewerAndSelector.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		JSplitPane levelSelectorAndCreator = new JSplitPane();
		levelSelectorAndCreator.setResizeWeight(1.0);
		levelSelectorAndCreator.setEnabled(false);
		levelSelectorAndCreator.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		createLevelBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		
		levelViewerAndSelector.setLeftComponent(viewerAndEditor);
		levelViewerAndSelector.setRightComponent(levelSelectorAndCreator);
		
		levelSelectorAndCreator.setLeftComponent(levelTypesAndText);
		levelSelectorAndCreator.setRightComponent(createBtnPanel);
		
		this.getContentPane().add(levelViewerAndSelector);
	}
	
	void setupLayout() {
		GroupLayout gl_createBtnPanel = new GroupLayout(createBtnPanel);
		gl_createBtnPanel.setAutoCreateGaps(true);
		gl_createBtnPanel.setAutoCreateContainerGaps(true);
		gl_createBtnPanel.setHorizontalGroup(
			gl_createBtnPanel.createParallelGroup(Alignment.CENTER)
				.addGroup(Alignment.CENTER, gl_createBtnPanel.createSequentialGroup()
					.addContainerGap(150, Short.MAX_VALUE)
					.addComponent(createLevelBtn)
					.addContainerGap(150, Short.MAX_VALUE))
		);
		gl_createBtnPanel.setVerticalGroup(
			gl_createBtnPanel.createParallelGroup(Alignment.CENTER)
				.addGroup(Alignment.CENTER, gl_createBtnPanel.createSequentialGroup()
					.addGap(10)
					.addComponent(createLevelBtn)
					.addGap(10))
		);
		createBtnPanel.setLayout(gl_createBtnPanel);
	}
	
	void initializeControllers() {
		createLevelBtn.addActionListener(new CreateLevelBtnController(highestExistingLevel));
	}
}


