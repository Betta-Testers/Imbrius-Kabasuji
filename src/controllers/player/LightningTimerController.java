package controllers.player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.Game;
import view.LevelView;

public class LightningTimerController implements ActionListener{
	LevelView view;
	Game g;
	
	
	public LightningTimerController(LevelView view, Game g){
		this.view = view;
		this.g = g;
	}
	
	public void actionPerformed(ActionEvent e){
		g.getExitView().setVisible(true);
		view.dispose();
	}
}
