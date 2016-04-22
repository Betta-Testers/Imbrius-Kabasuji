package controllers;

import java.io.File;

import model.Board;
import model.PuzzleLevel;
import view.BuilderView;
import app.Builder;
import junit.framework.TestCase;

public class TestBuilderBoard extends TestCase {
	
	PuzzleLevel pl;
	Builder build;
	BuilderView bv;
	Board b;
	
	@Override
	public void setUp(){
		new File("./imbriusLevelTESTING/").mkdirs();
		build = new Builder("./imbriusLevelTESTING/");
		build.createPuzzleLevel();
		pl = (PuzzleLevel)build.getCurrentLevel();
		bv = build.getBuilderView();
		pl.setBoard(new Board());
		b = pl.getBoard();
	}
	
	@Override
	public void tearDown(){
		File dir = new File("./imbriusLevelTESTING/");
		for(File file: dir.listFiles()) file.delete();
		dir.delete();
	}

}
