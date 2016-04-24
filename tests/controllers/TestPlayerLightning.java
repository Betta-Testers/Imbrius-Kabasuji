package controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.File;

import view.BoardView;
import view.BullpenView;
import view.LevelView;
import model.Board;
import model.BoardTile;
import model.Bullpen;
import model.LightningLevel;
import model.Piece;
import app.Game;
import app.LevelFactory;
import junit.framework.TestCase;

public class TestPlayerLightning extends TestCase {
	
	Game game;
	LightningLevel level;
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
		LightningLevel tempLevel = factory.GenerateBlankLightning(1);
		tempLevel.setTotalTime(50);
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
		level = (LightningLevel) game.getCurrentLevel();
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
	public void testPlacePiece () {
		MouseEvent me;
		/*
		 * initialize board with 36 board tiles and verify
		 */
		for(int i = 0; i < 12; i++) {
			for(int j = 0; j < 3; j++) {
				board.swapTile(new BoardTile(i, j));
			}
		}
		assertEquals(36, board.getNumBoardTiles());
		/*
		 * initialize bullpen
		 */
		bullpen.incrementPiece(1);
		bullpen.setSelectedPiece(1);
		assertEquals(1, bullpen.numAvailablePieces());
		
		/*
		 * create mouse moved to verify piece preview
		 */
		me = new MouseEvent(boardView, 
				MouseEvent.MOUSE_MOVED, 
				System.currentTimeMillis(), 0, 
				1*board.getTileSize(), 
				4*board.getTileSize(), 0, false);
		level.getBoardController().mouseMoved(me);
		assertEquals(Color.GREEN, board.getTileAt(1*board.getTileSize(), 4*board.getTileSize()).getColor());
		assertEquals("board", board.getTileAt(1*board.getTileSize(), 4*board.getTileSize()).getTileType());
		
		/*
		 * create mouse press to place piece
		 */
		me = new MouseEvent(boardView, 
				MouseEvent.MOUSE_RELEASED, 
				System.currentTimeMillis(), 0, 
				1*board.getTileSize(), 
				4*board.getTileSize(), 0, false);
		level.getBoardController().mouseReleased(me);
		assertEquals(Color.BLUE, board.getTileAt(1*board.getTileSize(), 4*board.getTileSize()).getColor());
		assertEquals("lightning", board.getTileAt(1*board.getTileSize(), 4*board.getTileSize()).getTileType());
		assertFalse(level.checkStatus());
		
		/*
		 * place different piece that overlaps 5/6 previous tiles, verify that the number of 
		 * lightning tiles on the board only increases by 1
		 */
		bullpen.incrementPiece(1);
		bullpen.setSelectedPiece(1);
		me = new MouseEvent(boardView, 
				MouseEvent.MOUSE_RELEASED, 
				System.currentTimeMillis(), 0, 
				1*board.getTileSize(), 
				5*board.getTileSize(), 0, false);
		level.getBoardController().mouseReleased(me);
		assertEquals(29, board.getNumBoardTiles() );
		assertFalse(level.checkStatus());
	}
	
	
	//====================== Test Stars Earned ======================//
	public void testStarsEarned() {
		/*
		 * initialize board with 18 board tiles and verify
		 */
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 3; j++) {
				board.swapTile(new BoardTile(i, j));
			}
		}
		assertEquals(18, board.getNumBoardTiles());
		
		/*
		 * timer
		 */
		board.putPieceOnBoard(new Piece(1), 2, 0);
		assertFalse(level.checkStatus()); 
		assertEquals(1, level.getStarsEarned());
		
		board.putPieceOnBoard(new Piece(1), 2, 1);
		assertFalse(level.checkStatus()); 
		assertEquals(2, level.getStarsEarned());
		
		board.putPieceOnBoard(new Piece(1), 2, 2);
		assertTrue(level.checkStatus()); // level is over since all tiles have been marked
		assertEquals(3, level.getStarsEarned());

	}

}
