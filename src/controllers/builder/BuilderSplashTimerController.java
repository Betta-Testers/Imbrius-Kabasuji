package controllers.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import app.Builder;
import view.SplashScreen;

/**
 * Splash Timer attached to builder. Closes the splash screen and shows the Level Type Selection screen
 * @author Dylan
 *
 */
public class BuilderSplashTimerController implements ActionListener{
	SplashScreen splash;
	Builder b;
	
	/**
	 * 
	 * @param view The splash screen
	 * @param b The builder to show
	 */
	public BuilderSplashTimerController(SplashScreen splash, Builder b){
		this.splash = splash;
		this.b = b;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){		
		splash.dispose();
		b.getLevelTypeSelectView().setVisible(true);
	}
}
