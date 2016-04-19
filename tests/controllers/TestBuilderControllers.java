package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.Timer;

import view.BuilderView;
import view.SplashScreen;
import app.Builder;
import junit.framework.TestCase;

public class TestBuilderControllers extends TestCase {
	
	Builder build;
	BuilderView bv;
	
	@Override
	public void setUp(){
		build = new Builder("./imbriusLevelTESTING/");
		bv = build.getBuilderView();
	}
	
	@Override
	public void tearDown(){
		File dir = new File("./imbriusLevelTESTING/");
		for(File file: dir.listFiles()) file.delete();
	}
	
	public void testSplashScreen() {
		SplashScreen splash = new SplashScreen();
		Timer timer = new Timer(2000, new SplashTimerController(splash, build));
		timer.setRepeats(false);
		timer.start();
		
		assertTrue(splash.isVisible());
		assertFalse(build.getLevelTypeSelectView().isVisible());
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertFalse(splash.isVisible());
		assertTrue(build.getLevelTypeSelectView().isVisible());
	}
	
	public void testBuilderView() {
		assertFalse(build.getBuilderView().isVisible());
		
		// TODO how to handle created mouse events
		MouseEvent me = new MouseEvent(build.getLevelTypeSelectView(), 
				MouseEvent.MOUSE_CLICKED, 
				System.currentTimeMillis(), 0, 
				build.getLevelTypeSelectView().getX(), 
				build.getLevelTypeSelectView().getY(), 1, false);
		
//		MouseAdapter eventManagers = build.getLevelTypeSelectView().getCreatePuzzleBtn().getMouseListeners();
//		eventManager.mouseClicked(me);
		
//		assertTrue(build.getBuilderView().isVisible());
	}
}
