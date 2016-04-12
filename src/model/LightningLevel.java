package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/** An AbstractLevelModel class determines what kind of information all three types of 
 * levels should store inside of them and the kinds of functionality they should have.
 * @author Dylan
 */
public class LightningLevel extends AbstractLevelModel{
	int totalTime;
	int timeLeft;
	int unmarkedTiles;
	int piecesToGen;

	LightningLevel(File sourceFile, int levelID) {
		super(sourceFile, levelID, "Lightning", false);
		// TODO Auto-generated constructor stub
	}

	/**LoadLevel is a helper method to the constructor. On instantiation, it will attempt to
	 * read any data about the level it can in. If nothing is found inside the file, then no 
	 * fields are set and it's apparent the level is being CREATED in the BUILDER. Setters will 
	 * handle the rest from here out in that case.
	 * 
	 * If the file can't be opened, the error is caught here. 
	 * 
	 * Method for reading: line by line through a buffer. File is closed at end of reading.
	 */
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
	

	/** A level is complete if the total number of stars earned is 3, meaning there are no more moves to be made, the player
	 * has achieved the most they can.
	 * 
	 * OR
	 * 
	 * The player is out of time. 
	 */
	@Override
	boolean isComplete() {
		if(starsEarned == 3 || timeLeft == 0){
			return true;
		}
		
		return false;
	}

	/**updateProgress occurs after every move is made. This updates the stars earned for the current level if
	 * the number of marked tiles is equal to the thresholds. The starsEarned is set rather than incremented
	 * to prevent duplicate triggers of the same threshold. (Ie place a piece that marks all but 12 tiles and
	 * the place another piece that marks all but 8 tiles. That would increment twice - not wanted).
	 * 
	 * After all checks are made, the level is saved if the current play through has earned more stars than 
	 * the number tracked on file.
	 */
	@Override
	void updateProgress() {
		if(unmarkedTiles <= 12 && unmarkedTiles > 6){
			starsEarned = 1;
		}
		
		if(unmarkedTiles <= 6 && unmarkedTiles > 0){
			starsEarned = 2;
		}
		
		if(unmarkedTiles == 0){
			starsEarned = 3;
		}
		
		if(starsEarned > maxStarsEarned){
			saveProgressInFile();
		}
	}
	
	/**
	 * Decreases the number of unmarked tiles. This works towards the level termination
	 * condition of marking an entire board.
	 * @param numMarked The number of tiles marked. Since pieces can overlap, this number won't
	 * always be 6.
	 */
	public void decrementUnmarked(int numMarked){
		unmarkedTiles -= numMarked;
	}
}
