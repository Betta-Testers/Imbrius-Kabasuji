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
		assertEquals("board r:1 c:1", bt.toString());
	}
	
	public void testReleaseTile() {
		ReleaseTile rt = new ReleaseTile(1, 1, 4, Color.BLUE);
		assertEquals(Color.BLUE, rt.getColorSet());
		assertEquals(4, rt.getNumber());
		assertEquals("release r:1 c:1", rt.toString());
		assertEquals(Color.BLUE, rt.getColorSet());
		assertEquals(4, rt.getNumber());
	}
	
	public void testSimpleTiles() {
		EmptyTile et = new EmptyTile(1,1);
		assertEquals(Color.LIGHT_GRAY, et.color);
		assertEquals("empty r:1 c:1", et.toString());
		et.setMouseOverColor(true);
		assertEquals(Color.GREEN, et.color);
		et.resetColor();
		assertEquals(Color.LIGHT_GRAY, et.color);
		
		LightningTile lt = new LightningTile(1,1);
		assertEquals(Color.BLUE, lt.color);
		assertEquals("lightning r:1 c:1", lt.toString());
		
	}
	
	public void testPieceTile() {
		Piece piece = new Piece(1);
		assertNotNull(piece.getColor());
		PieceTile tile = piece.tiles[1];
		PieceTile origin = piece.tiles[0];
		
		assertEquals(tile.getColInPiece(), 0);
		assertEquals(tile.getRowInPiece(), 1);
		
		tile.updateColInPiece(-1);
		tile.updateRowInPiece(-1);
		
		try{
			origin.updateColInPiece(-1);
			fail();
		}catch (RuntimeException e){
			assertEquals(origin.getColInPiece(), 0);
		}
		
		try{
			origin.updateRowInPiece(-1);
			fail();
		}catch (RuntimeException e){
			assertEquals(origin.getRowInPiece(), 0);
		}
		
		assertEquals("piece r:-1 c:-1", tile.toString());
		assertEquals(new Color(240, 0, 0), tile.color);
		
		origin.setLocation(5, 7);
		assertEquals(origin.colOnBoard, 7);
		assertEquals(origin.rowOnBoard, 5);
		
	}
	
}
