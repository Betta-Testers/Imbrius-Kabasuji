package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/** 
 * A PuzzleLevel is the model class backing to the puzzle gamemode. Information
 * relevant to the puzzle mode is stored here.
 * 
 * The attributes tracking End Conditions: 
 * 		moveLimit -> The maximum allowed moves for the level
 * 		movesMade -> The current number of moves made
 * 		tilesLeft -> The number of tiles left to be covered in the level
 * 
 * @author Dylan
 */
public class PuzzleLevel extends AbstractLevelModel{
	/**The moveLimit is the maximum number of moves THIS level allows to be made**/
	int moveLimit;
	
	/**The movesMade is the number of moves a player has made on THIS level**/
	int movesMade;
	
	/**The tilesLeft is the number of tiles left for the player to cover on THIS level**/
	int tilesLeft;

	PuzzleLevel(File sourceFile, int levelID) {
		super(sourceFile, levelID, "Puzzle", true);
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * LoadLevel is a helper method to the constructor. On instantiation, it will attempt to
	 * read any data about the level it can in. If nothing is found inside the file, then no 
	 * fields are set and it's apparent the level is being CREATED in the BUILDER. Setters will 
	 * handle the rest from here out in that case.
	 * 
	 * If the file can't be opened, the error is caught here. 
	 * 
	 * Method for reading: line by line through a buffer. File is closed at end of reading.
	 */
	@Override
	boolean loadLevel(){
		try{
			FileReader fileReader = new FileReader(sourceFile);
			BufferedReader br = new BufferedReader(fileReader);
			String strLine;
			while ((strLine = br.readLine()) != null)   {
				//Read the file LINE by LINE and do something with each line
				strLine.length(); //Do something with strLine...
			}
			//End Of File Reached, Close the file
			fileReader.close();
		}catch (IOException e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		return true; //TODO replace this
	}

	@Override
	boolean saveProgressInFile() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean saveLevelToFile() {
		// TODO Auto-generated method stub
		return false;
	}

	/** 
	 * A level is complete if the total number of stars earned is 3, meaning there are no more moves to be made, the player
	 * has achieved the most they can.
	 * 
	 * OR
	 * 
	 * The player is out of moves. 
	 */
	@Override
	boolean isComplete() {
		if(starsEarned == 3 || (moveLimit-movesMade) == 0){
			return true;
		}
		
		return false;
	}

	/**
	 * updateProgress occurs after every move is made. This updates the stars earned for the current level if
	 * the number of tiles left uncovered on the board is remaining is 0/6/12. The starsEarned is set rather than incremented
	 * to prevent duplicate triggers of the same threshold (Since you can moves a piece off a board and back onto it).
	 * 
	 * This also means it is possible to lower a player's current star count due to moving a piece off the board, reducing the
	 * number of tiles covered.
	 * 
	 * After all checks are made, the level is saved if the current play through has earned more stars than 
	 * the number tracked on file.
	 */
	@Override
	void updateProgress() {
		
		switch(tilesLeft){
			case(12):
				starsEarned = 1;
				break;
			case(6):
				starsEarned = 2;
				break;
			case(0):
				starsEarned = 3;
				break;
			default:
				starsEarned = 0;
		}
		
		//TODO This line is now in the wrong place. If a player drops their total stars earned during play, but exceeded their best at one point, this would be an
		//in accurate reflection of their actual performance
		if(starsEarned > maxStarsEarned){
			saveProgressInFile();
		}
	}
	
	/**
	 * AdjustTileCount takes in a delta and offsets the tilesLeft to be converted on the board
	 * by that amount. The ultimate goal is to get the tilesLeft value to 0.
	 * @param delta A positive or negative integer representing the number of tiles a piece is replacing the board
	 * This value is *anticipated* to always be +- 6
	 */
	public void adjustTileCount(int delta){
		tilesLeft += delta;
	}
	
	/**
	 * incrementMovesMade is called whenever a move is performed in a puzzle level. This includes bullpen to board,
	 * board to board, or off the board. It always increments by 1.
	 */
	public void incrementMovesMade(){
		movesMade++;
	}
}
