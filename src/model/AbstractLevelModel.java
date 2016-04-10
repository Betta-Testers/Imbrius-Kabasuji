package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/** THIS IS A PLACEHOLDER CLASS FOR THE TIME BEING
 * DO NO POPULATE!!
 * @author Dylan
 *
 */
public class AbstractLevelModel {
	
	AbstractLevelModel(){
		
	}

	/**
	 * Method capable of openeing the given file and reading it line by
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


