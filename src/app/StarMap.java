package app;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;

/**
 * StarMap is the functionality of two TreeMaps merged into one, where one TreeMap holds a higher importance over the other.
 * One TreeMap associates a Key to a Value, while the other TreeMap associates the same set of Keys to different values.
 * The second TreeMap, however, cannot add a Key,Value pair unless the first map has the key.
 * 
 * @author Dylan
 */
public class StarMap implements Serializable{
	/**This class is saved to disk to store the max number of stars earned for a level**/
	private static final long serialVersionUID = 7576231489845563260L;

	/**TreeMap that stores the ID of a level (Key) with the maximum stars earned for that level (Value)**/
	TreeMap<Integer, Integer> stars = new TreeMap<Integer, Integer>();

	/**TreeMap stores levelID with levelType**/
	TreeMap<Integer, String> levelData = new TreeMap<Integer, String>();

	/**Path to Directory assigned in the constructor to save the StarMap serialization**/
	final String directory;

	StarMap(String directory){
		this.directory = directory;
	}

	/**
	 * A new StarMap is made if the map can't be deserialized in an attempt to continue play. The only
	 * information lost in such an event is the player's earned stars progress. The rest of the map
	 * is populated with levelIDs found and their types.
	 */
	void populateFromDirectory(){
		/**Creates the directory if it DNE. Return at this point, since
		 * nothing would be in an empty directory
		 */
		if(new File(directory).mkdirs()){return;}

		File[] folder = (new File(directory)).listFiles();
		String levelNum;
		String levelType;

		for (File f: folder) {
			if(f.getName().equals("StarMap.storage")){ continue;}

			int levelID;
			try{
				levelNum = f.getName().substring(0, f.getName().lastIndexOf("_"));
				levelType = f.getName().substring(f.getName().lastIndexOf("_")+1, f.getName().lastIndexOf("."));
				levelID = Integer.parseInt(levelNum);
				this.put(levelID, levelType);
				this.setMaxStars(levelID, 0);
			}catch(NumberFormatException e){
				System.err.println("Trash in directory, skipping...");
				continue;
			}catch(StringIndexOutOfBoundsException e1){
				System.err.println("Trash in directory, skipping...");
				continue;
			}
		}
	}

	//========================== LEVEL ID METHODS =============================
	/**
	 * Put method for adding levelData. Stores the Key, Value pair in a TreeMap
	 * Also initializes the key in the stars TreeMap, to prevent null pointer
	 * exceptions when trying to access a maxStarsEarned amount that hasn't been set
	 * yet.
	 * 
	 * This will force the StarMap to save itself to disk if a new key is added
	 * @param key - should be levelID, greater than 0 or else it can't be placed
	 * @param value - should be levelType, if not can't be placed
	 * @return boolean -true if the level was added, false if not
	 */
	public boolean put(Integer key, String value){
		if(levelData.containsKey(key) || key <= 0){ return false;}
		if(!value.equals("Puzzle") && !value.equals("Release") && !value.equals("Lightning")){ return false;}
		
		levelData.put(key, value);
		stars.put(key, 0);
		save();
		return true;	
	}

	/**
	 * Get the type associated with the levelID
	 * Returns null if the key does not have a value associated with it
	 * If the gotten key DNE, instead of letting the get method return null
	 * (since it is returning a data type that support null), a null pointer
	 * exception is throw instead. This allows consistency with the getMaxStars()
	 * method. 
	 * @param key
	 * @return value associated with key - the level type
	 * @throws exception if key is not in levelData
	 */
	public String get(Integer key) throws Exception{
		if(!levelData.containsKey(key)){
			throw new Exception("Key does not exist in StarMap");
		}
		return levelData.get(key);
	}

	/**
	 * Deletes the given ID from disk (if it exists) and removes it from the starMap 
	 * (if it exists). The starMap is then saved. NOTE if the file could not be deleted
	 * then the level will remain in the starmap.
	 * @param levelID - int value of the level you want to delete
	 * @return boolean - true if the level was deleted successfully.
	 */
	public boolean deleteFromDisk(Integer levelID){
		if(!levelData.containsKey(levelID)){return false;}
		String filename = levelID+"_"+levelData.get(levelID)+".storage";
		String location = directory+filename;
		if((new File(location)).delete()){
			levelData.remove(levelID);
			stars.remove(levelID);
			this.save();
			return true;
		}
		return false;
		
	}
	//========================== MAX STAR METHODS =============================
	/**
	 * Sets the stars of the given Key, if that key is registered in the levelData map
	 * If the star was stored, StarMap writes itself to disk. This method checks the
	 * parameters for validity: stars earned between 0-3 inclusive. Note: Key does not
	 * need to be verified as greater than 0 because the key is already verified when
	 * put() is called and this method won't set a starCount for a key that isn't 
	 * already put() into the levelData.
	 * @param key - should be LevelID
	 * @param starsEarned - should be maximum number of stars earned
	 * @return true if the stars could be stored,false if level did not exist
	 */
	public boolean setMaxStars(Integer key, Integer starsEarned){
		if(levelData.containsKey(key) && starsEarned >= 0 && starsEarned < 4){
			stars.put(key, starsEarned);
			save();
			return true;
		}	
		return false;
	}

	/**
	 * Get the maximumStarsEarned associated with the levelID
	 * Returns null if the key does not have a value associated with it
	 * Throws a null pointer exception if the key does not exist in the map
	 * @param key
	 * @return value associated with key - the maxStarsEarned or null if the levelID does not have a value associated with it
	 */
	public Integer getMaxStars(Integer key) throws Exception{
		if(!levelData.containsKey(key)){
			throw new Exception("Key does not exist in StarMap");
		}
		return stars.get(key);
	}

