package model;

import java.util.ArrayList;

/**
 * 
 * @author bwoconnor
 *
 */

public class Board {
	AbstractTile board[][] = new AbstractTile[12][12];
	//Standard row/column of matrix [row][column][0][0] is top left one below it is [1][0]
	ArrayList<Piece> pieces = new ArrayList<Piece>();
	int origBoardPieces;
	int tileSize = 32;
	
	public Board(){
		for(int i = 0;i<12;i++){
			for(int j = 0;j<12;j++){
				board[i][j] = new EmptyTile(i,j);
			}
		}
		
	}
	
	/**
	 * Places a piece onto the board: Adding it to the list of pieces, and swapping in its tiles
	 * @param p the piece being put onto the board
	 * @param row The row that the anchor tile should be placed on
	 * @param col The column that the anchor tile should be placed on
	 * @return the tile that was replaced.
	 */
	public boolean putPieceOnBoard(Piece p, int row, int col) {
		if (willFit(p, row, col)) {
			for (int i = 0; i < 6; i++) {
				swapTile(p.tiles[i],row + p.tiles[i].rowInPiece, col + p.tiles[i].colInPiece);
				AbstractTile temp = board[row + p.tiles[i].rowOnBoard][col + p.tiles[i].colOnBoard];
				p.tiles[i].setPreviousTile(temp);
			}
			pieces.add(p);
			return true;
		}
		return false;
	}
	
	/**
	 * Resets the board, removing every piece from the board and replacing them 
	 * with the tiles that used to be in their locations
	 * @return Returns an array list containing all of the old pieces that used to be on the board
	 */
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
	public boolean willFit(Piece p, int row, int col) {
		for (int i = 0; i < 6; i++) {
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
	
	/**
	 * Remove a given piece from the board, the piece must already exist on the board
	 * @param p the piece being removed from the board
	 * @return boolean of whether or not the piece was able to be removed, if used properly should ALWAYS return true
	 */
	public boolean removePiece(Piece p) {
		if (pieces.contains(p)) {
			int place = pieces.indexOf(p);
			for (int i = 0; i < 6; i++) {
				swapTile(p.tiles[i], p.tiles[i].rowOnBoard, p.tiles[i].colOnBoard);
			}
			pieces.remove(p);
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
	
	AbstractTile swapTile(AbstractTile bt, int row, int col){
		AbstractTile temp = board[row][col];
		board[row][col] = bt;
		bt.rowOnBoard = row;
		bt.colOnBoard = col;
		return temp;
	}
	
	/**
	 * returns the AbstractTile that is located at an x,y co ordinate 
	 * @param bt the tile being put onto the board
	 * @return the tile that was replaced.
	 */
	//DONE
	public AbstractTile getTileAt(int x, int y){
		int row = y/tileSize;
		int column = x/tileSize;
		return board[row][column];
	}
	
	/**
	 * changes color of tiles that may be placed, green if
	 * @param bt the tile being put onto the board
	 * @return the tile that was replaced.
	 */

	//CAN BE DONE MORE EFFICIENTLY! CHECK IF IT CAN BE PLACED WITH FIT METHOD IF IT CAN THEN CHANGE ALL TO GREEN!
	//IF NOT THEN MORE SCRUTINY NEEDED!
	public void showPiecePreview(Piece p, int row, int col){
		for(int i = 0; i<6; i++){
			if(p.tiles[i].rowInPiece+row < 0 || p.tiles[i].rowInPiece+row > 11
					|| p.tiles[i].colInPiece+col < 0 || p.tiles[i].colInPiece+row > 11){
				//DO NOTHING! IT WILL BE OUT OF THE BOARD! DO NOT WANT AN OUT OF BOUNDS ERROR//
			}else{
				if(board[row + p.tiles[i].rowInPiece][col + p.tiles[i].colInPiece].tileType.equals("empty")
						|| board[row + p.tiles[i].rowInPiece][col + p.tiles[i].colInPiece].tileType.equals("piece")){
					board[row + p.tiles[i].rowInPiece][col + p.tiles[i].colInPiece].setMouseOverColor(false);
				}else{
					board[row + p.tiles[i].rowInPiece][col + p.tiles[i].colInPiece].setMouseOverColor(true);
				}
			}
		}
	}
	
	/**
	 * Returns the total number of board tiles still remaining on the board
	 * @return the total number of board tiles still remaining on the board
	 */
	int getNumBoardTiles(){
		int count = 0;
		for(int i = 0; i <12;i++){
			for(int j = 0; j<12;j++){
				if(board[i][j].tileType.equals("board")){
					count++;
				}
			}
		}
		return count;
	}
	
	/**
	 * Will clear all piece previewing from the board, setting all tiles back to their original colors.
	 * @return void
	 */
	public void clearPiecePreview(){
		for(int i = 0; i <12; i++){
			for(int j = 0; j <12; j++){
				board[i][j].resetColor();
			}
		}
	}
}
