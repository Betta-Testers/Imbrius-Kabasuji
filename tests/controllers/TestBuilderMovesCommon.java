package controllers;

import java.io.File;
import java.util.ArrayList;

import view.BuilderView;
import model.AbstractTile;
import model.Board;
import model.BoardTile;
import model.Bullpen;
import model.EmptyTile;
import model.Piece;
import model.PieceGroup;
import model.PieceTile;
import model.PuzzleLevel;
import app.Builder;
import controllers.builder.SwapTileEmptyToBoardMove;
import controllers.common.Move;
import controllers.common.MovePieceOffBoardMove;
import controllers.common.MovePieceOnBoardMove;
import controllers.common.PlacePieceOnBoardFromBullpenMove;
import junit.framework.TestCase;

/**
 * 
 * @author awharrison
 *
 */
public class TestBuilderMovesCommon extends TestCase {
	PuzzleLevel pl;
	Builder build;
	BuilderView bv;
	Board b;
	
	@Override
	public void setUp(){
		new File("./imbriusLevelTESTING/").mkdirs();
		build = new Builder("./imbriusLevelTESTING/");
		build.createPuzzleLevel();
		pl = (PuzzleLevel)build.getCurrentLevel();
		bv = build.getBuilderView();
		pl.setBoard(new Board());
		b = pl.getBoard();
	}
	
	@Override
	public void tearDown(){
		File dir = new File("./imbriusLevelTESTING/");
		for(File file: dir.listFiles()) file.delete();
		dir.delete();
	}
	
	public void testPlacePieceRemovePiece() {
		// get the number of board tiles on the board
		assertEquals(0, b.getNumBoardTiles());
		
		// create a move
		Move m;
		for(int i = 0; i < 12; i++){
			for(int j = 0; j < 12; j++){
				m = new SwapTileEmptyToBoardMove(bv, (EmptyTile)b.getTileAt(i*32, j*32), pl);
				m.doMove();
			}
		}
		
		// verify that the pile selected for placement is a board tile
		AbstractTile at = b.getTileAt(6, 6);
		assertEquals("board", at.getTileType());
		assertEquals(144, b.getNumBoardTiles());
		
//		// create and perform place piece move
//		m = new MovePieceOnBoardMove(pl, (BoardTile)b.getTileAt(144, 144), new Piece(2));
//		m.doMove();
//		// verify that the tile is now a piece tile
//		at = b.getTileAt(144, 144);
//		assertEquals("piece", at.getTileType());
//		
//		// verify that the number of board tiles has decreased by 6
//		assertEquals(138, b.getNumBoardTiles());
		
		// remove the piece from the board
		// TODO Revisit when all other tests are done if more code coverage
//		m = new MovePieceOffBoardMove(pl, bv.getBullpenView());
//		m.doMove();
//		// verify that the tile is now a piece tile
//		at = b.getTileAt(144, 144);
//		assertEquals("board", at.getTileType());
//		
//		// test undo
//		m.undo();
//		at = b.getTileAt(144, 144);
//		assertEquals("piece", at.getTileType());
//		
//		// test redo
//		m.redo();
//		at = b.getTileAt(144, 144);
//		assertEquals("board", at.getTileType());
//		
	}
	
	public void testScore() {
		// set move limit and board
		pl.setMoveLimit(4);
		Move m;
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 6; j++){
				m = new SwapTileEmptyToBoardMove(bv, (EmptyTile)b.getTileAt(i*b.getTileSize(), j*b.getTileSize()), pl);
				m.doMove();
			}
		}
		assertEquals(24, b.getNumBoardTiles());
		
