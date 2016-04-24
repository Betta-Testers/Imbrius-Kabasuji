package controllers.builder;

import app.Builder;

/**
 * 
 * @author awharrison
 *
 */
public class UndoEditButtonController {
	Builder app;
	
	public UndoEditButtonController(Builder app) {
		this.app = app;
	}
	
	public boolean undoRequested() {
		// TODO Implement Singleton Undo manager. Call undo method.
		return false;
	}
}
