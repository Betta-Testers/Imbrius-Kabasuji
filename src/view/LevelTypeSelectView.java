package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import app.Builder;
import controllers.builder.ExistingLevelDeleteController;
import controllers.builder.ExistingLevelEditController;
import controllers.builder.NewLightningLevelController;
import controllers.builder.NewPuzzleLevelController;
import controllers.builder.NewReleaseLevelController;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Window to show what levels are available to edit, as well as to show the types of levels a user can create. Used for the Builder application.
 * @author dfontana
 * @author awharrison
 * @author hejohnson
 *
 */
public class LevelTypeSelectView extends JFrame {
	private static final long serialVersionUID = 1L;

	/**Shows existing levels.**/
	ExistingLevelViewer existingLevels;
	
	/**Shows description of each level type.**/
	JTextArea txtAreaLevelTypeDescription;
	
	/**Button to create a new puzzle level.**/
	JButton createPuzzle;
	/**Button to create a new lightning level.**/
	JButton createLightning;
	/**Button to create a new release level.**/
	JButton createRelease;
	/**Contains the buttons and existing levels.**/
	JPanel container;
	/**Title for the ExistingLevelViewer.**/
	JLabel existingLevelMsg;
	
	/**Handles when the window is closed.**/
	WindowListener shutdownHandler;
	
	/**Handles create puzzle button mouse events.**/
	MouseListener puzzleBtnHandler;
	
	/**Handles create lightning button mouse events.**/
	MouseListener lightningBtnHandler;
	
	/**Handles create release button mouse events.**/
	MouseListener releaseBtnHandler;
	
	/**
	 * Creates a LevelTypeSelectView.
	 */
	public LevelTypeSelectView() {
		super();
		container = new JPanel();
		existingLevels = new ExistingLevelViewer();
		createPuzzle = new JButton();
		createLightning = new JButton();
		createRelease = new JButton();
	
		txtAreaLevelTypeDescription = new JTextArea();
		existingLevelMsg = new JLabel("Click a level below to edit:");
		
		initialize();
		setupLayout();
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
		txtAreaLevelTypeDescription.setText("Mouse over a level to see its description");
		
		createPuzzle.setIcon(new ImageIcon(LevelTypeSelectView.class.getResource("/icons/Puzzle.png")));
		createLightning.setIcon(new ImageIcon(LevelTypeSelectView.class.getResource("/icons/Lightning.png")));
		createRelease.setIcon(new ImageIcon(LevelTypeSelectView.class.getResource("/icons/Release.png")));
		
		existingLevelMsg.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		
		existingLevels.setPreferredSize(new Dimension(536, 195));
		existingLevels.setMaximumSize(new Dimension(536, 195));
		existingLevels.setMinimumSize(new Dimension(536, 195));
		
		container.add(existingLevelMsg);
		container.add(existingLevels);
		container.add(createPuzzle);
		container.add(createLightning);
		container.add(createRelease);
				
		this.getContentPane().add(container);
	}
	
	/**
	 * Initialize level creation button controllers.
	 * @param b - Builder
	 */
	public void initializeControllers(Builder b) {
		setPuzzleBtnHandler(new NewPuzzleLevelController(b, txtAreaLevelTypeDescription, "Puzzle: Fill the board with hexominoes before you run out of moves!"));
		setLightningBtnHandler(new NewLightningLevelController(b, txtAreaLevelTypeDescription, "Lightning: Cover as many tiles as you can before time runs out!"));
		setReleaseBtnHandler(new NewReleaseLevelController(b, txtAreaLevelTypeDescription, "Release: Cover tiles to release number/color sequences and win!"));
	}
	
	/**
	 * Returns the text area used to display the description of each level type.
	 * @return txtAreaLevelTypeDescription - JTextArea
	 */
	public JTextArea getLevelDescriptionBox() {
		return txtAreaLevelTypeDescription;
	}
	
	/**
	 * Adds an existing level to the ExistingLevelViewer.
	 * @param levelType - String
	 * @param levelNumber - int
	 * @param b - Builder
	 */
	public void addExistingLevel (String levelType, int levelNumber, Builder b){
		ExistingLevelView elv = existingLevels.addLevelView(levelType, levelNumber);
		elv.addActionListenerToEditButton(new ExistingLevelEditController(b));
		elv.addActionListenerToDeleteButton(new ExistingLevelDeleteController(b));
	}
	