//		// move 1
//		AbstractTile at = b.getTileAt(0, 2*b.getTileSize());
//		m = new MovePieceOnBoardMove(pl, (BoardTile)at, new Piece(1));
//		m.doMove();
//		// verify that the tile is now a piece tile
//		at = b.getTileAt(0, 2*b.getTileSize());
//		assertEquals("piece", at.getTileType());
//		assertEquals(18, b.getNumBoardTiles());
//		pl.incrementMovesMade();
//		// Number of stars earned is 0
//		assertEquals(0, pl.getStarsEarned());
//		assertFalse(pl.checkStatus());
//		
//		// move 2
//		at = b.getTileAt(b.getTileSize(), 2*b.getTileSize());
//		m = new MovePieceOnBoardMove(pl, (BoardTile)at, new Piece(1));
//		m.doMove();
//		// verify that the tile is now a piece tile
//		at = b.getTileAt(b.getTileSize(), 2*b.getTileSize());
//		assertEquals("piece", at.getTileType());
//		assertEquals(12, b.getNumBoardTiles());
//		pl.incrementMovesMade();
//		// Number of stars earned is 1
//		assertFalse(pl.checkStatus());
//		assertEquals(1, pl.getStarsEarned());
//		
//		// move 3
//		at = b.getTileAt(2*b.getTileSize(), 2*b.getTileSize());
//		m = new MovePieceOnBoardMove(pl, (BoardTile)at, new Piece(1));
//		m.doMove();
//		// verify that the tile is now a piece tile
//		at = b.getTileAt(2*b.getTileSize(), 2*b.getTileSize());
//		assertEquals("piece", at.getTileType());
//		assertEquals(6, b.getNumBoardTiles());
//		pl.incrementMovesMade();
//		// Number of stars earned is 2
//		assertFalse(pl.checkStatus());
//		assertEquals(2, pl.getStarsEarned());
//		
//		// move 4
//		at = b.getTileAt(3*b.getTileSize(), 2*b.getTileSize());
//		m = new MovePieceOnBoardMove(pl, (BoardTile)at, new Piece(1));
//		m.doMove();
//		// verify that the tile is now a piece tile
//		at = b.getTileAt(3*b.getTileSize(), 2*b.getTileSize());
//		assertEquals("piece", at.getTileType());
//		assertEquals(0, b.getNumBoardTiles());
//		pl.incrementMovesMade();
//		// Number of stars earned is 3
//		assertTrue(pl.checkStatus());
//		assertEquals(3, pl.getStarsEarned());
//		
//		// test undo move
//		m.undo();
//		at = b.getTileAt(3*b.getTileSize(), 2*b.getTileSize());
//		assertEquals("board", at.getTileType());
//		assertEquals(6, b.getNumBoardTiles());
//		pl.incrementMovesMade();
//		// Number of stars earned is 2 again
//		assertFalse(pl.checkStatus());
//		assertEquals(2, pl.getStarsEarned());
//		
//		// test redo move
//		m.redo();
//		at = b.getTileAt(3*b.getTileSize(), 2*b.getTileSize());
//		assertEquals("piece", at.getTileType());
//		assertEquals(0, b.getNumBoardTiles());
//		pl.incrementMovesMade();
//		// TODO check in on getStarsEarned
//		// Number of stars earned is 3
//		assertTrue(pl.checkStatus());
//		assertEquals(3, pl.getStarsEarned());
	}
	
	public void testBullpen() {
		ArrayList<PieceGroup> test = new ArrayList<PieceGroup>();
		
		test.add(new PieceGroup(1, 1));
		test.add(new PieceGroup(3, 1));
		test.add(new PieceGroup(7, 1));
		test.add(new PieceGroup(2, 1));
		
		pl.setBullpen(new Bullpen(test));
		
		assertEquals(4, pl.getBullpen().numAvailablePieces());
		assertTrue(pl.getBullpen().setSelectedPiece(2));
		
		// get the number of board tiles on the board
		assertEquals(0, b.getNumBoardTiles());
		
		// create a move
		Move m;
		for(int i = 0; i < 12; i++){
			for(int j = 0; j < 12; j++){
				m = new SwapTileEmptyToBoardMove(bv, (EmptyTile)b.getTileAt(i*b.getTileSize(), j*b.getTileSize()), pl);
				m.doMove();
			}
		}
		
		// verify that the pile selected for placement is a board tile
		AbstractTile at = b.getTileAt(4*b.getTileSize(), 5*b.getTileSize());
		assertEquals(144, b.getNumBoardTiles());
		
		// verify that the number of pieces in the bullpen has been decremented by 1
		m = new PlacePieceOnBoardFromBullpenMove(pl, at, bv.getBullpenView());
		assertTrue(m.doMove());
		assertEquals(null, pl.getBullpen().getSelectedPiece());
		assertEquals(3, pl.getBullpen().numAvailablePieces());
	}
}
