package app;

import java.util.Stack;

import controllers.common.IMove;
import view.ButtonGroupView;

/**
 * Singleton for handling undo and redo.
 * @author Dylan
 */
public class UndoManager{
	/**Holds the only instance if the undoManager that can be reached.**/
	private static UndoManager instance = new UndoManager();
	/**Stack for tracking moves to be undone**/
	static Stack<IMove> undoStack;
	/**Stack for tracking moves to be redone**/
	static Stack<IMove> redoStack;
	
	/**Breaks singleton standard to micro manage the undo/redo buttons for the current view.
	 * This value is set in the constructor of ButtonGroupView, essentially telling the 
	 * Undo Manager that the button group view will be using this set of buttons for the given
	 * view instantiation.
	 */
	ButtonGroupView bgv;
	

	/**Private constructor prevents further instantiations**/
	private UndoManager(){
		if(instance != null){throw new IllegalStateException("Alredy Instantiated");}
		undoStack = new Stack<IMove>();
		redoStack = new Stack<IMove>();
	}

	public void pushMove(IMove m){
		if(bgv != null){
			bgv.setUndoEnabled(true); //TODO set undo button enabled
		}
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
		if(UndoManager.undoStack.empty()){return false;}
		bgv.setRedoEnabled(true);//TODO enable the redo button
		IMove m = UndoManager.undoStack.pop();
		m.undo();
		UndoManager.redoStack.push(m);
		if(UndoManager.undoStack.empty()){bgv.setUndoEnabled(false);}//TODO IF emptied, disable
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
		if(UndoManager.redoStack.empty()){ return false;}
		bgv.setUndoEnabled(true);//TODO enable the undo button
		IMove m = UndoManager.redoStack.pop();
		m.redo();
		UndoManager.undoStack.push(m);
		if(UndoManager.redoStack.empty()){bgv.setRedoEnabled(false);}//TODO if emptied, disable
		return true;
	}
	
	/**
	 * Gives the singleton a button group to be modified. This value is a changing value,
	 * given when a button group view is instantiated/
	 * @param bgv - the button group being manipulated
	 */
	public void giveButtonGroup(ButtonGroupView bgv){
		this.bgv = bgv;
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
