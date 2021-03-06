package app;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import junit.framework.TestCase;

/**
 * @author dfontana
 */
@SuppressWarnings("javadoc")
public class TestStarMap extends TestCase {
	StarMap starMap;

	@Override
	protected void setUp(){
		new File("./imbriusLevelTESTING/").mkdirs();
		starMap = new StarMap("./imbriusLevelTESTING/");
	}

	@Override
	protected void tearDown(){
		File dir = new File("./imbriusLevelTESTING/");
		for(File file: dir.listFiles()) {file.delete();}
		dir.delete();
	}
	
	public void testPopulateFromDirectory(){
		/**Try to populate from non-existent directory, starMap will make it**/
		File dir = new File("./imbriusLevelTESTING/");
		dir.delete();
		StarMap testStarMap = new StarMap("./imbriusLevelTESTING/");
		testStarMap.populateFromDirectory();
		assertTrue(testStarMap.isEmpty());
		
		/**Try to populate from empty directory. Get empty testStarMap**/
		dir = new File("./imbriusLevelTESTING/");
		File[] files = dir.listFiles();
		assertEquals(0,files.length);   //Proven empty directory
		
		testStarMap.populateFromDirectory();
		assertTrue(testStarMap.isEmpty());  //StarMap shouldn't have any values
		
		/**Try to populate from directory with only valid names**/
		LevelFactory factory = new LevelFactory();
		factory.setDirectory("./imbriusLevelTESTING/");
		factory.saveLevel(factory.GeneratePuzzle(1, 1));
		factory.saveLevel(factory.GeneratePuzzle(2, 1));
		files = dir.listFiles();
		assertEquals(2,files.length);   //Proven non-empty directory
		
		testStarMap.populateFromDirectory();
		assertFalse(testStarMap.isEmpty());
		assertEquals("[1,Puzzle,-1],[2,Puzzle,-1]", testStarMap.toString());
		
		/**Try to populate from directory with mix of valid and invalid**/
		Path path = Paths.get("./imbriusLevelTESTING/A_PuzzleLevel_AHardLifeStory.txt");
		Path path2 = Paths.get("./imbriusLevelTESTING/TestingForTheSakeOfTesting.storage");

		try {
			Files.createFile(path);
			Files.createFile(path2);
		} catch (IOException e) {
			System.err.println("Failure to make sample files during test of PopulateFromDirectory() in TestStarMap");
			fail();
		}
		
		testStarMap.populateFromDirectory();
		assertFalse(testStarMap.isEmpty());
		assertEquals("[1,Puzzle,-1],[2,Puzzle,-1]", testStarMap.toString());
	}
	
	public void testPut(){
		/**Try to add an invalid ID**/
		boolean placed = starMap.put(0, "Puzzle");
		assertFalse(placed);
		
		/**Try to add a non-existing ID**/
		placed = starMap.put(1,  "Puzzle");
		assertTrue(placed);
		placed = starMap.put(2,  "Lightning");
		assertTrue(placed);
		placed = starMap.put(3,  "Release");
		assertTrue(placed);
		
		/**Try to add to existing ID**/
		placed = starMap.put(1,  "Release");
		assertFalse(placed);
		
		
		/**Try to add invalid type**/
		placed = starMap.put(4, "MONKEYYYYY");
		assertFalse(placed);
				
	}
	
	public void testGet(){
		/**Try to access an invalid ID**/
		try{
			starMap.get(-1);
			fail();
		}catch(Exception e){
			assertTrue(true);
		}
		
		/**Try to access an ID that has not been initialized**/
		try{
			starMap.get(2);
			fail();
		}catch(Exception e){
			assertTrue(true);
		}
		
		/**Try to get a valid ID**/
		starMap.put(1, "Puzzle");
		try{
			String validID = starMap.get(1);
			assertEquals("Puzzle", validID);
		}catch(Exception e){
			fail();
		}
		
	}
	
	public void testDeleteFromDisk(){
		/**Provide ID that DNE**/
		LevelFactory factory = new LevelFactory();
		factory.setDirectory("./imbriusLevelTESTING/");
		factory.saveLevel(factory.GeneratePuzzle(1, 1));
		factory.saveLevel(factory.GeneratePuzzle(2, 1));
		StarMap testStarMap = new StarMap("./imbriusLevelTESTING/");
		testStarMap.populateFromDirectory();
		
		File dir = new File("./imbriusLevelTESTING/");
		File files[] = dir.listFiles();
		assertEquals(3,files.length);   //Proven non-empty directory
		assertFalse(testStarMap.deleteFromDisk(3));
		files = dir.listFiles();
		assertEquals(3,files.length);   //Directory not changed

		/**Provide ID that Does exist**/
		assertTrue(testStarMap.deleteFromDisk(2));
		files = dir.listFiles();
		assertEquals(2,files.length);   //Directory changed
		assertEquals("[1,Puzzle,-1]",testStarMap.toString());
	}
	
	public void testSetMaxStars(){
		/**Try to set stars of invalid ID**/
		boolean invalidID = starMap.setMaxStars(-1, 3);
		assertFalse(invalidID);
		
		/**Try to set the stars of a non-initialized ID**/
		boolean badID = starMap.setMaxStars(2, 3);
		assertFalse(badID);
		
		/**Try to pass an invalid starCount to an ID**/
		starMap.put(1, "Puzzle");
		boolean badStar = starMap.setMaxStars(1, 4);
		assertFalse(badStar);
		badStar = starMap.setMaxStars(1, -1);
		assertFalse(badStar);
	}
	
