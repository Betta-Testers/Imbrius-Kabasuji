package controllers.common;

/**
 * Abstract class determining what a move must have. Useful for making actions undoable and redoable
 * in the UndoManager.
 * @author hejohnson
 */
public abstract class Move {

		/**
		 * Creates the move
		 */
		public Move () {}
		
		/**
		 * Performs the move.
		 * @return true if the move could be done.
		 */
		abstract public boolean doMove();
		/**
		 * Determines if the move can be made.
		 * @return true if the move can be done.
		 */
		abstract public boolean isValid();
		/**
		 * Undoes the move. 
		 * @return true if the undo could be done.
		 */
		abstract public boolean undo();
		
		/**
		 * Redoes the move.
		 * @return true if the move could be redone.
		 */
		abstract public boolean redo();
}
