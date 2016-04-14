package app;

import java.io.File;

import junit.framework.TestCase;
import model.AbstractLevelModel;
import model.LightningLevel;
import model.PuzzleLevel;
import model.ReleaseLevel;

public class TestBuilder extends TestCase {
	PuzzleLevel pl;
	ReleaseLevel rl;
	LightningLevel ll;
	AbstractLevelModel m;
	Builder b;
	
	@Override
	protected void setUp(){
		pl = new PuzzleLevel(1);
		rl = new ReleaseLevel(2);
		ll = new LightningLevel(3);
		b = new Builder();
		b.defaultDirectory = "./imbriusLevelTESTING/";
		b.levelData = new StarMap();
	}
	
	@Override
	protected void tearDown(){
		File dir = new File("./imbriusLevelTESTING/");
		for(File file: dir.listFiles()) file.delete();
	}
	
	/**
	 * Case 1: Try to make multiple different types of levels in a row
	 * Load each one in. They should load in to be the type they were
	 * saved as.
	 */
	public void testCreateLevelCase1(){
		b.createLevel("Puzzle");
		b.saveLevel();
		m = b.loadLevel(1);
		assertEquals(m.toString(), pl.toString());
		assertTrue(m instanceof PuzzleLevel);
		
		b.createLevel("Release");
		b.saveLevel();
		m = b.loadLevel(2);
		assertEquals(m.toString(), rl.toString());
		assertTrue(m instanceof ReleaseLevel);
		
		b.createLevel("Lightning");
		b.saveLevel();
		m = b.loadLevel(3);
		assertEquals(m.toString(), ll.toString());	
		assertTrue(m instanceof LightningLevel);
	}
	
	public void testCreateLevelCase2(){

		//======== CASE 2: Make a level, Don't save, Can't Load ========
		//======== CASE 3: Load same level multiple times ========
	}
	
	public void testSaveStarMap(){
		
	}
	
	public void testLoadStarMap(){
		
	}
	
	public void testSaveLevel(){
		
	}
	
	public void testLoadLevel(){
		
	}
	
}
