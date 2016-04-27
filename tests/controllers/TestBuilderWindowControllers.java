package controllers;
import java.io.File;

import javax.swing.Timer;
import java.awt.event.MouseEvent;
import app.Builder;
import controllers.builder.BuilderSplashTimerController;
import view.SplashScreen;

/**
 * @author hejohnson
 * @author awharrison
 *
 */
@SuppressWarnings("javadoc")
public class TestBuilderWindowControllers extends MouseTesting {
	Builder build;
	
	@Override
	public void setUp(){
		build = new Builder("./imbriusLevelTESTING/");
	}
	
	@Override
	public void tearDown(){
		File dir = new File("./imbriusLevelTESTING/");
		for(File file: dir.listFiles()) file.delete();
	}
	
	public void testCreatePuzzle() {
		/*
		 * start splash screen and timer
		 */
		SplashScreen splash = new SplashScreen();
		Timer timer = new Timer(100, new BuilderSplashTimerController(splash, build));
		timer.setRepeats(false);
		timer.start();
		
		/*
		 * verify that the splash screen is visible
		 */
		assertTrue(splash.isVisible());
		assertFalse(build.getLevelTypeSelectView().isVisible());
		
		/*
		 * wait until the expected time is up
		 */
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/*
		 * verify that the splash screen is no longer visible and the level type select view is visible
		 */
		assertFalse(splash.isVisible());
		assertTrue(build.getLevelTypeSelectView().isVisible());
		
		/*
		 * create a mouse event to select build puzzle level
		 */
		MouseEvent me = new MouseEvent(build.getLevelTypeSelectView(), 
				MouseEvent.MOUSE_PRESSED, 
				System.currentTimeMillis(), 0, 
				build.getLevelTypeSelectView().getX(), 
				build.getLevelTypeSelectView().getY(), 1, false);
		
		/*
		 * handle the mouse event, verify that the level type select view is no longer visible and the builder view is now visible
		 */
		build.getLevelTypeSelectView().getPuzzleBtnHandler().mousePressed(me);
		assertFalse(build.getLevelTypeSelectView().isVisible());
		assertTrue(build.getBuilderView().isVisible()); 
		
	}
	
	public void testCreateLightning() {
		/*
		 * start splash screen and timer
		 */
		SplashScreen splash = new SplashScreen();
		Timer timer = new Timer(100, new BuilderSplashTimerController(splash, build));
		timer.setRepeats(false);
		timer.start();
		
		/*
		 * verify that the splash screen is visible
		 */
		assertTrue(splash.isVisible());
		assertFalse(build.getLevelTypeSelectView().isVisible());
		
		/*
		 * wait until the expected time is up
		 */
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/*
		 * verify that the splash screen is no longer visible and the level type select view is visible
		 */
		assertFalse(splash.isVisible());
		assertTrue(build.getLevelTypeSelectView().isVisible());
		
		/*
		 * create a mouse event to select build lightning level
		 */
		MouseEvent me = new MouseEvent(build.getLevelTypeSelectView(), 
				MouseEvent.MOUSE_PRESSED, 
				System.currentTimeMillis(), 0, 
				build.getLevelTypeSelectView().getX(), 
				build.getLevelTypeSelectView().getY(), 1, false);
		
		/*
		 * handle the mouse event, verify that the level type select view is no longer visible and the builder view is now visible
		 */
		build.getLevelTypeSelectView().getLightningBtnHandler().mousePressed(me);
		assertTrue(build.getBuilderView().isVisible()); 
		assertFalse(build.getLevelTypeSelectView().isVisible());
		
	}
	
	public void testCreateRelease() {
		/*
		 * start splash screen and timer
		 */
		SplashScreen splash = new SplashScreen();
		Timer timer = new Timer(100, new BuilderSplashTimerController(splash, build));
		timer.setRepeats(false);
		timer.start();
		
		/*
		 * verify that the splash screen is visible
		 */
		assertTrue(splash.isVisible());
		assertFalse(build.getLevelTypeSelectView().isVisible());
		
		/*
		 * wait until the expected time is up
		 */
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/*
		 * verify that the splash screen is no longer visible and the level type select view is visible
		 */
		assertFalse(splash.isVisible());
		assertTrue(build.getLevelTypeSelectView().isVisible());
		
		/*
		 * create a mouse event to select build release level
		 */
		MouseEvent me = new MouseEvent(build.getLevelTypeSelectView(), 
				MouseEvent.MOUSE_PRESSED, 
				System.currentTimeMillis(), 0, 
				build.getLevelTypeSelectView().getX(), 
				build.getLevelTypeSelectView().getY(), 1, false);
		
		/*
		 * handle the mouse event, verify that the level type select view is no longer visible and the builder view is now visible
		 */
		build.getLevelTypeSelectView().getReleaseBtnHandler().mousePressed(me);
		assertTrue(build.getBuilderView().isVisible()); 
		assertFalse(build.getLevelTypeSelectView().isVisible());
		
	}	
}
