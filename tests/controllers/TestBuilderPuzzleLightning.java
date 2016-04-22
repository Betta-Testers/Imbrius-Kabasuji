package controllers;

import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.Timer;

import model.Board;
import model.Bullpen;
import model.PuzzleLevel;
import model.ReleaseLevel;
import view.BoardView;
import view.BuilderView;
import view.BullpenView;
import view.ButtonGroupView;
import view.LevelPropertiesView;
import view.ReleaseNumberCreationView;
import view.SplashScreen;
import app.Builder;
import controllers.builder.BuilderSplashTimerController;
import junit.framework.TestCase;

public class TestBuilderPuzzleLightning extends TestCase {
	Builder build;
	BuilderView buildView;
	PuzzleLevel lvl;
	Board releaseBoard;
	BoardView boardView;
	BullpenView bpView;
	ReleaseNumberCreationView rncv;
	
	@Override
	public void setUp(){
		new File("./imbriusLevelTESTING/").mkdirs();
		build = new Builder("./imbriusLevelTESTING/");
		build.createReleaseLevel();
		buildView = build.getBuilderView();
		lvl = (PuzzleLevel)build.getCurrentLevel();
		releaseBoard = lvl.getBoard();
		boardView = buildView.getBoardView();
		bpView = buildView.getBullpenView();
		rncv = buildView.getReleaseNumberView();
	}
	
	public void testPuzzleLightningBoard() {
		
	}
}
