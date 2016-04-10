package app;

import java.io.File;
import java.util.TreeMap;

import view.BuilderView;
import controllers.CloseBuilderDialog;
import model.AbstractLevelModel;
import view.LevelTypeSelectView;

public class Builder {
	LevelTypeSelectView ltsv;
	BuilderView bv;
	TreeMap<Integer, String> levelData;
	AbstractLevelModel buildingLevel;
	int highestLevelID;

	Builder(){
		levelData = loadLevelData();
		if(levelData.isEmpty()){
			highestLevelID = 0;
		}else{
			highestLevelID = levelData.lastKey();
		}
		
		bv = new BuilderView();
		ltsv = new LevelTypeSelectView(this, levelData);

		initializeControllers();
	}

	void initializeControllers(){
		bv.addWindowListener(new CloseBuilderDialog(this, bv));
	}

	/**
	 * Reads the directory located in the specified path, taking all files and storing them into an array.
	 * The files are then filtered to only include those who are of type ".txt" and have a parsable Integer.
	 * If the file meets those conditions, it is then added to an ArrayList of levelIDs.
	 * Finally, the array list is guarenteed to be sorted Lowest -> Highest.
	 * @return ArrayList with the LevelIDs read. If nothing is found, the arrayList returned is empty. 
	 * (Can check this with ArrayList.isEmpty())
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
	 * to set the level being built. It increments the highestLevelID to account
	 * for the new level being created. This allows the Builder class to know
	 * what level is being made
	 */
	public void setModelLevelCreation(){
		//Prepare the Builder View to display only the relevant sections of the editor
		switch(ltsv.getSelectedLevelType()){
		case "Puzzle":
			//TODO Store this building level in levelData ON SAVE
			/** TODO Add these Lines when PuzzleLevel implemented
			 * PuzzleLevel pl = new PuzzleLevel();
			 * buildingLevel = pl;
			 * bv.setModelLevel(pl);
			 */
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
	 */
	public void setModelLevelEditing(int levelID){
		/** TODO 
		 * Sort through the 3 types and prepare the BV for the right one
		 * Create the level model needed w/ string passed to constructor
		 * Then get the
		 * Then call a method inside that class that RETURNS the entire levelModel
		 * buildingLevel = levelModel;
		 */
		String levelType = levelData.get(levelID);
		String fileName = levelID+"_"+levelType+".txt";
		switch(levelType){
		case "Puzzle":
			/** TODO Add these Lines when PuzzleLevel implemented (Alternate Constructor used)
			 * PuzzleLevel pl = new PuzzleLevel(fileName);
			 * buildingLevel = pl;
			 * bv.setModelLevel(pl);
			 */
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

	public int getHighestLevelID(){
		return highestLevelID;
	}


//======================== TODO: ADDRESS THE FOLLOWING UNUSED METHODS ========================// 
	void initialize(){}
	void initializeView(){}
	void initializeLevelModel(int levelID){}
	void initializeLevelView(){}
	void initializeLevelControllers(){}

}
