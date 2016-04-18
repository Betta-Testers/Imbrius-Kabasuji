package app;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import junit.framework.TestCase;

public class TestLevelIO extends TestCase {
	Builder b;
	
	@Override
	protected void setUp(){
		new File("./imbriusLevelTESTING/").mkdirs();
	}
	
	@Override
	protected void tearDown(){
		File dir = new File("./imbriusLevelTESTING/");
		for(File file: dir.listFiles()) file.delete();
		dir.delete();
	}
	
	/**
	 * When testing LoadStarMap, be sure to have a case where you save
	 * it to disk, DELETE the level, then load the starmap. Also, add a
	 * file that can't be parsed ("uWutm8.txt" and "A_HardKnockLife.storage")
	 */
	
	public void testLoadStarMap(){
		/**Try to load a starMap from an empty folder**/
		File dir = new File("./imbriusLevelTESTING/");
		File files[] = dir.listFiles();
		assertEquals(0, files.length);				//Prove folder empty
		b = new Builder("./imbriusLevelTESTING/");	//Builder calls loadStarMap on initialize
		assertTrue(b.levelData.isEmpty());			//LevelData is empty
		
		/**Add levels to starMap, save the starMap**/
		b.createPuzzleLevel();
		b.saveLevel();
		b.createLightningLevel();
		b.saveLevel();
		
		/**Recreate the builder, should load in two levels**/
		files = dir.listFiles();
		assertEquals(3, files.length);				 //Prove dir has 3 files
		b = new Builder("./imbriusLevelTESTING/");	 //Builder calls loadStarMap on initialize
		assertFalse(b.levelData.isEmpty());			 //LevelData is NOT empty
		assertEquals(2, b.levelData.keySet().size());//LevelData has 2 elements
		assertEquals("[1,Puzzle,0],[2,Lightning,0]", b.levelData.toString());
		
		/**Now delete the level on disk, and add trash to the directory**/
		/**Should have only level 1 in it when all is done**/
		for(int i = 0; i<3; i++){
			if(files[i].getName().equals("1_Puzzle.storage")){
				files[i].delete();
			}
		}
		
		Path path = Paths.get("./imbriusLevelTESTING/A_PuzzleLevel_AHardLifeStory.txt");
		Path path2 = Paths.get("./imbriusLevelTESTING/TestingForTheSakeOfTesting.storage");
		try {
			Files.createFile(path);
			Files.createFile(path2);
		} catch (IOException e) {
			System.err.println("Failure to make sample files during test of PopulateFromDirectory() in TestStarMap");
			fail();
		}
		
		files = dir.listFiles();
		assertEquals(4, files.length);				 //Prove dir has 3 files
		b = new Builder("./imbriusLevelTESTING/");	 //Builder calls loadStarMap on initialize
		assertFalse(b.levelData.isEmpty());			 //LevelData is NOT empty
		assertEquals(1, b.levelData.keySet().size());//LevelData has 1 element
		assertEquals("[2,Lightning,0]", b.levelData.toString());		
	}
}
