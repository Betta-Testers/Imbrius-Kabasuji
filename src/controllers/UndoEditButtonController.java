package controllers;

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
		// TODO Implement move tracking in the Builder Class
		// return.app.undoMove();
		return false;
	}
}
