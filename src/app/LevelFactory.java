package app;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.AbstractLevelModel;
import model.AbstractTile;
import model.Board;
import model.Bullpen;
import model.LightningLevel;
import model.PieceGroup;
import model.PuzzleLevel;
import model.ReleaseLevel;

/**
 * Class capable of creating levels for testing when created and saves them to disk
 * @author Dylan
 *
 */
public class LevelFactory{
	String directory;
	StarMap levels;

	public static void main(String[] args){
		LevelFactory factory = new LevelFactory();
		factory.quick15("./imbriusLevelFiles/");
	}
	
	public LevelFactory(){
		System.out.println("Factory Started...");
	}
	
	/**
	 * Generates 15 levels, 5 of each type going Puzzle, Release, Lightning, Puzzle..
	 * Saves each to disk and stores each one into the StarMap.
	 * Good quick testing needs
	 * @param directory -> location where the files will be made
	 */
	public void quick15(String directory){
		this.directory = directory;
		this.levels = new StarMap(directory);
		for(int i=1; i <= 5; i++){
			PuzzleLevel pl = GeneratePuzzle(levels.nextOpenID(), 15);
			saveLevel(pl);
			addToData(pl, 2);
			LightningLevel ll = GenerateLightning(levels.nextOpenID(), 15);
			saveLevel(ll);
			addToData(ll, 3);
			ReleaseLevel rl = GenerateRelease(levels.nextOpenID(), 15);
			saveLevel(rl);
			addToData(rl, 1);
		}
	}
	
	/**
	 * Generates a ReleaseLevel with the given ID. The Board and bullpen of this release
	 * level are populated with the pieces and tiles passed in.
	 * @param id	- LevelID
	 * @param pieces - ArrayList of all pieces to be put into the bullpen
	 * @param tiles - ArrayList of all tiles to be added to the board.
	 * @return ReleaseLevel
	 */
	public ReleaseLevel GenerateSpecificRelease(int id, ArrayList<PieceGroup> pieces, ArrayList<AbstractTile> tiles){
		System.out.println("	Generating NOTSAVED Specific Release @"+id);
		ReleaseLevel rl = new ReleaseLevel(id);
		Board board = new Board(tiles);
		Bullpen bullpen = new Bullpen(pieces);
		rl.setBoard(board);
		rl.setBullpen(bullpen);
		return rl;
	}
	
	/**
	 * Generates a LightningLevel with the given ID. The Board and bullpen of this lightning
	 * level are populated with the pieces and tiles passed in.
	 * @param id	- LevelID
	 * @param pieces - ArrayList of all pieces to be put into the bullpen
	 * @param tiles - ArrayList of all tiles to be added to the board.
	 * @return ReleaseLevel
	 */
	public LightningLevel GenerateSpecificLightning(int id, ArrayList<PieceGroup> pieces, ArrayList<AbstractTile> tiles){
		System.out.println("	Generating NOTSAVED Specific Lightning @"+id);
		LightningLevel ll = new LightningLevel(id);
		Board board = new Board(tiles);
		Bullpen bullpen = new Bullpen(pieces);
		ll.setBoard(board);
		ll.setBullpen(bullpen);
		return ll;
	}
	
	/**
	 * Generates a PuzzleLevel with the given ID. The Board and bullpen of this puzzle
	 * level are populated with the pieces and tiles passed in.
	 * @param id	- LevelID
	 * @param pieces - ArrayList of all pieces to be put into the bullpen
	 * @param tiles - ArrayList of all tiles to be added to the board.
	 * @return ReleaseLevel
	 */
	public PuzzleLevel GenerateSpecificPuzzle(int id, ArrayList<PieceGroup> pieces, ArrayList<AbstractTile> tiles){
		System.out.println("	Generating NOTSAVED Specific Puzzle @"+id);
		PuzzleLevel pl = new PuzzleLevel(id);
		Board board = new Board(tiles);
		Bullpen bullpen = new Bullpen(pieces);
		pl.setBoard(board);
		pl.setBullpen(bullpen);
		return pl;
	}
	
	/**
	 * Generates a ReleaseLevel with the given ID and bullpen size
	 * Note the bullpen is random in this case. If you want to specify
	 * the exact pieces in the bullpen/board, use the alternate method
	 * @param id	- LevelID
	 * @param bullpenSize - Size of randomly generated bullpen
	 * @return ReleaseLevel
	 */
	public ReleaseLevel GenerateRelease(int id, int bullpenSize) {
		System.out.println("	Generating NOTSAVED Release @"+id);
		ReleaseLevel rl = new ReleaseLevel(id);
		Board board = new Board();
		Bullpen bullpen = new Bullpen(bullpenSize);
		rl.setBoard(board);
		rl.setBullpen(bullpen);
		return rl;
	}

