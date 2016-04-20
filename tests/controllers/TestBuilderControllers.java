package controllers;
import java.io.File;

import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseEvent;

import app.Builder;
import controllers.builder.BuilderSplashTimerController;
import model.Board;
import model.Bullpen;
import model.PieceGroup;
import model.PuzzleLevel;
import view.BuilderPieceGroupView;
import view.BuilderView;
import view.BullpenView;
import view.SplashScreen;

/**
 * @author hejohnson
 *
 */
public class TestBuilderControllers extends MouseTesting {
	PuzzleLevel pl;
	Builder build;
	BuilderView bv;
	Board b;
	Bullpen bp;
	BullpenView bpv;
	
	@Override
	public void setUp(){
		build = new Builder("./imbriusLevelTESTING/");
		build.createPuzzleLevel();
		pl = (PuzzleLevel)build.getCurrentLevel();
		bv = build.getBuilderView();
		pl.setBoard(new Board());
		b = pl.getBoard();
		bp = pl.getBullpen();
		bpv = bv.getBullpenView();
	}
	
	@Override
	public void tearDown(){
		File dir = new File("./imbriusLevelTESTING/");
		for(File file: dir.listFiles()) file.delete();
	}
	
	public void testSplashScreen() {
		SplashScreen splash = new SplashScreen();
		Timer timer = new Timer(2000, new BuilderSplashTimerController(splash, build));
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

	public void testBuilderPieceSpinnerController() {
		PieceGroup pg = bp.getPlayablePieces().get(1);
		BuilderPieceGroupView bpgv = (BuilderPieceGroupView)bpv.getPieceGroupViews()[1];
		assertEquals(0, pg.getNumPieces());
		ChangeEvent ce = new ChangeEvent(bpgv.getSpinner());
		bpgv.getSpinner().setValue(2);
		assertEquals(0, pg.getNumPieces());
		bpgv.getSpinner().getChangeListeners()[0].stateChanged(ce);
		assertEquals(2, pg.getNumPieces());
	}
}
