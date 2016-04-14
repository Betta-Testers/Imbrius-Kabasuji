package view;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import java.util.TreeMap;

import app.Builder;
import app.StarMap;
import controllers.CreateLevelBtnController;
import controllers.ExistingLevelEditController;
import controllers.NewLevelTypeController;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;


public class LevelTypeSelectView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ViewAndEditLevels viewerAndEditor;
	LevelTypesAndText levelTypesAndText;
	JButton createLevelBtn;
	JPanel createBtnPanel;
	StarMap<Integer, String> levelData;
	Builder b;
	
	/**
	 * Create the application.
	 */
	public LevelTypeSelectView(Builder b, StarMap<Integer, String> levelData) {
		super();
		this.levelData = levelData;
		this.b = b;
		viewerAndEditor = new ViewAndEditLevels(levelData);
		levelTypesAndText = new LevelTypesAndText();
		createLevelBtn = new JButton("Create Level");
		createBtnPanel = new JPanel();
	
		
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
		
		JSplitPane levelViewerAndSelector = new JSplitPane();
		levelViewerAndSelector.setEnabled(false);
		levelViewerAndSelector.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		JSplitPane levelSelectorAndCreator = new JSplitPane();
		levelSelectorAndCreator.setResizeWeight(1.0);
		levelSelectorAndCreator.setEnabled(false);
		levelSelectorAndCreator.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		createLevelBtn.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		createLevelBtn.setEnabled(false);
		
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
		createLevelBtn.addActionListener(new CreateLevelBtnController(b));
		for (ExistingLevelView elv : viewerAndEditor.getExistingLevelButtons()) {
			elv.addActionListener(new ExistingLevelEditController(b));
		}
		for (LevelTypeToggle ltt : levelTypesAndText.getLevelTypeButtons()) {
			ltt.addActionListener(new NewLevelTypeController(this));
		}
	}
	
	public JTextArea getLevelDescriptionBox() {
		return levelTypesAndText.getTextArea();
	}
	
	public void addExistingLevel (String levelType, int levelNumber){
		viewerAndEditor.addLevel(levelType, levelNumber);
		levelData.put(levelNumber, levelType);
	}
	
	public String getSelectedLevelType() {
		return this.levelTypesAndText.getSelectedLevelType();
	}
	
	public JButton getCreateLevelBtn () {
		return this.createLevelBtn;
	}
}


