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

import java.awt.Font;
import java.awt.event.WindowListener;
import java.util.ArrayList;

/**
 * Class for displaying the Levels available for play.
 * 
 * @author Brendan
 * @author dfontana
 * @author awharrison
 * @author hejohnson
 */
public class LevelSelectionView extends JFrame {
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	JLabel lblTitle;
	JScrollPane availableLevels;
	ArrayList<AvailableLevelView> levels;
	WindowListener shutdownHandler;
	JPanel scrollablePanel;
	
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
		availableLevels.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		availableLevels.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		scrollablePanel = new JPanel();
		availableLevels.setViewportView(scrollablePanel);
		
		levels = new ArrayList<AvailableLevelView>();
		
//		for(int i = 0; i < 15; i++){
//			levels[i] = new AvailableLevelView("Level "+(i+1));
//			scrollablePanel.add(levels[i]);
//		}
//		
//		levels[0].unlockLevel(0);
		
		setupLayout();
		
	}
	
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
	 * Adds a PlayLevelButtonController to the button for the given ID
	 * @param levelID - ID of level adding listener to
	 * @param g - game object, passed for the controller to access
	 */
	public void addListenerToButton(int levelID, Game g){
		for (AvailableLevelView av : levels) {
			if (av.getLevelID() == levelID) {
				av.getPlayButton().addActionListener(new PlayLevelButtonController(this, g, levelID));
			}
		}
	}
	
	/**
	 * Updates the number of stars displayed for the given levelID
	 * @param levelID - level being updated
	 * @param starsEarned - number of stars to display
	 */
	public void updateStarsForLevel(int levelID, int starsEarned){
		for (AvailableLevelView av : levels) {
			if (av.getLevelID() == levelID) {
				av.updateStars(starsEarned);;
			}
		}
	}
	
	/**
	 * Unlocks the level specified and sets the stars earned to the
	 * stars earned of given
	 * @param levelID - Level being unlocked
	 * @param starsEarned - number of stars to display
	 */
	public void unlockLevel(int levelID, int starsEarned){
		for (AvailableLevelView av : levels) {
			if (av.getLevelID() == levelID) {
				av.unlockLevel(starsEarned);
			}
		}
	}
	
	/**
	 * Returns the button for the given levelID
	 * @param levelID - the levelID being accessed (values of 1+ only)
	 * @return JButton
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
	 * Method for setting up the layout for the LevelSelectionView
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
