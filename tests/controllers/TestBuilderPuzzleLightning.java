package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import java.awt.Color;

import controllers.builder.SwapTileBoardToEmptyMove;
import controllers.builder.SwapTileEmptyToBoardMove;
import controllers.common.IMove;
import controllers.common.MovePieceOffBoardMove;
import controllers.common.MovePieceOnBoardMove;
import controllers.common.PlacePieceOnBoardFromBullpenMove;
import model.Board;
import model.BoardTile;
import model.Bullpen;
import model.Piece;
import model.PieceGroup;
import model.PuzzleLevel;
import view.BoardView;
import view.BuilderView;
import view.BullpenView;
import app.Builder;
import junit.framework.TestCase;

/**
 * 
 * @author awharrison
 *
 */

public class TestBuilderPuzzleLightning extends TestCase {
	Builder build;
	BuilderView buildView;
	PuzzleLevel lvl;
	Board board;
	BoardView boardView;
	BullpenView bpView;
	
	@Override
	public void setUp(){
		new File("./imbriusLevelTESTING/").mkdirs();
		build = new Builder("./imbriusLevelTESTING/");
		build.createPuzzleLevel();
		buildView = build.getBuilderView();
		lvl = (PuzzleLevel)build.getCurrentLevel();
		board = lvl.getBoard();
		boardView = buildView.getBoardView();
		bpView = buildView.getBullpenView();
	}
	
