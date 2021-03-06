package controllers.builder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.File;

import controllers.builder.SwapTileBoardToReleaseMove;
import controllers.builder.SwapTileEmptyToBoardMove;
import controllers.builder.SwapTileReleaseToBoardMove;
import controllers.builder.SwapTileReleaseToReleaseMove;
import controllers.common.IMove;
import model.Board;
import model.BoardTile;
import model.EmptyTile;
import model.ReleaseLevel;
import model.ReleaseTile;
import view.BoardView;
import view.BuilderView;
import view.BullpenView;
import view.ReleaseNumberCreationView;
import app.Builder;
import app.LevelFactory;
import junit.framework.TestCase;

/**
 * 
 * @author awharrison
 *
 */
@SuppressWarnings("javadoc")
public class TestBuilderRelease extends TestCase {
	Builder build;
	BuilderView buildView;
	ReleaseLevel lvl;
	Board releaseBoard;
	BoardView boardView;
	BullpenView bpView;
	ReleaseNumberCreationView rncv;
	
	@Override
	public void setUp(){
		new File("./imbriusLevelTESTING/").mkdirs();
		build = new Builder("./imbriusLevelTESTING/");
		build.createLevel((new LevelFactory()).GenerateBlankRelease(build.getNextOpenID()));
		buildView = build.getBuilderView();
		lvl = (ReleaseLevel)build.getCurrentLevel();
		releaseBoard = lvl.getBoard();
		boardView = buildView.getBoardView();
		bpView = buildView.getBullpenView();
		rncv = buildView.getReleaseNumberView();
	}
	
	@Override
	public void tearDown(){
		File dir = new File("./imbriusLevelTESTING/");
		for(File file: dir.listFiles()) file.delete();
		dir.delete();
	}

	//====================== Empty to Board to Empty Tile Swapping ======================//
	public void testBoardEmptyTileSwap() {
		/*
		 * list variables needed for this test 
		 */
		MouseEvent me;
		
		/*
		 * verify that the starting board has no tiles
		 */
		assertEquals(0, releaseBoard.getNumBoardTiles());
		assertEquals(1, boardView.getMouseListeners().length);
		assertEquals(1, boardView.getMouseMotionListeners().length);
		
		/*
		 * create mouse event that will trigger a tile swap from empty to board
		 */
		assertEquals("empty", releaseBoard.getTileAt(boardView.getX()+releaseBoard.getTileSize()*2, boardView.getY()+releaseBoard.getTileSize()*2).getTileType());
		me = new MouseEvent(boardView, 
				MouseEvent.MOUSE_RELEASED, 
				System.currentTimeMillis(), 0, 
				boardView.getX()+releaseBoard.getTileSize()*2, 
				boardView.getY()+releaseBoard.getTileSize()*2, 0, false);
		rncv = buildView.getReleaseNumberView();
		assertEquals(-1, rncv.getNumberSelected());
		boardView.getMouseActionController().mouseReleased(me);
		
		/*
		 * verify change in tile type and boardTile count
		 */
		assertEquals(1, releaseBoard.getNumBoardTiles());
		assertEquals("board", releaseBoard.getTileAt(boardView.getX()+releaseBoard.getTileSize()*2, boardView.getY()+releaseBoard.getTileSize()*2).getTileType());
		
		
		/*
		 * trigger the tile back to empty
		 */
		boardView.getMouseActionController().mouseReleased(me);
		assertEquals("empty", releaseBoard.getTileAt(boardView.getX()+releaseBoard.getTileSize()*2, boardView.getY()+releaseBoard.getTileSize()*2).getTileType());
		assertEquals(0, releaseBoard.getNumBoardTiles());
	}
	
