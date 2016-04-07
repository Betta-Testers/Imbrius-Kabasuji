package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gameMockups.AvailableLevelView;
import gameMockups.GameExitScreen;

public class QuitGameButtonController implements ActionListener{
	GameExitScreen view;
	//Game model;
	
	public QuitGameButtonController(GameExitScreen view){
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent e){
		new AvailableLevelView("NAME?");
		
		//new AvailableLevelView("NAME?");
	}
}
