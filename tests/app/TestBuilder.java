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
	Builder b;
	
	@Override
	protected void setUp(){
		pl = new PuzzleLevel(1);
		rl = new ReleaseLevel(2);
		ll = new LightningLevel(3);
	}
	
	@Override
	protected void tearDown(){

	}
	
	public void testSetModelLevelCreation(){
		File dir = new File("./imbriusLevelFiles/");
		for(File file: dir.listFiles()) file.delete();
		b = new Builder();
		
		b.setModelLevelCreation("Puzzle");
		b.saveLevel();
		AbstractLevelModel m = b.loadLevel(1);
		PuzzleLevel exp = new PuzzleLevel(1);
		assertEquals(m.toString(), exp.toString());
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
