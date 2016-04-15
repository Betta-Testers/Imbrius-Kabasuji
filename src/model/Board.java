package model;

public class Board {
	AbstractTile board[][] = new AbstractTile[12][12];
	
	int tileSize = 32;
	
	public Board(){
		
	}
	
//	boolean putPieceOnBoard(Piece p){
		//TODO once piece is solidified, figure out how to properly add it to the matrix
//	}
	
	void resetBoard(){
		//TODO: Reset board so that no pieces are on it, piece tiles will have a list of what they replaced. 
		//needs to return something that will contain 
	}
	
	//boolean deletePiece(Piece p){
		//TODO: Will need to remove piece from board, and delete it from the list of pieces on the board
		// Should this still just return a boolean? or should it return the piece that was removed?
	//}
	
	//AbstractTile swapTile(AbstractTile bt){
		
	//}
	
	AbstractTile getTileAt(int x, int y){
		int row = x/tileSize;
		int column = y/tileSize;
		
		return board[row][column];
	}
}
