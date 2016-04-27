package app;
import java.awt.EventQueue;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.UIManager;

import controllers.builder.BuilderSplashTimerController;
import controllers.player.GameSplashTimerController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

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
					playSound(new GameSplashTimerController(splash, game));	
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Plays splashscreen song. Sends action event to controller upon completion.
	 * @param e - ActionListener
	 */
	public static synchronized void playSound(final ActionListener e) {
		  new Thread(new Runnable() {
			private final int BUFFER_SIZE = 128000;
			private File soundFile;
			private AudioInputStream audioStream;
			private AudioFormat audioFormat;
			private SourceDataLine sourceLine;
			public void run(){
				String strFilename = "resources/sounds/song.wav";	
			    try {
			        soundFile = new File(strFilename);
			    } catch (Exception e) {
			        e.printStackTrace();
			        System.exit(1);
			    }
			
			    try {
			        audioStream = AudioSystem.getAudioInputStream(soundFile);
			    } catch (Exception e){
			        e.printStackTrace();
			        System.exit(1);
			    }
			
			    audioFormat = audioStream.getFormat();
			
			    DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
			    try {
			        sourceLine = (SourceDataLine) AudioSystem.getLine(info);
			        sourceLine.open(audioFormat);
			    } catch (LineUnavailableException e) {
			        e.printStackTrace();
			        System.exit(1);
			    } catch (Exception e) {
			        e.printStackTrace();
			        System.exit(1);
			    }
			
			    sourceLine.start();
			
			    int nBytesRead = 0;
			    byte[] abData = new byte[BUFFER_SIZE];
			    while (nBytesRead != -1) {
			        try {
			            nBytesRead = audioStream.read(abData, 0, abData.length);
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
			        if (nBytesRead >= 0) {
			            @SuppressWarnings("unused")
			            int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
			        }
			    }
			
			    sourceLine.drain();
			    sourceLine.close();
			    e.actionPerformed(null);
			}
		  }).start();
	}
}
