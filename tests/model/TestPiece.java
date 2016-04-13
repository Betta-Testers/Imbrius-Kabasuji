package model;


import static org.junit.Assert.*;

import junit.framework.TestCase;

import java.awt.Color;

import junit.framework.TestCase;

/**
 * 
 * @author ejbosia
 *
 */

public class TestPiece extends TestCase{
	Piece piece, piece2;
	
	@Override
	protected void setUp(){
		piece = new Piece(0, Color.blue);
		piece2 = new Piece(2, Color.red);
	}
	
	@Override
	protected void tearDown(){
		
	}
	
	
	public void testOrigin(){
		assertEquals(piece.origin, piece.tiles[0]);
		assertEquals(piece.origin, piece.getOrigin());
	}
	public void testColor(){
		assertEquals(piece.color, Color.blue);
		assertEquals(piece.color, piece.getColor());
	}
	public void testID(){
		assertEquals(piece.ID, piece.getID());
	}
	public void testPieces(){
		for(int i = 0; i < 35; i++){
			new Piece(i, Color.blue);
		}
	}
	public void testIncorrectID(){
		try{
			Piece p = new Piece(-1, Color.blue);
			fail("Incorrect ID");
		}catch (RuntimeException e){

		}
		try{
			Piece p = new Piece(35, Color.blue);
			fail("Incorrect ID");
		}catch (RuntimeException e){

		}
	}

}
