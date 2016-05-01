package controllers.player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import javax.swing.Timer;

import app.Game;
import model.LightningLevel;
import view.LevelView;
import view.TimeRemainingView;

/**
 * Controls the timer of the lightning mode gameplay.
 * @author hejohnson
 */
public class LightningTimerController extends WindowAdapter implements ActionListener{
	/** The view of the level being played **/
	LevelView view;
	/** The overarching game object **/
	Game game;
	/** A swing timer **/
	Timer timer;
	/** Count of seconds elapsed **/
	int secondsElapsed;
	/** End time of the timer, set by the level model **/
	int totalTime;	
	
	/** 
	 * Sets up the timer to fire events every second and repeat
	 * @param g The game object
	 * @param lv the view of the lightning level being played
	 */
	public LightningTimerController(Game g, LevelView lv){
		this.view = lv;
		this.game = g;
		this.secondsElapsed = 0;
		this.timer = new Timer(1000, this);
		this.totalTime = ((LightningLevel)g.getCurrentLevel()).getTotalTime();
		timer.setRepeats(true);
		timer.start();
	}
	
	/** 
	 * Counts the number of seconds (an event is fired every second
	 * If the count reaches the total time, the timer is stopped and the game window is closed
	 */
	public void actionPerformed(ActionEvent e){
		secondsElapsed++;
		
		((TimeRemainingView)view.getEndConditionPanel()).updateTimeLeft(totalTime-secondsElapsed);
		if (secondsElapsed >= totalTime) {
			timer.stop();
			game.getLevelView().dispatchEvent(new WindowEvent(game.getLevelView(), WindowEvent.WINDOW_CLOSING));
		}
	}
	
	/** 
	 * If the window is closed by an outside actor, the timer is stopped
	 */
	public void windowClosing(WindowEvent we) {
		timer.stop();
	}
}
