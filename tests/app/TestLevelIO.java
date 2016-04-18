package app;

import java.io.File;

import junit.framework.TestCase;

public class TestLevelIO extends TestCase {
	@Override
	protected void setUp(){

	}
	
	@Override
	protected void tearDown(){
		File dir = new File("./imbriusLevelTESTING/");
		for(File file: dir.listFiles()) file.delete();
	}
}
