/**
 * 
 */
package controllers;

import java.util.ArrayList;

import junit.framework.TestCase;
import model.Board;
import model.BoardTile;
import model.Bullpen;
import model.EmptyTile;
import model.PieceGroup;
import model.PuzzleLevel;

/**
 * @author hejohnson
 *
 */
public class TestBuilderMoves extends TestCase {

	ArrayList<PieceGroup> playablePieces= new ArrayList<PieceGroup>();
	PuzzleLevel pl;
	Board b;
	Bullpen bp;
	
	public void setUp() {
		for (int i = 1; i<=35; i++) {
			playablePieces.add(new PieceGroup(i, 0));
		}
		pl = new PuzzleLevel(1);
		b = new Board();
		bp = new Bullpen(playablePieces);
		pl.setBoard(b);
		pl.setBullpen(bp);
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
