package app;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import view.BuilderView;
import view.LevelTypeSelectView;
import controllers.common.ShutdownController;
import model.AbstractLevelModel;
import model.LightningLevel;
import model.ReleaseLevel;
import model.PuzzleLevel;

/**
 * Application class tracking the Builder. Prepares the views and controllers for LevelTypeSelectView and
 * manages the returning and leaving between the builderView and the LevelTypeSelectionView.
 * @author Dylan
 *
 */
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
		System.out.println(levelData.toString());
		this.initializeView();
		this.initializeControllers();
	}

	void initializeView(){
		ltsv = new LevelTypeSelectView();

		for(int id: levelData.keySet()){
			try {
				ltsv.addExistingLevel(levelData.get(id), id, this);
			} catch (Exception e) {
				throw new RuntimeException("ID not found in levelData, LTSV couldn't be initialized" + e.getMessage());
			}
		}
	}

	void initializeControllers(){
		ltsv.setShutdownController(new ShutdownController(this));
		ltsv.initializeControllers(this);
	}

	/**
	 * Saves the level being edited to disk. If the level is not already in levelData, it is
	 * then added to levelData and the LTSV. This method assumes the board/bullpen/any termination conditions have
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

		if(!levelData.containsKey(id)){
			levelData.put(id, type);
			ltsv.addExistingLevel(type, id, this);
		}
	}

	/**
	 * Deletes a level from disk, which upon success will remove it from the view and the currentLevel
	 * fields. 
	 * @param id - ID of level being deleted
	 * @return true if the level could be deleted successfully
	 */
	public boolean deleteLevel(int id){
		if(levelData.deleteFromDisk(id)){
			ltsv.removeExistingLevel(id);
			this.currentLevel = null;
			return true;
		}
		return false;
	}
	
	public void createReleaseLevel() {
		LevelFactory factory = new LevelFactory();
		ReleaseLevel rl = factory.GenerateBlankRelease(levelData.nextOpenID());
		currentLevel = rl;
		bv = new BuilderView(this);
		bv.prepRelease();
	}

	public void createPuzzleLevel() {
		LevelFactory factory = new LevelFactory();
		PuzzleLevel pl = factory.GenerateBlankPuzzle(levelData.nextOpenID());
		currentLevel = pl;
		bv = new BuilderView(this);
		bv.prepPuzzle();
	}

	public void createLightningLevel() {
		LevelFactory factory = new LevelFactory();
		LightningLevel ll = factory.GenerateBlankLightning(levelData.nextOpenID());
		currentLevel = ll;
		bv = new BuilderView(this);
		bv.prepLightning();
	}

	/**
	 * For EDITING a level. This method is used by the ExistingLevelEditController
	 * to set the bv up for the level being edited.
	 * @param int levelID - level requested for editing. 
	 * @return boolean - true if level could be edited
	 */
	public boolean editLevel(int levelID){
		String levelType;
		try{
			levelType = levelData.get(levelID);
		}catch(Exception e){
			return false;
		}
		
		switch(levelType){
		case "Puzzle":
			PuzzleLevel pl;
			try {
				pl = (PuzzleLevel) loadLevel(levelID);
				currentLevel = pl;
				bv = new BuilderView(this);
				bv.prepPuzzle();
			} catch (Exception e) {
				System.err.println(e.getMessage());
				return false;
			}
			break;
		case "Lightning":
			LightningLevel ll;
			try {
				ll = (LightningLevel) loadLevel(levelID);
				currentLevel = ll;
				bv = new BuilderView(this);
				bv.prepLightning();
			} catch (Exception e) {
				System.err.println(e.getMessage());
				return false;
			}
			break;
		case "Release":
			ReleaseLevel rl;
			try {
				rl = (ReleaseLevel) loadLevel(levelID);
				currentLevel = rl;
				bv = new BuilderView(this);
				bv.prepRelease();
			} catch (Exception e) {
				System.err.println(e.getMessage());
				return false;
			}
			break;
		}
		return true;
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
//	public boolean isNewLevel() {
//		return !levelData.containsKey(currentLevel.getID());
//	}
}
