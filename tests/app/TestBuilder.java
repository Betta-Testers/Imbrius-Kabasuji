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
		System.out.println(m.toString());
		System.out.println(pl.toString());
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
	
	/**
	 * Case 2: Make a level, but don't save it. Shouldn't be able to load
	 * it. Then verify by trying to load a level that doesn't exist
	 */
	public void testCreateLevelCase2(){
		
		
	}
	
	/**
	 * Case 3: Make a level, load it more than one time. Is the keySet
	 * of StarMap changed? It shouldn't.
	 */
	public void testCreateLevelCase3(){
		
		
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
