package app;

import java.io.File;

import junit.framework.TestCase;
import model.AbstractLevelModel;

public class TestLevelIO extends TestCase {
	AbstractLevelModel m;
	Builder b;
	
	@Override
	protected void setUp(){
		new File("./imbriusLevelTESTING/").mkdirs();
		//TODO Pick a version of game or builder to instantiate...
	//	b = new Builder("./imbriusLevelTESTING/");
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
}
