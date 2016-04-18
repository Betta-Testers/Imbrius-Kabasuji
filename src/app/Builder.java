package app;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import view.BuilderView;
import view.LevelTypeSelectView;
import controllers.CloseBuilderDialog;
import controllers.ShutdownController;
import model.AbstractLevelModel;
import model.LightningLevel;
import model.ReleaseLevel;
import model.PuzzleLevel;

public class Builder extends LevelIO{

	/**The LevelTypeSelectionView to select the type of level the builder wants to make**/
	LevelTypeSelectView ltsv;

	/**The BuilderView, for displaying the level once the builder has choosen to edit/create a level**/
	BuilderView bv;

	/**Current level being edited.**/
	AbstractLevelModel currentLevel;

	public Builder(String directory){
		super(directory);
		this.initialize();
	}

	void initialize(){
		this.levelData = loadStarMap();
		System.out.println("Levels Loaded:"+levelData.toString());

		this.initializeView();
		this.initializeControllers();
	}

	void initializeView(){
		bv = new BuilderView(this);
		ltsv = new LevelTypeSelectView();

		for(int id: levelData.keySet()){
			try {
				ltsv.addExistingLevel(levelData.get(id), id);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("ID not found in levelData, LTSV couldn't be initialized");
			}
		}
	}

	void initializeControllers(){
		bv.addWindowListener(new CloseBuilderDialog(this, bv));
		ltsv.addWindowListener(new ShutdownController(this));

		ltsv.initializeControllers(this);
	}

	/**
	 * Saves the level being edited to disk. If the level is not already in levelData, it is
	 * then added to levelData. This method assumes the board/bullpen/any termination conditions have
	 * already been reset to a default state (bullpen has all pieces restored to it if they were testing, board has all pieces
	 * cleared from it, etc).
	 * 
	 * The file format is ID_TYPE.storage
	 */
	public void saveLevel(){
		ObjectOutputStream oos = null;

		int id = currentLevel.getID();
		String type = currentLevel.getType();
		String location = defaultDirectory+id+"_"+type+".storage";

		try {
			oos = new ObjectOutputStream(new FileOutputStream(location));
			oos.writeObject(currentLevel);
		} catch (Exception e) {
			System.err.println("Unable to save the level:" + e.getMessage());
		}

		if (oos != null) {
			try { oos.close(); } catch (IOException ioe) { } 
		}

		if(id > levelData.lastID()){
			levelData.put(id, type);
		}
	}

	public void createReleaseLevel() {
		LevelFactory factory = new LevelFactory();
		ReleaseLevel rl = factory.GenerateBlankRelease(levelData.nextOpenID());
		currentLevel = rl;
		bv.prepRelease();
	}

	public void createPuzzleLevel() {
		LevelFactory factory = new LevelFactory();
		PuzzleLevel pl = factory.GenerateBlankPuzzle(levelData.nextOpenID());
		currentLevel = pl;
		bv.prepPuzzle();
	}

	public void createLightningLevel() {
		LevelFactory factory = new LevelFactory();
		LightningLevel ll = factory.GenerateBlankLightning(levelData.nextOpenID());
		currentLevel = ll;
		bv.prepLightning();
	}

	/**
	 * For EDITING a level. This method is used by the ExistingLevelEditController
	 * to set the bv up for the level being edited.
	 * @param int levelID - level requested for editing. 
	 */
	public void editLevel(int levelID){
		String levelType;
		try{
			levelType = levelData.get(levelID);
		}catch(Exception e){
			throw new RuntimeException("Called editLevel on Builder with non-existant ID");
		}
		
		switch(levelType){
		case "Puzzle":
			PuzzleLevel pl;
			try {
				pl = (PuzzleLevel) loadLevel(levelID);
				currentLevel = pl;
				bv.prepPuzzle();
			} catch (Exception e) {
				System.err.println("Could not load levelID "+levelID+" from disk.");
				e.printStackTrace();
			}
			break;
		case "Lightning":
			LightningLevel ll;
			try {
				ll = (LightningLevel) loadLevel(levelID);
				currentLevel = ll;
				bv.prepLightning();
			} catch (Exception e) {
				System.err.println("Could not load levelID "+levelID+" from disk.");
				e.printStackTrace();
			}
			break;
		case "Release":
			ReleaseLevel rl;
			try {
				rl = (ReleaseLevel) loadLevel(levelID);
				currentLevel = rl;
				bv.prepRelease();
			} catch (Exception e) {
				System.err.println("Could not load levelID "+levelID+" from disk.");
				e.printStackTrace();
			}
			break;
		}
	}

	//========================== Getters ==========================//
	public BuilderView getBuilderView(){
		return bv;
	}
	public LevelTypeSelectView getLevelTypeSelectView(){
		return ltsv;
	}
	public int getHighestLevelID(){
		return levelData.lastID();
	}
	public AbstractLevelModel getCurrentLevel(){
		return currentLevel;
	}
}
