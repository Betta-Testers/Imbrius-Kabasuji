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
	Stack<Move> undoStack = new Stack<Move>();
	/**Stack for tracking moves to be redone**/
	Stack<Move> redoStack = new Stack<Move>();

	/**Private constructor prevents further instantiations**/
	private UndoManager(){
		if(instance != null){throw new IllegalStateException("Alredy Instantiated");}
		undoStack = new Stack<Move>();
		redoStack = new Stack<Move>();
	}

	public void pushMove(Move m){
		this.undoStack.push(m);
		this.redoStack.clear();
		System.out.println("The stack is Empty! "+redoStack.empty());
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
		if(this.undoStack.empty()){ return false;}
		Move m = this.undoStack.pop();
		m.undo();
		this.redoStack.push(m);
		return this.undoStack.empty();
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
		if(this.redoStack.empty()){ return false;}
		Move m = this.redoStack.pop();
		m.redo();
		this.undoStack.push(m);
		return true;
	}
	
	/**
	 * Returns the singular instance of the UndoManager that is created
	 * @return the UndoManager object
	 */
	public static UndoManager getInstance(){
		return instance;
	}
}
