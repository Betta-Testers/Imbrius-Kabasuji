package app;

import java.io.File;

import junit.framework.TestCase;


public class TestStarMap extends TestCase {
	Builder b;
	
	@Override
	protected void setUp(){
		b = new Builder("./imbriusLevelTESTING/");
		//b.levelData = new StarMap(b.defaultDirectory);
	}
	
	@Override
	protected void tearDown(){
		File dir = new File("./imbriusLevelTESTING/");
		for(File file: dir.listFiles()) file.delete();
	}
	
	public void testSaveAndLoad(){
		//Store some levels in levelData
		b.levelData.put(1, "Puzzle");
		b.levelData.put(2, "Puzzle");
		b.levelData.put(3, "Puzzle");
		b.levelData.put(4, "Puzzle");
		
		//Prove Data is inside levelData
		assertEquals("[1,Puzzle,0],[2,Puzzle,0],[3,Puzzle,0],[4,Puzzle,0]", b.levelData.toString());
		
		//Save levelData to disk
		b.levelData.save();
		
		//Delete information in levelData
		b.levelData = null;
		
		//Prove levelData is empty
		assertEquals(null, b.levelData);
		
		//load the starMap
		b.levelData = b.loadStarMap();
		
		assertEquals("[1,Puzzle,0],[2,Puzzle,0],[3,Puzzle,0],[4,Puzzle,0]", b.levelData.toString() );
	}
	
//	public void testLoad(){
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
