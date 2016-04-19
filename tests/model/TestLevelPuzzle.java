package model;

import junit.framework.TestCase;

/**
 * 
 * @author Evan
 *
 */
public class TestLevelPuzzle extends TestCase {
	PuzzleLevel p;
	@Override
	protected void setUp(){
		p = new PuzzleLevel(0);
	}
	
	@Override
	protected void tearDown(){
		
	}
	
	public void testInitialization(){
		assertEquals(p.movesMade, 0);
		assertEquals(p.moveLimit, 0);
	}
	
	public void testMoveLimit(){
		assertEquals(p.moveLimit, 0);
		p.setMoveLimit(9);
		assertEquals(p.moveLimit, 9);
	}
	
	public void testEndConditions(){
		p.incrementMovesMade();
		assertEquals(p.movesMade, 1);	
	}
	public void testToString(){
		assertEquals(p.toString(), "Puzzle00");	
	}
	/**
	 * TODO: Check status
	 */
	public void testCheckStatus(){
		//l.checkStatus();
	}
}
