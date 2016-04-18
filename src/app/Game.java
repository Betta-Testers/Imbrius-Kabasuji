package app;

import view.GameExitScreen;
import view.LevelView;
import view.LevelSelectionView;
import view.StarView;

import controllers.PlayLevelButtonController;
import controllers.QuitGameButtonController;
import controllers.ShutdownController;
import model.AbstractLevelModel;

public class Game extends LevelIO{

	/**The LevelSelectionView to view all levels**/
	LevelSelectionView selectLevel;

	/**The View of the level being played**/
	LevelView levelView;

	/**The view displayed at the end of the level being played**/
	GameExitScreen exitLevel;
	
	/**Holds the current level being played**/	
	AbstractLevelModel currentLevel;
	
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
	 * @author Dylan
	 * @param ID of the level requested to play
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

	void initializeView(){
		this.selectLevel = new LevelSelectionView();
		this.exitLevel = new GameExitScreen(new StarView());
	}

	void initializeControllers(){
		exitLevel.getExitButton().addActionListener(new QuitGameButtonController(this.exitLevel, this));
		selectLevel.addWindowListener(new ShutdownController(this));
	}

	/**
	 * Prepares all buttons of the levels available for play at launch of application.
	 * After levelData has been read in, the the method iterates over all levelids that count as
	 * unlocked (retrieved from a method call to StarMap). It unlocks the button in the view and then
	 * adds a listener to that button in the view that "connects" the entity to the button.
	 * This method assumes levelData has been read in.
	 * @author Dylan
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
	 * Unlocks the specified level for play. Sets the button to enabled
	 * and initializes its controller
	 * @author Dylan
	 * @param levelID
	 */
	public boolean unlockNextLevel(){
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
	public AbstractLevelModel getCurrentLevel(){
		return currentLevel;
	}
}