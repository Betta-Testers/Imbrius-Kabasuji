package controllers;

import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.Timer;

import controllers.builder.BuilderSplashTimerController;
import model.Board;
import model.Bullpen;
import model.PuzzleLevel;
import view.BoardView;
import view.BuilderView;
import view.BullpenView;
import view.ButtonGroupView;
import view.LevelPropertiesView;
import view.SplashScreen;
import app.Builder;
import junit.framework.TestCase;

public class TestBuilderBoard extends TestCase {
	Builder build;
	BuilderView bView;
	Board b;
	
	@Override
	public void setUp(){
		new File("./imbriusLevelTESTING/").mkdirs();
		build = new Builder("./imbriusLevelTESTING/");
		bView = build.getBuilderView();
	}
	
	@Override
	public void tearDown(){
		File dir = new File("./imbriusLevelTESTING/");
		for(File file: dir.listFiles()) file.delete();
		dir.delete();
	}
	
	public void testPuzzleLightningBoard() {
		/*
		 * list variables needed for this test 
		 */
		PuzzleLevel lvl;
		Board puzzleBoard;
		BoardView boardView;
		Bullpen bp;
		BullpenView bpView;
		LevelPropertiesView lvlPropView;
		ButtonGroupView buttonGroupView;
		
		/*
		 * start splash screen and timer
		 */
		SplashScreen splash = new SplashScreen();
		Timer timer = new Timer(100, new BuilderSplashTimerController(splash, build));
		timer.setRepeats(false);
		timer.start();
		
		/*
		 * wait until the expected time is up
		 */
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/*
		 * create a mouse event to select build puzzle level
		 */
		MouseEvent me = new MouseEvent(build.getLevelTypeSelectView(), 
				MouseEvent.MOUSE_CLICKED, 
				System.currentTimeMillis(), 0, 
				build.getLevelTypeSelectView().getX(), 
				build.getLevelTypeSelectView().getY(), 1, false);
		
		/*
		 * handle the mouse event 
		 */
		build.getLevelTypeSelectView().getPuzzleBtnHandler().mouseClicked(me);
		
		/*
		 * verify that level created was a Puzzle level
		 */
		lvl = (PuzzleLevel)build.getCurrentLevel();
		assertEquals("Puzzle", lvl.getType());
		
		puzzleBoard = lvl.getBoard();
		bp = lvl.getBullpen();
		bpView = bView.getBullpenView();
		
	}
	
	public void testReleaseBoard() {

	}

}
