package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.Game;
import view.SplashScreen;

public class GameSplashTimerController implements ActionListener{
	SplashScreen view;
	Game model;
	
	//add Game model to controller???
	public GameSplashTimerController(SplashScreen view, Game g){
		this.view = view;
		this.model = g;
	}
	
	public void actionPerformed(ActionEvent e){
		
		//call to game to initialize AvailableLevelView
		model.getSelectView().setVisible(true);
		view.dispose();
	}
}
