package app;


import view.GameExitScreen;
import view.LevelView;
import view.LevelSelectionView;
import view.SplashScreen;
import view.StarView;
import controllers.ExitLevelButtonController;
import controllers.PlayLevelButtonController;
import controllers.QuitGameButtonController;
import model.AbstractLevelModel;

public class Game {
	SplashScreen startUp;
	LevelSelectionView selectLevel;
	AbstractLevelModel levels[];
	AbstractLevelModel currentLevel;
	LevelView levelView;
	GameExitScreen exitLevel;
	
	Game(){
		this.initialize();
	}
	
	//TODO GAME NEEDS TO SAVE PROGRESS OF LEVEL EVERYTIME YOU GET A STAR
	void initialize(){
		this.initializeView();
		this.initializeControllers();
		this.initializeModels();
	}
	
	void initializeView(){
		//TODO Initialize splash screen or level select view here?
		this.startUp = new SplashScreen();
		this.selectLevel = new LevelSelectionView();
		this.levelView = new LevelView("Puzzle");
		this.exitLevel = new GameExitScreen(new StarView());
		
		startUp.setVisible(true);
	}
	
	void initializeControllers(){
		//TODO add controllers that are needed here
		levelView.addWindowListener(new ExitLevelButtonController(this.levelView, this));
		exitLevel.getExitButton().addActionListener(new QuitGameButtonController(this.exitLevel, this));
		selectLevel.getAvailableLevelView(0).getPlayButton().addActionListener(new PlayLevelButtonController(selectLevel, this));
	}
	
	void initializeModels(){
		
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
	
	//TODO Implement reading levels in. Needs to modify levels[] and currentLevel
	//TODO When reading in levels, it's expected you pass the File associated with the level to that level's constructor
//========================== TODO: Questionable Methods to Implement ==========================//
	void initializeLevelView(){}
	void initializeLevelControllers(){}
}