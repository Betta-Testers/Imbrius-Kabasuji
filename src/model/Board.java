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
	boolean putPieceOnBoard(Piece p, int row, int col){
		pieces.add(p);
		for(int i = 0; i<=6;i++){
			AbstractTile temp = board[row+p.tiles[i].rowOnBoard][col+p.tiles[i].colOnBoard];
			board[row+p.tiles[i].rowOnBoard][col+p.tiles[i].colOnBoard] = p.tiles[i];
			//p.tiles[i].oldTile = temp;
		}
		return true;
	}
	
	void resetBoard(){
		//TODO: Reset board so that no pieces are on it, piece tiles will have a list of what they replaced. 
		//needs to return something that will contain all the pieces
	}
	
	/**
	 * Says if a piece will fit on the board with the anchor square in the row column position given
	 * @param p the piece being put onto the board
	 * @param row The row that the anchor tile should be placed on
	 * @param col The column that the anchor tile should be placed on
	 * @return boolean of whether or not the piece can be placed at that location or not
	 */
	boolean willFit(Piece p, int row, int col){
		for(int i = 0; i <=6;i++){
			if(board[row+p.tiles[i].rowInPiece][col+p.tiles[i].colInPiece].tileType.equals("empty")
			 ||board[row+p.tiles[i].rowInPiece][col+p.tiles[i].colInPiece].tileType.equals("piece")){
				return false;
			}
		}
		return true;
	}
	
	//boolean removePiece(Piece p){
		//TODO: Will need to remove piece from board, and delete it from the list of pieces on the board
		// Should this still just return a boolean? or should it return the piece that was removed?
	//}
	
	/**
	 * Swaps a tile on the board with a new tile
	 * @param bt the tile being put onto the board
	 * @return the tile that was replaced.
	 */
	AbstractTile swapTile(AbstractTile bt){
		int row = bt.rowOnBoard;
		int col = bt.colOnBoard;
		AbstractTile temp = board[row][col];
		board[row][col] = bt;
		return temp;
	}
	
	AbstractTile getTileAt(int x, int y){
		int row = x/tileSize;
		int column = y/tileSize;
		
		return board[row][column];
	}
}