	public void testPuzzleLightningBoard() {
		MouseEvent me;
		/*
		 * verify empty starting board
		 */
		assertEquals(0, board.getNumBoardTiles());
		
		/*
		 * create mouse event to convert empty tile to board tile
		 */
		assertEquals("empty", board.getTileAt(board.getTileSize(), board.getTileSize()).getTileType());
		me = new MouseEvent(boardView, 
				MouseEvent.MOUSE_RELEASED, 
				System.currentTimeMillis(), 0, 
				board.getTileSize(), 
				board.getTileSize(), 0, false);
		buildView.getBuilderBoardControl().mouseReleased(me);
		assertEquals("board", board.getTileAt(board.getTileSize(), board.getTileSize()).getTileType());
		
		/*
		 * toggle place piece, give piece to place
		 */
		lvl.getBullpen().incrementPiece(1);
		lvl.getBullpen().setSelectedPiece(new Piece(1));
		buildView.getPlacePiecesBtn().doClick();
		ActionEvent ae = new ActionEvent(buildView.getPlacePiecesBtn(), ActionEvent.ACTION_PERFORMED, "toggle");
		buildView.getPlacePieceHandler().actionPerformed(ae);
		assertTrue(buildView.getPlacePiecesBtn().isSelected());
		buildView.getConvertPieceToBoardBtn().doClick();
		assertTrue(buildView.getConvertPieceToBoardBtn().isSelected());
		
		/*
		 * place piece on board, verify that the piece tiles become board tiles
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
				3*board.getTileSize(), 
				3*board.getTileSize(), 0, false);
		buildView.getBuilderBoardControl().mouseReleased(me);
		
		assertEquals("board", board.getTileAt(3*board.getTileSize(), 1*board.getTileSize()).getTileType());
		assertEquals("board", board.getTileAt(3*board.getTileSize(), 2*board.getTileSize()).getTileType());
		assertEquals("board", board.getTileAt(3*board.getTileSize(), 3*board.getTileSize()).getTileType());
		assertEquals("board", board.getTileAt(3*board.getTileSize(), 4*board.getTileSize()).getTileType());
		assertEquals("board", board.getTileAt(3*board.getTileSize(), 5*board.getTileSize()).getTileType());
		assertEquals("board", board.getTileAt(3*board.getTileSize(), 6*board.getTileSize()).getTileType());
		assertEquals(Color.WHITE, board.getTileAt(3*board.getTileSize(), 1*board.getTileSize()).getColor());
		assertEquals(Color.WHITE, board.getTileAt(3*board.getTileSize(), 2*board.getTileSize()).getColor());
		assertEquals(Color.WHITE, board.getTileAt(3*board.getTileSize(), 3*board.getTileSize()).getColor());
		assertEquals(Color.WHITE, board.getTileAt(3*board.getTileSize(), 4*board.getTileSize()).getColor());
		assertEquals(Color.WHITE, board.getTileAt(3*board.getTileSize(), 5*board.getTileSize()).getColor());
		assertEquals(Color.WHITE, board.getTileAt(3*board.getTileSize(), 6*board.getTileSize()).getColor());
		
		/*
		 * reset board, untoggle ConverPieceToBoard button, toggle place hint button, place hint and verify
		 * note: hints are yellow tiles
		 */
		lvl.getBullpen().setSelectedPiece(new Piece(1));
		buildView.getConvertPieceToBoardBtn().doClick();
		assertFalse(buildView.getConvertPieceToBoardBtn().isSelected());
		buildView.getPlaceHintBtn().doClick();
		assertTrue(buildView.getPlaceHintBtn().isSelected());
		
		me = new MouseEvent(boardView, 
				MouseEvent.MOUSE_RELEASED, 
				System.currentTimeMillis(), 0, 
				3*board.getTileSize(), 
				3*board.getTileSize(), 0, false);
		buildView.getBuilderBoardControl().mouseReleased(me);
		
		assertEquals("board", board.getTileAt(3*board.getTileSize(), 1*board.getTileSize()).getTileType());
		assertEquals("board", board.getTileAt(3*board.getTileSize(), 2*board.getTileSize()).getTileType());
		assertEquals("board", board.getTileAt(3*board.getTileSize(), 3*board.getTileSize()).getTileType());
		assertEquals("board", board.getTileAt(3*board.getTileSize(), 4*board.getTileSize()).getTileType());
		assertEquals("board", board.getTileAt(3*board.getTileSize(), 5*board.getTileSize()).getTileType());
		assertEquals("board", board.getTileAt(3*board.getTileSize(), 6*board.getTileSize()).getTileType());
		assertEquals(Color.YELLOW, board.getTileAt(3*board.getTileSize(), 1*board.getTileSize()).getColor());
		assertEquals(Color.YELLOW, board.getTileAt(3*board.getTileSize(), 2*board.getTileSize()).getColor());
		assertEquals(Color.YELLOW, board.getTileAt(3*board.getTileSize(), 3*board.getTileSize()).getColor());
		assertEquals(Color.YELLOW, board.getTileAt(3*board.getTileSize(), 4*board.getTileSize()).getColor());
		assertEquals(Color.YELLOW, board.getTileAt(3*board.getTileSize(), 5*board.getTileSize()).getColor());
		assertEquals(Color.YELLOW, board.getTileAt(3*board.getTileSize(), 6*board.getTileSize()).getColor());
		
		/*
		 * toggle place hint off, move piece over hint
		 * place a piece over hint, verify
		 */
		lvl.getBullpen().setSelectedPiece(new Piece(1));
		buildView.getPlaceHintBtn().doClick();
		assertFalse(buildView.getPlaceHintBtn().isSelected());
		
		me = new MouseEvent(boardView, 
				MouseEvent.MOUSE_MOVED, 
				System.currentTimeMillis(), 0, 
				3*board.getTileSize(), 
				3*board.getTileSize(), 0, false);
		buildView.getBuilderBoardControl().mouseMoved(me);
		assertEquals(Color.GREEN, board.getTileAt(3*board.getTileSize(), 1*board.getTileSize()).getColor());
		assertEquals(Color.GREEN, board.getTileAt(3*board.getTileSize(), 2*board.getTileSize()).getColor());
		assertEquals(Color.GREEN, board.getTileAt(3*board.getTileSize(), 3*board.getTileSize()).getColor());
		assertEquals(Color.GREEN, board.getTileAt(3*board.getTileSize(), 4*board.getTileSize()).getColor());
		assertEquals(Color.GREEN, board.getTileAt(3*board.getTileSize(), 5*board.getTileSize()).getColor());
		assertEquals(Color.GREEN, board.getTileAt(3*board.getTileSize(), 6*board.getTileSize()).getColor());
		
		me = new MouseEvent(boardView, 
				MouseEvent.MOUSE_RELEASED, 
				System.currentTimeMillis(), 0, 
				3*board.getTileSize(), 
				3*board.getTileSize(), 0, false);
		buildView.getBuilderBoardControl().mouseReleased(me);
		
		assertEquals("piece", board.getTileAt(3*board.getTileSize(), 1*board.getTileSize()).getTileType());
		assertEquals("piece", board.getTileAt(3*board.getTileSize(), 2*board.getTileSize()).getTileType());
		assertEquals("piece", board.getTileAt(3*board.getTileSize(), 3*board.getTileSize()).getTileType());
		assertEquals("piece", board.getTileAt(3*board.getTileSize(), 4*board.getTileSize()).getTileType());
		assertEquals("piece", board.getTileAt(3*board.getTileSize(), 5*board.getTileSize()).getTileType());
		assertEquals("piece", board.getTileAt(3*board.getTileSize(), 6*board.getTileSize()).getTileType());
		
		/*
		 * drag, then remove the piece from the board, verify
		 */
		me = new MouseEvent(boardView, 
				MouseEvent.MOUSE_PRESSED, 
				System.currentTimeMillis(), 0, 
				3*board.getTileSize(), 
				3*board.getTileSize(), 0, false);
		buildView.getBuilderBoardControl().mousePressed(me);
		
		me = new MouseEvent(boardView, 
				MouseEvent.MOUSE_DRAGGED, 
				System.currentTimeMillis(), 0, 
				4*board.getTileSize(), 
				4*board.getTileSize(), 0, false);
		buildView.getBuilderBoardControl().mouseDragged(me);
		
		assertEquals(Color.RED, board.getTileAt(4*board.getTileSize(), 2*board.getTileSize()).getColor());
		assertEquals(Color.RED, board.getTileAt(4*board.getTileSize(), 3*board.getTileSize()).getColor());
		assertEquals(Color.RED, board.getTileAt(4*board.getTileSize(), 4*board.getTileSize()).getColor());
		assertEquals(Color.RED, board.getTileAt(4*board.getTileSize(), 5*board.getTileSize()).getColor());
		assertEquals(Color.RED, board.getTileAt(4*board.getTileSize(), 6*board.getTileSize()).getColor());
		assertEquals(Color.RED, board.getTileAt(4*board.getTileSize(), 7*board.getTileSize()).getColor());
		
		me = new MouseEvent(boardView, 
				MouseEvent.MOUSE_EXITED, 
				System.currentTimeMillis(), 0, 
				3*board.getTileSize(), 
				3*board.getTileSize(), 0, false);
		buildView.getBuilderBoardControl().mouseExited(me);
		assertEquals("board", board.getTileAt(3*board.getTileSize(), 1*board.getTileSize()).getTileType());
		assertEquals("board", board.getTileAt(3*board.getTileSize(), 2*board.getTileSize()).getTileType());
		assertEquals("board", board.getTileAt(3*board.getTileSize(), 3*board.getTileSize()).getTileType());
		assertEquals("board", board.getTileAt(3*board.getTileSize(), 4*board.getTileSize()).getTileType());
		assertEquals("board", board.getTileAt(3*board.getTileSize(), 5*board.getTileSize()).getTileType());
		assertEquals("board", board.getTileAt(3*board.getTileSize(), 6*board.getTileSize()).getTileType());
	}
	
