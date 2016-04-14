package app;

import view.GameExitScreen;
import view.LevelView;
import view.LevelSelectionView;
import view.StarView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import controllers.ExitLevelButtonController;
import controllers.PlayLevelButtonController;
import controllers.QuitGameButtonController;
import model.AbstractLevelModel;

public class Game {
	/**Directory specified in main for loading files**/
	String defaultDirectory;
	
	/**The LevelSelectionView to view all levels**/
	LevelSelectionView selectLevel;
	
	/**Array of all levels available**/
	AbstractLevelModel levels[];
	
	/**The current level being played**/
	AbstractLevelModel currentLevel;
	
	/**The View of the level being played**/
	LevelView levelView;
	
	/**The view displayed at the end of the level being played**/
	GameExitScreen exitLevel;
	
	/**A sorted Mapping of all EXISTING levels ON DISK by ID, Type**/
	StarMap<Integer, String> levelData;
	
	Game(String defaultDirectory){
		this.defaultDirectory = defaultDirectory;
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

	/**
	 * Returns a StarMap object read from disk. If the StarMap cannot be read, null is
	 * returned instead and an error is printed.
	 * @return StarMap
	 */
	public StarMap<Integer, String> loadStarMap(){
		ObjectInputStream ois = null;
		StarMap<Integer, String> m = null;

		String location = defaultDirectory+"StarMap.storage";

		try {
			ois = new ObjectInputStream (new FileInputStream(location));
			m = (StarMap<Integer, String>) ois.readObject();
			ois.close();
		} catch (Exception e) { 
			System.err.println("Unable to load levelData from:" + location);
			m = null;
		}

		if (ois != null) { 
			try { ois.close(); } catch (IOException ioe) { }
		}
		return m;
	}
	
	/**
	 * Stores a StarMap to disk. If the starmap cannot be saved, an error is
	 * printed to the console
	 */
	public void saveStarMap(){
		ObjectOutputStream oos = null;

		String location = defaultDirectory+"StarMap.storage";

		try {
			oos = new ObjectOutputStream(new FileOutputStream(location));
			oos.writeObject(levelData);
		} catch (Exception e) {
			System.err.println("Unable to save the levelData:" + e.getMessage());
		}

		if (oos != null) {
			try { oos.close(); } catch (IOException ioe) { } 
		}
	}
	
	/**
	 * TODO WORK IN PROGRESS THE BELOW COMMENT IS NO LONGER TRUE
	 * Right now it reads in an abstract level model and returns that. As to whether that is enough
	 * information or not, I am not sure yet. I need to test this.
	 * 
	 * Given a levelID, the method looks up the associated levelType from the LevelData tree.
	 * Using this information it generates the path to the file, determines the correct type of level
	 * to create, and returns that object.
	 * @param levelID - ID of the level being opened
	 */
	public AbstractLevelModel loadLevel(int levelID){
		ObjectInputStream ois = null;
		AbstractLevelModel m = null;

		String type = levelData.get(levelID);
		String location = defaultDirectory+levelID+"_"+type+".storage";

		try {
			ois = new ObjectInputStream (new FileInputStream(location));
			m = (AbstractLevelModel) ois.readObject();
			ois.close();
		} catch (Exception e) { 
			System.err.println("Unable to load state from:" + location);
			m = null;
		}

		if (ois != null) { 
			try { ois.close(); } catch (IOException ioe) { }
		}
		return m;
	}

//========================== TODO: Questionable Methods to Implement ==========================//
	void initializeLevelView(){}
	void initializeLevelControllers(){}
}