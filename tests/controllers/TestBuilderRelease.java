package controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.Timer;

import controllers.builder.BuilderSplashTimerController;
import model.Board;
import model.Bullpen;
import model.PuzzleLevel;
import model.ReleaseLevel;
import model.ReleaseTile;
import view.BoardView;
import view.BuilderView;
import view.BullpenView;
import view.ButtonGroupView;
import view.LevelPropertiesView;
import view.ReleaseNumberCreationView;
import view.SplashScreen;
import app.Builder;
import junit.framework.TestCase;

/**
 * 
 * @author awharrison
 *
 */

public class TestBuilderRelease extends TestCase {
	Builder build;
	BuilderView buildView;
	
	@Override
	public void setUp(){
		new File("./imbriusLevelTESTING/").mkdirs();
		build = new Builder("./imbriusLevelTESTING/");
	}
	
	@Override
	public void tearDown(){
		File dir = new File("./imbriusLevelTESTING/");
		for(File file: dir.listFiles()) file.delete();
		dir.delete();
	}
	
	public void testPuzzleLightningBoard() {
		/*
		 * list variables needed for this test 
		 */
		PuzzleLevel lvl;
		Board puzzleBoard;
		BoardView boardView;
		Bullpen bp;
		BullpenView bpView;
		LevelPropertiesView lvlPropView;
		ButtonGroupView buttonGroupView;
		
		//====================== Start Up ======================//
		
		/*
		 * start splash screen and timer
		 */
		SplashScreen splash = new SplashScreen();
		Timer timer = new Timer(100, new BuilderSplashTimerController(splash, build));
		timer.setRepeats(false);
		timer.start();
		
		/*
		 * wait until the expected time is up
		 */
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//====================== Select Level Type ======================//
		
		/*
		 * create a mouse event to select build puzzle level
		 */
		MouseEvent me = new MouseEvent(build.getLevelTypeSelectView(), 
				MouseEvent.MOUSE_CLICKED, 
				System.currentTimeMillis(), 0, 
				build.getLevelTypeSelectView().getX(), 
				build.getLevelTypeSelectView().getY(), 1, false);
		
		/*
		 * handle the mouse event 
		 */
		build.getLevelTypeSelectView().getPuzzleBtnHandler().mouseClicked(me);
		
		/*
		 * verify that level created was a Puzzle level
		 */
		lvl = (PuzzleLevel)build.getCurrentLevel();
		assertEquals("Puzzle", lvl.getType());
		
		//====================== Manipulate Bullpen/Hover Mouse on Board ======================//
		//====================== Rotate Pieces ======================//
		//====================== Place and Remove Pieces ======================//
		//====================== Set Moves (and timer?) ======================//
		//====================== Convert to Hint ======================//
		//====================== Undo/Redo ======================//
		//====================== Save Level? ======================//
		
	}
	
	public void testReleaseBoard() {
		/*
		 * list variables needed for this test 
		 */
		ReleaseLevel lvl;
		Board releaseBoard;
		BoardView boardView;
		Bullpen bp;
		BullpenView bpView;
		LevelPropertiesView lvlPropView;
		ButtonGroupView buttonGroupView;
		ReleaseNumberCreationView rncv;
		MouseEvent me;
		ActionEvent ae;
		
		//====================== Start Up ======================//
		
		/*
		 * start splash screen and timer
		 */
		SplashScreen splash = new SplashScreen();
		Timer timer = new Timer(100, new BuilderSplashTimerController(splash, build));
		timer.setRepeats(false);
		timer.start();
		
		/*
		 * wait until the expected time is up
		 */
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//====================== Select Level Type ======================//
		
		/*
		 * create a mouse event to select build puzzle level
		 */
		me = new MouseEvent(build.getLevelTypeSelectView(), 
				MouseEvent.MOUSE_CLICKED, 
				System.currentTimeMillis(), 0, 
				build.getLevelTypeSelectView().getX(), 
				build.getLevelTypeSelectView().getY(), 1, false);
		
		/*
		 * handle the mouse event 
		 */
		build.getLevelTypeSelectView().getReleaseBtnHandler().mouseClicked(me);
		
		/*
		 * verify that level created is a release level
		 */
		lvl = (ReleaseLevel)build.getCurrentLevel();
		assertEquals("Release", lvl.getType());
		
		/*
		 * set necessary variables
		 */

		buildView = build.getBuilderView();
		releaseBoard = lvl.getBoard();
		bpView = buildView.getBullpenView();
		boardView = buildView.getBoardView();
		
		//====================== Empty to Board to Empty Tile Swapping ======================//
		
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
		
		//====================== Board to Release to Board Tile Swapping ======================//
		
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
		// TODO figure out why this is returning the color r=255, g=255, b=255
//		assertEquals(Color.RED, ((ReleaseTile)releaseBoard.getTileAt(boardView.getX()+releaseBoard.getTileSize()*2, boardView.getY()+releaseBoard.getTileSize()*2)).getColor());
		
		/*
		 * untoggle all buttons, swap tile back to board
		 */
		rncv.toggleButton(1);
		boardView.getMouseActionController().mouseReleased(me);
		assertEquals("board", releaseBoard.getTileAt(boardView.getX()+releaseBoard.getTileSize()*2, boardView.getY()+releaseBoard.getTileSize()*2).getTileType());
		assertEquals(1, releaseBoard.getNumBoardTiles());
	}

}
