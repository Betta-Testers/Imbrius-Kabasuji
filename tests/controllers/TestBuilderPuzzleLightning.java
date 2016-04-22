package controllers;

import java.io.File;
import controllers.builder.SwapTileBoardToEmptyMove;
import controllers.builder.SwapTileEmptyToBoardMove;
import controllers.common.Move;
import model.Board;
import model.BoardTile;
import model.EmptyTile;
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
	Board releaseBoard;
	BoardView boardView;
	BullpenView bpView;
	
	@Override
	public void setUp(){
		new File("./imbriusLevelTESTING/").mkdirs();
		build = new Builder("./imbriusLevelTESTING/");
		build.createPuzzleLevel();
		buildView = build.getBuilderView();
		lvl = (PuzzleLevel)build.getCurrentLevel();
		releaseBoard = lvl.getBoard();
		boardView = buildView.getBoardView();
		bpView = buildView.getBullpenView();
	}
	
	public void testPuzzleLightningBoard() {
		
	}
	
	//====================== Empty to Board Tile to Empty Swapping ======================//
	public void testTileEmptyToBoardSwapMove() {
		Move m;
		m = new SwapTileEmptyToBoardMove(buildView, (EmptyTile)releaseBoard.getTileAt(boardView.getX(), boardView.getX()), lvl);
		assertTrue(m.doMove());
		assertEquals(1, releaseBoard.getNumBoardTiles());
		m.undo();
		assertEquals(0, releaseBoard.getNumBoardTiles());
		m.redo();
		assertEquals(1, releaseBoard.getNumBoardTiles());
		
		m = new SwapTileBoardToEmptyMove(buildView, (BoardTile)releaseBoard.getTileAt(boardView.getX(), boardView.getX()), lvl);
		assertTrue(m.doMove());
		assertEquals(0, releaseBoard.getNumBoardTiles());
		m.undo();
		assertEquals(1, releaseBoard.getNumBoardTiles());
		m.redo();
		assertEquals(0, releaseBoard.getNumBoardTiles());
	}
	
	
	//====================== Place Piece on Board from Bullpen Move ======================//
	public void testMovePiecesOnBoardFromBullpen() {
		Move m;
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
