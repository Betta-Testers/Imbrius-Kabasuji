package app;
import java.awt.EventQueue;

import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.UIManager;

import controllers.builder.BuilderSplashTimerController;
import controllers.player.GameSplashTimerController;
import java.awt.event.ActionEvent;
import view.SplashScreen;

/**
 * Class for launching the game and setting the look and feel.
 * @author dfontana
 */
public class MainGame{
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Game game = new Game("./imbriusLevelFiles/");
					SplashScreen splash = new SplashScreen();
					Song song = new Song(new GameSplashTimerController(splash, game));	
					song.playSong();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
