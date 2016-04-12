package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
	File sourceFile;

	/**You CANNOT instantiate an AbstractLevelModel. This constructor is here so you can super() set the 
	 * final fields within the subclasses. Otherwise, these fields would have a hard time being set AND
	 * being final!
	 **/
	AbstractLevelModel(int levelID, String levelType, boolean canMovePiece){
		this.levelID = levelID;
		this.levelType = levelType;
		this.canMovePiece = canMovePiece;
	}
	
	abstract boolean isComplete();
	
	//Player Save Method - Boolean is to tell if file could not be opened
	abstract boolean saveProgressInFile();
	
	//Builder Save Method - Boolean is to tell if file could not be opened
	//When editing, overwrite old file.
	abstract boolean saveLevelToFile();
	
	/**
	 * Method capable of opening the given file and reading it line by
	 * line through a buffer, after which closing the file. Use this method
	 * to read in a level and set the properties of it.
	 * @param FileName
	 */
	public void loadLevel(String fileName){
		try{
			FileReader levelFile = new FileReader(fileName);
			BufferedReader br = new BufferedReader(levelFile);
			String strLine;
			while ((strLine = br.readLine()) != null)   {
				//Read the file LINE by LINE and do something with each line
				strLine.length(); //Do something with strLine...
			}
			//End Of File Reached, Close the file
			levelFile.close();
		}catch (IOException e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
}


