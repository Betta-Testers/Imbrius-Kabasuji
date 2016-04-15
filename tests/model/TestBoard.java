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
		b.board[0][0] = new BoardTile(0,0);
		b.board[1][0] = new BoardTile(1,0);
		b.board[2][0] = new BoardTile(2,0);
		b.board[3][0] = new BoardTile(3,0);
		b.board[4][0] = new BoardTile(4,0);
		b.board[5][0] = new BoardTile(5,0);

		
		
	}

}
