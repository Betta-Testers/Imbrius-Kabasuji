package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gameMockups.GameExitScreen;

public class QuitGameButtonController implements ActionListener{
	GameExitScreen view;
	//Game model;
	
	public QuitGameButtonController(GameExitScreen view){
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent e){
		
		//call to game to initialize AvailableLevelView
		
		view.dispose();
	}
}
