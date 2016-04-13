package model;

import java.awt.Color;

import junit.framework.TestCase;

/**
 * 
 * @author hejohnson
 *
 */

public class TestTiles extends TestCase {
	public void testBoardTile() {
		BoardTile bt = new BoardTile(1, 1);
		
		bt.setMouseOverColor(true);
		assertEquals(Color.GREEN, bt.color);
		bt.setMouseOverColor(false);
		assertEquals(Color.RED, bt.color);
		bt.resetColor();
		assertEquals(Color.WHITE, bt.color);
		
		assertEquals("board", bt.toString());
		
		
	}
	
	public void testReleaseTile() {
		ReleaseTile rt = new ReleaseTile(1, 1, 4, Color.BLUE);
		assertEquals(Color.BLUE, rt.getColorSet());
		assertEquals(4, rt.getNumber());
		assertEquals("release", rt.toString());
	}
	
	public void testSimpleTiles() {
		EmptyTile et = new EmptyTile(1,1);
		assertEquals(Color.LIGHT_GRAY, et.color);
		assertEquals("empty", et.toString());
		
		LightningTile lt = new LightningTile(1,1);
		assertEquals(Color.GREEN, lt.color);
		assertEquals("lightning", lt.toString());
		
		HintTile ht = new HintTile(1,1);
		assertEquals(Color.DARK_GRAY, ht.color);
		assertEquals("hint", ht.toString());
	}
	
	public void testPieceTile() {
		Piece piece = new Piece(0);
		PieceTile pt = new PieceTile(1, 1, piece);
		
		PieceTile pt2 = new PieceTile(1, 1, piece);
		//assertEquals(Color.WHITE, pt.color); //Doesn't make sense to test yet since there's no piece to get the color from
		assertEquals("piece", pt.toString());
	}
	
}
