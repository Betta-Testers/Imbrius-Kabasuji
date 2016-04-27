package app;
import java.awt.EventQueue;

import javax.swing.Timer;
import javax.swing.UIManager;

import controllers.builder.BuilderSplashTimerController;
import view.SplashScreen;

/**
 * Class for launching the Builder and setting the look and feel.
 * @author dfontana
 */
public class MainBuilder {
	@SuppressWarnings("javadoc")
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					
					SplashScreen splash = new SplashScreen();
					Builder builder = new Builder("./imbriusLevelFiles/");
					
					Timer timer = new Timer(2000, new BuilderSplashTimerController(splash, builder));
					timer.setRepeats(false);
					timer.start();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
