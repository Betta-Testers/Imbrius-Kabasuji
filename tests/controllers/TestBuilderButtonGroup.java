package controllers;

import java.awt.event.MouseEvent;
import java.io.File;

import model.Board;
import model.Bullpen;
import model.Piece;
import view.BoardView;
import view.BuilderView;
import view.ButtonGroupView;
import view.PiecePanel;
import view.SelectedPieceView;
import app.Builder;
import junit.framework.TestCase;

public class TestBuilderButtonGroup extends TestCase {
	Builder build;
	BuilderView buildView;
	ButtonGroupView buttonGroup;
	Board board;
	BoardView boardView;
	
	@Override
	public void setUp(){
		new File("./imbriusLevelTESTING/").mkdirs();
		build = new Builder("./imbriusLevelTESTING/");
		build.createReleaseLevel();
		buildView = build.getBuilderView();
		board = build.getCurrentLevel().getBoard();
		boardView = buildView.getBoardView();
		buttonGroup = buildView.getButtonGroup();
	}
	
	@Override
	public void tearDown(){
		File dir = new File("./imbriusLevelTESTING/");
		for(File file: dir.listFiles()) file.delete();
		dir.delete();
	}
	
	public void testUndoRedoBoardTile() {
		MouseEvent me;
		/*
		 * post-initialization, both the undo and redo buttons should be inactive, no board tiles as well
		 */
		assertFalse(buttonGroup.getUndoBtn().isEnabled());
		assertFalse(buttonGroup.getRedoBtn().isEnabled());
		assertEquals(0, board.getNumBoardTiles());
		
		/*
		 * convert a tile to a board tile, then verify undo/redo
		 */
		me = new MouseEvent(boardView, 
				MouseEvent.MOUSE_RELEASED, 
				System.currentTimeMillis(), 0, 
				board.getTileSize(), 
				board.getTileSize(), 0, false);
		
		buildView.getBuilderBoardControl().mouseReleased(me);
		assertEquals("board", board.getTileAt(board.getTileSize(), board.getTileSize()).getTileType());
		assertEquals(1, board.getNumBoardTiles());
		
		buttonGroup.getUndoBtn().doClick();
		assertEquals("empty", board.getTileAt(board.getTileSize(), board.getTileSize()).getTileType());
		assertEquals(0, board.getNumBoardTiles());
		
		buttonGroup.getRedoBtn().doClick();
		assertEquals("board", board.getTileAt(board.getTileSize(), board.getTileSize()).getTileType());
		assertEquals(1, board.getNumBoardTiles());
		
	}
	
	public void testUndoRedoConvertPieceToBoard() {
		MouseEvent me;
		/*
		 * post-initialization, both the undo and redo buttons should be inactive, no board tiles as well
		 */
		assertFalse(buttonGroup.getUndoBtn().isEnabled());
		assertFalse(buttonGroup.getRedoBtn().isEnabled());
		assertEquals(0, board.getNumBoardTiles());
		
		/*
		 * toggle pieceConversion, initialize bullpen
		 */
		buildView.getPlacePiecesBtn().doClick();
		buildView.getConvertPieceToBoardBtn().doClick();
		build.getCurrentLevel().getBullpen().incrementPiece(1);
		build.getCurrentLevel().getBullpen().setSelectedPiece(1);
		
		/*
		 * convert a piece to board
		 */
		me = new MouseEvent(boardView, 
				MouseEvent.MOUSE_ENTERED, 
				System.currentTimeMillis(), 0, 
				3*board.getTileSize(), 
				0, 0, false);
		buildView.getBuilderBoardControl().mouseEntered(me);
		
		me = new MouseEvent(boardView, 
				MouseEvent.MOUSE_RELEASED, 
				System.currentTimeMillis(), 0, 
				2*board.getTileSize(), 
				2*board.getTileSize(), 0, false);
		buildView.getBuilderBoardControl().mouseReleased(me);
		
		/*
		 * verify, then test undo/redo
		 */
		assertEquals("board", board.getTileAt(2*board.getTileSize(), 0*board.getTileSize()).getTileType());
		assertEquals("board", board.getTileAt(2*board.getTileSize(), 1*board.getTileSize()).getTileType());
		assertEquals("board", board.getTileAt(2*board.getTileSize(), 2*board.getTileSize()).getTileType());
		assertEquals("board", board.getTileAt(2*board.getTileSize(), 3*board.getTileSize()).getTileType());
		assertEquals("board", board.getTileAt(2*board.getTileSize(), 4*board.getTileSize()).getTileType());
		assertEquals("board", board.getTileAt(2*board.getTileSize(), 5*board.getTileSize()).getTileType());
		
		buttonGroup.getUndoBtn().doClick();
		assertEquals("empty", board.getTileAt(2*board.getTileSize(), 0*board.getTileSize()).getTileType());
		assertEquals("empty", board.getTileAt(2*board.getTileSize(), 1*board.getTileSize()).getTileType());
		assertEquals("empty", board.getTileAt(2*board.getTileSize(), 2*board.getTileSize()).getTileType());
		assertEquals("empty", board.getTileAt(2*board.getTileSize(), 3*board.getTileSize()).getTileType());
		assertEquals("empty", board.getTileAt(2*board.getTileSize(), 4*board.getTileSize()).getTileType());
		assertEquals("empty", board.getTileAt(2*board.getTileSize(), 5*board.getTileSize()).getTileType());
		
		buttonGroup.getRedoBtn().doClick();
		assertEquals("board", board.getTileAt(2*board.getTileSize(), 0*board.getTileSize()).getTileType());
		assertEquals("board", board.getTileAt(2*board.getTileSize(), 1*board.getTileSize()).getTileType());
		assertEquals("board", board.getTileAt(2*board.getTileSize(), 2*board.getTileSize()).getTileType());
		assertEquals("board", board.getTileAt(2*board.getTileSize(), 3*board.getTileSize()).getTileType());
		assertEquals("board", board.getTileAt(2*board.getTileSize(), 4*board.getTileSize()).getTileType());
		assertEquals("board", board.getTileAt(2*board.getTileSize(), 5*board.getTileSize()).getTileType());
		
	}
	
