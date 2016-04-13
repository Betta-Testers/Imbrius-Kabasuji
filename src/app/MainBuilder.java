package app;


import java.awt.EventQueue;

import javax.swing.Timer;
import javax.swing.UIManager;

import controllers.SplashTimerController;
import view.SplashScreen;

public class MainBuilder {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/** The directory where files are saved and loaded from**/
					final String defaultDirectory = "./imbriusLevelFiles/";
					
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					
					SplashScreen splash = new SplashScreen();
					Builder builder = new Builder(defaultDirectory);
					
					Timer timer = new Timer(2000, new SplashTimerController(splash, builder));
					timer.setRepeats(false);
					timer.start();

					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
