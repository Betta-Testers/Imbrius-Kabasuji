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
		LightningLevel l = new LightningLevel(f, 0);
		//l.decrementUnmarked(0);	
	}
	
	public void testPuzzleLevel(){
		PuzzleLevel l = new PuzzleLevel(f, 0);
	}
	
	public void testReleaseLevel(){
		ReleaseLevel l = new ReleaseLevel(f, 0);
	}
	
	
}
