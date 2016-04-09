package app;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;

import view.BuilderView;
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
		//TODO Initialize selectionView controllers here

		/**
		 * TODO The controller for selection view should read the selection made 
		 * when you hit "play level" and call a builder initialization method inside
		 * THIS (so pass it this) that will prep a lightning, puzzle, or release.
		 * 
		 * -OR-
		 * 
		 * Pass it BuilderView and have it call the appropriate method on builderView to prepare it.
		 * Then set the builderView to visible and the selection view to hidden
		 * 
		 * Think about level views. When you prepare the level model and it reads in, how will your
		 * view adapt to that? It would call the proper method on the BuilderView to display the correct objects,
		 * after which boardView and bullpenView would read their models.
		 * 
		 * So if the player chooses to load a level, they would want to initializeModel(), then View, then Controllers.
		 * 
		 * Does that mean making a method here that lets you change the builderView to a new one generated in the
		 * controller so you can easily swap it? Or does that mean writing a reevaluate() method in the builderView,
		 * where it updates everything since a model inside must have beens set()
		 */
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

		levelIDs.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 <= o2){return o1;}
				return o2;
			}
		});

		return levelIDs;
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
			highestLevelID++;
			/** TODO Add these Lines when PuzzleLevel implemented
			 * PuzzleLevel pl = new PuzzleLevel();
			 * buildingLevel = pl;
			 * bv.setModelLevel(pl);
			 */
			bv.prepPuzzle();
			break;
		case "Lightning":
			highestLevelID++;
			/** TODO Add these lines when LightningLevel implemented
			 * LightningLevel ll = new LightningLevel();
			 * buildingLevel = ll;
			 * bv.setModelLevel(ll);
			 */
			bv.prepLightning();
			break;
		case "Release":
			highestLevelID++;
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
	
	
	void initializeLevelView(){
		//TODO Initialize BuilderView in here
	}

	void initializeLevelControllers(){
		//TODO Initialize BuilderView Controllers in here
		//		builderView.setVisible(true); to make builderview appear
	}


}
