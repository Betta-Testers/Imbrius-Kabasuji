package model;

import java.util.ArrayList;

import junit.framework.TestCase;
import model.Bullpen;
import model.Piece;
import model.PieceGroup;

/**
 * 
 * @author awharrison
 *
 */


public class TestBullpen extends TestCase {

	ArrayList<PieceGroup> testPlayablePieces= new ArrayList<PieceGroup>();
	ArrayList<PieceGroup> testGetPieces = new ArrayList<PieceGroup>();
	Bullpen testBP1, testBP2, testBP3;
	
	@Override
	protected void setUp() {
		// initialize an unosrted ArrayList to enter to a Bullpen constructor
		testPlayablePieces.add(new PieceGroup(4, 1));
		testPlayablePieces.add(new PieceGroup(2, 1));
		testPlayablePieces.add(new PieceGroup(5, 2));
		testPlayablePieces.add(new PieceGroup(3, 1));
		testPlayablePieces.add(new PieceGroup(1, 1));
		
		// generate a Bullpen with all 35 pieces
		testBP2 = new Bullpen();
	}
	
	@Override 
	protected void tearDown() {
		// currently no tearDown needed
	}
	
	public void testSort() {
		// test that the ArrayList is unsorted
		assertEquals(4, testPlayablePieces.get(0).getPiece().getID());
		assertEquals(2, testPlayablePieces.get(1).getPiece().getID());
		assertEquals(5, testPlayablePieces.get(2).getPiece().getID());
		assertEquals(3, testPlayablePieces.get(3).getPiece().getID());
		assertEquals(1, testPlayablePieces.get(4).getPiece().getID());
//		
		// create a Bullpen with above ArrayList
		testBP1 = new Bullpen(testPlayablePieces);
		
		// test that the ArrayList in the Bullpen is now sorted
		assertEquals(testBP1.getPlayablePieces().get(0).getPiece().getID(), 1);
		assertEquals(testBP1.getPlayablePieces().get(1).getPiece().getID(), 2);
		assertEquals(testBP1.getPlayablePieces().get(2).getPiece().getID(), 3);
		assertEquals(testBP1.getPlayablePieces().get(3).getPiece().getID(), 4);
		assertEquals(testBP1.getPlayablePieces().get(4).getPiece().getID(), 5);	
	}
	
	public void testAddPieces() {
		// test that the randomly generated Bullpen has 10 available pieces
		assertEquals(testBP2.numAvailablePieces(), 0);
		// add a single piece to the Bullpen, test that the number of pieces is 1 greater than before
		testBP2.incrementPiece(1);
		assertEquals(testBP2.numAvailablePieces(), 1);
		
		// add a 5 random pieces to the Bullpen, test that the number of pieces is 5 greater than before
		testBP2.incrementPiece(1);
		testBP2.incrementPiece(2);
		testBP2.incrementPiece(10);
		testBP2.incrementPiece(33);
		testBP2.incrementPiece(21);
		assertEquals(testBP2.numAvailablePieces(), 6);
		
		// ensure that the Bullpen is still sorted when random pieces are added
		for(int i = 1; i < testBP2.numAvailablePieces(); i++) {
			assertEquals(testBP2.getPlayablePieces().get(i).getPiece().getID() >= testBP2.getPlayablePieces().get(i-1).getPiece().getID(), true);
		}
		
		// test that the Bullpen created from the ArrayList has 6 available pieces (pieceGroup with ID 0 has 2 available pieces)
		testBP1 = new Bullpen(testPlayablePieces);
		assertEquals(testBP1.numAvailablePieces(), 6);
		
		// test that the Bullpen created from an empty ArrayList has 0 available pieces 
		testBP3 = new Bullpen(new ArrayList<PieceGroup>());
		assertEquals(testBP3.numAvailablePieces(), 0);
	}
	
	public void testRemovePiece() {
		// test that a Bullpen created from the initialized ArrayList returns true when a pieceGroup that is in it is removed
		testBP1 = new Bullpen(testPlayablePieces);
		assertEquals(testBP1.decrementPiece(5), true);
		
		// since 5 was decremented, the total should decrement by 1
		assertEquals(testBP1.numAvailablePieces(), 5);
		
		// test that the Bullpen returns false when a pieceGroup that is not in it is removed
		try {
			testBP1.decrementPiece(9);
			fail();
		} catch (RuntimeException e) {
			
		}
		assertEquals(testBP1.numAvailablePieces(), 5);
		
		// test that a Bullpen that is created from an empty Arraylist is empty and that a Bullpen created from a non-empty ArrayList is not empty
		testBP3 = new Bullpen(new ArrayList<PieceGroup>());
		assertEquals(testBP3.isEmpty(), true);
		assertEquals(testBP1.isEmpty(), false);
	}

	public void testGets() {
		testBP1 = new Bullpen(testPlayablePieces);
		
		// test that the getPlayablePieces method returns the ArrayList contained in the Bullpen
		testGetPieces = testBP1.getPlayablePieces();
		assertEquals(testGetPieces.size(), 5);
		assertEquals(testGetPieces.get(0).getPiece().getID(), 1);
		assertEquals(testGetPieces.get(1).getPiece().getID(), 2);
		assertEquals(testGetPieces.get(2).getPiece().getID(), 3);
		assertEquals(testGetPieces.get(3).getPiece().getID(), 4);
		assertEquals(testGetPieces.get(4).getPiece().getID(), 5);
		
		// test that the getSelectedPiece method returns null when there is no assigned selectedPiece
		Piece testPiece = testBP1.getSelectedPiece();
		assertEquals(testPiece, null);
		
		// test that the setSelectedPiece method can only assign a piece that exists in the Bullpen
		assertEquals(testBP1.setSelectedPiece(4), true);
		testPiece = testBP1.getSelectedPiece();
		assertEquals(testPiece.getID(), 4);
		assertEquals(testBP1.setSelectedPiece(7), false);
		
		assertEquals(6, testBP1.numAvailablePieces());
		testBP1.decrementPiece(testPiece.getID());
		assertEquals(5, testBP1.numAvailablePieces());
		
	
	}
	
	public void testRuntimeExceptions() {
		// ensure that the exceptions are thrown in the correct instances
		try {
			testBP3 = new Bullpen(-2);
			fail();
		} catch (RuntimeException e) {
			
		}
	}
}