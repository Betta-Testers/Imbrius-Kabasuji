package controllers.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import app.Builder;
import view.SplashScreen;

/**
 * Splash Timer attached to builder. Closes the splash screen and shows the Level Type Selection screen
 * @author dfontana
 */
public class BuilderSplashTimerController implements ActionListener{
	SplashScreen splash;
	Builder b;
	
	/**
	 * Creates the controller.
	 * @param view The splash screen
	 * @param b The builder to show
	 */
	public BuilderSplashTimerController(SplashScreen splash, Builder b){
		this.splash = splash;
		this.b = b;
	}
	
	/**
	 * The action on trigger is to dispose the splash screen and display the level select view from the builder
	 */
	@Override
	public void actionPerformed(ActionEvent e){		
		splash.dispose();
		b.getLevelTypeSelectView().setVisible(true);
	}
}