	public void testUndoRedoRotateRight() {
		SelectedPieceView testView = buildView.getSelectedPieceView();
		Bullpen testBullpen = build.getCurrentLevel().getBullpen();
		Piece comparisonPiece = new Piece(35);
		
		/*
		 * post-initialization, both the undo and redo buttons should be inactive, no board tiles as well
		 */
		assertFalse(buttonGroup.getUndoBtn().isEnabled());
		assertFalse(buttonGroup.getRedoBtn().isEnabled());
		assertEquals(0, board.getNumBoardTiles());
		
		/*
		 * initialize bullpen, verify same coordinates as comparison piece
		 */
		testBullpen.incrementPiece(35);
		testBullpen.setSelectedPiece(35);
		testBullpen.getSelectedPiece().occupiesSameCoorindates(comparisonPiece);
		
		/*
		 * rotate right
		 */
		comparisonPiece.rotateRight();
		assertFalse(testBullpen.getSelectedPiece().occupiesSameCoorindates(comparisonPiece)); // verify different coordinates inbetween
		testView.getRotateRightBtn().doClick();
		assertTrue(testBullpen.getSelectedPiece().occupiesSameCoorindates(comparisonPiece));
		
		/*
		 * undo, verify that undo = rotate left
		 */
		buttonGroup.getUndoBtn().doClick();
		assertFalse(testBullpen.getSelectedPiece().occupiesSameCoorindates(comparisonPiece)); // verify different coordinates inbetween
		comparisonPiece.rotateLeft();
		assertTrue(testBullpen.getSelectedPiece().occupiesSameCoorindates(comparisonPiece));
		
		/*
		 * redo, verify that redo = rotate right
		 */
		buttonGroup.getRedoBtn().doClick();
		assertFalse(testBullpen.getSelectedPiece().occupiesSameCoorindates(comparisonPiece)); // verify different coordinates inbetween
		comparisonPiece.rotateRight();
		assertTrue(testBullpen.getSelectedPiece().occupiesSameCoorindates(comparisonPiece));
	}
	
	public void testUndoRedoRotateLeft() {
		SelectedPieceView testView = buildView.getSelectedPieceView();
		Bullpen testBullpen = build.getCurrentLevel().getBullpen();
		Piece comparisonPiece = new Piece(35);
		
		/*
		 * post-initialization, both the undo and redo buttons should be inactive, no board tiles as well
		 */
		assertFalse(buttonGroup.getUndoBtn().isEnabled());
		assertFalse(buttonGroup.getRedoBtn().isEnabled());
		assertEquals(0, board.getNumBoardTiles());
		
		/*
		 * initialize bullpen, verify same coordinates as comparison piece
		 */
		testBullpen.incrementPiece(35);
		testBullpen.setSelectedPiece(35);
		testBullpen.getSelectedPiece().occupiesSameCoorindates(comparisonPiece);
		
		/*
		 * rotate left
		 */
		comparisonPiece.rotateLeft();
		assertFalse(testBullpen.getSelectedPiece().occupiesSameCoorindates(comparisonPiece)); // verify different coordinates inbetween
		testView.getRotateLeftBtn().doClick();
		assertTrue(testBullpen.getSelectedPiece().occupiesSameCoorindates(comparisonPiece));
		
		/*
		 * undo, verify that undo = rotate right
		 */
		buttonGroup.getUndoBtn().doClick();
		assertFalse(testBullpen.getSelectedPiece().occupiesSameCoorindates(comparisonPiece)); // verify different coordinates inbetween
		comparisonPiece.rotateRight();
		assertTrue(testBullpen.getSelectedPiece().occupiesSameCoorindates(comparisonPiece));
		
		/*
		 * redo, verify that redo = rotate left
		 */
		buttonGroup.getRedoBtn().doClick();
		assertFalse(testBullpen.getSelectedPiece().occupiesSameCoorindates(comparisonPiece)); // verify different coordinates inbetween
		comparisonPiece.rotateLeft();
		assertTrue(testBullpen.getSelectedPiece().occupiesSameCoorindates(comparisonPiece));
	}
	
