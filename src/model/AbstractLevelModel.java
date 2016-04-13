package model;

import java.io.File;

/**
 * An AbstractLevelModel class determines what kind of information all three types of 
 * levels should store inside of them and the kinds of functionality they should have.
 * @author Dylan
 */
public abstract class AbstractLevelModel {
	
	/**The ID of a level is a unique integer of value 1+ and corresponds to the file name**/
	final int levelID;
	
	/**LevelType is a string telling the model what type this level is. It avoids instanceOf checks!**/
	final String levelType;
	
	/**The starsEarned for a level is an integer 0-3, tracking the progress thus far on an attempt at this level**/
	int starsEarned;
	
	/**The most amount of stars a player has earned for this level - the value read in from file**/
	int maxStarsEarned;
	
	/**isLocked is a boolean value telling the model that this level is not yet available to be played**/
	boolean isLocked;
	
	/**CanMovePiece is a boolean value telling the level if pieces can be moved on the board or not**/
	final boolean canMovePiece;
	
	/**The Bullpen that is associated with this level**/
	//TODO Add Attribute: Bullpen bullpen;
	
	/**The Board that is associated with this level**/
	//TODO Add Attribute: Board board;

	/**
	 * You CANNOT instantiate an AbstractLevelModel. This constructor is here so you can super() set the 
	 * final fields within the subclasses. Otherwise, these fields would have a hard time being set AND
	 * being final!
	 **/
	AbstractLevelModel(int levelID, String levelType, boolean canMovePiece){
		this.levelID = levelID;
		this.levelType = levelType;
		this.canMovePiece = canMovePiece;	
	}
	
	/**
	 * updateProgress occurs after every move is made. This updates the current state of play in the level, such as
	 * the movesMade, how many tiles have been covered, etc. Because of this, updateProgress can also trigger 
	 * saveProgressToFile() when a star threshold has been earned. 
	 */
	abstract void updateProgress();
	
	/**
	 * isComplete() returns a boolean describing if the player has finished the level or not. 
	 * It's a matter of are they out of moves/pieces/time OR did they earn 3 stars.**/
	abstract boolean isComplete();

	/**
	 * Returns the ID of the level
	 * @return levelID - Integer
	 */
	public int getID(){
		return levelID;
	}
	
	/**
	 * Returns the type of the level
	 * @return levelType - String version of level: Puzzle, Release, or Lightning
	 */
	public String getType(){
		return levelType;
	}
	
	/**
	 * saveProgressInFile is used in the Player side of Kabasuji. If the player earns a star, that progress
	 * must be saved. This method does that.**/
	abstract boolean saveProgressInFile();
	
	/**
	 * saveLevelToFile is used in the Builder side of Kabasuji. When the builder saves the level being built
	 * this method saves the state of the entire level and overwrites any existing level. (Aka: Don't use append mode!)**/
	abstract boolean saveLevelToFile();
	
	 //TODO Set maxStarsEarned
	 //TODO Read in the board and bullpen, store it here.
	  
	
	
}


