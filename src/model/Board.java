package model;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * A Board stores the state of the board, including all tiles on it as well as what pieces are on it.
 * @author bwoconnor
 * @author hejohnson
 */

public class Board implements Serializable{
	/**ID for serialization**/
	private static final long serialVersionUID = -5485493680104033292L;

	/**The board[][] is a 12 by 12 array of AbstractTiles. Note that tiles are stored in the board in row-column coordinates. Row is positive down and column is positive to the right, with the top left tile located at (0,0).**/
	AbstractTile board[][] = new AbstractTile[12][12];
	
	/**Constant Tile Size.**/
	final int tileSize = 32;

	/**The pieces arrayList stores all pieces placed on the board. **/
	transient ArrayList<Piece> pieces = new ArrayList<Piece>();
	
	/**Known tiles that are hints on the board. This is used for tracking entire hints that need to be removed, rather than singular tiles**/
	ArrayList<ArrayList<BoardTile>> hintPieces = new ArrayList<ArrayList<BoardTile>>();
	
	/**The piece being dragged.**/
	transient Piece draggedPiece;

	/**
	 * Create a board with all emptyTiles.
	 */
	public Board(){
		for(int i = 0;i<12;i++){
			for(int j = 0;j<12;j++){
				board[i][j] = new EmptyTile(i,j);
			}
		}
	}

	/**
	 * Create a board with a specific setup of tiles.
	 * @param tiles - ArrayList<AbstractTile>
	 */
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
	
	/**
	 * Adds the given piece to the known hints on the board
	 * @param hintTiles ArrayList of tiles that are part of a hint
	 */
	public void addHint(ArrayList<BoardTile> hintTiles) {
		this.hintPieces.add(hintTiles);
	}
	
	/**
	 * Removes a Piece from the hintPieces arrayList based on if two piece's tile's coordinates 
	 * are the same. Uses a helper method to determine if two pieces are the same.
	 * @param p - Piece to be removed
	 */
	public void removeHint(ArrayList<BoardTile> hint) {
		for(int i = 0; i < hintPieces.size(); i++){
			if(hasSameContents(hintPieces.get(i),hint)){
				hintPieces.remove(i);
				break;
			}
		}
	}
	
