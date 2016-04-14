package model;

import java.util.ArrayList;

public class Board {
	AbstractTile board[][] = new AbstractTile[12][12];
	//Standard row/column of matrix [row][column][0][0] is top left one below it is [1][0]
	ArrayList<Piece> pieces = new ArrayList<Piece>();
	
	
	int tileSize = 32;
	
	public Board(){
		
	}
	
	/**
	 * Places a piece onto the board: Adding it to the list of pieces, and swapping in its tiles
	 * @param p the piece being put onto the board
	 * @param row The row that the anchor tile should be placed on
	 * @param col The column that the anchor tile should be placed on
	 * @return the tile that was replaced.
	 */
	boolean putPieceOnBoard(Piece p, int row, int col) {
		pieces.add(p);
		if (willFit(p, row, col)) {
			for (int i = 0; i <= 6; i++) {
				AbstractTile temp = board[row + p.tiles[i].rowOnBoard][col + p.tiles[i].colOnBoard];
				board[row + p.tiles[i].rowOnBoard][col + p.tiles[i].colOnBoard] = p.tiles[i];
				p.tiles[i].setPreviousTile(temp);
			}
			return true;
		}
		return false;
	}
	
	ArrayList<Piece> resetBoard(){
		ArrayList<Piece> piecesTemp = new ArrayList<Piece>();
		while(!pieces.isEmpty()){
			removePiece(pieces.get(0));
		}
		return piecesTemp;
	}
	
	/**
	 * Says if a piece will fit on the board with the anchor square in the row column position given
	 * @param p the piece being put onto the board
	 * @param row The row that the anchor tile should be placed on
	 * @param col The column that the anchor tile should be placed on
	 * @return boolean of whether or not the piece can be placed at that location or not
	 */
	boolean willFit(Piece p, int row, int col) {
		for (int i = 0; i <= 6; i++) {
			if (row + p.tiles[i].rowInPiece < 0 || row + p.tiles[i].rowInPiece > 11 || col + p.tiles[i].colInPiece < 0
					|| col + p.tiles[i].colInPiece > 11) {
				return false;
			} else {
				if (board[row + p.tiles[i].rowInPiece][col + p.tiles[i].colInPiece].tileType.equals("empty")
						|| board[row + p.tiles[i].rowInPiece][col + p.tiles[i].colInPiece].tileType.equals("piece")) {
					return false;
				}
			}
		}
		return true;
	}
	
	boolean removePiece(Piece p) {
		if (pieces.contains(p)) {
			int place = pieces.indexOf(p);
			for (int i = 0; i < 6; i++) {
				swapTile(p.tiles[i], p.tiles[i].rowOnBoard, p.tiles[i].colOnBoard);
			}
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Swaps a tile on the board with a new tile
	 * @param bt the tile being put onto the board
	 * @return the tile that was replaced.
	 */
	//DONE
	AbstractTile swapTile(AbstractTile bt, int row, int col){
		AbstractTile temp = board[row][col];
		board[row][col] = bt;
		return temp;
	}
	
	/**
	 * returns the AbstractTile that is located at an x,y co ordinate 
	 * @param bt the tile being put onto the board
	 * @return the tile that was replaced.
	 */
	//DONE
	AbstractTile getTileAt(int x, int y){
		int row = y/tileSize;
		int column = x/tileSize;
		return board[row][column];
	}
}
