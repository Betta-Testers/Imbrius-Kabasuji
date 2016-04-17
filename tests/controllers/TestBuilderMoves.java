/**
 * 
 */
package controllers;

import java.io.File;
import java.util.ArrayList;

import app.Builder;
import app.LevelFactory;
import app.StarMap;
import junit.framework.TestCase;
import model.AbstractLevelModel;
import model.Board;
import model.BoardTile;
import model.Bullpen;
import model.EmptyTile;
import model.LightningLevel;
import model.PieceGroup;
import model.PuzzleLevel;
import model.ReleaseLevel;

/**
 * @author hejohnson
 *
 */
public class TestBuilderMoves extends TestCase {

	PuzzleLevel pl;
	AbstractLevelModel m;
	Builder b;
	
	@Override
	public void setUp(){
		b = new Builder("./imbriusLevelTESTING/");
		b.levelData = new StarMap("./imbriusLevelTESTING/");
		
		b.createLevel("Puzzle");
		b.saveLevel();
		pl = b.loadLevel(1);
	}
	
	@Override
	public void tearDown(){
		File dir = new File("./imbriusLevelTESTING/");
		for(File file: dir.listFiles()) file.delete();
	}
	
	public void testSwapBoardAndEmpty() {
		Move m;
		m = new SwapTileEmptyToBoardMove((EmptyTile)b.getTileAt(16, 16), pl);
		m.doMove();
		assertEquals(1, b.getNumBoardTiles());
		m.undo();
		assertEquals(0, b.getNumBoardTiles());
		
		b.swapTile(new BoardTile(0, 0));
		assertEquals(1, b.getNumBoardTiles());
		m = new SwapTileBoardToEmptyMove((BoardTile)b.getTileAt(0, 0), pl);
		m.doMove();
		assertEquals(0, b.getNumBoardTiles());
		m.undo();
		assertEquals(1, b.getNumBoardTiles());
	}
	
	public void testSwapBoardAndRelease() {
		
	}

}
