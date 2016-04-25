package app;

import java.util.Stack;
import controllers.common.Move;

/**
 * Singleton for handling undo and redo.
 * @author Dylan
 */
public class UndoManager{
	/**Holds the only instance if the undoManager that can be reached.**/
	private static UndoManager instance = new UndoManager();
	/**Stack for tracking moves to be undone**/
	static Stack<Move> undoStack;
	/**Stack for tracking moves to be redone**/
	static Stack<Move> redoStack;

	/**Private constructor prevents further instantiations**/
	private UndoManager(){
		if(instance != null){throw new IllegalStateException("Alredy Instantiated");}
		undoStack = new Stack<Move>();
		redoStack = new Stack<Move>();
	}

	public void pushMove(Move m){
		//TODO set undo button enabled
		//TODO set redo button disabled
		UndoManager.undoStack.push(m);
		UndoManager.redoStack.clear();
	}
	
	/**
	 * Undoes the move on top of the undo stack by:
	 * 1) Popping the move
	 * 2) Calling the move's undo
	 * 3) Pushing the move onto the redo stack
	 * Undo fails if there are no moves in the stack for it to undo.
	 * @return true if the undo could be done
	 */
	public boolean undo(){
		if(UndoManager.undoStack.empty()){ 
			//TODO Set undo button disabled
			return false;
		}
		Move m = UndoManager.undoStack.pop();
		m.undo();
		UndoManager.redoStack.push(m);
		return true;
	}
	
	/**
	 * Redoes the move on top of the redo stack by:
	 * 1) Popping the move
	 * 2) Calling the move's redo
	 * 3) Pushing the move onto the undo stack
	 * Redo fails if there are no moves in the stack for it to redo.
	 * @return true if the redo could be done
	 */
	public boolean redo(){
		if(UndoManager.redoStack.empty()){ 
			//TODO set redo button disabled
			return false;
		}
		Move m = UndoManager.redoStack.pop();
		m.redo();
		UndoManager.undoStack.push(m);
		return true;
	}
	
	/**
	 * Clears the stacks of all undos and redos. This is for the
	 * sake of operating between builder view instances.
	 */
	public void flush(){
		UndoManager.redoStack.clear();
		UndoManager.undoStack.clear();
	}
	
	/**
	 * Returns the singular instance of the UndoManager that is created
	 * @return the UndoManager object
	 */
	public static UndoManager getInstance(){
		return instance;
	}
}
