package app;


import java.awt.EventQueue;

import javax.swing.Timer;
import javax.swing.UIManager;

import controllers.builder.BuilderSplashTimerController;
import view.SplashScreen;

public class MainBuilder {
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
