package app;

import java.io.File;

import junit.framework.TestCase;
import model.AbstractLevelModel;
import model.LightningLevel;
import model.PuzzleLevel;
import model.ReleaseLevel;

public class TestBuilder extends TestCase {
	AbstractLevelModel m;
	Builder b;
	
	@Override
	protected void setUp(){
		new File("./imbriusLevelTESTING/").mkdirs();
		b = new Builder("./imbriusLevelTESTING/");
	}
	
	@Override
	protected void tearDown(){
		File dir = new File("./imbriusLevelTESTING/");
		for(File file: dir.listFiles()) file.delete();
		dir.delete();
	}
	
	/**
	 * Check that the builder successfully loads 15 levels into it's starMap
	 * on creation. This also forces controller and view linkings to run, checking
	 * those for errors in their *initializations*
	 */
	public void testBuilder(){
		/**Test builder opening empty directory**/
		File dir = new File("./imbriusLevelTESTING/");
		dir.delete();
		b = new Builder("./imbriusLevelTESTING/");
		String expected = "";
		assertEquals(expected, b.levelData.toString());
		assertEquals(0,b.getHighestLevelID());
		
		/**Test builder opening a non-empty directory**/
		(new LevelFactory()).quick15("./imbriusLevelTESTING/");
		b = new Builder("./imbriusLevelTESTING/");
		expected = "[1,Puzzle,2],[2,Lightning,3],[3,Release,1],[4,Puzzle,2],[5,Lightning,3],[6,Release,1],[7,Puzzle,2],[8,Lightning,3],[9,Release,1],[10,Puzzle,2],[11,Lightning,3],[12,Release,1],[13,Puzzle,2],[14,Lightning,3],[15,Release,1]";
		assertEquals(expected, b.levelData.toString());
		assertEquals(15,b.getHighestLevelID());
	}
	
	/**
	 * Case 1: Try to make multiple different types of levels in a row
	 * Load each one in. They should load in the exact way they were saved
	 */
	public void testCreateLevelCase1(){
		b.createPuzzleLevel();
		String expected = b.getCurrentLevel().toString();
		b.saveLevel();
		try {
			m = b.loadLevel(1);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		assertTrue(m instanceof PuzzleLevel);
		assertEquals(expected, m.toString());
		
		b.createReleaseLevel();
		expected = b.getCurrentLevel().toString();
		b.saveLevel();
		try {
			m = b.loadLevel(2);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		assertTrue(m instanceof ReleaseLevel);
		assertEquals(expected, m.toString());
		
		b.createLightningLevel();
		expected = b.getCurrentLevel().toString();
		b.saveLevel();
		try {
			m = b.loadLevel(3);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		assertTrue(m instanceof LightningLevel);
		assertEquals(expected, m.toString());	
	}
	
	/**
	 * Case 2: Make a level, but don't save it. Shouldn't be able to load
	 * it.
	 */
	public void testCreateLevelCase2(){
		b.createPuzzleLevel();
		try {
			m = b.loadLevel(1);
			fail();
		} catch (Exception e) {
			assertTrue(true);	
		}
	}

	/**
	 * Case 1: Make a level, save it more than one time. Should not put
	 * into levelData more than once!
	 */
	public void testSaveLevel(){
		b.createPuzzleLevel();
		assertFalse(b.getLevelData().containsKey(1));
		b.saveLevel();
		assertTrue(b.getLevelData().containsKey(1));
		b.saveLevel();
		assertEquals("[1]",b.getLevelData().keyToString());
	}
	
	public void testEditLevel(){
		/**Test editing ID that DNE**/
		assertFalse(b.editLevel(1));
		
		/**Test editing existant ID**/
		b.createPuzzleLevel();
		b.saveLevel();
		assertTrue(b.getLevelData().containsKey(1));
		b.createReleaseLevel();
		b.saveLevel();
		assertTrue(b.getLevelData().containsKey(2));
		b.createLightningLevel();
		b.saveLevel();
		assertTrue(b.getLevelData().containsKey(3));
		assertTrue(b.editLevel(1));
		assertTrue(b.editLevel(2));
		assertTrue(b.editLevel(3));
		
		/**Try editing ID in levelData but couldn't load from disk.
		 * In order for this case to happen, a level would have to have failed
		 * saving, which can't happen. But in a redundancy check, if a level did
		 * save but couldn't be read at another time an exception is thrown.
		 *
		 * To simulate this, I'm telling builder this ID should be on disk. 
		 * It won't be.
		 */
		b.levelData.put(4, "Puzzle");
		b.levelData.put(5, "Release"); 
		b.levelData.put(6, "Lightning"); 
		assertFalse(b.editLevel(4));
		assertFalse(b.editLevel(5));
		assertFalse(b.editLevel(6));
	}
}
