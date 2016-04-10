package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.SplashScreen;

public class SplashTimerController implements ActionListener{
	SplashScreen view;
	//Game model;
	
	//add Game model to controller???
	public SplashTimerController(SplashScreen view){
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent e){
		
		//call to game to initialize AvailableLevelView
		
		view.dispose();
	}
}