	//====================== Empty to Board Tile to Empty Swapping ======================//
	public void testTileEmptyToBoardSwapMove() {
		IMove m;
		m = new SwapTileEmptyToBoardMove(board.getTileAt(boardView.getX(), boardView.getX()), lvl.getBoard(), buildView.getLevelPropertiesView(), boardView);
		assertTrue(m.doMove());
		assertEquals(1, board.getNumBoardTiles());
		m.undo();
		assertEquals(0, board.getNumBoardTiles());
		m.redo();
		assertEquals(1, board.getNumBoardTiles());
		
		m = new SwapTileBoardToEmptyMove(board.getTileAt(boardView.getX(), boardView.getX()), lvl.getBoard(), buildView.getLevelPropertiesView(), boardView);
		assertTrue(m.doMove());
		assertEquals(0, board.getNumBoardTiles());
		m.undo();
		assertEquals(1, board.getNumBoardTiles());
		m.redo();
		assertEquals(0, board.getNumBoardTiles());
	}
	
	
	//====================== Place Piece on Board from Bullpen Move ======================//
	public void testMovePiecesOnBoardFromBullpen() {
		IMove m;
		
		/*
		 * initialize bullpen
		 */
		ArrayList<PieceGroup> pieces = new ArrayList<PieceGroup>();
		pieces.add(new PieceGroup(1,4));
		lvl.setBullpen(new Bullpen(pieces));
		lvl.getBullpen().setSelectedPiece(new Piece(1));
		assertEquals(4, lvl.getBullpen().numAvailablePieces());
		
		/*
		 * swap tiles to be able to place pieces
		 */
		board.swapTile(new BoardTile(0,0));
		board.swapTile(new BoardTile(1,0));
		board.swapTile(new BoardTile(2,0));
		board.swapTile(new BoardTile(3,0));
		board.swapTile(new BoardTile(4,0));
		board.swapTile(new BoardTile(5,0));
		
		board.swapTile(new BoardTile(0,1));
		BoardTile placementTileFail = new BoardTile(1, 1);
		board.swapTile(placementTileFail);
		BoardTile placementTile = new BoardTile(2, 1);
		board.swapTile(placementTile);
		board.swapTile(new BoardTile(3,1));
		board.swapTile(new BoardTile(4,1));
		board.swapTile(new BoardTile(5,1));
		assertEquals(12, board.getNumBoardTiles());
		
		/*
		 * try to place piece that should fail
		 */
		m = new PlacePieceOnBoardFromBullpenMove(lvl, placementTileFail, bpView, buildView.getSelectedPieceView(), boardView);
		assertFalse(m.doMove());
		
		/*
		 *  try to place piece that should complete
		 */
		assertEquals("board", board.getTileAt(board.getTileSize(), board.getTileSize()).getTileType());
		m = new PlacePieceOnBoardFromBullpenMove(lvl, placementTile, bpView, buildView.getSelectedPieceView(), boardView);
		assertTrue(m.doMove());
		
		/*
		 * verify number of board tiles has changed, the bullpen has been updated, and the board contains piece tiles
		 */
		assertEquals(6, board.getNumBoardTiles());
		assertEquals(3, lvl.getBullpen().numAvailablePieces());
		assertEquals("piece", board.getTileAt(board.getTileSize(), board.getTileSize()).getTileType());
		m.undo();
		assertEquals("board", board.getTileAt(board.getTileSize(), board.getTileSize()).getTileType());
		m.redo();
		assertEquals("piece", board.getTileAt(board.getTileSize(), board.getTileSize()).getTileType());
	}
	
