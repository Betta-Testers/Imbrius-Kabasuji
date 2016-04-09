package view;

//TODO Cleaned out Imports
import javax.swing.JFrame;
import javax.swing.JTextArea;

import app.Builder;
import controllers.CreateLevelBtnController;
import controllers.ExistingLevelEditController;
import controllers.NewLevelTypeController;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import java.awt.Font;

public class LevelTypeSelectView extends JFrame {

	ViewAndEditLevels viewerAndEditor;
	LevelTypesAndText levelTypesAndText;
	JButton createLevelBtn;
	JPanel createBtnPanel;
	int highestExistingLevel;
	
	//TODO: Verify these attributes
	BuilderView bv;
	Builder b;
	/**
	 * Create the application.
	 */
	//TODO: Verify builder parameter
	public LevelTypeSelectView(Builder b, int highestExistingLevel, BuilderView builderView) {
		super();
		this.highestExistingLevel = highestExistingLevel;
		viewerAndEditor = new ViewAndEditLevels();
		levelTypesAndText = new LevelTypesAndText();
		createLevelBtn = new JButton("Create Level");
		createBtnPanel = new JPanel();
		
		//TODO verify these lines
		this.bv = builderView;
		this.b = b;
		
		initialize();
		setupLayout();
		initializeControllers();
		
		//TODO Verify this line
		setVisible(true);
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
		//TODO Added b and bv to the parameters of this controller
		createLevelBtn.addActionListener(new CreateLevelBtnController(this, b, bv));
		for (ExistingLevelView elv : viewerAndEditor.getExistingLevelButtons()) {
			elv.addActionListener(new ExistingLevelEditController());
		}
		for (LevelTypeToggle ltt : levelTypesAndText.getLevelTypeButtons()) {
			ltt.addActionListener(new NewLevelTypeController(this));
		}
	}
	
	public JTextArea getLevelDescriptionBox() {
		return levelTypesAndText.getTextArea();
	}
	
	public void setHighestExistingLevel(int newHighest) {
		this.highestExistingLevel = newHighest;
	}
	
	public int getHighestExistingLevel() {
		return this.highestExistingLevel;
	}
	
	public String getSelectedLevelType() {
		return this.levelTypesAndText.getSelectedLevelType();
	}
	
	public JButton getCreateLevelBtn () {
		return this.createLevelBtn;
	}
}


