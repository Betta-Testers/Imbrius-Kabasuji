/**
 * 
 */
package controllers;

import java.io.File;

import javax.swing.event.ChangeEvent;

import app.Builder;
import model.Board;
import model.Bullpen;
import model.PieceGroup;
import model.PuzzleLevel;
import model.ReleaseLevel;
import view.BuilderPieceGroupView;
import view.BuilderView;
import view.BullpenView;

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
	
	public void testBuilderPieceSpinnerController() {
		PieceGroup pg = bp.getPlayablePieces().get(1);
		BuilderPieceGroupView bpgv = (BuilderPieceGroupView)bpv.getPieceGroupView(1);
		assertEquals(0, pg.getNumPieces());
		ChangeEvent ce = new ChangeEvent(bpgv.getSpinner());
		bpgv.getSpinner().setValue(2);
		assertEquals(0, pg.getNumPieces());
		bpgv.getSpinner().getChangeListeners()[0].stateChanged(ce);
		assertEquals(2, pg.getNumPieces());
	}
}