	//====================== Board to Release to Board Tile Swapping ======================//
	public void testBoardReleaseTileSwap() {
		/*
		 * list variables needed for this test 
		 */
		MouseEvent me;
		ActionEvent ae;
		
		me = new MouseEvent(boardView, 
				MouseEvent.MOUSE_RELEASED, 
				System.currentTimeMillis(), 0, 
				boardView.getX()+releaseBoard.getTileSize()*2, 
				boardView.getY()+releaseBoard.getTileSize()*2, 0, false);
		rncv = buildView.getReleaseNumberView();
		
		/*
		 * trigger the tile again to board
		 */
		boardView.getMouseActionController().mouseReleased(me);
		assertEquals("board", releaseBoard.getTileAt(boardView.getX()+releaseBoard.getTileSize()*2, boardView.getY()+releaseBoard.getTileSize()*2).getTileType());
		assertEquals(1, releaseBoard.getNumBoardTiles());
		
		/*
		 * toggle release number 1, color blue
		 */
		rncv.toggleButton(0);
		assertEquals(1, rncv.getNumberSelected());
		rncv.getColorSelector().setSelectedItem("Blue");
		assertEquals("Blue", rncv.getColorSelector().getSelectedItem());
		assertEquals(Color.BLUE, rncv.getColorSelected());
		
		/*
		 * toggle release number 2, color red
		 */
		rncv.toggleButton(0);
		rncv.toggleButton(1);
		assertEquals(2, rncv.getNumberSelected());
		rncv.getColorSelector().setSelectedItem("Red");
		ae = new ActionEvent(rncv.getColorSelector(), ActionEvent.ACTION_PERFORMED, "stuff");
		rncv.getSetColorController().actionPerformed(ae);
		assertEquals("Red", rncv.getColorSelector().getSelectedItem());
		assertEquals(Color.RED, rncv.getColorSelected());
		
		/*
		 * convert a board tile to a release tile, verify release tile creation
		 */
		boardView.getMouseActionController().mouseReleased(me);
		assertEquals("release", releaseBoard.getTileAt(boardView.getX()+releaseBoard.getTileSize()*2, boardView.getY()+releaseBoard.getTileSize()*2).getTileType());
		assertEquals(0, releaseBoard.getNumBoardTiles());
		assertEquals(2, ((ReleaseTile)releaseBoard.getTileAt(boardView.getX()+releaseBoard.getTileSize()*2, boardView.getY()+releaseBoard.getTileSize()*2)).getNumber());
		assertEquals(Color.RED, ((ReleaseTile)releaseBoard.getTileAt(boardView.getX()+releaseBoard.getTileSize()*2, boardView.getY()+releaseBoard.getTileSize()*2)).getColorSet());
		
		/*
		 * untoggle all buttons, swap tile back to board
		 */
		rncv.toggleButton(1);
		boardView.getMouseActionController().mouseReleased(me);
		assertEquals("board", releaseBoard.getTileAt(boardView.getX()+releaseBoard.getTileSize()*2, boardView.getY()+releaseBoard.getTileSize()*2).getTileType());
		assertEquals(1, releaseBoard.getNumBoardTiles());
	}
	
	public void testTileBoardToReleaseSwapMove() {
		IMove m;
		/*
		 * first convert an empty tile to a board tile
		 */
		m = new SwapTileEmptyToBoardMove((EmptyTile)releaseBoard.getTileAt(boardView.getX(), boardView.getX()), lvl.getBoard(), buildView.getLevelPropertiesView(), boardView);
		assertTrue(m.doMove());
		assertEquals(1, releaseBoard.getNumBoardTiles());
		
		/*
		 * then convert the board tile to a release tile, undo, redo
		 */
		rncv.toggleButton(2);
		assertEquals("Blue", rncv.getColorSelector().getSelectedItem());
		m = new SwapTileBoardToReleaseMove(rncv, (BoardTile)releaseBoard.getTileAt(boardView.getX(), boardView.getX()), lvl.getBoard(), boardView);
		assertTrue(m.doMove());
		assertEquals(0, releaseBoard.getNumBoardTiles());
		assertEquals(3, ((ReleaseTile)releaseBoard.getTileAt(boardView.getX(), boardView.getY())).getNumber());
		m.undo();
		assertEquals("board", releaseBoard.getTileAt(boardView.getX(), boardView.getY()).getTileType());
		m.redo();
		assertEquals("release", releaseBoard.getTileAt(boardView.getX(), boardView.getY()).getTileType());
		assertEquals(Color.BLUE, ((ReleaseTile)releaseBoard.getTileAt(boardView.getX(), boardView.getY())).getColorSet());
		
		/*
		 * untoggle button
		 */
		rncv.toggleButton(2);
		assertEquals(-1, rncv.getNumberSelected());
		
		/*
		 * swap tile with a new release tile selection, undo, redo
		 */
		rncv.toggleButton(4);
		m = new SwapTileReleaseToReleaseMove(rncv, releaseBoard.getTileAt(boardView.getX(), boardView.getX()), lvl.getBoard(), boardView);
		assertTrue(m.doMove());
		assertEquals(5, ((ReleaseTile)releaseBoard.getTileAt(boardView.getX(), boardView.getY())).getNumber());
		m.undo();
		assertEquals(3, ((ReleaseTile)releaseBoard.getTileAt(boardView.getX(), boardView.getY())).getNumber());
		m.redo();
		assertEquals(5, ((ReleaseTile)releaseBoard.getTileAt(boardView.getX(), boardView.getY())).getNumber());
		
		/*
		 * untoggle button
		 */
		rncv.toggleButton(4);
		assertEquals(-1, rncv.getNumberSelected());
		
		/*
		 * convert back to board tile, undo, redo
		 */
		m = new SwapTileReleaseToBoardMove(releaseBoard.getTileAt(boardView.getX(), boardView.getX()), lvl.getBoard(), boardView);
		assertTrue(m.doMove());
		assertEquals("board", releaseBoard.getTileAt(boardView.getX(), boardView.getY()).getTileType());
		m.undo();
		assertEquals("release", releaseBoard.getTileAt(boardView.getX(), boardView.getY()).getTileType());
		m.redo();
		assertEquals("board", releaseBoard.getTileAt(boardView.getX(), boardView.getY()).getTileType());
	}

}
