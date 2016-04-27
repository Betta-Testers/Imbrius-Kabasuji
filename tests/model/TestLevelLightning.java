package model;

import app.LevelFactory;
import junit.framework.TestCase;

/**
 * 
 * @author ejbosia
 *
 */
@SuppressWarnings("javadoc")
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
		assertEquals(l.getTotalTime(), 1);
	}
	public void testEndConditions(){
		l.setTotalTime(10);
		assertEquals(l.getTotalTime(), 10);
	}
	public void testToString(){
		assertEquals(l.toString(), "Lightning01"+l.board.toString()+l.bullpen.toString());	
	}

}