	public void testGetMaxStars(){
		/**Try to access an invalid ID, should throw exception**/
		try{
			starMap.getMaxStars(2);
			fail();
		}catch(Exception e){
			assertTrue(true);
		}
		
		/**Try to get a valid ID**/
		starMap.put(1, "Puzzle");
		starMap.setMaxStars(1, 1);
		
		try {
			int validID = starMap.getMaxStars(1);
			assertEquals(1, validID);
		} catch (Exception e) {
			fail();
		}
		
	}
	
	public void testKeySet(){
		/**Test an empty KeySet, expecting empty arrayList**/
		ArrayList<Integer> expected = new ArrayList<Integer>();
		assertTrue(starMap.isEmpty());
		assertEquals(expected,starMap.keySet());
		assertEquals(expected.toString(),starMap.keyToString());
		
		/**Add a bunch of information to the keySet**/
		starMap.put(1, "Puzzle");
		starMap.put(2, "Puzzle");
		starMap.put(3, "Puzzle");
		starMap.put(4, "Puzzle");
		
		/**Get the keySet, match against the known, expected value**/
		expected = new ArrayList<Integer>();
		expected.add(1);
		expected.add(2);
		expected.add(3);
		expected.add(4);
		assertEquals(expected,starMap.keySet());
		assertEquals(expected.toString(),starMap.keyToString());
	}
	
	public void testUnlockedLevels(){
		/**Test an Empty StarMap**/
		ArrayList<Integer> expected = new ArrayList<Integer>();
		assertTrue(starMap.isEmpty());
		assertEquals(expected,starMap.unlockedLevels());
		assertEquals(expected.toString(),starMap.unlockedLevels().toString());
		
		/**Test a StarMap with no extra unlocked levels (The first level always is)**/
		starMap.put(1, "Puzzle");
		starMap.put(2, "Puzzle");
		starMap.put(3, "Puzzle");
		starMap.put(4, "Puzzle");
		expected.add(1);
		assertFalse(starMap.isEmpty());
		assertEquals(expected,starMap.unlockedLevels());
		assertEquals(expected.toString(),starMap.unlockedLevels().toString());
		
		/**Test a StarMap with a few unlocked levels**/
		starMap.setMaxStars(2, 3);
		starMap.setMaxStars(3, 2);
		starMap.setMaxStars(4, 1);
		starMap.put(5, "Puzzle");
		expected.add(2);
		expected.add(3);
		expected.add(4);
		assertFalse(starMap.isEmpty());
		assertEquals(expected,starMap.unlockedLevels());
		assertEquals(expected.toString(),starMap.unlockedLevels().toString());
	}
	
	public void testLastID(){
		/**Get the last ID of an empty StarMap. Should return 0**/
		assertTrue(starMap.isEmpty());
		//NOTE the cast is because JUnit doesn't know how to handle int vs Integer compares
		assertEquals((Integer)0, starMap.lastID());
		
		/**Get the last ID of a non-empty StarMap.**/
		starMap.put(1, "Puzzle");
		starMap.put(2, "Puzzle");
		starMap.put(3, "Puzzle");
		assertEquals((Integer)3, starMap.lastID());
		
	}
	
	public void testNextOpenID(){
		/**Get the next open key from an Empty Star Map**/
		assertEquals((Integer)1, starMap.nextOpenID());
		
		/**Get next open key from broken starMap**/
		starMap.put(1, "Puzzle");
		starMap.put(3, "Puzzle");
		assertEquals((Integer)2, starMap.nextOpenID());
		
		/**Get next open key from full starMap**/
		starMap.put(2, "Puzzle");
		assertEquals((Integer)4, starMap.nextOpenID());
		
	}
	
	public void testLowestNoStarLevel(){
		/**Call on an empty map**/
		assertEquals((Integer)1, starMap.lowestNoStarLevel());
		
		/**Call on starMap with 1 as lowest entry**/
		starMap.put(1, "Puzzle");
		starMap.put(2, "Puzzle");
		assertEquals((Integer)1, starMap.lowestNoStarLevel());
		
		/**Call on starMap whose earlier level has stars**/
		starMap.setMaxStars(1, 1);
		assertEquals((Integer)2, starMap.lowestNoStarLevel());
	}
	
	public void testIsEmpty(){
		/**True for empty**/
		assertTrue(starMap.isEmpty());
		/**False for not empty**/
		starMap.put(1, "Puzzle");
		assertFalse(starMap.isEmpty());
	}
	
	public void testContainsKey(){
		/**Test an empty starMap**/
		assertTrue(starMap.isEmpty());
		assertFalse(starMap.containsKey(1));
		
		/**Test StarMap with non-existent key**/
		starMap.put(1, "Puzzle");
		assertFalse(starMap.containsKey(2));
		
		/**Test StarMap with key**/
		starMap.put(2, "Puzzle");
		assertTrue(starMap.containsKey(2));
	}
	
	public void testToString(){
		/** Empty starMap**/
		assertTrue(starMap.isEmpty());
		assertEquals("",starMap.toString());
		/** Non-Empty starMap **/
		starMap.put(1, "Puzzle");
		starMap.put(2, "Puzzle");
		starMap.put(3, "Puzzle");
		starMap.setMaxStars(1, 2);
		starMap.setMaxStars(2, 3);
		assertEquals("[1,Puzzle,2],[2,Puzzle,3],[3,Puzzle,-1]",starMap.toString());
	}

}
