package app;

import java.io.File;
import java.util.ArrayList;

import junit.framework.TestCase;
import model.AbstractTile;
import model.Board;
import model.EmptyTile;
import model.LightningLevel;
import model.PieceGroup;
import model.PuzzleLevel;
import model.ReleaseLevel;

public class TestLevelFactory extends TestCase {
	LevelFactory factory;
	
	@Override
	protected void setUp(){
		new File("./imbriusLevelTESTING/").mkdirs();
		factory = new LevelFactory();
		factory.setDirectory("./imbriusLevelTESTING/");
	}

	@Override
	protected void tearDown(){
		File dir = new File("./imbriusLevelTESTING/");
		for(File file: dir.listFiles()) {file.delete();}
		dir.delete();
	}

	public void testGenerateSpecificRelease(){
		ArrayList<PieceGroup> pieces = new ArrayList<PieceGroup>();
		ArrayList<AbstractTile> tiles = new ArrayList<AbstractTile>();
		for(int i = 0; i<12; i++){
			pieces.add(new PieceGroup(i+1, i+1));
			for(int j = 0; j<12; j++){
				tiles.add(new EmptyTile(i, j));
			}
		}
		
		ReleaseLevel rl = factory.GenerateSpecificRelease(1, pieces, tiles);
		String expectedBullpen = "ID:1Count:1ID:2Count:2ID:3Count:3ID:4Count:4ID:5Count:5ID:6Count:6ID:7Count:7ID:8Count:8ID:9Count:9ID:10Count:10ID:11Count:11ID:12Count:12";;
		String expectedBoard = (new Board()).toString();
		String expectedlevel = "Release1falsefalsefalse"+expectedBoard+expectedBullpen;
		assertEquals(expectedBullpen, rl.getBullpen().toString());
		assertEquals(expectedBoard, rl.getBoard().toString());
		assertEquals(expectedlevel, rl.toString());
	}

	public void testGenerateSpecificLightning(){
		ArrayList<PieceGroup> pieces = new ArrayList<PieceGroup>();
		ArrayList<AbstractTile> tiles = new ArrayList<AbstractTile>();
		for(int i = 0; i<12; i++){
			pieces.add(new PieceGroup(i+1, i+1));
			for(int j = 0; j<12; j++){
				tiles.add(new EmptyTile(i, j));
			}
		}
		
		LightningLevel ll = factory.GenerateSpecificLightning(1, pieces, tiles);
		String expectedBullpen = "ID:1Count:1ID:2Count:2ID:3Count:3ID:4Count:4ID:5Count:5ID:6Count:6ID:7Count:7ID:8Count:8ID:9Count:9ID:10Count:10ID:11Count:11ID:12Count:12";;
		String expectedBoard = (new Board()).toString();
		String expectedlevel = "Lightning11"+expectedBoard+expectedBullpen;
		assertEquals(expectedBullpen, ll.getBullpen().toString());
		assertEquals(expectedBoard, ll.getBoard().toString());
		assertEquals(expectedlevel, ll.toString());
	}

	public void testGenerateSpecificPuzzle(){
		ArrayList<PieceGroup> pieces = new ArrayList<PieceGroup>();
		ArrayList<AbstractTile> tiles = new ArrayList<AbstractTile>();
		for(int i = 0; i<12; i++){
			pieces.add(new PieceGroup(i+1, i+1));
			for(int j = 0; j<12; j++){
				tiles.add(new EmptyTile(i, j));
			}
		}
		
		PuzzleLevel pl = factory.GenerateSpecificPuzzle(1, pieces, tiles);
		String expectedBullpen = "ID:1Count:1ID:2Count:2ID:3Count:3ID:4Count:4ID:5Count:5ID:6Count:6ID:7Count:7ID:8Count:8ID:9Count:9ID:10Count:10ID:11Count:11ID:12Count:12";
		String expectedBoard = (new Board()).toString();
		String expectedlevel = "Puzzle10"+expectedBoard+expectedBullpen;
		assertEquals(expectedBullpen, pl.getBullpen().toString());
		assertEquals(expectedBoard, pl.getBoard().toString());
		assertEquals(expectedlevel, pl.toString());
	}
	
	public void testAddToData(){
		assertTrue(factory.addToData(factory.GenerateBlankLightning(1), 1));
		/**Add non-existing level**/
		assertTrue(factory.addToData(factory.GenerateBlankLightning(2), 1));
		
		/**Add existing level**/
		assertFalse(factory.addToData(factory.GenerateBlankLightning(1), 1));
	}
	
	public void testSaveLevel(){
		factory = new LevelFactory();
		PuzzleLevel pl = factory.GenerateBlankPuzzle(1);
		/**Try saving without setting directory**/
		assertFalse(factory.saveLevel(pl));
		
		/**Try saving with setting directory**/
		factory.setDirectory("./imbriusLevelTESTING/");
		assertTrue(factory.saveLevel(pl));
	}
}
