package model;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Piece factory looks into the specified directory to generate known pieces for the session 
 * of the applcation. This is a singlton.
 * @author hejohnson
 */
public class PieceFactory {

	/**Instance of the PieceFactory.**/
	private static PieceFactory instance = new PieceFactory();
	/**Stores all known pieces on disk at Runtime, ID -> Piece**/
	TreeMap<Integer, Piece> pieces;
	
	private PieceFactory() {
		if(instance != null){throw new IllegalStateException("Already Instantiated");}
		loadFiles();
	}
	
	/**
	 * Returns the piece factory singleton object
	 * @return The piece factory
	 */
	public static PieceFactory getInstance() {
		return instance;
	}
	
	void loadFiles() {
		pieces = new TreeMap<Integer, Piece>();
		File piecesDir = new File("./resources/pieces/");
		File[] pieceFiles = piecesDir.listFiles();
		for (File pieceFile : pieceFiles) {
			try {
				ArrayList<String> contents = new ArrayList<String>();
				String line;
	            
	            FileReader fileReader = new FileReader(pieceFile);
	
	            BufferedReader bufferedReader = new BufferedReader(fileReader);
	
	            while((line = bufferedReader.readLine()) != null) {
	                contents.add(line);
	            }  
	            
	            int ID = Integer.parseInt(pieceFile.getName().substring(0, pieceFile.getName().indexOf(".")));
	            
	            parsePiece(ID, contents);
	            contents.clear();
	
	            // Always close files.
	            bufferedReader.close();         
	        }
	        catch(FileNotFoundException ex) {
	            System.err.println("Unable to open file");              
	        }
	        catch(IOException ex) {
	            ex.printStackTrace();
	        }
		}
	}

	/**
	 * 
	 * @param id The new piece's ID
	 * @param pieceData The string containing the color and tile coordinates
	 */
	void parsePiece(int id, ArrayList<String> pieceData) {
		Piece p = new Piece(id);
		Color c = null;
		for (String line : pieceData) {
			String[] parts = line.split(",");
			for (int i = 0; i<parts.length; i++) {
				parts[i] = parts[i].trim();
			}
			switch (parts.length) {
			case 2:
				if (p != null) {
					if (!(Integer.parseInt(parts[0]) == 0 && Integer.parseInt(parts[1]) == 0)) { // Ignore the origin tile
						p.addTile(new PieceTile(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), p));
					}
				}
				break;
			case 3:
				if (p != null) {
					c = new Color(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
				}
				break;
			default:
				throw new RuntimeException("PieceFactory::Malformed piece file, ID: " + id);
			}
		}

		p.setColor(c);
		pieces.put(p.getID(), p);
	}
	
	/**
	 * Returns a copy of the requested piece
	 * @param pID The desired piece's ID
	 * @return The piece with that ID
	 */
	public Piece getPiece(int pID) {
		if (pieces.containsKey(pID)) {
			return pieces.get(pID).makeCopy();
		} else {
			throw new RuntimeException("That piece ID does not exist");
		}
	}
	
	/**
	 * Determines if the given piece ID actually exists
	 * @param id The ID to check
	 * @return True if the ID/piece does exist
	 */
	public boolean pieceExists(int id) {
		return pieces.containsKey(id);
	}
	
	/**
	 * Returns the piece with the highest number
	 * @return The ID of the highest numbered piece
	 */
	public int getHighestNumberedPiece() {
		return pieces.lastKey();
	}
}
