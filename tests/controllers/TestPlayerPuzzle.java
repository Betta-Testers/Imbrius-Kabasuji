package controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.File;

import controllers.common.Move;
import view.BoardView;
import view.BullpenView;
import view.LevelView;
import model.Board;
import model.BoardTile;
import model.Bullpen;
import model.PuzzleLevel;
import app.Game;
import app.LevelFactory;
import junit.framework.TestCase;

public class TestPlayerPuzzle extends TestCase {
	
	Game game;
	PuzzleLevel level;
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
		PuzzleLevel tempLevel = factory.GenerateBlankPuzzle(1);
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
		level = (PuzzleLevel) game.getCurrentLevel();
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
	
	//====================== Bullpen Piece Select Test ======================//
	public void testSelectBullpenPiece() {
		/*
		 * initialize bullpen to have 1 piece available (ID = 1)
		 */
		bullpen.incrementPiece(1);
		assertEquals(1, bullpen.numAvailablePieces());
		assertEquals(null, bullpen.getSelectedPiece());
		
		
		/*
		 * create action event to select the piece group view, handle mouse event
		 */
		ActionEvent ae = new ActionEvent(bullpenView.getPieceGroupViews()[0].getSelectPieceButton(), ActionEvent.ACTION_PERFORMED, "stuff");
		bullpenView.getPieceGroupViews()[0].getPieceSelectHandler().actionPerformed(ae);
		

		/*
		 * verify that the correct piece was selected
		 */
		assertEquals(bullpen.getPlayablePieces().get(0).getPiece(), bullpen.getSelectedPiece());
	}
	
	//====================== Tile Placements (both pass and fail) ======================//
	public void testPlacePiece () {
		MouseEvent me;
		/*
		 * initialize board with 144 board tiles and verify
		 */
		for(int i = 0; i < 12; i++) {
			for(int j = 0; j < 12; j++) {
				board.swapTile(new BoardTile(i, j));
			}
		}
		assertEquals(144, board.getNumBoardTiles());
		
		/*
		 * Create mouse event for moving the mouse over the board
		 */
		me = new MouseEvent(boardView, 
				MouseEvent.MOUSE_MOVED, 
				System.currentTimeMillis(), 0, 
				boardView.getX(), 
				boardView.getY(), 0, false);
		
		/*
		 * verify that the board has no reaction when there is no selected piece in the bullpen
		 */
		level.getBoardController().mouseMoved(me);
		assertEquals(Color.WHITE, board.getTileAt(boardView.getX(), boardView.getY()).getColor());
		assertEquals("board", board.getTileAt(boardView.getX(), boardView.getY()).getTileType());
		
		/*
		 * initialize bullpen with a piece with ID 1
		 */
		bullpen.incrementPiece(1);
		bullpen.setSelectedPiece(1);
		assertEquals(1, bullpen.numAvailablePieces());
		
		/*
		 * verify that the board reacts when there is a selected piece in the bullpen (shows a piece preview)
		 */
		level.getBoardController().mouseMoved(me);
		assertEquals(Color.GREEN, board.getTileAt(boardView.getX(), boardView.getY()).getColor());
		assertEquals("board", board.getTileAt(boardView.getX(), boardView.getY()).getTileType());
		
		/*
		 * created mouse entered event
		 */
		me = new MouseEvent(boardView, 
				MouseEvent.MOUSE_ENTERED, 
				System.currentTimeMillis(), 0, 
				boardView.getX(), 
				boardView.getY(), 0, false);
		
		/*
		 * enter board
		 */
		level.getBoardController().mouseEntered(me);
		
		/*
		 * create a mouse event that will press on the board
		 */
		me = new MouseEvent(boardView, 
				MouseEvent.MOUSE_PRESSED, 
				System.currentTimeMillis(), 0, 
				boardView.getX(), 
				boardView.getY(), 0, false);
		/*
		 * press on the board
		 */
		level.getBoardController().mousePressed(me);
		
		/*
		 * create a mouse event that will release on the board
		 */
		me = new MouseEvent(boardView, 
				MouseEvent.MOUSE_RELEASED, 
				System.currentTimeMillis(), 0, 
				boardView.getX(), 
				boardView.getY(), 0, false);
		
		/*
		 * release on the board
		 */
		level.getBoardController().mouseReleased(me);
		assertEquals("piece", board.getTileAt(boardView.getX(), boardView.getY()).getTileType());
		
		/*
		 * set a another piece to place
		 */
		bullpen.incrementPiece(1);
		bullpen.setSelectedPiece(1);
		assertEquals(1, bullpen.numAvailablePieces());
		
		/*
		 * show that piece preview is red when it cannot fit
		 */
		me = new MouseEvent(boardView, 
				MouseEvent.MOUSE_MOVED, 
				System.currentTimeMillis(), 0, 
				0, 
				0, 0, false);
		level.getBoardController().mouseMoved(me);
		assertEquals(Color.RED, board.getTileAt(0, 0).getColor());
		
		/*
		 * Verify that placing a piece is unsuccessful
		 */
		me = new MouseEvent(boardView, 
				MouseEvent.MOUSE_PRESSED, 
				System.currentTimeMillis(), 0, 
				0, 
				0, 0, false);
		level.getBoardController().mousePressed(me);
		me = new MouseEvent(boardView, 
				MouseEvent.MOUSE_RELEASED, 
				System.currentTimeMillis(), 0, 
				0, 
				0, 0, false);
		level.getBoardController().mouseReleased(me);
		assertEquals("board", board.getTileAt(0, 0).getTileType());
	}
	
	//====================== Test Moving a Piece from Board to Board ======================//
	public void testMovePiece() {
		
	}
	
}
