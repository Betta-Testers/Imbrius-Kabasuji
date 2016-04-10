package App;

import gameMockups.SelectLevel;
import view.LevelTypeSelectView;
import view.LevelView;

public class Game {
	SelectLevel selectLevel;
	//TODO add abstractLevelModel levels[]
	//TODO add abstractLevelModel currentLevel
	LevelView levelView;
	//ExitLevelScreen exitLevel
	
	Game(){
		
	}
	
	void initialize(){
		
	}
	
	void initializeView(){
		//TODO Initialize splash screen or level select view here?
	}
	
	void initializeControllers(){
		//TODO add controllers that are needed here
	}
	
	void initializeModels(){
		
	}
	
	void unlockNextLevel(int nextLevelID){
		//TODO add this in when files are put together, 
		//AvailableLevelView already has an unlocklevel operation, just need to have that run with a for loop
	}
	
	void initializeLevelView(){
		//TODO initialize the view for levels
	}
	
	void initializeLevelControllers(){
		//TODO Add the controllers needed in the level
	}
	
	void initializeExitLevelScreen(){
		//TODO initialize the exit level screen made by EVAN
	}
	
	void initializeExitLevelScreenControllers(){
		//TODO initialize the controllers needed for the exit level screen
	}
}
