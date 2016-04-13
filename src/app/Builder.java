package app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeMap;

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
	TreeMap<Integer, String> levelData;

	/**The current level being built or edited**/
	AbstractLevelModel buildingLevel;

	Builder(String defaultDirectory){
		this.defaultDirectory = defaultDirectory;

		levelData = loadLevelData();
		bv = new BuilderView();
		ltsv = new LevelTypeSelectView(this, levelData);

		initializeControllers();
	}

	void initializeControllers(){
		bv.addWindowListener(new CloseBuilderDialog(this, bv));
	}

	/**
	 * Reads the directory located in the specified path, taking all level files and storing them into an array.
	 * Every file has its name read and stored in a TreeMap by LevelID, LevelType.
	 * Because it is a TreeMap, the levels are guaranteed to be sorted lowest -> highest.
	 * @return TreeMap with the LevelIDs read. If nothing is found, the TreeList returned is empty. 
	 */
	TreeMap<Integer, String> loadLevelData(){
		File folder = new File(defaultDirectory);
		File[] listOfFiles = folder.listFiles();
		String levelType;
		String levelNum;
		int levelID = 0;
		TreeMap<Integer, String> levelData = new TreeMap<Integer, String>();

		for (File f: listOfFiles) {
			levelNum = f.getName().substring(0, f.getName().lastIndexOf("_"));
			levelType = f.getName().substring(f.getName().lastIndexOf("_")+1, f.getName().lastIndexOf("."));
			try{
				levelID = Integer.parseInt(levelNum);
			}catch(NumberFormatException e){
				levelID = -1;
			}

			levelData.put(levelID, levelType);

		}

		return levelData;
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
	 * TODO Store this building level in levelData ON SAVE
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
			/** TODO Add these lines when LightningLevel implemented (Alternate Constructor used)
			 * LightningLevel ll = new LightningLevel(fileName);
			 * buildingLevel = ll;
			 * bv.setModelLevel(ll);
			 */
			bv.prepLightning();
			break;
		case "Release":
			/** TODO Add these lines when ReleaseLevel implemented (Alternate Constructor used)
			 * ReleaseLevel rl = new ReleaseLevel(fileName);
			 * buildingLevel = rl;
			 * bv.setModelLevel(rl);
			 */
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

}
