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

public class LightningTimerController extends WindowAdapter implements ActionListener{
	LevelView view;
	Game game;
	Timer timer;
	int secondsElapsed;
	int totalTime;	
	
	public LightningTimerController(LevelView view, Game g){
		this.view = view;
		this.game = g;
		this.secondsElapsed = 0;
		this.timer = new Timer(1000, this);
		this.totalTime = ((LightningLevel)g.getCurrentLevel()).getTotalTime();
		timer.setRepeats(true);
		timer.start();
	}
	
	public void actionPerformed(ActionEvent e){
		secondsElapsed++;
		String time = new DecimalFormat("   ").format(totalTime-secondsElapsed);
		((TimeRemainingView)view.getEndConditionPanel()).updateTimeLeft(time);
		if (secondsElapsed >= totalTime) {
			timer.stop();
			game.getLevelView().dispatchEvent(new WindowEvent(game.getLevelView(), WindowEvent.WINDOW_CLOSING));
		}
	}
	
	public void windowClosing(WindowEvent we) {
		timer.stop();
	}
}
