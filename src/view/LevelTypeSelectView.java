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
 * 
 * @author Dylan
 * @author awharrison
 *
 */
public class LevelTypeSelectView extends JFrame {
	private static final long serialVersionUID = 1L;

	ExistingLevelViewer existingLevels;
	JTextArea txtAreaLevelTypeDescription;
	JButton createPuzzle;
	JButton createLightning;
	JButton createRelease;
	JPanel container;
	JLabel existingLevelMsg;
	WindowListener shutdownHandler;
	MouseListener puzzleBtnHandler;
	MouseListener lightningBtnHandler;
	MouseListener releaseBtnHandler;
	
	/**
	 * Create the application.
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
	
	public void initializeControllers(Builder b) {
		setPuzzleBtnHandler(new NewPuzzleLevelController(b, txtAreaLevelTypeDescription, "Puzzle: Fill the board with hexominoes before you run out of moves!"));
		setLightningBtnHandler(new NewLightningLevelController(b, txtAreaLevelTypeDescription, "Lightning: Cover as many tiles as you can before time runs out!"));
		setReleaseBtnHandler(new NewReleaseLevelController(b, txtAreaLevelTypeDescription, "Release: Cover tiles to release number/color sequences and win!"));
		// add JButton mouse listeners
	}
	
	public JTextArea getLevelDescriptionBox() {
		return txtAreaLevelTypeDescription;
	}
	
	public void addExistingLevel (String levelType, int levelNumber, Builder b){
		ExistingLevelView elv = existingLevels.addLevelView(levelType, levelNumber);
		elv.addActionListenerToEditButton(new ExistingLevelEditController(b));
		elv.addActionListenerToDeleteButton(new ExistingLevelDeleteController(b));
	}
	
	public void removeExistingLevel(int levelNumber){
		existingLevels.removeLevelView(levelNumber);
	}
	
	/**
	 * retrieve the button that tells the Builder to create a puzzle level
	 * @return Jbutton
	 */
	public JButton getCreatePuzzleBtn() {
		return this.createPuzzle;
	}
	
	/**
	 * retrieve the button that tells the Builder to create a Lightning level
	 * @return Jbutton
	 */
	public JButton getCreateLightningBtn() {
		return this.createLightning;
	}
	
	/**
	 * retrieve the button that tells the Builder to create a Release level
	 * @return Jbutton
	 */
	public JButton getCreateReleaseBtn() {
		return this.createRelease;
	}
	
	/**
	 * set the controller handling window closes
	 * @return MouseListener
	 */
	public void setShutdownController(WindowListener we) {
		this.shutdownHandler = we;
		this.addWindowListener(we);
	}
	
	/**
	 * get the controller handling window closes
	 * @return MouseListener
	 */
	public WindowListener getShutdownController() {
		return this.shutdownHandler;
	}
	
	/**
	 * set the controller for the button that tells the Builder to create a puzzle level
	 * @return 
	 */
	public void setPuzzleBtnHandler(MouseListener me) {
		this.puzzleBtnHandler = me;
		createPuzzle.addMouseListener(me);
	}
	
	/**
	 * set the controller for the button that tells the Builder to create a Lightning level
	 * @return 
	 */
	public void setLightningBtnHandler(MouseListener me) {
		this.lightningBtnHandler = me;
		createLightning.addMouseListener(me);
	}
	
	/**
	 * set the controller for the button that tells the Builder to create a Release level
	 * @return 
	 */
	public void setReleaseBtnHandler(MouseListener me) {
		this.releaseBtnHandler = me;
		createRelease.addMouseListener(me);
	}
	
	/**
	 * get the controller for the button that tells the Builder to create a puzzle level
	 * @return MouseListener
	 */
	public MouseListener getPuzzleBtnHandler() {
		return this.puzzleBtnHandler;
	}
	
	/**
	 * get the controller for the button that tells the Builder to create a Lightning level
	 * @return MouseListener
	 */
	public MouseListener getLightningBtnHandler() {
		return this.lightningBtnHandler;
	}
	
	/**
	 * get the controller for the button that tells the Builder to create a Release level
	 * @return MouseListener
	 */
	public MouseListener getReleaseBtnHandler() {
		return this.releaseBtnHandler;
	}
	
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


