package controllers;

import java.awt.event.WindowAdapter;
import app.LevelIO;


public class ShutdownController extends WindowAdapter{
	LevelIO io;
	
	public ShutdownController(LevelIO io){
		this.io = io;
	}
	
	/**
	 * When the player is done, we don't want to save ANYTHING other than the 
	 * stars earned for a level. Thankfully, that information is stored elsewhere
	 * on disk: the StarMap. So let's save this file!
	 */
	@Override
	public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		io.saveStarMap();
	}
}
