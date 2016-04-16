package app;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import model.AbstractLevelModel;
import model.Board;
import model.Bullpen;
import model.LightningLevel;
import model.PuzzleLevel;
import model.ReleaseLevel;

/**
 * Class capable of creating levels for testing when created and saves them to disk
 * @author Dylan
 *
 */
public class LevelFactory{
	final String directory;
	StarMap levels;

	public static void main(String[] args){
		LevelFactory factory = new LevelFactory("./imbriusLevelFiles/");
	}
	
	/**
	 * Level Factory needs to :
	 * Generate 15 levels, 5 of each type. For Each:
	 * 		-> Generate a board
	 * 		-> Generate a Bullpen
	 * 			-> Set those
	 * 		-> Save to disk
	 * 			-> put in StarMap
	 * @param directory
	 */
	public LevelFactory(String directory){
		System.out.println("Factory Started...");
		this.directory = directory;
		this.levels = new StarMap(directory);
		
		for(int i=1; i <= 5; i++){
			saveLevel(GeneratePuzzle());
			saveLevel(GenerateLightning());
			saveLevel(GenerateRelease());
		}
	}
	
	
	
	ReleaseLevel GenerateRelease() {
		int id = levels.nextOpenID();
		System.out.println("	Generating Release @"+id);
		ReleaseLevel rl = new ReleaseLevel(id);
		Board board = new Board();
		Bullpen bullpen = new Bullpen(id);
		rl.setBoard(board);
		rl.setBullpen(bullpen);
		return rl;
	}



	LightningLevel GenerateLightning() {
		int id = levels.nextOpenID();
		System.out.println("	Generating Lightning @"+id);
		LightningLevel ll = new LightningLevel(id);
		Board board = new Board();
		Bullpen bullpen = new Bullpen(id);
		ll.setBoard(board);
		ll.setBullpen(bullpen);
		ll.setTotalTime(200);
		return ll;
	}



	PuzzleLevel GeneratePuzzle() {
		int id = levels.nextOpenID();
		System.out.println("	Generating Puzzle @"+id);
		PuzzleLevel pl = new PuzzleLevel(id);
		Board board = new Board();
		Bullpen bullpen = new Bullpen(id);
		pl.setBoard(board);
		pl.setBullpen(bullpen);
		pl.setMoveLimit(20);
		return pl;
	}



	public void saveLevel(AbstractLevelModel level){
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

		System.out.println("		LastKey:"+levels.lastID()+"Current:"+id);
		if(id > levels.lastID()){
			levels.put(id, type);
			levels.setMaxStars(id, 1);
		}
	}
}
