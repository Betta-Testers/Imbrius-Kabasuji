package app;

import java.io.File;

import model.AbstractLevelModel;
import model.Board;
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
		new File("./imbriusLevelTESTING/").mkdirs();
		game = new Game("./imbriusPlayerTESTING/");
		try {
			alm = game.loadLevel(1);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		b = alm.getBoard();
	}
	
	@Override
	public void tearDown(){
		File dir = new File("./imbriusPlayerTESTING/");
		for(File file: dir.listFiles()) file.delete();
		dir.delete();
	}
}