	//====================== Move Piece Board to Board Move ======================//
	public void testMovePiecesOnBoard() {
		IMove m;
		
		/*
		 * swap tiles to be able to place pieces
		 */
		board.swapTile(new BoardTile(0,0));
		board.swapTile(new BoardTile(1,0));
		BoardTile placementTile = new BoardTile(2, 0);
		board.swapTile(placementTile);
		board.swapTile(new BoardTile(3,0));
		board.swapTile(new BoardTile(4,0));
		board.swapTile(new BoardTile(5,0));
		
		board.swapTile(new BoardTile(0,1));
		board.swapTile(new BoardTile(1,1));
		board.swapTile(new BoardTile(2,1));
		board.swapTile(new BoardTile(3,1));
		board.swapTile(new BoardTile(4,1));
		board.swapTile(new BoardTile(5,1));
		assertEquals(12, board.getNumBoardTiles());
		
		/*
		 * create piece and place to be tested
		 */
		Piece testPiece = new Piece(1);
		assertTrue(board.putPieceOnBoard(testPiece, 2, 0));
		assertEquals(6, board.getNumBoardTiles());
		assertEquals("piece", board.getTileAt(0*board.getTileSize(), 0).getTileType());
		assertEquals("board", board.getTileAt(1*board.getTileSize(), 1).getTileType());
		
		/*
		 * create move to place piece to column to the right
		 */
		board.removePiece(testPiece);
		m = new MovePieceOnBoardMove(lvl.getBoard(), placementTile, testPiece, 0, 1, boardView);
		assertTrue(m.doMove());
		assertEquals(6, board.getNumBoardTiles());
		assertEquals("board", board.getTileAt(0*board.getTileSize(), 0).getTileType());
		assertEquals("piece", board.getTileAt(1*board.getTileSize(), 1).getTileType());
		
		/*
		 * test undo and redo
		 */
		m.undo();
		assertEquals(6, board.getNumBoardTiles());
		assertEquals("piece", board.getTileAt(0*board.getTileSize(), 0).getTileType());
		assertEquals("board", board.getTileAt(1*board.getTileSize(), 1).getTileType());
		m.redo();
		assertEquals(6, board.getNumBoardTiles());
		assertEquals("board", board.getTileAt(0*board.getTileSize(), 0).getTileType());
		assertEquals("piece", board.getTileAt(1*board.getTileSize(), 1).getTileType());
	}
	
	//====================== Move Piece Off Board Move ======================//
	public void testMovePiecesOffBoard() {
		IMove m;
		/*
		 * swap tiles to be able to place pieces
		 */
		board.swapTile(new BoardTile(0,0));
		board.swapTile(new BoardTile(1,0));
		BoardTile placementTile = new BoardTile(2, 0);
		board.swapTile(placementTile);
		board.swapTile(new BoardTile(3,0));
		board.swapTile(new BoardTile(4,0));
		board.swapTile(new BoardTile(5,0));
		assertEquals(6, board.getNumBoardTiles());
		
		/*
		 * create piece and place to be tested
		 */
		Piece testPiece = new Piece(1);
		assertTrue(board.putPieceOnBoard(testPiece, 2, 0));
		assertEquals(0, board.getNumBoardTiles());
		assertEquals("piece", board.getTileAt(0*board.getTileSize(), 0).getTileType());
		
		/*
		 * set piece being dragged and create move
		 */
		board.removePiece(testPiece);
		board.setDraggedPiece(testPiece);
		m = new MovePieceOffBoardMove(lvl, bpView, boardView); 
		assertTrue(m.doMove());
		assertEquals(null,board.getDraggedPiece());
		assertEquals("board", board.getTileAt(0*board.getTileSize(), 0*board.getTileSize()).getTileType()); 
		
		/*
		 * test undo and redo
		 */
		m.undo();
		assertEquals("piece", board.getTileAt(0*board.getTileSize(), 0).getTileType());
		m.redo();
		assertEquals("board", board.getTileAt(0*board.getTileSize(), 0).getTileType());
	}
}
