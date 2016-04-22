package controllers;

import java.io.File;
import model.Board;
import model.PuzzleLevel;
import view.BoardView;
import view.BuilderView;
import view.BullpenView;
import app.Builder;
import junit.framework.TestCase;

public class TestBuilderPuzzleLightning extends TestCase {
	Builder build;
	BuilderView buildView;
	PuzzleLevel lvl;
	Board releaseBoard;
	BoardView boardView;
	BullpenView bpView;
	
	@Override
	public void setUp(){
		new File("./imbriusLevelTESTING/").mkdirs();
		build = new Builder("./imbriusLevelTESTING/");
		build.createPuzzleLevel();
		buildView = build.getBuilderView();
		lvl = (PuzzleLevel)build.getCurrentLevel();
		releaseBoard = lvl.getBoard();
		boardView = buildView.getBoardView();
		bpView = buildView.getBullpenView();
	}
	
	public void testPuzzleLightningBoard() {
		
	}
}
