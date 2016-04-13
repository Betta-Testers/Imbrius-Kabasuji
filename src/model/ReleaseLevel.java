package model;

import java.util.ArrayList;

/** 
 * An AbstractLevelModel class determines what kind of information all three types of 
 * levels should store inside of them and the kinds of functionality they should have.
 * @author Dylan
 */
public class ReleaseLevel extends AbstractLevelModel{
	/**Serialized ID used for writing to disk**/
	private static final long serialVersionUID = -1980934631273821149L;
	
	//TODO Verify there will only be 6 of any color on board
	ArrayList<Integer> reds = new ArrayList<Integer>();
	ArrayList<Integer> yellows = new ArrayList<Integer>();
	ArrayList<Integer> blues = new ArrayList<Integer>();
	
	//TODO Verify these parameters are needed
	int totalReds;
	int totalYellows;
	int totalBlues;

	public ReleaseLevel(int levelID) {
		super(levelID, "Release", false);
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean saveProgressInFile() {
		if(starsEarned > maxStarsEarned){
			//save starsEarned instead of maxStarsEarned
		}
		return false;
	}

	@Override
	boolean saveLevelToFile() {
		
		
		return false;
	}

	/** 
	 * A level is complete if the total number of stars earned is 3, meaning there are no more moves to be made, the player
	 * has achieved the most they can.
	 * 
	 * OR
	 * 
	 * The player is out of pieces to move in the bullpen. This means in order to check this, the level needs to ask the bullpen
	 * if it is empty or not.
	 */
	@Override
	boolean isComplete() {
		if(starsEarned == 3){ //TODO Add this when bullpen class exists: || bullpen.empty()){
			return true;
		}
		
		return false;
	}

	/**
	 * updateProgress occurs after every move is made. This updates the stars earned for the current level if 
	 * a set has been released. Each set is checked in a seperate statement as a way to ensure that if more
	 * that one set was released at a time, the number of stars earned is updated correctly. 
	 * 
	 * After all checks are made, the level is saved if the current playthrough has earned more stars than 
	 * the number tracked on file.
	 */
	@Override
	void updateProgress() {
		if(reds.size() == totalReds){
			starsEarned++;
		}
		
		if(blues.size() == totalBlues){
			starsEarned++;
		}
		
		if(yellows.size() == totalYellows){
			starsEarned++;
		}
	}
	
	/**
	 * Appends the number released to the ArrayList tracking the red integers released. 
	 * To check if all numbers of a type were released, look at the size of the array list
	 * against the total number of that colored number
	 * @param releasedNum Is the number that was released
	 */
	public void addToRedReleased(int releasedNum){
		this.reds.add(releasedNum);
	}
	
	/**
	 * Appends the number released to the ArrayList tracking the blue integers released. 
	 * To check if all numbers of a type were released, look at the size of the array list
	 * against the total number of that colored number
	 * @param releasedNum Is the number that was released
	 */
	public void addToBlueReleased(int releasedNum){
		this.blues.add(releasedNum);
	}
	
	/**
	 * Appends the number released to the ArrayList tracking the yellow integers released. 
	 * To check if all numbers of a type were released, look at the size of the array list
	 * against the total number of that colored number
	 * @param releasedNum Is the number that was released
	 */
	public void addToYellowReleased(int releasedNum){
		this.yellows.add(releasedNum);
	}

}
