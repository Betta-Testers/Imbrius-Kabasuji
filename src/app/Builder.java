package app;

import java.io.File;
import java.util.HashMap;


import view.BuilderView;
import controllers.CloseBuilderDialog;
import view.LevelTypeSelectView;

public class Builder {
	LevelTypeSelectView ltsv;
	BuilderView bv;
	HashMap<Integer, String> levelData;
	//TODO add this line: AbstractLevelModel buildingLevel;
	int highestLevelID;

	Builder(){
		levelData = loadLevelData();
		if(levelData.isEmpty()){
			highestLevelID = 0;
		}else{
			//Iterate though level data and populate with largest value
		}


		bv = new BuilderView();
		ltsv = new LevelTypeSelectView(this, levelData);

		initializeControllers();
	}


	void initialize(){
		/**TODO Determine where to get highest level from....
		 * Probably need to have a method run before this that reads files and stores
		 * the highest number, then pass that as the argument
		 */


		//initializeView();
		//initializeControllers();
	}

	void initializeView(){
		//TODO Initialize selectionView in here

	}

	void initializeControllers(){
		bv.addWindowListener(new CloseBuilderDialog(this, bv));
	}

	void initializeLevelModel(int levelID){

	}

	/**
	 * Reads the directory located in the specified path, taking all files and storing them into an array.
	 * The files are then filtered to only include those who are of type ".txt" and have a parsable Integer.
	 * If the file meets those conditions, it is then added to an ArrayList of levelIDs.
	 * Finally, the array list is guarenteed to be sorted Lowest -> Highest.
	 * @return ArrayList with the LevelIDs read. If nothing is found, the arrayList returned is empty. 
	 * (Can check this with ArrayList.isEmpty())
	 */
	HashMap<Integer, String> loadLevelData(){
		File folder = new File("./ImbriusBuilderLevels/");
		File[] listOfFiles = folder.listFiles();
		String levelType;
		String levelNum;
		int levelID = 0;
		HashMap<Integer, String> levelData = new HashMap<Integer, String>();

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
	public void setModelLevel(){
		//Prepare the Builder View to display only the relevant sections of the editor
		switch(ltsv.getSelectedLevelType()){
		case "Puzzle":
			levelData.put(++highestLevelID, "Puzzle");
			/** TODO Add these Lines when PuzzleLevel implemented
			 * PuzzleLevel pl = new PuzzleLevel();
			 * buildingLevel = pl;
			 * bv.setModelLevel(pl);
			 */
			bv.prepPuzzle();
			break;
		case "Lightning":
			levelData.put(++highestLevelID, "Lightning");
			/** TODO Add these lines when LightningLevel implemented
			 * LightningLevel ll = new LightningLevel();
			 * buildingLevel = ll;
			 * bv.setModelLevel(ll);
			 */
			bv.prepLightning();
			break;
		case "Release":
			levelData.put(++highestLevelID, "Release");
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

	void initializeLevelView(){
		//TODO Initialize BuilderView in here
	}

	void initializeLevelControllers(){
		//TODO Initialize BuilderView Controllers in here
		//		builderView.setVisible(true); to make builderview appear
	}



	public void cancelBuild() {
		setBuilderViewVisible(false);
		levelData.remove(highestLevelID);
		highestLevelID--;
		setLevelTypeSelectViewVisible(true);
	}


}
