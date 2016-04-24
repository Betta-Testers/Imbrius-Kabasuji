package controllers;

import java.io.File;
import java.util.ArrayList;

import controllers.builder.SwapTileBoardToEmptyMove;
import controllers.builder.SwapTileEmptyToBoardMove;
import controllers.common.Move;
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
	Board puzzleBoard;
	BoardView boardView;
	BullpenView bpView;
	
	@Override
	public void setUp(){
		new File("./imbriusLevelTESTING/").mkdirs();
		build = new Builder("./imbriusLevelTESTING/");
		build.createPuzzleLevel();
		buildView = build.getBuilderView();
		lvl = (PuzzleLevel)build.getCurrentLevel();
		puzzleBoard = lvl.getBoard();
		boardView = buildView.getBoardView();
		bpView = buildView.getBullpenView();
	}
	
	public void testPuzzleLightningBoard() {
		
	}
	
	//====================== Empty to Board Tile to Empty Swapping ======================//
	public void testTileEmptyToBoardSwapMove() {
		Move m;
		m = new SwapTileEmptyToBoardMove(puzzleBoard.getTileAt(boardView.getX(), boardView.getX()), lvl.getBoard(), buildView.getLevelPropertiesView());
		assertTrue(m.doMove());
		assertEquals(1, puzzleBoard.getNumBoardTiles());
		m.undo();
		assertEquals(0, puzzleBoard.getNumBoardTiles());
		m.redo();
		assertEquals(1, puzzleBoard.getNumBoardTiles());
		
		m = new SwapTileBoardToEmptyMove(puzzleBoard.getTileAt(boardView.getX(), boardView.getX()), lvl.getBoard(), buildView.getLevelPropertiesView());
		assertTrue(m.doMove());
		assertEquals(0, puzzleBoard.getNumBoardTiles());
		m.undo();
		assertEquals(1, puzzleBoard.getNumBoardTiles());
		m.redo();
		assertEquals(0, puzzleBoard.getNumBoardTiles());
	}
	
	
	//====================== Place Piece on Board from Bullpen Move ======================//
	public void testMovePiecesOnBoardFromBullpen() {
		Move m;
		
		/*
		 * initialize bullpen
		 */
		ArrayList<PieceGroup> pieces = new ArrayList<PieceGroup>();
		pieces.add(new PieceGroup(1,4));
		lvl.setBullpen(new Bullpen(pieces));
		lvl.getBullpen().setSelectedPiece(1);
		assertEquals(4, lvl.getBullpen().numAvailablePieces());
		
		/*
		 * swap tiles to be able to place pieces
		 */
		puzzleBoard.swapTile(new BoardTile(0,0));
		puzzleBoard.swapTile(new BoardTile(1,0));
		puzzleBoard.swapTile(new BoardTile(2,0));
		puzzleBoard.swapTile(new BoardTile(3,0));
		puzzleBoard.swapTile(new BoardTile(4,0));
		puzzleBoard.swapTile(new BoardTile(5,0));
		
		puzzleBoard.swapTile(new BoardTile(0,1));
		BoardTile placementTileFail = new BoardTile(1, 1);
		puzzleBoard.swapTile(placementTileFail);
		BoardTile placementTile = new BoardTile(2, 1);
		puzzleBoard.swapTile(placementTile);
		puzzleBoard.swapTile(new BoardTile(3,1));
		puzzleBoard.swapTile(new BoardTile(4,1));
		puzzleBoard.swapTile(new BoardTile(5,1));
		assertEquals(12, puzzleBoard.getNumBoardTiles());
		
		/*
		 * try to place piece that should fail
		 */
		m = new PlacePieceOnBoardFromBullpenMove(lvl, placementTileFail, bpView);
		assertFalse(m.doMove());
		
		/*
		 *  try to place piece that should complete
		 */
		assertEquals("board", puzzleBoard.getTileAt(puzzleBoard.getTileSize(), puzzleBoard.getTileSize()).getTileType());
		m = new PlacePieceOnBoardFromBullpenMove(lvl, placementTile, bpView);
		assertTrue(m.doMove());
		
		/*
		 * verify number of board tiles has changed, the bullpen has been updated, and the board contains piece tiles
		 */
		assertEquals(6, puzzleBoard.getNumBoardTiles());
		assertEquals(3, lvl.getBullpen().numAvailablePieces());
		assertEquals("piece", puzzleBoard.getTileAt(puzzleBoard.getTileSize(), puzzleBoard.getTileSize()).getTileType());
		m.undo();
		assertEquals("board", puzzleBoard.getTileAt(puzzleBoard.getTileSize(), puzzleBoard.getTileSize()).getTileType());
		m.redo();
		assertEquals("piece", puzzleBoard.getTileAt(puzzleBoard.getTileSize(), puzzleBoard.getTileSize()).getTileType());
	}
	
	//====================== Move Piece Board to Board Move ======================//
	public void testMovePiecesOnBoard() {
		Move m;
		
		/*
		 * swap tiles to be able to place pieces
		 */
		puzzleBoard.swapTile(new BoardTile(0,0));
		puzzleBoard.swapTile(new BoardTile(1,0));
		BoardTile placementTile = new BoardTile(2, 0);
		puzzleBoard.swapTile(placementTile);
		puzzleBoard.swapTile(new BoardTile(3,0));
		puzzleBoard.swapTile(new BoardTile(4,0));
		puzzleBoard.swapTile(new BoardTile(5,0));
		
		puzzleBoard.swapTile(new BoardTile(0,1));
		puzzleBoard.swapTile(new BoardTile(1,1));
		puzzleBoard.swapTile(new BoardTile(2,1));
		puzzleBoard.swapTile(new BoardTile(3,1));
		puzzleBoard.swapTile(new BoardTile(4,1));
		puzzleBoard.swapTile(new BoardTile(5,1));
		assertEquals(12, puzzleBoard.getNumBoardTiles());
		
		/*
		 * create piece and place to be tested
		 */
		Piece testPiece = new Piece(1);
		assertTrue(puzzleBoard.putPieceOnBoard(testPiece, 2, 0));
		assertEquals(6, puzzleBoard.getNumBoardTiles());
		assertEquals("piece", puzzleBoard.getTileAt(0*puzzleBoard.getTileSize(), 0).getTileType());
		assertEquals("board", puzzleBoard.getTileAt(1*puzzleBoard.getTileSize(), 1).getTileType());
		
		/*
		 * create move to place piece to column to the right
		 */
		m = new MovePieceOnBoardMove(lvl, placementTile, testPiece, 0, 1);
		assertTrue(m.doMove());
		assertEquals(6, puzzleBoard.getNumBoardTiles());
		assertEquals("board", puzzleBoard.getTileAt(0*puzzleBoard.getTileSize(), 0).getTileType());
		assertEquals("piece", puzzleBoard.getTileAt(1*puzzleBoard.getTileSize(), 1).getTileType());
		
		/*
		 * test undo and redo
		 */
		m.undo();
		assertEquals(6, puzzleBoard.getNumBoardTiles());
		assertEquals("piece", puzzleBoard.getTileAt(0*puzzleBoard.getTileSize(), 0).getTileType());
		assertEquals("board", puzzleBoard.getTileAt(1*puzzleBoard.getTileSize(), 1).getTileType());
		m.redo();
		assertEquals(6, puzzleBoard.getNumBoardTiles());
		assertEquals("board", puzzleBoard.getTileAt(0*puzzleBoard.getTileSize(), 0).getTileType());
		assertEquals("piece", puzzleBoard.getTileAt(1*puzzleBoard.getTileSize(), 1).getTileType());
	}
	
	//====================== Move Piece Off Board Move ======================//
	public void testMovePiecesOffBoard() {
		Move m;
		/*
		 * swap tiles to be able to place pieces
		 */
		puzzleBoard.swapTile(new BoardTile(0,0));
		puzzleBoard.swapTile(new BoardTile(1,0));
		BoardTile placementTile = new BoardTile(2, 0);
		puzzleBoard.swapTile(placementTile);
		puzzleBoard.swapTile(new BoardTile(3,0));
		puzzleBoard.swapTile(new BoardTile(4,0));
		puzzleBoard.swapTile(new BoardTile(5,0));
		assertEquals(6, puzzleBoard.getNumBoardTiles());
		
		/*
		 * create piece and place to be tested
		 */
		Piece testPiece = new Piece(1);
		assertTrue(puzzleBoard.putPieceOnBoard(testPiece, 2, 0));
		assertEquals(0, puzzleBoard.getNumBoardTiles());
		assertEquals("piece", puzzleBoard.getTileAt(0*puzzleBoard.getTileSize(), 0).getTileType());
		
		/*
		 * set piece being dragged and create move
		 */
		puzzleBoard.setDraggedPiece(testPiece);
		m = new MovePieceOffBoardMove(lvl, bpView);
		assertTrue(m.doMove());
		assertEquals("board", puzzleBoard.getTileAt(0*puzzleBoard.getTileSize(), 0).getTileType());
		
		/*
		 * test undo and redo
		 */
		m.undo();
		assertEquals("piece", puzzleBoard.getTileAt(0*puzzleBoard.getTileSize(), 0).getTileType());
		m.redo();
		assertEquals("board", puzzleBoard.getTileAt(0*puzzleBoard.getTileSize(), 0).getTileType());
	}
}
