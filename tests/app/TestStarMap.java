package app;

import java.io.File;
import java.io.IOException;

import junit.framework.TestCase;
import model.PuzzleLevel;


public class TestStarMap extends TestCase {
	StarMap starMap;

	@Override
	protected void setUp(){
		//b = new Builder("./imbriusLevelTESTING/");
		starMap = new StarMap("./imbriusLevelTESTING/");
	}

	@Override
	protected void tearDown(){
		File dir = new File("./imbriusLevelTESTING/");
		for(File file: dir.listFiles()) file.delete();
	}

	public void testPut(){
		/**Try to add an invalid ID**/
		boolean placed = starMap.put(0, "Puzzle");
		assertFalse(placed);
		
		/**Try to add a non-existing ID**/
		placed = starMap.put(1,  "Puzzle");
		assertTrue(placed);
		
		/**Try to add to existing ID**/
		placed = starMap.put(1,  "Release");
		assertFalse(placed);
	}
	
	public void testGet(){
		/**Try to access an invalid ID**/
		try{
			starMap.get(-1);
			fail();
		}catch(NullPointerException e){
			assertTrue(true);
		}
		
		/**Try to access an ID that has not been initialized**/
		try{
			starMap.get(2);
			fail();
		}catch(NullPointerException e){
			assertTrue(true);
		}
		
		/**Try to get a valid ID**/
		starMap.put(1, "Puzzle");
		String validID = starMap.get(1);
		assertEquals("Puzzle", validID);
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
	}
	
	public void testGetMaxStars(){
		/**Try to access an invalid ID**/
		int emptyID = starMap.getMaxStars(-1);
		assertEquals(null, emptyID);
		
		/**Try to access an ID that has not been initialized**/
		int badID = starMap.getMaxStars(2);
		assertEquals(null, badID);
		
		/**Try to get a valid ID**/
		starMap.put(1, "Puzzle");
		starMap.setMaxStars(1, 1);
		int validID = starMap.getMaxStars(1);
		assertEquals(1, validID);
	}
	
	
//	void testSaveAndLoad(){
//		//Store some levels in levelData
//
//		try {
//			for(int i=1; i <= 4; i++){
//				b.levelData.put(i, "Puzzle");
//				File file = new File("./imbriusLevelTESTING/"+i+"_Puzzle.Storage");
//				file.createNewFile();
//			}
//		} catch (IOException e) {
//			System.err.println("Could not write test files to disk");
//			e.printStackTrace();
//		}
//
//
//	//Prove Data is inside levelData
//	assertEquals("[1,Puzzle,0],[2,Puzzle,0],[3,Puzzle,0],[4,Puzzle,0]", b.levelData.toString());
//
//	//Delete information in levelData
//	b.levelData = null;
//
//	//Prove levelData is empty
//	assertEquals(null, b.levelData);
//
//	//load the starMap
//	b.levelData = b.loadStarMap();
//
//	assertEquals("[1,Puzzle,0],[2,Puzzle,0],[3,Puzzle,0],[4,Puzzle,0]", b.levelData.toString() );
//}
//
////	public void testLoad(){
//
//	}
//	
//	public void testPut(){
//
//	}
//
//	public void testGet(){
//
//	}
//
//	public void testSetMaxStars(){
//
//	}
//
//	public void testGetMaxStars(){
//
//	}
//
//	public void testKeySet(){
//		
//	}
//
//	public void testLastKey(){
//	}
//
//	public void testIsEmpty(){
//	}
}
