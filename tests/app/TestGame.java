package app;

import java.io.File;

import junit.framework.TestCase;

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
}
