package model;

import java.io.Serializable;

/**
 * An AbstractLevelModel class determines what kind of information all three types of 
 * levels should store inside of them and the kinds of functionality they should have.
 * @author Dylan
 */
public abstract class AbstractLevelModel implements Serializable{

	/**While an this class should NEVER be serialized, this is needed to serialize subclasses**/
	private static final long serialVersionUID = -5159764997744131193L;

	/**The ID of a level is a unique integer of value 1+ and corresponds to the file name**/
	final int levelID;

	/**LevelType is a string telling the model what type this level is. It avoids instanceOf checks!**/
	final String levelType;

	/**The starsEarned for a level is an integer 0-3, tracking the progress thus far on an attempt at this level**/
	int starsEarned;

	/**CanMovePiece is a boolean value telling the level if pieces can be moved on the board or not**/
	final boolean canMovePiece;

	/**The Bullpen that is associated with this level**/
	Bullpen bullpen;

	/**The Board that is associated with this level**/
	Board board;

	/**
	 * You CANNOT instantiate an AbstractLevelModel. This constructor is here so you can super() set the 
	 * final fields within the subclasses. Otherwise, these fields would have a hard time being set AND
	 * being final!
	 * @author Dylan
	 **/
	AbstractLevelModel(int levelID, String levelType, boolean canMovePiece){
		this.levelID = levelID;
		this.levelType = levelType;
		this.canMovePiece = canMovePiece;	
	}

	/**
	 * Check status occurs after every move is made. This updates the current state of play in the level, such as
	 * the movesMade, how many tiles have been covered, etc. It returns a boolean indicating if the level is finished
	 * (true) or false if the level has not hit the end of play
	 * @author Dylan
	 */
	public abstract boolean checkStatus();


	//============================== SETTERS ==================================
	/**
	 * sets the board associated with this level to the one passed in
	 * @author Dylan
	 * @param board
	 */
	public void setBoard(Board board){
		this.board = board;
	}
	/**
	 * Sets the bullpen associated with this level to the one passed in
	 * @author Dylan
	 * @param bullpen
	 */
	public void setBullpen(Bullpen bullpen){
		this.bullpen = bullpen;
	}

	//============================== GETTERS ==================================
	/**
	 * Returns the ID of the level
	 * @author Dylan
	 * @return levelID - Integer
	 */
	public int getID(){
		return levelID;
	}
	/**
	 * Returns the type of the level
	 * @author Dylan
	 * @return levelType - String version of level: Puzzle, Release, or Lightning
	 */
	public String getType(){
		return levelType;
	}
	/**
	 * Returns the Bullpen of this level
	 * @author Dylan
	 * @return Bullpen
	 */
	public Bullpen getBullpen(){
		return bullpen;
	}
	/**
	 * Returns the Board of this level
	 * @author Dylan
	 * @return Board
	 */
	public Board getBoard(){
		return board;
	}
	/**
	 * Returns the number of stars currently earned on this playthrough
	 * @author Dylan
	 * @return int between 0-3
	 */
	public int getStarsEarned(){
		return this.starsEarned;
	}
}