	public void testUndoRedoFlipHorz() {
		SelectedPieceView testView = buildView.getSelectedPieceView();
		Bullpen testBullpen = build.getCurrentLevel().getBullpen();
		Piece comparisonPiece = new Piece(35);
		
		/*
		 * post-initialization, both the undo and redo buttons should be inactive, no board tiles as well
		 */
		assertFalse(buttonGroup.getUndoBtn().isEnabled());
		assertFalse(buttonGroup.getRedoBtn().isEnabled());
		assertEquals(0, board.getNumBoardTiles());
		
		/*
		 * initialize bullpen, verify same coordinates as comparison piece
		 */
		testBullpen.incrementPiece(35);
		testBullpen.setSelectedPiece(35);
		testBullpen.getSelectedPiece().occupiesSameCoorindates(comparisonPiece);
		
		/*
		 * horizontal flip
		 */
		comparisonPiece.flipH();
		assertFalse(testBullpen.getSelectedPiece().occupiesSameCoorindates(comparisonPiece)); // verify different coordinates inbetween
		testView.getFlipHBtn().doClick();
		assertTrue(testBullpen.getSelectedPiece().occupiesSameCoorindates(comparisonPiece));
		
		/*
		 * undo, verify that undo = flip horizontally
		 */
		buttonGroup.getUndoBtn().doClick();
		assertFalse(testBullpen.getSelectedPiece().occupiesSameCoorindates(comparisonPiece)); // verify different coordinates inbetween
		comparisonPiece.flipH();
		assertTrue(testBullpen.getSelectedPiece().occupiesSameCoorindates(comparisonPiece));
		
		/*
		 * redo, verify that redo = flip horizontally
		 */
		buttonGroup.getRedoBtn().doClick();
		assertFalse(testBullpen.getSelectedPiece().occupiesSameCoorindates(comparisonPiece)); // verify different coordinates inbetween
		comparisonPiece.flipH();
		assertTrue(testBullpen.getSelectedPiece().occupiesSameCoorindates(comparisonPiece));
	}
		
	public void testUndoRedoFlipVert() {
		SelectedPieceView testView = buildView.getSelectedPieceView();
		Bullpen testBullpen = build.getCurrentLevel().getBullpen();
		Piece comparisonPiece = new Piece(35);
		
		/*
		 * post-initialization, both the undo and redo buttons should be inactive, no board tiles as well
		 */
		assertFalse(buttonGroup.getUndoBtn().isEnabled());
		assertFalse(buttonGroup.getRedoBtn().isEnabled());
		assertEquals(0, board.getNumBoardTiles());
		
		/*
		 * initialize bullpen, verify same coordinates as comparison piece
		 */
		testBullpen.incrementPiece(35);
		testBullpen.setSelectedPiece(35);
		testBullpen.getSelectedPiece().occupiesSameCoorindates(comparisonPiece);
		
		/*
		 * vertical flip
		 */
		comparisonPiece.flipV();
		assertFalse(testBullpen.getSelectedPiece().occupiesSameCoorindates(comparisonPiece)); // verify different coordinates inbetween
		testView.getFlipVBtn().doClick();
		assertTrue(testBullpen.getSelectedPiece().occupiesSameCoorindates(comparisonPiece));
		
		/*
		 * undo, verify that undo = flip vertically
		 */
		buttonGroup.getUndoBtn().doClick();
		assertFalse(testBullpen.getSelectedPiece().occupiesSameCoorindates(comparisonPiece)); // verify different coordinates inbetween
		comparisonPiece.flipV();
		assertTrue(testBullpen.getSelectedPiece().occupiesSameCoorindates(comparisonPiece));
		
		/*
		 * redo, verify that redo = flip vertically
		 */
		buttonGroup.getRedoBtn().doClick();
		assertFalse(testBullpen.getSelectedPiece().occupiesSameCoorindates(comparisonPiece)); // verify different coordinates inbetween
		comparisonPiece.flipV();
		assertTrue(testBullpen.getSelectedPiece().occupiesSameCoorindates(comparisonPiece));
	}

}
