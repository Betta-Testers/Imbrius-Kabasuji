package controllers;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.io.File;

import view.BoardView;
import view.BullpenView;
import view.LevelView;
import model.Board;
import model.BoardTile;
import model.Bullpen;
import model.Piece;
import model.PieceFactory;
import model.ReleaseLevel;
import model.ReleaseTile;
import app.Game;
import app.LevelFactory;
import junit.framework.TestCase;


@SuppressWarnings("javadoc")
public class TestPlayerRelease extends TestCase {
	
	Game game;
	ReleaseLevel level;
	LevelView levelView;
	Board board;
	BoardView boardView;
	Bullpen bullpen;
	BullpenView bullpenView;
	LevelFactory factory;
	
	
	@Override
	public void setUp() {
		/*
		 * create a single puzzle level 
		 */
		new File("./imbriusLevelTESTING/").mkdirs();
		factory = new LevelFactory();
		factory.setDirectory("./imbriusLevelTESTING/");
		ReleaseLevel tempLevel = factory.GenerateBlankRelease(1);
		factory.saveLevel(tempLevel);
		factory.addToData(tempLevel, 1);
		
		/*
		 * load and display the level in a game
		 */
		game = new Game("./imbriusLevelTESTING/");
		game.displayLevel(1);
		
		/*
		 * set attributes for this test class
		 */
		level = (ReleaseLevel) game.getCurrentLevel();
		levelView = game.getLevelView();
		board = level.getBoard();
		bullpen = level.getBullpen();
		boardView = levelView.getBoardView();
		bullpenView = levelView.getBullpenView();
		
	}
	
	@Override
	public void tearDown() {
		File dir = new File("./imbriusLevelTESTING/");
		for(File file: dir.listFiles()) {file.delete();}
		dir.delete();
	}
	
	//====================== Tile Placements ======================//
	public void testPlacePieceAndStars() {
		MouseEvent me;
		/*
		 * initialize board with 18 release tiles and 18 board tiles and verify
		 */
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 3; j++) {
				board.swapTile(new BoardTile(i, j));
			}
		}
		
		// Blue tiles
		for(int i = 1; i <= 6; i++) {
			board.swapTile(new ReleaseTile(i-1, 3, i, Color.BLUE));
		}
		
		// Red tiles
		for(int i = 1; i <= 6; i++) {
			board.swapTile(new ReleaseTile(i-1, 4, i, Color.RED));
		}
		
		// Green tiles
		for(int i = 1; i <= 6; i++) {
			board.swapTile(new ReleaseTile(i-1, 5, i, Color.GREEN));
		}
		
		assertEquals(18, board.getNumBoardTiles());
		
		/*
		 * initialize bullpen
		 */
		bullpen.incrementPiece(1);
		bullpen.incrementPiece(1);
		bullpen.incrementPiece(1);
		bullpen.incrementPiece(1);
		bullpen.setSelectedPiece(PieceFactory.getInstance().getPiece(1));;
		
		
		/*
		 * create mouse moved to show preview
		 */
		me = new MouseEvent(boardView, 
				MouseEvent.MOUSE_MOVED, 
				System.currentTimeMillis(), 0, 
				3*board.getTileSize(), 
				2*board.getTileSize(), 0, false);
		level.getBoardController().mouseMoved(me);
		assertEquals(Color.GREEN, board.getTileAt(3*board.getTileSize(), 2*board.getTileSize()).getColor());
		assertEquals("release", board.getTileAt(3*board.getTileSize(), 2*board.getTileSize()).getTileType());
		
		/*
		 * release Blues
		 */
		me = new MouseEvent(boardView, 
				MouseEvent.MOUSE_PRESSED, 
				System.currentTimeMillis(), 0, 
				3*board.getTileSize(), 
				2*board.getTileSize(), 0, false);
		level.getBoardController().mousePressed(me);
		assertFalse(level.checkStatus());
		assertEquals(1, level.getStarsEarned());
		
		/*
		 * release Reds
		 */
		me = new MouseEvent(boardView, 
				MouseEvent.MOUSE_PRESSED, 
				System.currentTimeMillis(), 0, 
				4*board.getTileSize(), 
				2*board.getTileSize(), 0, false);
		bullpen.setSelectedPiece(PieceFactory.getInstance().getPiece(1));
		level.getBoardController().mousePressed(me);
		assertFalse(level.checkStatus());
		assertEquals(2, level.getStarsEarned());
		
		/*
		 * release Greens
		 */
		me = new MouseEvent(boardView, 
				MouseEvent.MOUSE_PRESSED, 
				System.currentTimeMillis(), 0, 
				5*board.getTileSize(), 
				2*board.getTileSize(), 0, false);
		bullpen.setSelectedPiece(PieceFactory.getInstance().getPiece(1));
		level.getBoardController().mousePressed(me);
		assertTrue(level.checkStatus());
		assertEquals(3, level.getStarsEarned());
	}
}
