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
	public void testCreateLevelCase1(){;
		b.createLevel("Puzzle");
		b.saveLevel();
		m = b.loadLevel(1);
		assertEquals(pl.toString(), m.toString());
		assertTrue(m instanceof PuzzleLevel);
		
		b.createLevel("Release");
		b.saveLevel();
		m = b.loadLevel(2);
		assertEquals(rl.toString(), m.toString());
		assertTrue(m instanceof ReleaseLevel);
		
		b.createLevel("Lightning");
		b.saveLevel();
		m = b.loadLevel(3);
		assertEquals(ll.toString(), m.toString());	
		assertTrue(m instanceof LightningLevel);
		
		b.createLevel("Puzzle");
		((PuzzleLevel)b.getCurrentLevel()).setMoveLimit(2);
		b.saveLevel();
		m = b.loadLevel(4);
		assertNotSame(pl.toString(), m.toString());
		assertEquals("Puzzle42", m.toString());
		assertTrue(m instanceof PuzzleLevel);
	}
	
	/**
	 * Case 2: Make a level, but don't save it. Shouldn't be able to load
	 * it.
	 */
	public void testCreateLevelCase2(){
		b.createLevel("Puzzle");
		m = b.loadLevel(0);
		assertEquals(null, m);
		m = b.loadLevel(1);
		assertEquals(null, m);
		m = b.loadLevel(2);
		assertEquals(null, m);
	}
	
	
	public void testSaveStarMap(){
		
	}
	
	public void testLoadStarMap(){
		
	}
	
	/**
	 * Case 1: Make a level, save it more than one time. Should not put
	 * into levelData more than once!
	 */
	public void testSaveLevel(){
		b.createLevel("Puzzle");
		assertFalse(b.getLevelData().containsKey(1));
		b.saveLevel();
		assertTrue(b.getLevelData().containsKey(1));
		b.saveLevel();
		assertEquals("[1]",b.getLevelData().keyToString());
	}
	
	public void testLoadLevel(){
		
	}
	
}