	/**
	 * Helper method to the hints ArrayList. Instead of using the build in .equals method for removing
	 * an ArrayList from an ArrayList (which uses instance checking), this method will return if the
	 * ArrayList given has the same tiles as the hint given - essentially treating the two as equals.
	 * @param hintList - ArrayList from the known hints of this class
	 * @param hint - ArrayList being compared against HintList
	 * @return true if the two arrays are considered equals
	 */
	boolean hasSameContents(ArrayList<BoardTile> hintList, ArrayList<BoardTile> hint) {
		for(BoardTile bt: hintList){
			for(int i = 0; i < hint.size(); i++){
				if(bt.getRow() == hint.get(i).getRow() && bt.getCol() == hint.get(i).getCol()){
					break;
				}else if(i ==  hint.size()-1){ //Entire second array couldnt find tile with those coordinates
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Returns the list of hints on the board
	 * @return ArrayList of arraylists that are hints.
	 */
	public ArrayList<ArrayList<BoardTile>> getHintPieces(){
		return hintPieces;
	}
	
	/**
	 * Returns the piece being dragged.
	 * @return draggedPiece - Piece
	 */
	public Piece getDraggedPiece() {
		return draggedPiece;
	}
	
	/**
	 * Sets the piece being dragged.
	 * @param dp - Piece
	 */
	public void setDraggedPiece(Piece dp) {
		draggedPiece = dp;
	}

	/**
	 * Places a piece onto the board. This adds the piece to the arrayList<Piece> pieces, and swaps out the correct tiles on the board for PieceTiles.
	 * @param p (the piece being placed) - Piece
	 * @param row (row location of the piece) - int
	 * @param col (col location of the piece) - int
	 * @return if the piece was placed - boolean
	 */
	public boolean putPieceOnBoard(Piece p, int row, int col) {
		if(p == null) {
			throw new RuntimeException("putPieceOnBoard::piece being placed is null");
		}
		p.setLocation(row, col);
		if (willFit(p, row, col)) {
			for (PieceTile pt: p.getTiles()) {
				AbstractTile temp = swapTile(pt);
				pt.setPreviousTile(temp);
			}
			pieces.add(p);
			return true;
		}
		return false;
	}

	/**
	 * Resets the board, removing every piece from the board and replacing them with the previous tiles.
	 * @return piecesTemp (all pieces removed) - ArrayList<Piece>
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
	 * Removes a piece from the board. Note the piece must already exist on the board.
	 * @param p (piece being removed) - Piece
	 * @return if the piece existed and was removed - boolean
	 */
	public boolean removePiece(Piece p) {
		if (pieces.contains(p)) {
			for (PieceTile pt: p.getTiles()) {
				swapTile(pt.getPreviousTile());
			}
			pieces.remove(p);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Says if a piece will fit on the board. This function looks at interference from EmptyTiles and PieceTiles.
	 * @param p (piece being placed) - Piece
	 * @param row - int
	 * @param col - int
	 * @return if the piece can be placed at the location - boolean
	 */
	public boolean willFit(Piece p, int row, int col) {
		int r, c;
		if(!onBoard(p, row, col)){
			return false;
		}
		for (PieceTile pt: p.getTiles()) {
			r = row + pt.rowInPiece;
			c = col + pt.colInPiece;
			if(board[r][c].tileType.equals("empty") || board[r][c].tileType.equals("piece")){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Determines if a hint can fit on the board, by checking the tiles the hint is being placed on
	 * is not empty, piece, or already a hint. This method is used when placing a hint on the board
	 * in the builder from a piece.
	 * @param p - piece being checked for fitness
	 * @param row - row location of the piece
	 * @param col - column location of the peice
	 * @return true if the piece will fit
	 */
	public boolean willFitHint(Piece p, int row, int col) {
		int r, c;
		if(!onBoard(p, row, col)){
			return false;
		}
		for (PieceTile pt: p.getTiles()) {
			r = row + pt.rowInPiece;
			c = col + pt.colInPiece;
			if(board[r][c].tileType.equals("empty") || board[r][c].tileType.equals("piece") || ((BoardTile) board[r][c]).isHint()){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Says if a piece will fit on the board.
	 * @param p (piece being placed) - Piece
	 * @param row - row destination of the piece
	 * @param col - column destination of the piece
	 * @return if the piece can be placed at the location - boolean
	 */
	public boolean onBoard(Piece p, int row, int col){
		int r, c;
		for (PieceTile pt : p.getTiles()) {
			r = row + pt.getRowInPiece();
			c = col + pt.getColInPiece();
			if(r < 0 || r > 11 || c < 0 || c > 11) {return false;}
		}
		return true;
	}
	
	/**
	 * Says if a piece will be placed only on EmptyTiles.
	 * @param p (piece being placed) - Piece
	 * @param row - int
	 * @param col - int
	 * @return if the piece can be placed at the location - boolean
	 */
	public boolean isValidConvert(Piece p, int row, int col){
		int r, c;
		if(!onBoard(p, row, col)){return false;}
		for (PieceTile pt : p.getTiles()) {
			r = row + pt.getRowInPiece();
			c = col + pt.getColInPiece();
			if(!board[r][c].tileType.equals("empty")){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Swaps a tile on the board with a new tile.
	 * @param at (tile being swapped in) - AbstractTile
	 * @return temp (tile that was swapped out) - AbstractTile
	 */
	public AbstractTile swapTile(AbstractTile at){
		int row = at.getRow();
		int col = at.getCol();
		AbstractTile temp = board[row][col];
		board[row][col] = at;
		return temp;
	}

	/**
	 * Returns the AbstractTile that is located at an x,y coordinate. Note that the x coordinate relates to column, and the y coordinate relates to row.
	 * @param x - int
	 * @param y - int
	 * @return the tile at the x,y location - AbstractTile
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
	 * Changes color of tiles of where a piece maybe placed. Green means the piece can be placed, red means the piece cannot be placed.
	 * @param p (piece being placed) - Piece
	 * @param row - int
	 * @param col - int
	 */
	public void showPiecePreview(Piece p, int row, int col){
		if(willFit(p,row,col)){
			for(PieceTile pt : p.getTiles()){
				board[row + pt.getRowInPiece()][col + pt.getColInPiece()].setMouseOverColor(true);
			}
		}else{
			for(PieceTile pt : p.getTiles()){
				if(pt.getRowInPiece()+row < 0 || pt.getRowInPiece()+row > 11
						|| pt.getColInPiece()+col < 0 || pt.getColInPiece()+col > 11){
					//DO NOTHING! IT WILL BE OUT OF THE BOARD! DO NOT WANT AN OUT OF BOUNDS ERROR//
				}else{
					board[row + pt.getRowInPiece()][col + pt.getColInPiece()].setMouseOverColor(false);

				}
			}
		}
	}
	
	/**
	 * Changes color of tiles where a piece-to-board conversion may occur. Green means the piece can be converted, 
	 * red means the piece cannot be converted. Note that this is only used for the builder.
	 * @param p - Piece to be tested for fitness
	 * @param row - row location of piece
	 * @param col - col location of the peice
	 */
	public void showConversionPreview(Piece p, int row, int col){
		if(isValidConvert(p, row, col)){
			for(PieceTile pt : p.getTiles()){
				board[row + pt.getRowInPiece()][col + pt.getColInPiece()].setMouseOverColor(true);
			}
		}else{
			for(PieceTile pt : p.getTiles()){
				if(pt.getRowInPiece()+row < 0 || pt.getRowInPiece()+row > 11
						|| pt.getColInPiece()+col < 0 || pt.getColInPiece()+col > 11){
					//DO NOTHING! IT WILL BE OUT OF THE BOARD! DO NOT WANT AN OUT OF BOUNDS ERROR//
				}else{
					board[row + pt.getRowInPiece()][col + pt.getColInPiece()].setMouseOverColor(false);

				}
			}
		}
	}
	
	/**
	 * Displays a preview of where a hint will be placed on the board. Utilizies will fit hint
	 * as a method of determining color.
	 * @param p - Piece to be tested for fitness
	 * @param row - row location of piece
	 * @param col - col location of the peice
	 */
	public void showHintPreview(Piece p, int row, int col){
		if(willFitHint(p,row,col)){
			for(PieceTile pt : p.getTiles()){
				board[row + pt.getRowInPiece()][col + pt.getColInPiece()].setMouseOverColor(true);
			}
		}else{
			for(PieceTile pt : p.getTiles()){
				if(pt.getRowInPiece()+row < 0 || pt.getRowInPiece()+row > 11
						|| pt.getColInPiece()+col < 0 || pt.getColInPiece()+col > 11){
					//DO NOTHING! IT WILL BE OUT OF THE BOARD! DO NOT WANT AN OUT OF BOUNDS ERROR//
				}else{
					board[row + pt.getRowInPiece()][col + pt.getColInPiece()].setMouseOverColor(false);

				}
			}
		}
	}

	/**
	 * Returns the total number of board tiles still remaining on the board
	 * @return  int - the number of board tiles on the board
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
	 * Returns the total number of tiles that can be interacted with on a board.
	 * Used in the builder to track the count of tiles that contribute to the 6n 
	 * total.
	 * @return int - Number of release and board tiles on the board
	 */
	public int interactableTileCount(){
		int count = 0;
		for(int i = 0; i <12;i++){
			for(int j = 0; j<12;j++){
				if(board[i][j].tileType.equals("board") || board[i][j].tileType.equals("release")){
					count++;
				}
			}
		}
		return count;
	}
	
	/**
	 * Will clear all piece previewing from the board, setting all tiles back to their original colors.
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
	
	/**
	 * Returns the size of the tiles.
	 * @return tileSize - int
	 */
	public int getTileSize() {
		return this.tileSize;
	}

	/**
	 * Returns all toString() of the tiles making this board.
	 * @return string representation of this board - String
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
	 * @param stream - java.io.ObjectOutputStream
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
