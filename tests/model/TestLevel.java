package model;

import java.io.File;
import java.io.IOException;

import junit.framework.TestCase;

public class TestLevel extends TestCase {
	File f;
	@Override
	protected void setUp(){
		try {
			f = File.createTempFile("FOO", "BAR");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void tearDown(){
		
	}
	
	public void testLightningLevel(){
		LightningLevel l = new LightningLevel(0);
		assertEquals(l.getTotalTime(), 0);
		
		l.setTotalTime(10);
		assertEquals(l.getTotalTime(), 10);
		
		assertEquals(l.getPiecesToGen(), 0);
		assertEquals(l.toString(), "Lightning0100");
		//l.decrementUnmarked(0);	
		
		//l.checkStatus();
	}
	
	public void testPuzzleLevel(){
		PuzzleLevel p = new PuzzleLevel(0);
		
		//check initial conditions
		assertEquals(p.movesMade, 0);
		assertEquals(p.moveLimit, 0);
		
		p.incrementMovesMade();
		assertEquals(p.movesMade, 1);
		
		
		
	}
	
	public void testReleaseLevel(){
		ReleaseLevel l = new ReleaseLevel(0);
	}
	
	
	
}
