package model;

import model.Piece;
import model.PieceGroup;
import junit.framework.TestCase;

/**
 * 
 * @author awharrison
 *
 */
@SuppressWarnings("javadoc")
public class TestPieceGroup extends TestCase {
	PieceGroup testPG1, testPG2;
	
	@Override
	protected void setUp() {
		// create two test pieceGroups
		testPG1 = new PieceGroup(1, 1);
		testPG2 = new PieceGroup(15, 5);
	}
	
	@Override 
	protected void tearDown() {
		// currently no tearDown needed
	}
	
	public void testCount() {
		// test that the pieceGroup number of pieces is consistent with the constructor
		assertEquals(testPG1.getNumPieces(), 1);
		assertEquals(testPG2.getNumPieces(), 5);
		
		// test that the pieceGroup with more than 1 piece can be decremented
		assertEquals(testPG1.decrementCount(), true);
		assertEquals(testPG1.getNumPieces(), 0);
		
		// test that the pieceGroup with less than 1 piece cannot be decremented
		assertEquals(testPG1.decrementCount(), false);
		assertEquals(testPG1.getNumPieces(), 0);
		
		// test that the pieceGroup can be incremented
		assertEquals(testPG2.incrementCount(), true);
		assertEquals(testPG2.getNumPieces(), 6);
	}
	
	public void testCompare() {
		// test that the a pieceGroup compared with another returns -1 when its ID is lesser
		assertEquals(testPG1.compareTo(testPG2), -1);
		
		// test that the a pieceGroup compared with another returns 1 when its ID is greater
		assertEquals(testPG2.compareTo(testPG1), 1);
		
		// test that the a pieceGroup compared with another returns 0 when its ID is equal
		PieceGroup testPG3 = new PieceGroup(15, 4);
		assertEquals(testPG2.compareTo(testPG3), 0);
	}
	
	public void testGetPiece() {
		// test that the a pieceGroup can get a piece
		Piece x = testPG1.getPiece();
		assertEquals(testPG1.getPiece().getID(), x.getID());
		assertTrue(testPG2.getPiece().getID() != x.getID());
	}
	
	public void testToString() {
		assertEquals("ID:"+testPG2.ID+"Count:"+testPG2.numPieces, testPG2.toString());
	}
}
