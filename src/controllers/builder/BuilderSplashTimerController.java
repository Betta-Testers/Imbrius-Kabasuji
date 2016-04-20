package controllers.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import app.Builder;
import view.SplashScreen;

/**
 * Splash Timer attached to builder
 * @author Dylan
 *
 */
public class BuilderSplashTimerController implements ActionListener{
	SplashScreen view;
	Builder b;
	
	public BuilderSplashTimerController(SplashScreen view, Builder b){
		this.view = view;
		this.b = b;
	}
	
	public void actionPerformed(ActionEvent e){		
		view.dispose();
		b.getLevelTypeSelectView().setVisible(true);
	}
}
