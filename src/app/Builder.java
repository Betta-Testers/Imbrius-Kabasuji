package app;

import java.io.File;
import java.util.ArrayList;

import view.BuilderView;
import controllers.CloseBuilderDialog;
import view.LevelTypeSelectView;

public class Builder {
	LevelTypeSelectView ltsv;
	BuilderView bv;
	ArrayList<Integer> levelIDs;
	//TODO add this line: AbstractLevelModel buildingLevel;
	int highestLevelID;

	Builder(){
		levelIDs = loadLevelIDs();
		if(levelIDs.isEmpty()){
			highestLevelID = 0;
		}else{
			highestLevelID = levelIDs.get(levelIDs.size()-1);
		}
		bv = new BuilderView();
		ltsv = new LevelTypeSelectView(this, highestLevelID);
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
	ArrayList<Integer> loadLevelIDs(){
		File folder = new File("./ImbriusBuilderLevels/");
		File[] listOfFiles = folder.listFiles();
		String extension;
		String name;
		int levelID = 0;
		ArrayList<Integer> levelIDs = new ArrayList<Integer>();

		for (File f: listOfFiles) {
			name = f.getName().substring(0, f.getName().lastIndexOf("."));
			extension = f.getName().substring(f.getName().lastIndexOf("."), f.getName().length());	
			try{
				levelID = Integer.parseInt(name);
			}catch(NumberFormatException e){
				levelID = -1;
			}

			if (f.isFile() && extension.equals(".txt") && levelID > 0) {
				levelIDs.add(levelID);
			}

			levelID = 0;
		}


		/*levelIDs.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 <= o2){return o1;}
				return o2;
			}
		});*/


		return levelIDs;
	}

	/**
	 * For CREATING a level. This method is used by CreateLevelBtnController
	 * to set the level being built. It increments the highestLevelID to account
	 * for the new level being created. This allows the Builder class to know
	 * what level is being made
	 */
	public void setModelLevel(int levelID){
		//Prepare the Builder View to display only the relevant sections of the editor
		switch(ltsv.getSelectedLevelType()){
		case "Puzzle":
			levelIDs.add(levelID);
			highestLevelID = levelID;
			/** TODO Add these Lines when PuzzleLevel implemented
			 * PuzzleLevel pl = new PuzzleLevel();
			 * buildingLevel = pl;
			 * bv.setModelLevel(pl);
			 */
			bv.prepPuzzle();
			break;
		case "Lightning":
			levelIDs.add(levelID);
			highestLevelID = levelID;
			/** TODO Add these lines when LightningLevel implemented
			 * LightningLevel ll = new LightningLevel();
			 * buildingLevel = ll;
			 * bv.setModelLevel(ll);
			 */
			bv.prepLightning();
			break;
		case "Release":
			levelIDs.add(levelID);
			highestLevelID = levelID;
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
		levelIDs.remove(levelIDs.size()-1);
		highestLevelID = levelIDs.get(levelIDs.size()-1);
		setLevelTypeSelectViewVisible(true);
	}


}
