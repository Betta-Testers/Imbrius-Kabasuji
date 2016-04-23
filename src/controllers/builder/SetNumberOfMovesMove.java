/**
 * 
 */
package controllers.builder;

import javax.swing.JSpinner;

import controllers.common.Move;
import model.PuzzleLevel;

/**
 * Move for adjusting the total number of moves in the puzzle level editor
 * @author dfontana
 */
public class SetNumberOfMovesMove extends Move {
	PuzzleLevel pl;
	JSpinner spinMoves;
	int newMoves;
	int oldMoves;
	
	public SetNumberOfMovesMove (PuzzleLevel pl, JSpinner spinMoves) {
		this.spinMoves = spinMoves;
		this.pl = pl;
		this.newMoves = (int)spinMoves.getValue();
		this.oldMoves = pl.getMoveLimit();
	}

	@Override
	public boolean doMove() {
		if (isValid()) {
			pl.setMoveLimit(newMoves);
			return true;
		}
		return false;
	}

	@Override
	public boolean isValid() {
		return newMoves >= 0 && newMoves != oldMoves;
	}

	@Override
	public boolean undo() {
		pl.setMoveLimit(oldMoves);
		spinMoves.setValue(oldMoves);
		return false;
	}

	@Override
	public boolean redo() {
		pl.setMoveLimit(newMoves);
		spinMoves.setValue(newMoves);
		return false;
	}

}
