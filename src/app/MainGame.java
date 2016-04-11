package app;


import java.awt.EventQueue;

import javax.swing.Timer;
import javax.swing.UIManager;

import controllers.GameSplashTimerController;

public class MainGame {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Game game = new Game();
					
					Timer timer = new Timer(2000, new GameSplashTimerController(game.startUp, game));
					timer.setRepeats(false);
					timer.start();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
