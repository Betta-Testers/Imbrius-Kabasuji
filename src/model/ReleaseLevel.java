package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReleaseLevel extends AbstractLevelModel{

	ReleaseLevel(File sourceFile, int levelID) {
		super(sourceFile ,levelID, "Release", false);
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
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
	
	/**LoadLevel is a helper method to the constructor. On instantiation, it will attempt to
	 * read any data about the level it can in. If nothing is found inside the file, then no 
	 * fields are set and it's apparent the level is being CREATED in the BUILDER. Setters will 
	 * handle the rest from here out in that case.
	 * 
	 * If the file can't be opened, the error is caught here. 
	 * 
	 * Method for reading: line by line through a buffer. File is closed at end of reading.
	 *TODO might be worth returning a boolean, so that if the file is being used for editing,
	 *a boolean can be set and methods can react properly.
	 */
	void loadLevel(){
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
	}

}
