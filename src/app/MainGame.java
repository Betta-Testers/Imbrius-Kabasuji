package app;
import java.awt.EventQueue;

import javax.swing.Timer;
import javax.swing.UIManager;

import controllers.player.GameSplashTimerController;
import view.SplashScreen;

/**
 * Class for launching the game and setting the look and feel.
 * @author dfontana
 */
public class MainGame {
	@SuppressWarnings("javadoc")
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					
					SplashScreen splash = new SplashScreen();
					Game game = new Game("./imbriusLevelFiles/");
					
					Timer timer = new Timer(2000, new GameSplashTimerController(splash, game));
					timer.setRepeats(false);
					timer.start();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
