package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.Game;
import controllers.player.PlayLevelButtonController;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowListener;
import java.util.ArrayList;

/**
 * Class for displaying the Levels available for play.
 * 
 * @author bwoconnor
 * @author dfontana
 * @author awharrison
 * @author hejohnson
 */
public class LevelSelectionView extends JFrame {
	private static final long serialVersionUID = 1L;
	/**JPanel to show everything not in the scrollpane.**/
	JPanel contentPane;
	/**Stores the title of the screen.**/
	JLabel lblTitle;
	/**Scrollpane to show available levels.**/
	JScrollPane availableLevels;
	/**List of AvailableLevelViews for the scrollpane.**/
	ArrayList<AvailableLevelView> levels;
	/**Handles when the window is closed.**/
	WindowListener shutdownHandler;
	/**Panel to house the scrollpane.**/
	JPanel scrollablePanel;
	
	/**
	 * Creates a LevelSelectionView.
	 */
	public LevelSelectionView() {
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
		availableLevels.getHorizontalScrollBar().setUnitIncrement(150);
		availableLevels.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		availableLevels.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		scrollablePanel = new JPanel();
		availableLevels.setViewportView(scrollablePanel);
		
		levels = new ArrayList<AvailableLevelView>();
		
		setupLayout();
		this.getContentPane().setBackground( Color.WHITE );
	}
	
	/**
	 * Adds an available level to the LevelSelectionView. Looks at if the level has the required number of stars to unlock.
	 * @param i (ID) - int
	 * @param numStars - int
	 * @param g (the game entity) - Game
	 */
	public void addAvailableLevel(int i, int numStars, Game g) {
		AvailableLevelView av = new AvailableLevelView(i);
		
		if (numStars != -1) {
			av.unlockLevel(numStars);
			addListenerToButton(i, g);
		}
		levels.add(av);
		scrollablePanel.add(av);
		
	}

	/**
	 * Adds a PlayLevelButtonController to the button for the given ID.
	 * @param levelID - int
	 * @param g (Game object) - Game
	 */
	public void addListenerToButton(int levelID, Game g){
		for (AvailableLevelView av : levels) {
			if (av.getLevelID() == levelID) {
				av.getPlayButton().addActionListener(new PlayLevelButtonController(this, g, levelID));
			}
		}
	}
	
	/**
	 * Updates the number of stars displayed for the given levelID.
	 * @param levelID - int
	 * @param starsEarned - int
	 */
	public void updateStarsForLevel(int levelID, int starsEarned){
		for (AvailableLevelView av : levels) {
			if (av.getLevelID() == levelID) {
				av.updateStars(starsEarned);;
			}
		}
	}
	
	/**
	 * Unlocks the level specified and sets the stars earned to the stars earned of given.
	 * @param levelID - int
	 * @param starsEarned - int
	 */
	public void unlockLevel(int levelID, int starsEarned){
		for (AvailableLevelView av : levels) {
			if (av.getLevelID() == levelID) {
				av.unlockLevel(starsEarned);
			}
		}
	}
	
	/**
	 * Returns the button for the given levelID.
	 * @param levelID - int
	 * @return button from AvailableLevelView corresponding to levelID - JButton
	 */
	public JButton getButton(int levelID) {
		for (AvailableLevelView av : levels) {
			if (av.getLevelID() == levelID) {
				return av.getPlayButton();
			}
		}
		return null;
	}
	
	/**
	 * Sets the controller handling window closes.
	 * @param we - WindowListener
	 */
	public void setShutdownController(WindowListener we) {
		this.shutdownHandler = we;
		this.addWindowListener(we);
	}
	
	/**
	 * Get the controller handling window closes.
	 * @return shutdownHandler - WindowListener
	 */
	public WindowListener getShutdownController() {
		return this.shutdownHandler;
	}
	
	/**
	 * Sets up the layout for the LevelSelectionView.
	 */
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