	/**
	 * Generates a LightningLevel with the given ID and bullpen size
	 * Note the bullpen is random in this case. If you want to specify
	 * the exact pieces in the bullpen/board, use the alternate method
	 * @param id	- LevelID
	 * @param bullpenSize - Size of randomly generated bullpen
	 * @return LightningLevel
	 */
	public LightningLevel GenerateLightning(int id, int bullpenSize) {
		System.out.println("	Generating NOTSAVED Lightning @"+id);
		LightningLevel ll = new LightningLevel(id);
		Board board = new Board();
		Bullpen bullpen = new Bullpen(bullpenSize);
		ll.setBoard(board);
		ll.setBullpen(bullpen);
		ll.setTotalTime(200);
		return ll;
	}

	/**
	 * Generates a puzzle level with the given ID and bullpen size
	 * Note the bullpen is random in this case. If you want to specify
	 * the exact pieces in the bullpen/board, use the alternate method
	 * @param id	- LevelID
	 * @param bullpenSize - Size of randomly generated bullpen
	 * @return PuzzleLevel
	 */
	public PuzzleLevel GeneratePuzzle(int id, int bullpenSize) {
		System.out.println("	Generating NOTSAVED Puzzle @"+id);
		PuzzleLevel pl = new PuzzleLevel(id);
		Board board = new Board();
		Bullpen bullpen = new Bullpen(bullpenSize);
		pl.setBoard(board);
		pl.setBullpen(bullpen);
		pl.setMoveLimit(20);
		return pl;
	}
	
	/**
	 * Generates a ReleaseLevel with the given ID and bullpen size
	 * Note the bullpen is random in this case. If you want to specify
	 * the exact pieces in the bullpen/board, use the alternate method
	 * @param id	- LevelID
	 * @param bullpenSize - Size of randomly generated bullpen
	 * @return ReleaseLevel
	 */
	public ReleaseLevel GenerateBlankRelease(int id){
		System.out.println("	Generating NOTSAVED Blank Release @"+id);
		ReleaseLevel rl = new ReleaseLevel(id);
		Board board = new Board();
		Bullpen bullpen = new Bullpen();
		rl.setBoard(board);
		rl.setBullpen(bullpen);
		return rl;
	}

	/**
	 * Generates a LightningLevel with the given ID and bullpen size
	 * Note the bullpen is random in this case. If you want to specify
	 * the exact pieces in the bullpen/board, use the alternate method
	 * @param id	- LevelID
	 * @param bullpenSize - Size of randomly generated bullpen
	 * @return LightningLevel
	 */
	public LightningLevel GenerateBlankLightning(int id){
		System.out.println("	Generating NOTSAVED Blank Lightning @"+id);
		LightningLevel ll = new LightningLevel(id);
		Board board = new Board();
		Bullpen bullpen = new Bullpen();
		ll.setBoard(board);
		ll.setBullpen(bullpen);
		return ll;
	}

	/**
	 * Generates a puzzle level with the given ID and bullpen size
	 * Note the bullpen is random in this case. If you want to specify
	 * the exact pieces in the bullpen/board, use the alternate method
	 * @param id	- LevelID
	 * @param bullpenSize - Size of randomly generated bullpen
	 * @return PuzzleLevel
	 */
	public PuzzleLevel GenerateBlankPuzzle(int id){
		System.out.println("	Generating NOTSAVED Blank Puzzle @"+id);
		PuzzleLevel pl = new PuzzleLevel(id);
		Board board = new Board();
		Bullpen bullpen = new Bullpen();
		pl.setBoard(board);
		pl.setBullpen(bullpen);
		return pl;
	}
	
	/**
	 * Adds a given model and the stars assigned to it into the StarMap. This will cause the
	 * StarMap to save itself. Can only add a model whose ID is not already in the starMap of 
	 * this Factory.
	 * @param m - AbstractLevelModel (Puzzle, Release, Lightning)
	 * @param starsEarned - Max Stars you wish to assign to it
	 */
	public void addToData(AbstractLevelModel m, int starsEarned){
		String type = m.getType();
		int id = m.getID();
		System.out.println("		LastKey:"+levels.lastID()+"Current:"+id);
		if(!levels.containsKey(id)){
			levels.put(id, type);
			levels.setMaxStars(id, starsEarned);
		}
	}
	
	/**
	 * Saves the given level to the current directory assigned in this factory
	 * @param level - Level you wish to save to disk
	 */
	public void saveLevel(AbstractLevelModel level){
		if(directory == null){ throw new RuntimeException("Did not set Factory's Directory!");}
		
		ObjectOutputStream oos = null;

		int id = level.getID();
		String type = level.getType();
		String location = directory+id+"_"+type+".storage";

		try {
			oos = new ObjectOutputStream(new FileOutputStream(location));
			oos.writeObject(level);
		} catch (Exception e) {
			System.err.println("Unable to save the level:" + e.getMessage());
		}

		if (oos != null) {
			try { oos.close(); } catch (IOException ioe) { } 
		}
	}

	/**
	 * Set Directory changes the directory this factory points to. Doing this forces a 
	 * recreation of the StarMap in this factory, which will subsequently change the
	 * one of DISK. Use this method carefully. Useful for testing, when you want to 
	 * clear a directory and rebase the StarMap.
	 * @param directory - Location on disk of where you want to point the factory to
	 */
	public void setDirectory(String directory){
		this.directory = directory;
		this.levels = new StarMap(directory);
	}
}
