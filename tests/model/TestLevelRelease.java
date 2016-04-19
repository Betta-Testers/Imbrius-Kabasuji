package model;

import junit.framework.TestCase;

/**
 * 
 * @author Evan
 *
 */
public class TestLevelRelease extends TestCase {
	ReleaseLevel r;
	@Override
	protected void setUp(){
		r = new ReleaseLevel(0);
	}
	
	@Override
	protected void tearDown(){
		
	}
	
	public void testInitialization(){		
		for(int i = 0; i < 6; i++){
			assertEquals(r.reds[i], -1);
			assertEquals(r.blues[i], -1);
			assertEquals(r.yellows[i], -1);
		}

	}
	
	public void testAddReleased(){
		r.addToRedReleased(1);
		r.addToBlueReleased(1);
		r.addToYellowReleased(1);
		
		//save state of 1 t
		int[] temp_red = r.reds;
		int[] temp_blue = r.blues;
		int[] temp_yellow = r.yellows;
		
		r.addToRedReleased(1);
		r.addToBlueReleased(1);
		r.addToYellowReleased(1);
		
		assertEquals(temp_red, r.reds);
		assertEquals(temp_blue, r.blues);
		assertEquals(temp_yellow, r.yellows);
	}
/*	
	public void testInvalidReleased(){
		int[] temp = r.reds;
		
		r.addToRedReleased(0);
		r.addToBlueReleased(0);
		r.addToYellowReleased(0);
		
		assertEquals(temp, r.reds);
		assertEquals(temp, r.blues);
		assertEquals(temp, r.yellows);
	}
*/
	public void testEndConditions(){
		assertTrue(!r.sumIsSix(r.reds));
		assertTrue(!r.sumIsSix(r.blues));
		assertTrue(!r.sumIsSix(r.yellows));
		for(int i = 0; i < 6; i++){
			r.addToRedReleased(i+1);
			r.addToBlueReleased(i+1);
			r.addToYellowReleased(i+1);
		}
		assertTrue(r.sumIsSix(r.reds));
		assertTrue(r.sumIsSix(r.blues));
		assertTrue(r.sumIsSix(r.yellows));
	}
	
	public void testToString(){
		assertEquals(r.toString(), "Release0falsefalsefalse");	
	}
	/**
	 * TODO: Check status
	 */
	public void testCheckStatus(){
		//r.checkStatus();
	}
}
