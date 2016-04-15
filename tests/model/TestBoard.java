package model;

import junit.framework.TestCase;

import java.awt.Color;


/**
 * 
 * @author bwoconnor
 *
 */

public class TestBoard extends TestCase{
	public void testBoard(){
		Board b = new Board();
		b.board[1][0] = new BoardTile(1,0);
		b.board[2][0] = new BoardTile(2,0);
		b.board[3][0] = new BoardTile(3,0);
		b.board[4][0] = new BoardTile(4,0);
		b.board[5][0] = new BoardTile(5,0);
		
		BoardTile bt = new BoardTile(0,0);
		b.swapTile(bt, 0, 0);
		
		int i = b.getNumBoardTiles();
		
		assertEquals(i, 6);
		
		String str1 = b.board[0][0].tileType;
		String str2 = bt.tileType;
		
		assertEquals(str2, str1);
		assertEquals(bt.rowOnBoard, 0);
		
		
		Piece p = new Piece(1);
		assertTrue(b.willFit(p, 2, 0));
		
		b.putPieceOnBoard(p, 2, 0);
		String str3 = b.board[0][0].tileType;
		String str4 = "piece";
		assertEquals(str3,str4);
		
		assertTrue(b.pieces.contains(p));
		
		
	}

}
