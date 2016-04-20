package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import app.Builder;
import view.SplashScreen;

public class SplashTimerController implements ActionListener{
	SplashScreen view;
	Builder b;
	
	public SplashTimerController(SplashScreen view, Builder b){
		this.view = view;
		this.b = b;
	}
	
	public void actionPerformed(ActionEvent e){		
		view.dispose();
		b.getLevelTypeSelectView().setVisible(true);
	}
}
