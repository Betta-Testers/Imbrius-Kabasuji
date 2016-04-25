package model;

import junit.framework.TestCase;

import java.awt.Color;


/**
 * 
 * @author Evan
 *
 */

public class TestPiece extends TestCase{
	Piece piece, jagged_piece;
	
	@Override
	protected void setUp(){
		piece = new Piece(1);
		jagged_piece = new Piece(14);			
	}
	
	@Override
	protected void tearDown(){
		
	}
	
	//test if get origin tile returns the correct tile
	public void testOrigin(){
		assertEquals(piece.tiles[0], piece.getOriginTile());
	}
	
	//test if the piece is initialized with the correct color
	public void testColor(){
		assertEquals(piece.color, new Color(150, 100, 50));
		assertEquals(piece.color, piece.getColor());
	}
	
	//test if the piece ID matches the integer returned
	public void testID(){
		assertEquals(piece.ID, piece.getID());
	}
	
	//test initializing all pieces
	public void testPieces(){
		for(int i = 1; i < 36; i++){
			new Piece(i);
		}
	}
	
	//test if incorrect ID is used to instantiate piece, a runtime error is thrown
	public void testIncorrectID(){
		try{
			new Piece(0);
			fail("Incorrect ID");
		}catch (RuntimeException e){

		}
		try{
			new Piece(36);
			fail("Incorrect ID");
		}catch (RuntimeException e){

		}
	}
	
	//test if flip horizontal works
	public void testFlipH(){
		Piece temp = new Piece(jagged_piece.getID());
		
		jagged_piece.flipH();
		
		for(int i = 0; i < 6; i++){
			assertEquals(jagged_piece.tiles[i].colInPiece, -temp.tiles[i].colInPiece);
			assertEquals(jagged_piece.tiles[i].rowInPiece, temp.tiles[i].rowInPiece);
		}
		
		jagged_piece.flipH();
		
		assertEquals(jagged_piece.toString(), temp.toString());
	}
	
	//test if flip vertical works
	public void testFlipV(){
		Piece temp = new Piece(jagged_piece.getID());
		
		jagged_piece.flipV();
		
		for(int i = 0; i < 6; i++){
			assertEquals(jagged_piece.tiles[i].colInPiece, temp.tiles[i].colInPiece);
			assertEquals(jagged_piece.tiles[i].rowInPiece, -temp.tiles[i].rowInPiece);
		}
		
		jagged_piece.flipV();
		
		assertEquals(jagged_piece.toString(), temp.toString());
	}
		
	//test each rotate right up to a full rotation
	public void testRotateRight(){
		Piece temp = new Piece(jagged_piece.getID());
		
		jagged_piece.rotateRight();

		for(int i = 0; i < 6; i++){
			assertEquals(jagged_piece.tiles[i].rowInPiece, temp.tiles[i].colInPiece);
			assertEquals(jagged_piece.tiles[i].colInPiece, -temp.tiles[i].rowInPiece);
		}
		
		
		jagged_piece.rotateRight();
		
		for(int i = 0; i < 6; i++){
			assertEquals(jagged_piece.tiles[i].rowInPiece, -temp.tiles[i].rowInPiece);
			assertEquals(jagged_piece.tiles[i].colInPiece, -temp.tiles[i].colInPiece);
		}
		
		jagged_piece.rotateRight();
		
		for(int i = 0; i < 6; i++){
			assertEquals(jagged_piece.tiles[i].rowInPiece, -temp.tiles[i].colInPiece);
			assertEquals(jagged_piece.tiles[i].colInPiece, temp.tiles[i].rowInPiece);
		}
		
		jagged_piece.rotateRight();
		
		assertEquals(jagged_piece.toString(), temp.toString());
	}
	
	//test each rotate left up to a full rotation
	public void testRotateLeft(){
		Piece temp = new Piece(jagged_piece.getID());
		
		jagged_piece.rotateLeft();
		
		for(int i = 0; i < 6; i++){
			assertEquals(jagged_piece.tiles[i].rowInPiece, -temp.tiles[i].colInPiece);
			assertEquals(jagged_piece.tiles[i].colInPiece, temp.tiles[i].rowInPiece);
		}
		
		jagged_piece.rotateLeft();
		
		for(int i = 0; i < 6; i++){
			assertEquals(jagged_piece.tiles[i].rowInPiece, -temp.tiles[i].rowInPiece);
			assertEquals(jagged_piece.tiles[i].colInPiece, -temp.tiles[i].colInPiece);
		}
		
		jagged_piece.rotateLeft();

		for(int i = 0; i < 6; i++){
			assertEquals(jagged_piece.tiles[i].rowInPiece, temp.tiles[i].colInPiece);
			assertEquals(jagged_piece.tiles[i].colInPiece, -temp.tiles[i].rowInPiece);
		}
		
		jagged_piece.rotateLeft();
		
		assertEquals(jagged_piece.toString(), temp.toString());
	}
	
	//test if rotate right and rotate left cancel, as well as out of order flipV's and flipH's
	public void testRotationsFlips(){
		Piece temp = new Piece(jagged_piece.getID());
		
		jagged_piece.rotateLeft();
		jagged_piece.rotateRight();
		
		assertEquals(jagged_piece.toString(), temp.toString());
		
		jagged_piece.flipH();
		jagged_piece.flipV();
		jagged_piece.flipH();
		jagged_piece.flipV();
		
		assertEquals(jagged_piece.toString(), temp.toString());
	}
}
