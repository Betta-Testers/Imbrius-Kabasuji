package app;

import java.io.File;

import model.AbstractLevelModel;
import model.Board;
import model.LightningLevel;
import model.PuzzleLevel;
import model.ReleaseLevel;
import app.Game;
import junit.framework.TestCase;

/**
 * 
 * @author awharrison
 *
 */
public class TestPlayerMovesPuzzle extends TestCase {
	Game game;
	AbstractLevelModel alm;
	Board b;
	
	@Override
	public void setUp(){
		game = new Game("./imbriusPlayerTESTING/");
		alm = game.loadLevel(1);
		b = alm.getBoard();
	}
	
	@Override
	public void tearDown(){
		File dir = new File("./imbriusPlayerTESTING/");
		for(File file: dir.listFiles()) file.delete();
	}
}
