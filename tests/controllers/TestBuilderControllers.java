package controllers;
import java.io.File;

import javax.swing.Timer;
import javax.swing.event.ChangeEvent;

import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import app.Builder;
import controllers.builder.BuilderPieceSpinnerController;
import controllers.builder.BuilderSplashTimerController;
import controllers.builder.CloseBuilderDialog;
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
 * @author awharrison
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
		assertEquals(1, bv.getWindowListeners().length);
		
		// TODO how to handle created mouse events
		MouseEvent me = new MouseEvent(build.getLevelTypeSelectView(), 
				MouseEvent.MOUSE_CLICKED, 
				System.currentTimeMillis(), 0, 
				build.getLevelTypeSelectView().getX(), 
				build.getLevelTypeSelectView().getY(), 1, false);
		assertEquals(2, build.getLevelTypeSelectView().getCreatePuzzleBtn().getMouseListeners().length);
		
		build.getLevelTypeSelectView().getPuzzleBtnHandler().mouseClicked(me);
		assertTrue(build.getBuilderView().isVisible()); 
		build.getBuilderView().getExitWindowListener().windowClosing(new WindowEvent(bv, WindowEvent.WINDOW_CLOSING));;
	}

	public void testBuilderPieceSpinnerController() {
		PieceGroup pg = bp.getPlayablePieces().get(1);
		BuilderPieceGroupView bpgv = (BuilderPieceGroupView)bpv.getPieceGroupView(1);
		bpgv.addSpinnerChangeListener(new BuilderPieceSpinnerController(bpgv, pg));
		assertEquals(0, pg.getNumPieces());
		ChangeEvent ce = new ChangeEvent(bpgv.getSpinner());
		bpgv.getSpinner().setValue(1);
		assertEquals(1, pg.getNumPieces());
//		bpgv.getSpinnerChangeListener().stateChanged(ce);
		bpgv.getSpinner().setValue(2);
		assertEquals(2, pg.getNumPieces());
//		bpgv.getSpinner().setValue(-1);
//		assertEquals(1, pg.getNumPieces());
	}
}
