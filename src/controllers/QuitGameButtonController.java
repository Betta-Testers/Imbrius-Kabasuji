package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import App.Game;
import view.GameExitScreen;

public class QuitGameButtonController implements ActionListener{
	GameExitScreen view;
	Game model;
	
	public QuitGameButtonController(GameExitScreen view, Game g){
		this.view = view;
		this.model = g;
	}
	
	public void actionPerformed(ActionEvent e){
		
		//call to game to initialize AvailableLevelView
		model.getSelectView().setVisible(true);
		view.dispose();
	}
}