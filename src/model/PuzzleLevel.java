
package model;

import java.io.IOException;
import java.io.Serializable;

import app.Game;
import controllers.ExitLevelButtonController;
import view.LevelView;
import view.NumberMovesLeftView;

/** 
 * A PuzzleLevel handles the back end for a Puzzle game mode, tracking the end conditions and progress of 
 * the game.
 * @author Dylan
 */
public class PuzzleLevel extends AbstractLevelModel implements Serializable{
	/**Serialized ID used for writing file to disk**/
	private static final long serialVersionUID = 1570651687735468714L;

	/**The moveLimit is the maximum number of moves THIS level allows to be made**/
	int moveLimit;
	
	/**The movesMade is the number of moves a player has made on THIS level**/
	transient int movesMade;
	
	public PuzzleLevel(int levelID) {
		super(levelID, "Puzzle", true);
		moveLimit = 0;
		initializeVars();
	}
	
	/**
	 * InitializeVars is here to redirect the contructor. When deserializing an object, it's 
	 * constructor is ignored. Because of this, any transient fields won't get initialized.
	 * To prevent this, a readObject() method is implemented and inside logic to initialize
	 * these fields is put there. To prevent duplicate code from the constructor, however,
	 * all this logic is done here.
	 * 
	 * Exploit this fact to initialize non-transient fields in the constructor!
	 */
	void initializeVars() {
		movesMade = 0;
	}

	/**
	 * CheckStatus occurs after every move is made. This updates the stars earned for the current level if
	 * the number of tiles left uncovered on the board is remaining is 0/6/12. The starsEarned is set rather than incremented
	 * to prevent duplicate triggers of the same threshold (Since you can moves a piece off a board and back onto it).
	 * 
	 * CheckStatus then checks if the level is done. If so, it returns true. Otherwise, false.
	 * @author Dylan
	 * @return boolean - true if the level's end conditions are met
	 */
	@Override
	public boolean checkStatus() {
		int unmarkedTiles = board.getNumBoardTiles();
		switch(unmarkedTiles){
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
		return unmarkedTiles == 0 || (moveLimit-movesMade) == 0;
	}
		
	/**
	 * incrementMovesMade is called whenever a move is performed in a puzzle level. This includes bullpen to board,
	 * board to board, or off the board. It always increments by 1.
	 * @author Dylan
	 */
	public void incrementMovesMade(){
		movesMade++;
	}
	
	/**
	 * Allows the setting of the move
	 * @param moves
	 */
	public void setMoveLimit(int moves){
		moveLimit = moves;
	}
	
	/**
	 * Initializes the view to display correctly for a puzzle level. 
	 * @return LevelView - view of the initialized LevelView
	 */
	@Override
	public LevelView initializeGame(Game g) {
		LevelView view = new LevelView("Puzzle", new NumberMovesLeftView());
		view.addWindowListener(new ExitLevelButtonController(view, g));
		return view;
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
		initializeVars();
	}
}
