package app;

import view.GameExitScreen;
import view.LevelView;
import view.LevelSelectionView;
import view.StarView;
import controllers.common.ShutdownController;
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

	void initialize(){
		this.levelData = loadStarMap();
		System.out.println("Levels Loaded:"+levelData.toString());
		
		this.initializeView();
		this.initializeControllers();
		this.initializeButtons();
	}

	/**
	 * DisplayLevel is called when the user has hit the button of the level they want to
	 * play. With this information known, it is possible to load the level requested and 
	 * make that level prepare its view and controllers (Timer for lightning for example)
	 * @param ID of the level requested to play
	 * @return boolean - true if the level could be displayed
	 */
	public boolean displayLevel(int levelID) {
		try {
			currentLevel = loadLevel(levelID);
			System.out.println(currentLevel.getBoard().toString());
			levelView = currentLevel.initializeGame(this);
			
			levelView.setVisible(true);
			return true;
		} catch (Exception e) {
			System.err.println("Call to displayLevel: LevelID"+levelID+" Does not exist");
			e.printStackTrace();
		}	
		return false;
	}

	void initializeView(){
		this.selectLevel = new LevelSelectionView();
		this.exitLevel = new GameExitScreen(new StarView());
	}

	void initializeControllers(){
		exitLevel.getExitButton().addActionListener(new QuitGameButtonController(this.exitLevel, this));
		selectLevel.setShutdownController(new ShutdownController(this));
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