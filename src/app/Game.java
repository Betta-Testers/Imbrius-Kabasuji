package app;

import view.GameExitScreen;
import view.LevelView;
import view.LevelSelectionView;
import view.StarView;

import controllers.PlayLevelButtonController;
import controllers.QuitGameButtonController;
import controllers.ShutdownController;

public class Game extends LevelIO{

	/**The LevelSelectionView to view all levels**/
	LevelSelectionView selectLevel;

	/**The View of the level being played**/
	LevelView levelView;

	/**The view displayed at the end of the level being played**/
	GameExitScreen exitLevel;

	Game(String directory){
		super(directory);
		this.initialize();
	}

	void initialize(){
		//TODO save the levelData in ShutdownController
		this.levelData = loadStarMap();


		this.initializeView();
		this.initializeControllers();
		this.initializeButtons();
	}

	/**TODO implement
	 * DisplayLevel is called when the user has hit the button of the level they want to
	 * play. With this information known, it is possible to load the level requested and 
	 * make that level prepare its view and controllers (Timer for lightning for example)
	 * @author Dylan
	 * @param ID of the level requested to play
	 */
	public void displayLevel(int LevelID) {

		/**
		 * 1) deserialize level, store in currentLevel
		 * 2) set the levelIO object = this
		 * 3) Call currentLevel.initialize() (Should return the view of the level)
		 * 4) initialize() should call initializeControllers() which adds the window
		 * 	  listener (passes the level's view and levelIO)
		 */
	//part 3 code: this.levelView = new LevelView("Puzzle");
	//part 4 code:	levelView.addWindowListener(new ExitLevelButtonController(this.levelView, this));
		//Put in lightning initializeControllers()
		//Timer timer = new Timer(2000, new LightningTimerController(this.levelView, levelIO));
		//timer.setRepeats(false);
		//timer.start();

	}

	void initializeView(){
		this.selectLevel = new LevelSelectionView();
		this.exitLevel = new GameExitScreen(new StarView());
	}

	void initializeControllers(){
		exitLevel.getExitButton().addActionListener(new QuitGameButtonController(this.exitLevel, this));
		selectLevel.addWindowListener(new ShutdownController(this));
	}

	/**
	 * Prepares all buttons available at game launch by setting the button to 
	 * unlocked and adding a play level listener to it
	 * @author Dylan
	 */
	void initializeButtons(){
		//TODO iterate over all levelIDs in levelData, "unlocking" every button for levels
		//that have enough stars (implement a method in starmap that returns levels with
		//at least 1 star
		selectLevel.unlockLevel(1, 0);
		//TODO iterate over all unlocked levels (see todo in initialize view) and add a 
		//listener to each button
		selectLevel.addListenerToButton(1, this);
	}

	/**
	 * Unlocks the specified level for play. Sets the button to enabled
	 * and initializes its controller
	 * @author Dylan
	 * @param levelID
	 */
	void unlockLevel(int levelID){
		selectLevel.unlockLevel(levelID, 0);
		selectLevel.getButton(levelID).addActionListener(new PlayLevelButtonController(selectLevel, this, levelID));
	}

	//========================== Getters ==========================//
	public LevelSelectionView getSelectView() {
		return this.selectLevel;
	}
	public GameExitScreen getExitView() {
		return this.exitLevel;
	}
	public LevelView getLevelView() {
		return this.levelView;
	}

	//========================== TODO: Questionable Methods to Implement ==========================//
	void initializeLevelView(){}
	void initializeLevelControllers(){}
}