package app;

import junit.framework.TestCase;
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
		b = new Builder();
	}
	
	@Override
	protected void tearDown(){
		b.getBuilderView().dispose();
		b.getLevelTypeSelectView().dispose();
	}
	
	public void testSetModelLevelCreation(){
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
