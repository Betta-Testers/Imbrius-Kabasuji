package controllers.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import app.Builder;
import view.SplashScreen;

/**
 * Splash Timer attached to builder. Closes the splash screen and shows the Level Type Selection screen
 * @author Dylan
 */
public class BuilderSplashTimerController implements ActionListener{
	SplashScreen view;
	Builder b;
	
	/**
	 * Creates the controller.
	 * @param view The splash screen
	 * @param b The builder to show
	 */
	public BuilderSplashTimerController(SplashScreen view, Builder b){
		this.view = view;
		this.b = b;
	}
	
	/**
	 * The action on trigger is to dispose the splash screen and display the level select view from the builder
	 */
	@Override
	public void actionPerformed(ActionEvent e){		
		view.dispose();
		b.getLevelTypeSelectView().setVisible(true);
	}
}
