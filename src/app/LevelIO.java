package app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.AbstractLevelModel;

public abstract class LevelIO {
	/**Directory specified in main for storing and loading files**/
	final String defaultDirectory = "./imbriusLevelFiles/";

	/**A sorted Mapping of all EXISTING levels ON DISK by ID, Type**/
	StarMap levelData;

	/**The current level being manipulated*/
	AbstractLevelModel currentLevel;

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
			ois = new ObjectInputStream (new FileInputStream(location));
			m = (StarMap) ois.readObject();
			ois.close();
		}catch (Exception e){
			System.err.println("StarMap file not readable, creating new StarMap...");
			m = new StarMap();
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
			e.printStackTrace();
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


}
