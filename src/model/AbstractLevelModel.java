package model;

import java.io.File;

/** An AbstractLevelModel class determines what kind of information all three types of 
 * levels should store inside of them and the kinds of functionality they should have.
 * @author Dylan
 */
public abstract class AbstractLevelModel {
	
	/**The ID of a level is a unique integer of value 1+ and corresponds to the file name**/
	final int levelID;
	
	/**LevelType is a string telling the model what type this level is. It avoids instanceOf checks!**/
	final String levelType;
	
	/**The starsEarned for a level is an integer 0-3, tracking the best progress thus far on that level**/
	int starsEarned;
	
	/**isLocked is a boolean value telling the model that this level is not yet available to be played**/
	boolean isLocked;
	
	/**CanMovePiece is a boolean value telling the level if pieces can be moved on the board or not**/
	final boolean canMovePiece;
	
	/**sourceFile is the file on disk associated with THIS level. If execution has reached this phase, this file
	 * ALWAYS exists - builder or player. Why? Because the Game class is in charge of loading the levels at launch
	 * and the Builder class is will create a placeholder file for the level if it's creating a new level!
	 * TODO Verify if this is the 
	 **/
	final File sourceFile;

	/**You CANNOT instantiate an AbstractLevelModel. This constructor is here so you can super() set the 
	 * final fields within the subclasses. Otherwise, these fields would have a hard time being set AND
	 * being final!
	 **/
	AbstractLevelModel(File sourceFile, int levelID, String levelType, boolean canMovePiece){
		this.sourceFile = sourceFile;
		this.levelID = levelID;
		this.levelType = levelType;
		this.canMovePiece = canMovePiece;	
	}
	
	/**isComplete is the method capable of telling anyone who asks if the current level is done or not.
	 * That means specifying if the player has FAILED the level. A followUp method, hasWon() extends this
	 * functionality.
	 */
	abstract boolean isComplete();
	
	/**hasWon tells the requester if the level was WON (true) or LOST (false). This is different from
	 * isComplete(), because isComplete() does not specify how the level ended, only IF it has eneded.**/
	abstract boolean hasWon();
	
	/**saveProgressInFile is used in the Player side of Kabasuji. If the player earns a star, that progress
	 * must be saved. This method does that.**/
	abstract boolean saveProgressInFile();
	
	/**saveLevelToFile is used in the Builder side of Kabasuji. When the builder saves the level being built
	 * this method saves the state of the entire level and overwrites any existing level. (Aka: Don't use append mode!)**/
	abstract boolean saveLevelToFile();
	
	/*TODO might be worth returning a boolean, so that if the file is being used for editing,
	 *a boolean can be set and methods can react properly.
	 */
	/**loadLevel is a helper method for each subclasses' constructor to read in the current state of a level. This method
	 * has to handle reading in an empty file (Aka: making a new level in the Builder)**/
	abstract void loadLevel();
	
	
}


