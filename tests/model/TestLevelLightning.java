package model;

import app.LevelFactory;
import junit.framework.TestCase;

/**
 * 
 * @author Evan
 *
 */
public class TestLevelLightning extends TestCase {
	LightningLevel l;
	@Override
	protected void setUp(){
		l = (new LevelFactory()).GenerateBlankLightning(0);
	}
	
	@Override
	protected void tearDown(){
		
	}
	
	public void testInitialization(){
		assertEquals(l.getTotalTime(), 0);
	}
	public void testEndConditions(){
		l.setTotalTime(10);
		assertEquals(l.getTotalTime(), 10);
	}
	public void testToString(){
		assertEquals(l.toString(), "Lightning00"+l.board.toString()+l.bullpen.toString());	
	}
	/**
	 * TODO: Check status
	 */
	public void testCheckStatus(){
		//l.checkStatus();
	}
}
