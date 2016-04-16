package app;

import java.io.File;
import java.io.IOException;

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

		try {
			for(int i=1; i <= 4; i++){
				b.levelData.put(i, "Puzzle");
				File file = new File("./imbriusLevelTESTING/"+i+"_Puzzle.Storage");
				file.createNewFile();
			}
		} catch (IOException e) {
			System.err.println("Could not write test files to disk");
			e.printStackTrace();
		}


	//Prove Data is inside levelData
	assertEquals("[1,Puzzle,0],[2,Puzzle,0],[3,Puzzle,0],[4,Puzzle,0]", b.levelData.toString());

	//Delete information in levelData
	b.levelData = null;

	//Prove levelData is empty
	assertEquals(null, b.levelData);

	System.out.println("About to test load");
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
