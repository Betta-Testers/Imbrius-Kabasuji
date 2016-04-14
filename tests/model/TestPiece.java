package model;

import junit.framework.TestCase;

import java.awt.Color;


/**
 * 
 * @author ejbosia
 *
 */

public class TestPiece extends TestCase{
	Piece piece, piece2;
	
	@Override
	protected void setUp(){
		piece = new Piece(0);
		piece2 = new Piece(2);
	}
	
	@Override
	protected void tearDown(){
		
	}
	
	
	public void testOrigin(){
		assertEquals(piece.tiles[0], piece.getOriginTile());
	}
	public void testColor(){
		assertEquals(piece.color, new Color(240, 0, 0));
		assertEquals(piece.color, piece.getColor());
	}
	public void testID(){
		assertEquals(piece.ID, piece.getID());
	}
	public void testPieces(){
		for(int i = 0; i < 35; i++){
			new Piece(i);
		}
	}
	
	public void testTileInPiece(){
		assertEquals(piece.tiles[1].getColInPiece(), 1);
		assertEquals(piece.tiles[1].getRowInPiece(), 0);
		
		piece.tiles[1].updateColInPiece(-1);
		piece.tiles[1].updateRowInPiece(-1);
		
		try{
			piece.tiles[0].updateColInPiece(-1);
			fail();
		}catch (RuntimeException e){

		}
		
		try{
			piece.tiles[0].updateRowInPiece(-1);
			fail();
		}catch (RuntimeException e){

		}
		
		
	}
	public void testIncorrectID(){
		try{
			new Piece(-1);
			fail("Incorrect ID");
		}catch (RuntimeException e){

		}
		try{
			new Piece(35);
			fail("Incorrect ID");
		}catch (RuntimeException e){

		}
	}

}
