package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.Game;
import view.SplashScreen;

public class GameSplashTimerController implements ActionListener{
	SplashScreen view;
	Game g;
	
	public GameSplashTimerController(SplashScreen view, Game g){
		this.view = view;
		this.g = g;
	}
	
	public void actionPerformed(ActionEvent e){
		view.dispose();
		g.getSelectView().setVisible(true);
	}
}
