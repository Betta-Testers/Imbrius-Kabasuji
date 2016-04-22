package app;

import java.io.File;

import junit.framework.TestCase;
import model.LightningLevel;

public class TestGame extends TestCase {
	Game g;
	
	@Override
	protected void setUp(){
		new File("./imbriusLevelTESTING/").mkdirs();
		g = new Game("./imbriusLevelTESTING/");
	}
	
	@Override
	protected void tearDown(){
		File dir = new File("./imbriusLevelTESTING/");
		for(File file: dir.listFiles()) {file.delete();}
		dir.delete();
	}
	
	/**
	 * Check that the game successfully loads 15 levels into it's starMap
	 * on creation. This also forces controller and view linkings to run, checking
	 * those for errors in their *initializations*
	 */
//	public void testGame(){
//		/**Test builder opening empty directory**/
//		File dir = new File("./imbriusLevelTESTING/");
//		dir.delete();
//		g = new Game("./imbriusLevelTESTING/");
//		String expected = "";
//		assertEquals(expected, g.levelData.toString());
//		
//		/**Test builder opening a non-empty directory**/
//		(new LevelFactory()).quick15("./imbriusLevelTESTING/");
//		g = new Game("./imbriusLevelTESTING/");
//		expected = "[1,Puzzle,2],[2,Lightning,3],[3,Release,1],[4,Puzzle,2],[5,Lightning,3],[6,Release,1],[7,Puzzle,2],[8,Lightning,3],[9,Release,1],[10,Puzzle,2],[11,Lightning,3],[12,Release,1],[13,Puzzle,2],[14,Lightning,3],[15,Release,1]";
//		assertEquals(expected, g.levelData.toString());
//	}
	
	public void testDisplayLevel(){
		(new LevelFactory()).quick15("./imbriusLevelTESTING/");
		g = new Game("./imbriusLevelTESTING/");
		String expected = "[1,Puzzle,0],[2,Lightning,0],[3,Release,0],[4,Puzzle,0],[5,Lightning,0],[6,Release,0],[7,Puzzle,0],[8,Lightning,0],[9,Release,0],[10,Puzzle,0],[11,Lightning,0],[12,Release,0],[13,Puzzle,0],[14,Lightning,0],[15,Release,0]";
		assertEquals(expected, g.levelData.toString());
		
		/**Try to display a level that DNE**/
		assertTrue(g.displayLevel(1));
		
		/**Try to display a level that does exist**/
		assertFalse(g.displayLevel(16));
	}
	
	public void testUnlockNextLevel(){
		LevelFactory factory = new LevelFactory();
		factory.setDirectory("./imbriusLevelTESTING/");
		LightningLevel ll = factory.GenerateBlankLightning(1);
		factory.saveLevel(ll);
		ll = factory.GenerateBlankLightning(2);
		factory.saveLevel(ll);
		ll = factory.GenerateBlankLightning(3);
		factory.saveLevel(ll);
		
		g = new Game("./imbriusLevelTESTING/");
		g.levelData.setMaxStars(1, 2);
		g.levelData.setMaxStars(2, 1);
		
		assertEquals(3, g.unlockNextLevel());
	}
	
	public void testGetSelectView(){
		assertEquals(g.selectLevel, g.getSelectView());
	}
	
	public void testGetExitView(){
		assertEquals(g.exitLevel, g.getExitView());
	}
	
	public void testGetLevelView(){
		assertEquals(g.levelView, g.getLevelView());
	}
	
	public void testGetCurrentLevel(){
		assertEquals(g.currentLevel, g.getCurrentLevel());
	}
	
	
}
