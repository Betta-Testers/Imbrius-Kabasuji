package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import app.Game;

import view.GameExitScreen;

public class QuitGameButtonController implements ActionListener{
	GameExitScreen view;
	Game model;
	
	public QuitGameButtonController(GameExitScreen view, Game g){
		this.view = view;
		this.model = g;

	}
	
	public void actionPerformed(ActionEvent e){
	
		model.getSelectView().setVisible(true);
		view.dispose();
	}
}

