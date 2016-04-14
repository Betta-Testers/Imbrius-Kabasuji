package app;

import view.GameExitScreen;
import view.LevelView;
import view.LevelSelectionView;
import view.StarView;

import controllers.ExitLevelButtonController;
import controllers.PlayLevelButtonController;
import controllers.QuitGameButtonController;
import controllers.ShutdownController;
import model.AbstractLevelModel;

public class Game extends LevelIO{
	
	/**The LevelSelectionView to view all levels**/
	LevelSelectionView selectLevel;
	
	/**Array of all levels available**/
	AbstractLevelModel levels[];
	
	/**The View of the level being played**/
	LevelView levelView;
	
	/**The view displayed at the end of the level being played**/
	GameExitScreen exitLevel;
	
	Game(){
		super();
		this.initialize();
	}
	
	//TODO GAME NEEDS TO SAVE PROGRESS OF LEVEL EVERYTIME YOU GET A STAR
	void initialize(){
		this.initializeModels();
		this.initializeView();
		this.initializeControllers();
		
		// TODO prepare state here. Such as unlocking any levels needed to be unlocked,
		// etc
	}
	
	void initializeView(){
		this.selectLevel = new LevelSelectionView();
		this.levelView = new LevelView("Puzzle");
		this.exitLevel = new GameExitScreen(new StarView());
	}
	
	void initializeControllers(){
		levelView.addWindowListener(new ExitLevelButtonController(this.levelView, this));
		exitLevel.getExitButton().addActionListener(new QuitGameButtonController(this.exitLevel, this));
		selectLevel.getAvailableLevelView(0).getPlayButton().addActionListener(new PlayLevelButtonController(selectLevel, this));
		selectLevel.addWindowListener(new ShutdownController(this));
	}
	
	void initializeModels(){
		loadStarMap();
	}
	
	public LevelSelectionView getSelectView() {
		return this.selectLevel;
	}
	
	public GameExitScreen getExitView() {
		return this.exitLevel;
	}
	
	public LevelView getLevelView() {
		return this.levelView;
	}
	
	void unlockNextLevel(int nextLevelID){
		//TODO This method must unlock a level in the AvailableLevelView.
		/*TODO This method must set the levelMODEL to be unlocked as well, which means opening the file associated with
		 * levelID, reading line by line until the unlocked marker is found, and changing that value in the file.
		 */
	}
	
	/**
	 * Updates the Maximum stars for a given LevelID and star count. 
	 * If the count passed in is less than the value recorded in levelData,
	 * the value is not recorded.
	 * @param levelID
	 * @param starsEarned - the current number of stars earned on a level
	 */
	public void updateStars(int levelID, int starsEarned){
		if(starsEarned > levelData.getMaxStars(levelID)){
			levelData.setMaxStars(levelID, starsEarned);
		}
	}

//========================== TODO: Questionable Methods to Implement ==========================//
	void initializeLevelView(){}
	void initializeLevelControllers(){}
}