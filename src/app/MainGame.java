package app;


import java.awt.EventQueue;

import javax.swing.Timer;
import javax.swing.UIManager;

import controllers.GameSplashTimerController;
import view.SplashScreen;

public class MainGame {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/** The directory where files are loaded from**/
					final String defaultDirectory = "./imbriusLevelFiles/";
					
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					
					SplashScreen splash = new SplashScreen();
					Game game = new Game(defaultDirectory);
					
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
