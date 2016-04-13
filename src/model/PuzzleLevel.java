package model;

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

/***************************************************************
 * 			TODO GO LOOK AT LAUNCHWORDMAP in WORDMAP. 
 * 			TODO LOOK AT BOARD IN WORDMAP 
 ***************************************************************/


public class PuzzleLevel extends AbstractLevelModel{
	/**Serialized ID used for writing file to disk**/
	private static final long serialVersionUID = 1570651687735468714L;

	/**The moveLimit is the maximum number of moves THIS level allows to be made**/
	int moveLimit;
	
	/**The movesMade is the number of moves a player has made on THIS level**/
	int movesMade;
	
	/**The tilesLeft is the number of tiles left for the player to cover on THIS level**/
	int tilesLeft;

	public PuzzleLevel(int levelID) {
		super(levelID, "Puzzle", true);
		// TODO Auto-generated constructor stub
	}


	@Override
	boolean saveProgressInFile() {
		if(starsEarned > maxStarsEarned){
			//save starsEarned instead of maxStarsEarned
		}
		return false;
	}

	/**
	 * saveLevelToFile is used in the Builder side of Kabasuji. When the builder saves the level being built
	 * this method saves the state of the entire level and overwrites any existing level. (Aka: Don't use append mode!)**/
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
