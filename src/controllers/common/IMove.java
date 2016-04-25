package controllers.common;

/**
 * Interface for declaring what constitutes a move.
 * Any moves that are created or added must implement
 * this interface.
 * @author hejohnson
 * @author dfontana
 */
public interface IMove {
	/**
	 * Performs the move.
	 * @return true if the move could be done.
	 */
	public boolean doMove();
	/**
	 * Determines if the move can be made.
	 * @return true if the move can be done.
	 */
	public boolean isValid();
	/**
	 * Undoes the move. 
	 * @return true if the undo could be done.
	 */
	public boolean undo();
	/**
	 * Redoes the move.
	 * @return true if the move could be redone.
	 */
	public boolean redo();
}
