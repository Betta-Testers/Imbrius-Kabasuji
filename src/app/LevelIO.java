package app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import model.AbstractLevelModel;

public abstract class LevelIO {
	/**Directory specified in main for storing and loading files**/
	String defaultDirectory;

	/**A sorted Mapping of all EXISTING levels ON DISK by ID, Type**/
	StarMap levelData;

	/**The current level being manipulated*/
	AbstractLevelModel currentLevel;

	public LevelIO(String directory) {
		this.defaultDirectory = directory;
	}

	/**
	 * Returns a StarMap object read from disk. If the StarMap cannot be read
	 * for any reason, a blank starmap is generated
	 * @return StarMap
	 */
	public StarMap loadStarMap(){
		ObjectInputStream ois = null;
		StarMap m = null;

		String location = defaultDirectory+"StarMap.storage";

		try {
			FileInputStream infile = new FileInputStream(location);
			ois = new ObjectInputStream(infile);
			m = (StarMap) ois.readObject();
			ois.close();
		}catch (FileNotFoundException e){
			System.err.println("StarMap.storage DNE. Making new StarMap");
			m = new StarMap(defaultDirectory);
			m.populateFromDirectory();
		}catch (Exception e){
			e.printStackTrace();
			throw new RuntimeException("LevelIO couldn't load StarMap @"+location);
		}

		if (ois != null) { 
			try { ois.close(); } catch (IOException ioe) { }
		}
		return m;
	}

	/**
	 * Given a levelID, the method looks up the associated levelType from the LevelData tree.
	 * Using this information it generates the path to the file, determines the correct type of level
	 * to create, and returns that object.
	 * @param levelID - ID of the level being opened
	 */
	public AbstractLevelModel loadLevel(int levelID){
		ObjectInputStream ois = null;
		AbstractLevelModel m = null;

		if(!levelData.containsKey(levelID)){ return null;}

		String type = levelData.get(levelID);
		String location = defaultDirectory+levelID+"_"+type+".storage";

		try {
			ois = new ObjectInputStream (new FileInputStream(location));
			m = (AbstractLevelModel) ois.readObject();
			ois.close();
		} catch (Exception e) { 
			e.printStackTrace();
			System.err.println("Unable to load state from:" + location);
			m = null;
		}

		if (ois != null) { 
			try { ois.close(); } catch (IOException ioe) { }
		}
		return m;
	}
	
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

	
//================== TESTING METHODS (FOR NOW) ================== 
	public AbstractLevelModel getCurrentLevel(){
		return currentLevel;
	}
	
	public StarMap getLevelData(){
		return levelData;
	}
	
	public LevelIO getLevelIO(){
		return this;
	}
}
