package controllers.builder;

import javax.swing.JSpinner;

import controllers.common.IMove;
import model.PuzzleLevel;

/**
 * Move for adjusting the total number of moves in the puzzle level editor
 * @author dfontana
 */
public class SetNumberOfMovesMove implements IMove {
	/**PuzzleLevel whose move limit is being set**/
	PuzzleLevel pl;
	/**Spinner affecting the move limit**/
	JSpinner spinMoves;
	/**Value of the spinner**/
	int newMoves;
	/**Old move limit the level has**/
	int oldMoves;
	
	/**
	 * Constructs the move
	 * @param pl - Puzzle Level whose move limit is being set
	 * @param spinMoves - Spinner manipulating the move limit
	 */
	public SetNumberOfMovesMove (PuzzleLevel pl, JSpinner spinMoves) {
		this.spinMoves = spinMoves;
		this.pl = pl;
		this.newMoves = (int)spinMoves.getValue();
		this.oldMoves = pl.getMoveLimit();
	}

	/**
	 * The move is done by setting the level's move limit from the
	 * spinner's value.
	 * @return true if the move completes
	 */
	@Override
	public boolean doMove() {
		if (isValid()) {
			pl.setMoveLimit(newMoves);
			return true;
		}
		return false;
	}

	/**
	 * The move is valid if the move limit is non-negative and doesn't match the
	 * current value set in the level.
	 * @return true if move can be done
	 */
	@Override
	public boolean isValid() {
		return newMoves >= 0 && newMoves != oldMoves;
	}

	/**
	 * The move is undone by setting the limit and spinner back to the old values
	 * @return true- the move can always be undone
	 */
	@Override
	public boolean undo() {
		pl.setMoveLimit(oldMoves);
		spinMoves.setValue(oldMoves);
		return true;
	}

	/**
	 * The move is redone by setting the limit and spinner back to the new values
	 * @return true - the move can always be redone 
	 */
	@Override
	public boolean redo() {
		pl.setMoveLimit(newMoves);
		spinMoves.setValue(newMoves);
		return true;
	}

}