	//========================== Iterator METHODS =============================
	/**
	 * Returns a set of keys in the StarMap
	 * @return set of keys in levelData
	 */
	public ArrayList<Integer> keySet(){
		return new ArrayList<Integer>(levelData.keySet()); 
	}

	/**
	 * Unlocked Levels returns a set over the levelIDs that counts as unlocked
	 * This fact is computed by checking the stars earned for a levelID inside the stars
	 * treemap. If the levelID has a value associated with it that is greater than 0, it
	 * counts as unlocked.
	 * @return set of integers - levelIDs
	 */
	public ArrayList<Integer> unlockedLevels(){

		ArrayList<Integer> keyList = new ArrayList<Integer>(levelData.keySet()); 
		Set<Integer> keys = levelData.keySet();
		for(Integer key: keys){
			if(key != 1 && stars.get(key) == 0){ keyList.remove(key);}
		}
		return keyList;
	}

	//========================== INFORMATION METHODS ==========================
	/**
	 * Returns the last key in the tree - the highest value key.
	 * If the map is empty, this method returns 0, as the 0th slot
	 * is burned
	 * @return Highest valued Key
	 */
	public Integer lastID(){
		try{
			return levelData.lastKey();
		}catch(NoSuchElementException e){
			return 0;
		}
	}

	/**
	 * Returns the next open ID (null position in tree) for level generation. If the map is empty,
	 * this method returns 1 since the first slot in the tree is burned (0)
	 * @return levelID that is free
	 */
	public Integer nextOpenID(){
		try{
			Iterator<Integer> keys = this.keySet().iterator();
			int i=1;
			for(;i<=levelData.lastKey(); i++){
				if(keys.next() != (Integer)i){
					return i;
				}
			}
			return i;
		}catch(NoSuchElementException e){
			return 1;
		}
	}

	/**
	 * Returns the lowest ID that does not have a non-zero star amount. If the map is empty,
	 * this method returns 1.
	 * @return levelID lowestID with no stars
	 */
	public Integer lowestNoStarLevel(){	
		for(int i = 1; i<=stars.size(); i++){
			if(stars.get(i) == 0){
				return i;
			}
		}
		return 1;
	}

	/**
	 * Tells whether the levelData is empty or not
	 * @return true if levelData is empty
	 */
	public boolean isEmpty(){
		return levelData.isEmpty();
	}

	/**
	 * Determines if the key is within the data structure.
	 * Returns true if so. False if not.
	 * @param key - ID being looked for
	 * @return true if key is within LevelData
	 */
	public boolean containsKey(int key) {
		return levelData.containsKey(key);
	}

	//========================== TO STRING METHODS ============================
	/**
	 * Returns the toString of just the LevelData keys
	 * Allows ability to see what levels are within level data, without extra info
	 * @return toString of ArrayList -> keySet().
	 */
	public String keyToString(){
		return this.keySet().toString();
	}

	/**
	 * Returns the to string of the StarMap
	 * Format: [ID,Type,Stars],[ID,Type,Stars], ...
	 * If starMap is empty, returns empty string ""
	 * @return string representation of StarMap
	 */
	public String toString(){
		StringBuilder s = new StringBuilder();
		for(int k: this.keySet()){
			s.append("["+k+","+levelData.get(k)+","+stars.get(k)+"],");			
		}
		if(s.length() > 0){ s.deleteCharAt(s.length()-1);}

		return s.toString();
	}

	//========================== Reading and Saving METHODS ===================
	/**
	 * When a StarMap is deserialized, it needs to synchronize with the levels
	 * available in the directory (in case an outside user deleted a level file).
	 * To account for this, the StarMap loads all LevelIDs from the directory and compares
	 * against its keyset. If the keyset contains an integer NOT in the directory, the key
	 * is deleted;
	 */
	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException{
		in.defaultReadObject();

		File[] folder = (new File(directory)).listFiles();
		ArrayList<Integer> keys = new ArrayList<Integer>();
		String levelNum;

		for (File f: folder) {
			if(f.getName().equals("StarMap.storage")){ continue;}

			int levelID;
			try{
				levelNum = f.getName().substring(0, f.getName().lastIndexOf("_"));
				levelID = Integer.parseInt(levelNum);
				keys.add(levelID);
			}catch(StringIndexOutOfBoundsException e1){
				System.err.println("Trash file in: "+directory);
				continue;
			}catch(NumberFormatException e){
				System.err.println("Trash file in: "+directory);
				continue;
			}
		}

		for(Iterator<Entry<Integer, String>> it = levelData.entrySet().iterator(); it.hasNext(); ) {
			Entry<Integer, String> entry = it.next();
			if(!keys.contains(entry.getKey())) {
				it.remove();
				stars.remove(entry.getKey());
			}
		}
	}

	/**
	 * Stores a StarMap to disk. If the starmap cannot be saved, an error is
	 * printed to the console. Because a starMap saves itself on change, this method
	 * does not need to be called outside of this class
	 * @throws IOException if the file could not be saved
	 */
	void save(){
		ObjectOutputStream oos = null;
		String location = directory+"StarMap.storage";

		try {
			oos = new ObjectOutputStream(new FileOutputStream(location));
			oos.writeObject(this);
		} catch (Exception e) {
			throw new RuntimeException("StarMap could not be saved to disk. Check permissions @"+location+"\n"+e.getMessage());
		}

		if (oos != null) {
			try { oos.close(); } catch (IOException ioe) { } 
		}
	}

}