	/**
	 * Removes an existing level to the ExistingLevelViewer.
	 * @param levelNumber - int
	 */
	public void removeExistingLevel(int levelNumber){
		existingLevels.removeLevelView(levelNumber);
	}
	
	/**
	 * Returns the button that tells the Builder to create a puzzle level.
	 * @return createPuzzle - Jbutton
	 */
	public JButton getCreatePuzzleBtn() {
		return this.createPuzzle;
	}
	
	/**
	 * Returns the button that tells the Builder to create a lightning level.
	 * @return createLightning - Jbutton
	 */
	public JButton getCreateLightningBtn() {
		return this.createLightning;
	}
	
	/**
	 * Returns the button that tells the Builder to create a release level.
	 * @return createRelease - Jbutton
	 */
	public JButton getCreateReleaseBtn() {
		return this.createRelease;
	}
	
	/**
	 * Set the controller handling window closes.
	 * @param we - WindowListener
	 */
	public void setShutdownController(WindowListener we) {
		this.shutdownHandler = we;
		this.addWindowListener(we);
	}
	
	/**
	 * Returns the controller handling window closes.
	 * @return shutdownHandler - WindowListener
	 */
	public WindowListener getShutdownController() {
		return this.shutdownHandler;
	}
	
	/**
	 * Set the controller for the button that tells the Builder to create a puzzle level.
	 * @param me - MouseListener 
	 */
	public void setPuzzleBtnHandler(MouseListener me) {
		this.puzzleBtnHandler = me;
		createPuzzle.addMouseListener(me);
	}
	
	/**
	 * Set the controller for the button that tells the Builder to create a lightning level.
	 * @param me - MouseListener 
	 */
	public void setLightningBtnHandler(MouseListener me) {
		this.lightningBtnHandler = me;
		createLightning.addMouseListener(me);
	}
	
	/**
	 * Set the controller for the button that tells the Builder to create a release level.
	 * @param me - MouseListener 
	 */
	public void setReleaseBtnHandler(MouseListener me) {
		this.releaseBtnHandler = me;
		createRelease.addMouseListener(me);
	}
	
	/**
	 * Returns the controller for the button that tells the Builder to create a puzzle level.
	 * @return puzzleBtnHandler - MouseListener
	 */
	public MouseListener getPuzzleBtnHandler() {
		return this.puzzleBtnHandler;
	}
	
	/**
	 * Returns the controller for the button that tells the Builder to create a lightning level.
	 * @return lightningBtnHandler - MouseListener
	 */
	public MouseListener getLightningBtnHandler() {
		return this.lightningBtnHandler;
	}
	
	/**
	 * Returns the controller for the button that tells the Builder to create a release level.
	 * @return releaseBtnHandler - MouseListener
	 */
	public MouseListener getReleaseBtnHandler() {
		return this.releaseBtnHandler;
	}
	
	/**
	 * Sets up the layout of the LevelTypeSelectView.
	 */
	void setupLayout() {
		GroupLayout gl_ltsv = new GroupLayout(container);
		gl_ltsv.setAutoCreateGaps(true);
		gl_ltsv.setAutoCreateContainerGaps(true);
		gl_ltsv.setHorizontalGroup(
			gl_ltsv.createParallelGroup(Alignment.CENTER)
					.addComponent(existingLevelMsg)
					.addComponent(existingLevels)
					.addGroup(gl_ltsv.createSequentialGroup()
						.addGap(10)
						.addComponent(createPuzzle)
						.addContainerGap(10, Short.MAX_VALUE)
						.addComponent(createLightning)
						.addContainerGap(10, Short.MAX_VALUE)
						.addComponent(createRelease)
						.addGap(10))
					.addComponent(txtAreaLevelTypeDescription)
		);
		gl_ltsv.setVerticalGroup(
			gl_ltsv.createSequentialGroup()
				.addGap(10)
				.addComponent(existingLevelMsg)
				.addGap(10)
				.addComponent(existingLevels)
				.addGap(10)
				.addGroup(gl_ltsv.createParallelGroup()
						.addComponent(createPuzzle)
						.addComponent(createLightning)
						.addComponent(createRelease))
				.addGap(10)
				.addComponent(txtAreaLevelTypeDescription)
		);
		container.setLayout(gl_ltsv);
	}
	
}


