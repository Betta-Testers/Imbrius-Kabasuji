package model;

import app.LevelFactory;
import junit.framework.TestCase;

/**
 * 
 * @author ejbosia
 *
 */
@SuppressWarnings("javadoc")
public class TestLevelRelease extends TestCase {
	ReleaseLevel r;
	@Override
	protected void setUp(){
		r = (new LevelFactory()).GenerateBlankRelease(0);
	}
	
	@Override
	protected void tearDown(){
		
	}
	
	public void testInitialization(){		
		for(int i = 0; i < 6; i++){
			assertEquals(r.reds[i], -1);
			assertEquals(r.blues[i], -1);
			assertEquals(r.greens[i], -1);
		}

	}
	
	public void testAddReleased(){
		r.addToRedReleased(1);
		r.addToBlueReleased(1);
		r.addToGreenReleased(1);
		
		//save state of 1 t
		int[] temp_red = r.reds;
		int[] temp_blue = r.blues;
		int[] temp_green = r.greens;
		
		r.addToRedReleased(1);
		r.addToBlueReleased(1);
		r.addToGreenReleased(1);
		
		assertEquals(temp_red, r.reds);
		assertEquals(temp_blue, r.blues);
		assertEquals(temp_green, r.greens);
	}

	public void testEndConditions(){
		assertTrue(!r.sumIsSix(r.reds));
		assertTrue(!r.sumIsSix(r.blues));
		assertTrue(!r.sumIsSix(r.greens));
		for(int i = 0; i < 6; i++){
			r.addToRedReleased(i+1);
			r.addToBlueReleased(i+1);
			r.addToGreenReleased(i+1);
		}
		assertTrue(r.sumIsSix(r.reds));
		assertTrue(r.sumIsSix(r.blues));
		assertTrue(r.sumIsSix(r.greens));
	}
	
	public void testToString(){
		assertEquals(r.toString(), "Release0falsefalsefalse"+r.board.toString()+r.bullpen.toString());	
	}
}
