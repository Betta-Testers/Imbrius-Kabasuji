package model;

import java.io.IOException;
import java.io.Serializable;

/** 
 * A PuzzleLevel handles the back end for a Puzzle game mode, tracking the end conditions and progress of 
 * the game.
 * @author Dylan
 */

public class PuzzleLevel extends AbstractLevelModel implements Serializable{
	/**Serialized ID used for writing file to disk**/
	private static final long serialVersionUID = 1570651687735468714L;

	/**The moveLimit is the maximum number of moves THIS level allows to be made**/
	int moveLimit = 1;
	
	/**The movesMade is the number of moves a player has made on THIS level**/
	transient int movesMade;
	
	/**The tilesLeft is the number of tiles left for the player to cover on THIS level**/
	transient int tilesLeft;

	public PuzzleLevel(int levelID) {
		super(levelID, "Puzzle", true);
		//moveLimit = 0;
		initialize();
	}
	
	/**
	 * Initialize is here to redirect the contructor. When deserializing an object, it's 
	 * constructor is ignored. Because of this, any transient fields won't get initialized.
	 * To prevent this, a readObject() method is implemented and inside logic to initialize
	 * these fields is put there. To prevent duplicate code from the constructor, however,
	 * all this logic is done here.
	 * 
	 * Exploit this fact to initialize non-transient files in the constructor!
	 */
	void initialize() {
		movesMade = 0;
		tilesLeft = 0;
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
	
	public String toString(){
		return levelType+levelID+moveLimit;
	}
	
	/**
	 * When deserializing this, the transient fields needs to be initialized.
	 * This method does just that, by calling the initialize method.
	 */
	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException{
		in.defaultReadObject();
		initialize();
	}
}
