package controllers.player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

import app.Game;
import view.SplashScreen;

/**
 * The controller to close the splash screen and launch the level select
 * @author dfontana
 *
 */
public class GameSplashTimerController implements ActionListener{
	/** The splash screen **/
	SplashScreen view;
	/** The game object that will be used to play levels in **/
	Game g;
	
	/**
	 * @param view The splash screen
	 * @param g The game object
	 */
	public GameSplashTimerController(SplashScreen view, Game g){
		this.view = view;
		this.g = g;
		playSong();
	}
	
	/**
	 * Closes the splash screen and shows the level select screen
	 */
	public void actionPerformed(ActionEvent e){
		view.dispose();
		g.getSelectView().setVisible(true);
	}
	public void playSong(){
		try {
		    File yourFile = new File("sounds/splash_song.wav");
		    AudioInputStream stream;
		    AudioFormat format;
		    DataLine.Info info;
		    Clip clip;

		    System.out.println("POOP");
		    
		    stream = AudioSystem.getAudioInputStream(yourFile);
		    System.out.println("POOP");
		    format = stream.getFormat();
		    info = new DataLine.Info(Clip.class, format);
		    clip = (Clip) AudioSystem.getLine(info);
		    

		    clip.open(stream);
		    clip.start();
		    
		}
		catch (Exception e) {
		    //whatevers
		}
	}
}
