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
		// TODO discuss the handling moves, Solitaire uses enumerations
		return.app.undoMove();
	}
}
