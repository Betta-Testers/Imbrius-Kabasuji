package view;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.util.TreeMap;

import app.Builder;
import app.StarMap;
import controllers.CreateLevelBtnController;
import controllers.ExistingLevelEditController;
import controllers.NewLevelTypeController;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;


public class LevelTypeSelectView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ExistingLevelViewer existingLevels;
	JTextArea txtAreaLevelTypeDescription;
	StarMap levelData;
	Builder b;
	JButton createPuzzle;
	JButton createLightning;
	JButton createRelease;
	JPanel container;
	JLabel existingLevelMsg;
	
	/**
	 * Create the application.
	 */
	public LevelTypeSelectView(Builder b, StarMap levelData) {
		super();
		this.levelData = levelData;
		this.b = b;
		container = new JPanel();
		existingLevels = new ExistingLevelViewer();
		createPuzzle = new JButton();
		createLightning = new JButton();
		createRelease = new JButton();
	
		txtAreaLevelTypeDescription = new JTextArea();
		existingLevelMsg = new JLabel("Click a level below to edit:");
		
		initialize();
		setupLayout();
		initializeControllers();
		setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		this.setResizable(false);
		this.setBounds(100, 100, 576, 688);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));
		
		txtAreaLevelTypeDescription.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		txtAreaLevelTypeDescription.setLineWrap(true);
		txtAreaLevelTypeDescription.setWrapStyleWord(true);
		txtAreaLevelTypeDescription.setText("Mouse over a level to see it's description");
		
		createPuzzle.setIcon(new ImageIcon(LevelTypeSelectView.class.getResource("/icons/Puzzle.png")));
		createLightning.setIcon(new ImageIcon(LevelTypeSelectView.class.getResource("/icons/Lightning.png")));
		createRelease.setIcon(new ImageIcon(LevelTypeSelectView.class.getResource("/icons/Release.png")));
		
		container.add(existingLevelMsg);
		container.add(existingLevels);
		container.add(createPuzzle);
		container.add(createLightning);
		container.add(createRelease);
				
		this.getContentPane().add(container);
	}
	
	void setupLayout() {
		GroupLayout gl_createBtnPanel = new GroupLayout(container);
		gl_createBtnPanel.setAutoCreateGaps(true);
		gl_createBtnPanel.setAutoCreateContainerGaps(true);
		gl_createBtnPanel.setHorizontalGroup(
			gl_createBtnPanel.createParallelGroup(Alignment.CENTER)
					.addComponent(existingLevelMsg)
					.addComponent(existingLevels)
					.addGroup(gl_createBtnPanel.createSequentialGroup()
						.addContainerGap(50, Short.MAX_VALUE)
						.addComponent(createPuzzle)
						.addContainerGap(50, Short.MAX_VALUE)
						.addComponent(createLightning)
						.addContainerGap(50, Short.MAX_VALUE)
						.addComponent(createRelease)
						.addContainerGap(50, Short.MAX_VALUE))
					.addComponent(txtAreaLevelTypeDescription)
		);
		gl_createBtnPanel.setVerticalGroup(
			gl_createBtnPanel.createSequentialGroup()
				.addGap(10)
				.addComponent(existingLevelMsg)
				.addGap(10)
				.addComponent(existingLevels)
				.addGap(10)
				.addGroup(gl_createBtnPanel.createParallelGroup()
						.addComponent(createPuzzle)
						.addComponent(createLightning)
						.addComponent(createRelease))
				.addGap(10)
				.addComponent(txtAreaLevelTypeDescription)
		);
		container.setLayout(gl_createBtnPanel);
	}
	
	void initializeControllers() {
		for (ExistingLevelView elv : existingLevels.getExistingLevelButtons()) {
			elv.addActionListener(new ExistingLevelEditController(b));
		}
		createPuzzle.addMouseListener(new NewLevelTypeController(b, this, "Puzzle: Fill the board with hexominoes before you run out of moves!"));
		createLightning.addMouseListener(new NewLevelTypeController(b, this, "Lightning: Cover as many tiles as you can before time runs out!"));
		createRelease.addMouseListener(new NewLevelTypeController(b, this, "Release: Cover tiles to release number/color sequences and win!"));
		// add JButton mouse listeners
	}
	
	public JTextArea getLevelDescriptionBox() {
		return txtAreaLevelTypeDescription;
	}
	
	public void addExistingLevel (String levelType, int levelNumber){
		existingLevels.addLevelView(levelType, levelNumber);
	}
	
	public void setDescriptionText(String description) {
		txtAreaLevelTypeDescription.setText(description);
	}
}


