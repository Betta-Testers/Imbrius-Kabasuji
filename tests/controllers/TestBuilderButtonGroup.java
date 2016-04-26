package controllers;

import java.io.File;

import view.BuilderView;
import app.Builder;
import junit.framework.TestCase;

public class TestBuilderButtonGroup extends TestCase {
	Builder build;
	BuilderView buildView;
	
	@Override
	public void setUp(){
		new File("./imbriusLevelTESTING/").mkdirs();
		build = new Builder("./imbriusLevelTESTING/");
		build.createReleaseLevel();
		buildView = build.getBuilderView();
	}
	
	@Override
	public void tearDown(){
		File dir = new File("./imbriusLevelTESTING/");
		for(File file: dir.listFiles()) file.delete();
		dir.delete();
	}
	
	public void testUndoRedoControllers() {
		/*
		 * post-initialization, both the undo and redo buttons should be inactive
		 */
	}

}
