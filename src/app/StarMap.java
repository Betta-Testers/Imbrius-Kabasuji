package app;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeMap;

/**
 * StarMap is the functionality of two TreeMaps merged into one, where one TreeMap holds a higher importance over the other.
 * One TreeMap associates a Key to a Value, while the other TreeMap associates the same set of Keys to different values.
 * The second TreeMap, however, cannot add a Key,Value pair unless the first map has the key.
 * 
 * @author Dylan
 *
 * @param <K> Generic Key
 * @param <V> Generic Value
 */
public class StarMap<K, V> implements Serializable{
	/**This class is saved to disk to store the max number of stars earned for a level**/
	private static final long serialVersionUID = 7576231489845563260L;
	
	/**TreeMap that stores the ID of a level (Key) with the maximum stars earned for that level (Value)**/
	TreeMap<K, K> stars = new TreeMap<K, K>();
	
	/**TreeMap stores levelID with levelType**/
	TreeMap<K, V> levelData = new TreeMap<K, V>();
	
	StarMap(){}
	
	/**
	 * Put method for adding levelData. Stores the Key, Value pair in a TreeMap
	 * Also initializes the key in the stars TreeMap, to prevent null pointer
	 * exceptions when trying to access a maxStarsEarned amount that hasn't been set
	 * yet
	 * @param key - should be levelID
	 * @param value - should be levelType
	 */
	public void put(K key, V value){
		levelData.put(key, value);
		stars.put(key, null);
	}
		
	/**
	 * Get the type associated with the levelID
	 * Returns null if the key does not have a value associated with it
	 * Throws a null pointer exception if the key does not exist in the map
	 * @param key
	 * @return value associated with key - the level type
	 */
	public V get(K key){
		return levelData.get(key);
	}
	
	/**
	 * Sets the stars of the given Key, if that key is registered in the levelData map
	 * @param key - should be LevelID
	 * @param starsEarned - should be maximum number of stars earned
	 * @return true if the stars could be stored, false if level did not exist
	 */
	public boolean setMaxStars(K key, K starsEarned){
		if(levelData.containsKey(key)){
			stars.put(key, starsEarned);
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
	public K getMaxStars(K key){
		return stars.get(key);
	}
	
	/**
	 * Returns an iterator of keys in the StarMap
	 * @return Iterator of keys in levelData
	 */
	public Set<K> keySet(){
		return levelData.keySet();
	}

	/**
	 * Returns the last key in the tree - the highest value key.
	 * @return Highest valued Key
	 */
	public K lastKey(){
		return levelData.lastKey();
	}
	
	/**
	 * Tells whether the levelData is empty or not
	 * @return true if levelData is empty
	 */
	public boolean isEmpty(){
		return levelData.isEmpty();
	}
	
	
	
	

}
