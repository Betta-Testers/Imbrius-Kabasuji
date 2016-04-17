package model;

import java.io.File;
import java.io.IOException;

import junit.framework.TestCase;

public class TestLevelLightning extends TestCase {
	LightningLevel l;
	@Override
	protected void setUp(){
		l = new LightningLevel(0);
	}
	
	@Override
	protected void tearDown(){
		
	}
	
	public void testInitialization(){
		assertEquals(l.getTotalTime(), 0);
		assertEquals(l.getPiecesToGen(), 0);
	}
	public void testEndConditions(){
		l.setTotalTime(10);
		assertEquals(l.getTotalTime(), 10);
	}
	public void testToString(){
		assertEquals(l.toString(), "Lightning000");	
	}
	/**
	 * TODO: Check status
	 */
	public void testCheckStatus(){
		//l.checkStatus();
	}
}
