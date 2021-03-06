package model;

import junit.framework.TestCase;

import java.awt.Color;


/**
 * 
 * @author bwoconnor
 * @author awharrison
 *
 */
@SuppressWarnings("javadoc")
public class TestBoard extends TestCase{
	Board b;
	BoardTile bt;
	@Override
	protected void setUp(){
		b = new Board();
		b.board[1][0] = new BoardTile(1,0);
		b.board[2][0] = new BoardTile(2,0);
		b.board[3][0] = new BoardTile(3,0);
		b.board[4][0] = new BoardTile(4,0);
		b.board[5][0] = new BoardTile(5,0);
		bt = new BoardTile(0,0);
		b.swapTile(bt);
	}
	@Override
	protected void tearDown(){
		
	}
	
	//test if the swap method works (run in setUp)
	public void testSwapTile(){
		assertEquals("board:0,0", b.board[0][0].toString());
	}
	
	//test the number of board tiles
	public void testNumBoardTiles(){
		assertEquals(b.getNumBoardTiles(), 6);
	}
	
	//test if the new tile type is a board tile, where the tile was swapped in
	public void testType(){	
		b.swapTile(bt);
		
		String str1 = b.board[0][0].tileType;
		String str2 = bt.tileType;
		
		assertEquals(str2, str1);
		assertEquals(bt.rowOnBoard, 0);
	}
	
	//test functions working with pieces
	public void testPieceFunctions(){	
		//add a piece
		Piece p = PieceFactory.getInstance().getPiece(1);
		assertTrue(b.willFit(p, 2, 0));
		b.putPieceOnBoard(p, 2, 0);
		
		//check if tile type changed and if board contains piece
		assertEquals(b.board[0][0].tileType,"piece");
		assertTrue(b.pieces.contains(p));
		assertEquals(b.getTileAt(0, 0), b.board[0][0]);
		
		
		b.board[0][1] = new BoardTile(0,1);
		b.board[1][1] = new BoardTile(1,1);
		b.board[2][1] = new BoardTile(2,1);
		b.board[3][1] = new BoardTile(3,1);
		b.board[4][1] = new BoardTile(4,1);
		b.board[5][1] = new BoardTile(5,1);
		
		b.removePiece(p);
		
		Piece p2 = PieceFactory.getInstance().getPiece(1);
		b.showPiecePreview(p2, 2, 1);
		
		assertEquals(Color.GREEN, b.board[2][1].color);
		
		Piece p3 = PieceFactory.getInstance().getPiece(1);
		
		b.showPiecePreview(p3, 2, 2);
		assertEquals(Color.RED, b.board[2][2].color);
		
		Piece p4 = PieceFactory.getInstance().getPiece(1);
		
		b.showPiecePreview(p4, 0, 3);
		assertEquals(Color.RED, b.board[0][3].color);
		b.clearPiecePreview();
		
		assertEquals(Color.WHITE,b.board[1][1].color);
		assertEquals(Color.LIGHT_GRAY,b.board[0][3].color);
		
	}
	
	public void testPieceRotationOnBoard() {
		/*
		 * initialize board with 144 board tiles and verify
		 */
		for(int i = 0; i < 12; i++) {
			for(int j = 0; j < 12; j++) {
				b.board[i][j] = new BoardTile(i,j);
			}
		}
		assertEquals(144,b.getNumBoardTiles());
		
		/*
		 * place piece on board
		 */
		Piece p = PieceFactory.getInstance().getPiece(1);
		Piece p2 = PieceFactory.getInstance().getPiece(1);
		
		assertTrue(b.willFit(p, 4, 5));
		b.putPieceOnBoard(p, 4, 5);
		
		for(int i = 2; i < 8; i++) {
			assertEquals("piece", b.board[i][5].tileType);
		}
		
		/*
		 * rotate piece
		 */
		p.rotateLeft();
		for(int i = 2; i < 8; i++) {
			assertEquals("piece", b.board[i][5].tileType);
		}
		
		assertFalse(b.removePiece(p2));
		Piece fromBoard = b.resetBoard().get(0);
		assertEquals(p, fromBoard);
		assertFalse(p2 == fromBoard);
	}
	
	public void testNullPiece() {
		/*
		 * initialize board with 144 board tiles and verify
		 */
		for(int i = 0; i < 12; i++) {
			for(int j = 0; j < 12; j++) {
				b.board[i][j] = new BoardTile(i,j);
			}
		}
		assertEquals(144,b.getNumBoardTiles());
		
		Piece p = null;
		try{
			b.putPieceOnBoard(p, 5, 6);
		} catch (RuntimeException e) {
			
		}
	}

}
