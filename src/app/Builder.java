package app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import view.BuilderView;
import controllers.CloseBuilderDialog;
import model.AbstractLevelModel;
import model.LightningLevel;
import model.PuzzleLevel;
import model.ReleaseLevel;
import view.LevelTypeSelectView;

public class Builder {
	/**Directory specified in main for storing and loading files**/
	String defaultDirectory;

	/**The LevelTypeSelectionView to select the type of level the builder wants to make**/
	LevelTypeSelectView ltsv;

	/**The BuilderView, for displaying the level once the builder has choosen to edit/create a level**/
	BuilderView bv;

	/**A sorted Mapping of all EXISTING levels ON DISK by ID, Type**/
	StarMap<Integer, String> levelData;

	/**The current level being built or edited**/
	AbstractLevelModel buildingLevel;

	Builder(String defaultDirectory){
		this.defaultDirectory = defaultDirectory;

		levelData = loadStarMap();
		bv = new BuilderView();
		ltsv = new LevelTypeSelectView(this, levelData);

		initializeControllers();
	}

	void initializeControllers(){
		bv.addWindowListener(new CloseBuilderDialog(this, bv));
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
	 *TODO THIS METHOD NEEDS TESTING. It stores the level as an abstract level model for now. If that is enough, I 
	 *am not yet sure
	 * Saves the level being edited to disk. If the level is not already in levelData, it is
	 * then added to levelData. This method assumes the board/bullpen/any termination conditions have
	 * already been reset to a default state (bullpen has all pieces restored to it if they were testing, board has all pieces
	 * cleared from it, etc).
	 */
	public void saveLevel(){
		ObjectOutputStream oos = null;

		int id = buildingLevel.getID();
		String type = buildingLevel.getType();
		String location = defaultDirectory+id+"_"+type+".storage";

		try {
			oos = new ObjectOutputStream(new FileOutputStream(location));
			oos.writeObject(buildingLevel);
		} catch (Exception e) {
			System.err.println("Unable to save the level:" + e.getMessage());
		}

		if (oos != null) {
			try { oos.close(); } catch (IOException ioe) { } 
		}

		if(id > levelData.lastKey()){
			levelData.put(id, type);
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

		/*
		ObjectInputStream ois = null;
		PuzzleLevel pl = null;
		ReleaseLevel rl = null;
		LightningLevel ll = null;

		String type = levelData.get(levelID);
		String location = defaultDirectory+levelID+"_"+type+".storage";

		switch(type){
		case "Puzzle":
			try {
				ois = new ObjectInputStream (new FileInputStream(location));
				pl = (PuzzleLevel) ois.readObject();
				ois.close();
			} catch (Exception e) { 
				System.err.println("Unable to load state from:" + location);
				pl = null;
			}

			if (ois != null) { 
				try { ois.close(); } catch (IOException ioe) { }
			}
			return pl;
		case "Release":
			try {
				ois = new ObjectInputStream (new FileInputStream(location));
				rl = (ReleaseLevel) ois.readObject();
				ois.close();
			} catch (Exception e) { 
				System.err.println("Unable to load state from:" + location);
				rl = null;
			}

			if (ois != null) { 
				try { ois.close(); } catch (IOException ioe) { }
			}
			return rl;
		case "Lightning":
			try {
				ois = new ObjectInputStream (new FileInputStream(location));
				ll = (LightningLevel) ois.readObject();
				ois.close();
			} catch (Exception e) { 
				System.err.println("Unable to load state from:" + location);
				ll = null;
			}

			if (ois != null) { 
				try { ois.close(); } catch (IOException ioe) { }
			}
			return ll;
		default:
			return null;
		}
		 */

	}

	/**
	 * For CREATING a level. This method is used by CreateLevelBtnController
	 * to set the level being built. The level being built is stored in buildingLevel
	 */
	public void setModelLevelCreation(){
		switch(ltsv.getSelectedLevelType()){
		case "Puzzle":
			PuzzleLevel pl = new PuzzleLevel(levelData.lastKey()+1);
			buildingLevel = pl;
			bv.setModelLevel(pl);
			bv.prepPuzzle();
			break;
		case "Lightning":
			LightningLevel ll = new LightningLevel(levelData.lastKey()+1);
			buildingLevel = ll;
			bv.setModelLevel(ll);
			bv.prepLightning();
			break;
		case "Release":
			ReleaseLevel rl = new ReleaseLevel(levelData.lastKey()+1);
			buildingLevel = rl;
			bv.setModelLevel(rl);
			bv.prepRelease();
			break;
		}
	}

	/**
	 * For EDITING a level. This method is used by the ExistingLevelEditController
	 * to set the bv up for the level being edited.
	 * TODO Don't pass a String fileName. Pass a File sourceFile instead
	 */
	public void setModelLevelEditing(int levelID){
		String levelType = levelData.get(levelID);
		switch(levelType){
		case "Puzzle":
			PuzzleLevel pl = (PuzzleLevel) loadLevel(levelID);
			buildingLevel = pl;
			bv.setModelLevel(pl);
			bv.prepPuzzle();
			break;
		case "Lightning":
			LightningLevel ll = (LightningLevel) loadLevel(levelID);
			buildingLevel = ll;
			bv.setModelLevel(ll);
			bv.prepLightning();
			break;
		case "Release":
			ReleaseLevel rl = (ReleaseLevel) loadLevel(levelID);
			buildingLevel = rl;
			bv.setModelLevel(rl);
			bv.prepRelease();
			break;
		}
	}

	/**
	 * Method encapsulates the setVisible functionality of builderView,
	 * to avoid the need of a getter/setter pair. If enabled is true, the
	 * window is displayed. Else, it's set to be hidden.
	 * @param enabled True displays window
	 */
	public void setBuilderViewVisible(boolean enabled){
		bv.setVisible(enabled);
	}

	/**
	 * Method encapsulates the setVisible functionality of LevelTypeSelectView,
	 * to avoid the need of a getter/setter pair. If enabled is true, the
	 * window is displayed. Else, it's set to be hidden.
	 * @param enabled True displays window
	 */
	public void setLevelTypeSelectViewVisible(boolean enabled){
		ltsv.setVisible(enabled);
	}

	/**
	 * Returns the highestLevelID of the loaded levelData. 
	 * If there is no data inside of levelData, 0 is returned.
	 * @return highestLevelID
	 */
	public int getHighestLevelID(){
		if(levelData.lastKey() == null){ return 0;}
		return levelData.lastKey();
	}

	//======================== TODO: ADDRESS THE FOLLOWING UNUSED METHODS ========================// 
	void initialize(){}
	void initializeView(){}
	void initializeLevelModel(int levelID){}
	void initializeLevelView(){}
	void initializeLevelControllers(){}
	
	//======================== TODO: MOVE THESE METHODS TO GAME ========================// 
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
	
	//TODO SaveStarMap
	//TODO LoadStarMap
	//TODO LoadLevel

}
