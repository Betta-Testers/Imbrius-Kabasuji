package App;

import view.GameExitScreen;
import view.LevelView;
import view.LevelSelectionView;
import view.SplashScreen;
import view.StarView;
import controllers.ExitLevelButtonController;
import controllers.PlayLevelButtonController;
import controllers.QuitGameButtonController;

public class Game {
	SplashScreen startUp;
	LevelSelectionView selectLevel;
	//TODO add abstractLevelModel levels[]
	//TODO add abstractLevelModel currentLevel
	LevelView levelView;
	GameExitScreen exitLevel;
	
	Game(){
		this.initialize();
	}
	
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
		//TODO add this in when files are put together, 
		//AvailableLevelView already has an unlocklevel operation, just need to have that run with a for loop
	}
	
//	void initializeLevelView(){
//		//TODO initialize the view for levels
//	}
//	
//	void initializeLevelControllers(){
//		//TODO Add the controllers needed in the level
//	}
//	
//	void initializeExitLevelScreen(){
//		//TODO initialize the exit level screen made by EVAN
//	}
//	
//	void initializeExitLevelScreenControllers(){
//		//TODO initialize the controllers needed for the exit level screen
//	}
}