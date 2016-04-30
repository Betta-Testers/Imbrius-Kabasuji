package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.swing.ImageIcon;

import app.Builder;
import app.Game;
import view.BuilderView;
import view.LevelView;

/**
 * An AbstractLevelModel dictates what a level needs to have.
 * @author dfontana
 */
public abstract class AbstractLevelModel implements Serializable{

	/**While an this class should NEVER be serialized, this is needed to serialize subclasses**/
	private static final long serialVersionUID = -5159764997744131193L;

	/**The ID of a level is a unique integer of value 1+ and corresponds to the file name**/
	final int levelID;

	/**LevelType is a string telling the model what type this level is. It avoids instanceOf checks!**/
	final String levelType;

	/**The starsEarned for a level is an integer 0-3, tracking the progress thus far on an attempt at this level**/
	transient int starsEarned;

	/**CanMovePiece is a boolean value telling the level if pieces can be moved on the board or not**/
	final boolean canMovePiece;

	/**The Bullpen that is associated with this level**/
	Bullpen bullpen;

	/**The Board that is associated with this level**/
	Board board;


	/**
	 * You CANNOT instantiate an AbstractLevelModel. This constructor is here so you can super() set the 
	 * final fields within the subclasses. Otherwise, these fields would have a hard time being set AND
	 * being final!
	 * @param levelID - Id of level being made
	 * @param levelType - type of level being made
	 * @param canMovePiece - if the level can move pieces on its board
	 */
	AbstractLevelModel(int levelID, String levelType, boolean canMovePiece){
		this.levelID = levelID;
		this.levelType = levelType;
		this.canMovePiece = canMovePiece;	
	}

	/**
	 * Check status occurs after every move is made. This updates the current state of play in the level, such as
	 * the movesMade, how many tiles have been covered, etc. It returns a boolean indicating if the level is finished
	 * (true) or false if the level has not hit the end of play
	 * @return true if the state of the game is done
	 */
	public abstract boolean checkStatus();

	/**
	 * initializes views and controllers for a this level.
	 * Any other initializations occur here.
	 * @param g - game whose current level's view is in need of initialization
	 * @return LevelView - view of this level
	 */
	public abstract LevelView initializeGame(Game g);

	/**
	 * Prepares the builderView for the level, should it be opened
	 * in the builder.
	 * @param b requesting the action
	 * @return BuilderView - view of the level being edited
	 */
	public abstract BuilderView prepBuilder(Builder b);
	//============================== SETTERS ==================================
	/**
	 * sets the board associated with this level to the one passed in
	 * @param board to be set
	 */
 	public void setBoard(Board board){
		this.board = board;
	}
	/**
	 * Sets the bullpen associated with this level to the one passed in
	 * @param bullpen to be set
	 */
	public void setBullpen(Bullpen bullpen){
		this.bullpen = bullpen;
	}

	//============================== GETTERS ==================================
	/**
	 * Returns the ID of the level
	 * @return levelID - Integer
	 */
	public int getID(){
		return levelID;
	}
	/**
	 * Returns the type of the level
	 * @return levelType - String version of level: Puzzle, Release, or Lightning
	 */
	public String getType(){
		return levelType;
	}
	/**
	 * Returns the Bullpen of this level
	 * @return Bullpen of this level
	 */
	public Bullpen getBullpen(){
		return bullpen;
	}
	/**
	 * Returns the Board of this level
	 * @return Board of this level
	 */
	public Board getBoard(){
		return board;
	}
	/**
	 * Returns the number of stars currently earned on this playthrough
	 * @return int between 0-3
	 */
	public int getStarsEarned(){
		return this.starsEarned;
	}
	
	/**
	 * @return Preview of the board
	 */
	public ImageIcon generateBoardPreview() {
		BufferedImage iconImg = new BufferedImage(73, 73, BufferedImage.TYPE_INT_ARGB);
	      Graphics2D g2 = iconImg.createGraphics();
	      for (int i = 0; i<12; i++) {
	    	  for (int j = 0; j<12; j++) {
	    		  AbstractTile bt = board.getTileAt(32*i, 32*j);
		    	  g2.setColor(bt.getColor());
		    	  g2.fillRect(i*6, j*6, 6, 6);
		    	  g2.setColor(Color.black);
		    	  g2.drawRect(i*6, j*6, 6, 6);
	    	  }
	      }
	      return new ImageIcon(iconImg);
	}
	
	/**
	 * Plays a sound when called.
	 * @param String - path to wav file
	 */
	public static synchronized void playSound(final String strFilename) {
		  new Thread(new Runnable() {
			private final int BUFFER_SIZE = 128000;
			private File soundFile;
			private AudioInputStream audioStream;
			private AudioFormat audioFormat;
			private SourceDataLine sourceLine;
			public void run(){
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
			}
		  }).start();
	}

}


