package app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import model.AbstractLevelModel;

/**
 * Super class for holding methods relevant to both builder and game reguarding the StarMap coordination.
 * @author dfontana
 */
public abstract class LevelIO {
	/**Directory specified in main for storing and loading files**/
	String defaultDirectory;

	/**A sorted Mapping of all EXISTING levels ON DISK by ID, Type**/
	StarMap levelData;

	public LevelIO(String directory) {
		this.defaultDirectory = directory;
	}

	/**
	 * Returns a StarMap object read from disk. 
	 * If the StarMap does not EXIST for any reason, a blank starmap is generated
	 * If the StarMap cannot be READ for any reason, a RuntimeException is thrown
	 * @return StarMap
	 * @throws RuntimeException if a StarMap couldn't be loaded from disk
	 */
	public StarMap loadStarMap(){
		ObjectInputStream ois = null;
		StarMap m = null;

		String location = defaultDirectory+"StarMap.storage";

		try {
			FileInputStream infile = new FileInputStream(location);
			ois = new ObjectInputStream(infile);
			m = (StarMap) ois.readObject();
		}catch (FileNotFoundException e){
			System.err.println("StarMap.storage DNE. Making new StarMap");
			m = new StarMap(defaultDirectory);
			m.populateFromDirectory();
		}catch (Exception e){
			e.printStackTrace();
			throw new RuntimeException("LevelIO couldn't load StarMap @"+location+". Check permissions");
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
	 * @return AbstractLevelModel that was loaded from disk
	 */
	public AbstractLevelModel loadLevel(int levelID) throws Exception{
		ObjectInputStream ois = null;
		AbstractLevelModel m = null;

		String type;
		try{
			type = levelData.get(levelID);
		}catch(Exception e){
			throw new Exception("LevelData doesn't have the ID: "+levelID);
		}
		String location = defaultDirectory+levelID+"_"+type+".storage";

		try {
			ois = new ObjectInputStream (new FileInputStream(location));
			m = (AbstractLevelModel) ois.readObject();
			ois.close();
		} catch (Exception e) { 
			throw new Exception("Could not load levelID "+levelID+" from disk @ "+location+". Bad permissions or Level not on disk.");
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
	 * @return boolean - true if star count was updated for that level. False if not.
	 */
	public boolean updateStars(int levelID, int starsEarned){
		try {
			if(starsEarned > levelData.getMaxStars(levelID)){
				return levelData.setMaxStars(levelID, starsEarned);
			}
		} catch (Exception e) {
			System.err.println("Call to UpdateStars: LevelID "+levelID+" Does not exist");
		}
		return false;
	}
}
