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
	
	public void testCreateLevelCase1(){
//======== CASE 1: Multiple created levels back to back ========
		b.createLevel("Puzzle");
		b.saveLevel();
		m = b.loadLevel(1);
		assertEquals(m.toString(), pl.toString());
		
		b.createLevel("Release");
		b.saveLevel();
		m = b.loadLevel(2);
		assertEquals(m.toString(), rl.toString());
		
		b.createLevel("Lightning");
		b.saveLevel();
		m = b.loadLevel(3);
		assertEquals(m.toString(), ll.toString());
		
//======== CASE 2: Make a level, Don't save, Can't Load ========
		
	}
	
	public void testCreateLevelCase2(){
		
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
