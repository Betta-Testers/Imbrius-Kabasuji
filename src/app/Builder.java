package app;

import java.io.File;
import java.util.TreeMap;

import view.BuilderView;
import controllers.CloseBuilderDialog;
import model.AbstractLevelModel;
import model.PuzzleLevel;
import view.LevelTypeSelectView;

public class Builder {
	LevelTypeSelectView ltsv;
	BuilderView bv;
	TreeMap<Integer, String> levelData;
	AbstractLevelModel buildingLevel;

	Builder(){
		levelData = loadLevelData();
		
		bv = new BuilderView(this);
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
		File folder = new File("./ImbriusBuilderLevels/");
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
	 * For CREATING a level. This method is used by CreateLevelBtnController
	 * to set the level being built. The level being built is stored in buildingLevel
	 * TODO Store this building level in levelData ON SAVE
	 * TODO When making a new level, create a File and pass it into the constructor
	 * TODO That means when CANCELLING a level, you need to delete the file that was created for it!
	 */
	public void setModelLevelCreation(){
		switch(ltsv.getSelectedLevelType()){
		case "Puzzle":
			/** TODO Add these Lines when PuzzleLevel implemented
			 * PuzzleLevel pl = new PuzzleLevel();
			 * buildingLevel = pl;
			 * bv.setModelLevel(pl);
			 */
			PuzzleLevel pl = new PuzzleLevel();
			buildingLevel = pl;
			bv.setModelLevel(pl);
			bv.prepPuzzle();
			break;
		case "Lightning":

			/** TODO Add these lines when LightningLevel implemented
			 * LightningLevel ll = new LightningLevel();
			 * buildingLevel = ll;
			 * bv.setModelLevel(ll);
			 */
			bv.prepLightning();
			break;
		case "Release":

			/** TODO Add these lines when ReleaseLevel implemented
			 * ReleaseLevel rl = new ReleaseLevel();
			 * buildingLevel = rl;
			 * bv.setModelLevel(rl);
			 */
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
		String fileName = levelID+"_"+levelType+".txt";
		switch(levelType){
		case "Puzzle":
			/** TODO Add these Lines when PuzzleLevel implemented (Alternate Constructor used)
			 * PuzzleLevel pl = new PuzzleLevel(fileName);
			 * buildingLevel = pl;
			 * bv.setModelLevel(pl);
			 */
			PuzzleLevel pl = new PuzzleLevel();
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

	public void saveLevel() {
		System.out.println("Yo man, I heard you wanted to save your file");
	}

//======================== TODO: ADDRESS THE FOLLOWING UNUSED METHODS ========================// 
	void initialize(){}
	void initializeView(){}
	void initializeLevelModel(int levelID){}
	void initializeLevelView(){}
	void initializeLevelControllers(){}

}
