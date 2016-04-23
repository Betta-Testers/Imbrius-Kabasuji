package model;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author bwoconnor
 *
 */

public class Board implements Serializable{
	/**ID for serialization**/
	private static final long serialVersionUID = -5485493680104033292L;

	AbstractTile board[][] = new AbstractTile[12][12];
	/**Constant Tile Size**/
	final int tileSize = 32;

	//Standard row/column of matrix [row][column][0][0] is top left one below it is [1][0]
	transient ArrayList<Piece> pieces = new ArrayList<Piece>();
	transient Piece draggedPiece;

	public Board(){
		for(int i = 0;i<12;i++){
			for(int j = 0;j<12;j++){
				board[i][j] = new EmptyTile(i,j);
			}
		}

	}

	public Board(ArrayList<AbstractTile> tiles){
		for(int i = 0;i<12;i++){
			for(int j = 0;j<12;j++){
				board[i][j] = new EmptyTile(i,j);
			}
		}
		ArrayList<AbstractTile> temp = tiles;
		while(!temp.isEmpty()){
			this.swapTile(temp.get(0));
			temp.remove(0);
		}
	}
	
	public Piece getDraggedPiece() {
		return draggedPiece;
	}
	
	public void setDraggedPiece(Piece dp) {
		draggedPiece = dp;
	}

	/**
	 * Places a piece onto the board: Adding it to the list of pieces, and swapping in its tiles
	 * @param p the piece being put onto the board
	 * @param row The row that the anchor tile should be placed on
	 * @param col The column that the anchor tile should be placed on
	 * @return the tile that was replaced.
	 */
	public boolean putPieceOnBoard(Piece p, int row, int col) {
		p.setLocation(row, col);
		if (willFit(p, row, col)) {
			for (int i = 0; i < 6; i++) {
				AbstractTile temp = swapTile(p.tiles[i]);
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
	public ArrayList<Piece> resetBoard(){
		ArrayList<Piece> piecesTemp = new ArrayList<Piece>();
		while(!pieces.isEmpty()){
			Piece p = pieces.get(0);
			piecesTemp.add(p);
			removePiece(p);
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
			for (int i = 0; i < 6; i++) {
				swapTile(p.tiles[i].getPreviousTile());
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
	public AbstractTile swapTile(AbstractTile at){
		int row = at.getRow();
		int col = at.getCol();
		AbstractTile temp = board[row][col];
		board[row][col] = at;
		return temp;
	}

	/**
	 * returns the AbstractTile that is located at an x,y co ordinate 
	 * @param bt the tile being put onto the board
	 * @return the tile that was replaced.
	 */
	public AbstractTile getTileAt(int x, int y){
		int row = y/tileSize;
		int column = x/tileSize;
		if(row > 11){
			row = 11;
		}else if(row < 0){
			row = 0;
		}

		if(column > 11){
			column = 11;
		}else if(column < 0){
			column = 0;
		}
		return board[row][column];
	}

	/**
	 * changes color of tiles that may be placed, green if
	 * @param bt the tile being put onto the board
	 * @return the tile that was replaced.
	 */
	public void showPiecePreview(Piece p, int row, int col){
		if(willFit(p,row,col)){
			for(int i = 0; i<6; i++){
				board[row + p.tiles[i].rowInPiece][col + p.tiles[i].colInPiece].setMouseOverColor(true);
			}
		}else{
			for(int i = 0; i<6; i++){
				if(p.tiles[i].rowInPiece+row < 0 || p.tiles[i].rowInPiece+row > 11
						|| p.tiles[i].colInPiece+col < 0 || p.tiles[i].colInPiece+col > 11){
					//DO NOTHING! IT WILL BE OUT OF THE BOARD! DO NOT WANT AN OUT OF BOUNDS ERROR//
				}else{
					board[row + p.tiles[i].rowInPiece][col + p.tiles[i].colInPiece].setMouseOverColor(false);

				}
			}
		}
	}

	/**
	 * Returns the total number of board tiles still remaining on the board
	 * @return the total number of board tiles still remaining on the board
	 */
	public int getNumBoardTiles(){
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

	/**
	 * Returns the number of pieces on the board. Used to validate a RemoveAllPiecesMove.
	 * @return int - number of pieces in the pieces array
	 */
	public int getPieceCount(){
		return this.pieces.size();
	}
	
	
	public int getTileSize() {
		return this.tileSize;
	}

	/**
	 * Returns all toString() of the tiles making this board
	 * @return String representation of this board
	 */
	public String toString(){
		StringBuilder s = new StringBuilder();
		for(AbstractTile[] row: this.board){
			for(AbstractTile t: row){
				s.append(t.toString());		
			}
			s.append("\n");
		}
		return s.toString();
	}

	/**
	 * Custom serialization clears the boards of piece tiles and replaces those tiles with what they were covering
	 * Allows system to not care if the board has pieces on it when saving
	 * @param stream
	 * @throws IOException
	 */
	private void writeObject(java.io.ObjectOutputStream stream) throws IOException{
		resetBoard();
		stream.defaultWriteObject();
	}

	/**
	 * When deserializing this, the transient fields needs to be initialized.
	 * This method does just that, by calling the initialize method.
	 */
	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException{
		in.defaultReadObject();
		pieces = new ArrayList<Piece>();
	}
}
