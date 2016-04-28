package app;

import view.GameExitScreen;
import view.LevelView;
import view.LevelSelectionView;
import view.StarView;
import controllers.player.PlayLevelButtonController;
import controllers.player.QuitGameButtonController;
import model.AbstractLevelModel;

/**
 * Class for handling playing the game.
 * 
 * The Game knows about the levels available to it from the star map, initializing 
 * the level selection view and dictating which level needs to prepare its view
 * next. 
 * @author dfontana
 *
 */
public class Game extends LevelIO{

	/**The LevelSelectionView to view all levels**/
	LevelSelectionView selectLevel;

	/**The View of the level being played**/
	LevelView levelView;

	/**The view displayed at the end of the level being played**/
	GameExitScreen exitLevel;
	
	/**Holds the current level being played**/	
	AbstractLevelModel currentLevel;
	
	/**
	 * Generates a Game
	 * @param directory this game is located in
	 */
	public Game(String directory){
		super(directory);
		this.initialize();
	}

	/**
	 * Prepares the starMap for the game, the view, the controllers, and
	 * the buttons for the levels in levelSelection.
	 */
	void initialize(){
		this.levelData = loadStarMap();

		this.initializeView();
		this.initializeButtons();
		exitLevel.getExitButton().addActionListener(new QuitGameButtonController(this.exitLevel, this));
	}

	/**
	 * DisplayLevel is called when the user has hit the button of the level they want to
	 * play. With this information known, it is possible to load the level requested and 
	 * make that level prepare its view and controllers (Timer for lightning for example)
	 * @param levelID of the level requested to play
	 * @return boolean - true if the level could be displayed
	 */
	public boolean displayLevel(int levelID) {
		try {
			currentLevel = loadLevel(levelID);
			levelView = currentLevel.initializeGame(this);
			
			levelView.setVisible(true);
			return true;
		} catch (Exception e) {
			System.err.println("Call to displayLevel: LevelID"+levelID+" Does not exist");
			e.printStackTrace();
		}	
		return false;
	}

	/**
	 * Prepares the view of levelSelection and the Game Exit Screen
	 */
	void initializeView(){
		this.selectLevel = new LevelSelectionView();
		for(int id: levelData.keySet()){
			try {
				selectLevel.addAvailableLevel(id, levelData.getMaxStars(id), this);
			} catch (Exception e) {
				throw new RuntimeException("ID not found in levelData, LSV couldn't be initialized" + e.getMessage());
			}
		}
		this.exitLevel = new GameExitScreen(new StarView());
	}

	/**
	 * Prepares all buttons of the levels available for play at launch of application.
	 * After levelData has been read in, the the method iterates over all levelids that count as
	 * unlocked (retrieved from a method call to StarMap). It unlocks the button in the view and then
	 * adds a listener to that button in the view that "connects" the entity to the button.
	 * This method assumes levelData has been read in.
	 */
	void initializeButtons(){
		for(int id: levelData.unlockedLevels()){
			try {
				selectLevel.unlockLevel(id, levelData.getMaxStars(id));
			} catch (Exception e) {
				System.err.println("Call to displayLevel: LevelID"+id+" Does not exist");
				e.printStackTrace();
			}
			selectLevel.addListenerToButton(id, this);
		}
		
		try {
			int id = levelData.lowestNoStarLevel();
			selectLevel.unlockLevel(id, levelData.getMaxStars(id));
			selectLevel.addListenerToButton(id, this);
		} catch (Exception e) {}
	}
	
	/**
	 * Returns the highest ID that is unlocked in the levelData of this game.
	 * @return int ID of level
	 */
	public int highestUnlockedID() {
		return levelData.lowestNoStarLevel()-1;
	}

	/**
	 * Unlocks the next level with no stars for play. Sets the button to enabled
	 * and initializes its controller
	 * @return int ID of level that was unlocked
	 */
	public int unlockNextLevel(){
		int id = levelData.lowestNoStarLevel();
		selectLevel.unlockLevel(id, 0);
		selectLevel.getButton(id).addActionListener(new PlayLevelButtonController(selectLevel, this, id));
		updateStars(id, 0);
		return id;
	}

	//========================== Getters ==========================//
	/**
	 * Gets the level selection view of this game
	 * @return LevelSelectionView
	 */
	public LevelSelectionView getSelectView() {
		return this.selectLevel;
	}
	/**
	 * Returns the ExitView of this game
	 * @return ExitView
	 */
	public GameExitScreen getExitView() {
		return this.exitLevel;
	}
	/**
	 * Returns the LevelView currently being played
	 * @return LevelView
	 */
	public LevelView getLevelView() {
		return this.levelView;
	}
	/**
	 * Returns the model of the current level being played
	 * @return AbstractLevelModel 
	 */
	public AbstractLevelModel getCurrentLevel(){
		return currentLevel;
	}
}
