package model;

import static org.junit.Assert.*;

import junit.framework.TestCase;

public class TestPieceGroup extends TestCase{
	PieceGroup p;	
	
	@Override
	protected void setUp(){
		p = new PieceGroup(0, 0);
	}
	@Override
	protected void tearDown(){
		
	}

	public void testIncrementCount() {
		assertTrue(p.incrementCount());
		assertEquals(p.numPieces, 1);
	}
	
	public void testDecrementCount(){
		p.incrementCount();
		assertTrue(p.decrementCount());
		assertEquals(p.numPieces, 0);
	}
	
	public void testInvalidDecrementCount(){
		assertTrue(!p.decrementCount());
		assertEquals(p.numPieces, 0);		
	}
	
	public void testGetMethods(){
		assertEquals(p.getPiece(), p.piece);
		assertEquals(p.getNumPieces(), p.numPieces);
	}
}
