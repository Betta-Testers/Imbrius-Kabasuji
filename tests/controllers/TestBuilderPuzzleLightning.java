package controllers;

import java.io.File;
import java.util.ArrayList;

import controllers.builder.SwapTileBoardToEmptyMove;
import controllers.builder.SwapTileEmptyToBoardMove;
import controllers.common.Move;
import controllers.common.PlacePieceOnBoardFromBullpenMove;
import model.Board;
import model.BoardTile;
import model.Bullpen;
import model.EmptyTile;
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
	Bullpen bullpen;
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
	}
	
	public void testPuzzleLightningBoard() {
		
	}
	
	//====================== Empty to Board Tile to Empty Swapping ======================//
	public void testTileEmptyToBoardSwapMove() {
		Move m;
		m = new SwapTileEmptyToBoardMove(buildView, (EmptyTile)puzzleBoard.getTileAt(boardView.getX(), boardView.getX()), lvl);
		assertTrue(m.doMove());
		assertEquals(1, puzzleBoard.getNumBoardTiles());
		m.undo();
		assertEquals(0, puzzleBoard.getNumBoardTiles());
		m.redo();
		assertEquals(1, puzzleBoard.getNumBoardTiles());
		
		m = new SwapTileBoardToEmptyMove(buildView, (BoardTile)puzzleBoard.getTileAt(boardView.getX(), boardView.getX()), lvl);
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
		
		/*
		 * swap tiles to be able to place pieces
		 */
		puzzleBoard.swapTile(new BoardTile(0, 0));
		puzzleBoard.swapTile(new BoardTile(1, 0));
		puzzleBoard.swapTile(new BoardTile(2, 0));
		assertEquals(3, puzzleBoard.getNumBoardTiles());
		/*
		 * try to place piece (test willfit)
		 */
		m = new PlacePieceOnBoardFromBullpenMove(lvl, puzzleBoard.getTileAt(2*puzzleBoard.getTileSize(), 0), bpView);
		
		// TODO figure out why willFit is returning a nullPointerException
		puzzleBoard.willFit(lvl.getBullpen().getSelectedPiece(), 2, 0);
		assertFalse(m.doMove());
		
		/*
		 * complete space for piece
		 */
		puzzleBoard.swapTile(new BoardTile(3, 0));
		puzzleBoard.swapTile(new BoardTile(4, 0));
		puzzleBoard.swapTile(new BoardTile(5, 0));
		assertTrue(m.doMove());
		assertEquals(6, puzzleBoard.getNumBoardTiles());
		
	}
	
	//====================== Move Piece Board to Board Move ======================//
	public void testMovePiecesOnBoard() {
		Move m;
	}
	
	//====================== Move Piece Off Board Move ======================//
	public void testMovePiecesOffBoard() {
		Move m;
	}
}
