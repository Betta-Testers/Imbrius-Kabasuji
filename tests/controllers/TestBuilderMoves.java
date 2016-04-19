/**
 * 
 */
package controllers;

import java.awt.Color;
import java.io.File;
import app.Builder;
import junit.framework.TestCase;
import model.Board;
import model.BoardTile;
import model.EmptyTile;
import model.ReleaseLevel;
import model.ReleaseTile;
import view.BuilderView;

/**
 * @author hejohnson
 *
 */
public class TestBuilderMoves extends TestCase {

	ReleaseLevel rl;
	Builder build;
	BuilderView bv;
	Board b;
	
	@Override
	public void setUp(){
		new File("./imbriusLevelTESTING/").mkdirs();
		build = new Builder("./imbriusLevelTESTING/");
		build.createReleaseLevel();
		rl = (ReleaseLevel)build.getCurrentLevel();
		bv = build.getBuilderView();
		rl.setBoard(new Board());
		b = rl.getBoard();
	}
	
	@Override
	public void tearDown(){
		File dir = new File("./imbriusLevelTESTING/");
		for(File file: dir.listFiles()) file.delete();
		dir.delete();
	}
	
	public void testSwapBoardAndEmpty() {
		Move m;
		m = new SwapTileEmptyToBoardMove(bv, (EmptyTile)b.getTileAt(16, 16), rl);
		m.doMove();
		assertEquals(1, b.getNumBoardTiles());
		m.undo();
		assertEquals(0, b.getNumBoardTiles());
		m.redo();
		assertEquals(1, b.getNumBoardTiles());

		assertEquals(1, b.getNumBoardTiles());
		m = new SwapTileBoardToEmptyMove(bv, (BoardTile)b.getTileAt(0, 0), rl);
		m.doMove();
		assertEquals(0, b.getNumBoardTiles());
		m.undo();
		assertEquals(1, b.getNumBoardTiles());
		m.redo();
		assertEquals(0, b.getNumBoardTiles());
	}
	
	public void testSwapBoardAndRelease() {
		Move m;
		b.swapTile(new BoardTile(0, 0));
		m = new SwapTileBoardToReleaseMove(bv, (BoardTile)b.getTileAt(0, 0), rl);
		assertTrue(m.doMove());
		ReleaseTile rt = (ReleaseTile) b.getTileAt(0, 0);
		assertEquals(0, rt.getNumber());
		assertEquals(Color.BLUE, rt.getColorSet());
		assertEquals(0, b.getNumBoardTiles());
		m.undo();
		assertEquals(1, b.getNumBoardTiles());
		m.redo();
		assertEquals(0, b.getNumBoardTiles());
		
		bv.getReleaseNumberView().getColorSelector().setSelectedIndex(1);
		bv.getReleaseNumberView().setSelected(2);
		System.out.println("Number selected: "+bv.getReleaseNumberView().getNumberSelected());
		m = new SwapTileReleaseToReleaseMove(bv, (ReleaseTile)b.getTileAt(0, 0), rl);
		assertTrue(m.doMove());
		rt = (ReleaseTile) b.getTileAt(0, 0);
		assertEquals(3, rt.getNumber());
		assertEquals(Color.YELLOW, rt.getColorSet());
		assertEquals(0, b.getNumBoardTiles());
		m.undo();
		rt = (ReleaseTile) b.getTileAt(0, 0);
		assertEquals(0, rt.getNumber());
		assertEquals(Color.BLUE, rt.getColorSet());
		m.redo();
		rt = (ReleaseTile) b.getTileAt(0, 0);
		assertEquals(3, rt.getNumber());
		assertEquals(Color.YELLOW, rt.getColorSet());	
		
		m = new SwapTileReleaseToBoardMove(bv, (ReleaseTile)b.getTileAt(0, 0), rl);
		assertTrue(m.doMove());
		assertEquals(1, b.getNumBoardTiles());
		assertTrue(m.undo());
		rt = (ReleaseTile) b.getTileAt(0, 0);
		assertEquals(0, b.getNumBoardTiles());
		assertEquals(3, rt.getNumber());
		assertEquals(Color.YELLOW, rt.getColorSet());
		assertTrue(m.redo());
		assertEquals(1, b.getNumBoardTiles());
		
	}

}
