/**
 * 
 */
package controllers;

import java.util.ArrayList;

import junit.framework.TestCase;
import model.Board;
import model.BoardTile;
import model.Bullpen;
import model.Piece;
import model.PieceGroup;
import model.PuzzleLevel;

/**
 * @author hejohnson
 *
 */
public class TestMoves extends TestCase {
	ArrayList<PieceGroup> playablePieces= new ArrayList<PieceGroup>();
	PuzzleLevel pl;
	Board b;
	Bullpen bp;
	
	public void setUp() {
		playablePieces.add(new PieceGroup(4, 1));
		playablePieces.add(new PieceGroup(2, 1));
		playablePieces.add(new PieceGroup(5, 2));
		playablePieces.add(new PieceGroup(3, 1));
		playablePieces.add(new PieceGroup(1, 1));
		pl = new PuzzleLevel(1);
		b = new Board();
		bp = new Bullpen(playablePieces);
		pl.setBoard(b);
		pl.setBullpen(bp);
	}
	
	public void testMovePieceOnBoard() {
		b.swapTile(new BoardTile(0,0));
		b.swapTile(new BoardTile(1,0));
		b.swapTile(new BoardTile(2,0));
		b.swapTile(new BoardTile(3,0));
		b.swapTile(new BoardTile(4,0));
		b.swapTile(new BoardTile(5,0));
		
		b.swapTile(new BoardTile(0,1));
		BoardTile placementTileFail = new BoardTile(1, 1);
		b.swapTile(placementTileFail);
		BoardTile placementTile = new BoardTile(2, 1);
		b.swapTile(placementTile);
		b.swapTile(new BoardTile(3,1));
		b.swapTile(new BoardTile(4,1));
		b.swapTile(new BoardTile(5,1));
		
		Piece p = new Piece(1);
		
		assertEquals(12, b.getNumBoardTiles());
		assertTrue(b.putPieceOnBoard(p, 2, 0));
		assertEquals(0, p.getOriginCol());
		assertEquals(2, p.getOriginRow());
		assertEquals(6, b.getNumBoardTiles());
		
		b.removePiece(p);//Done by the controller, MovePieceOnBoard is used when dragging a piece, which gets removed from the board first
		Move m = new MovePieceOnBoardMove(pl, placementTileFail, p);
		assertFalse(m.doMove());
		m = new MovePieceOnBoardMove(pl, placementTile, p);
		assertTrue(m.doMove());
		assertEquals(1, p.getOriginCol());
		assertEquals(2, p.getOriginRow());
		assertTrue(m.undo());
		assertEquals(0, p.getOriginCol());
		assertEquals(2, p.getOriginRow());
		
		m = new MovePieceOffBoardMove(pl, p);
		assertTrue(m.isValid());
		assertTrue(m.doMove());
		assertEquals(12, b.getNumBoardTiles());
		assertEquals(7, bp.numAvailablePieces());
		assertTrue(m.undo());
		assertEquals(0, p.getOriginCol());
		assertEquals(2, p.getOriginRow());
		assertEquals(6, b.getNumBoardTiles());
		assertEquals(6, bp.numAvailablePieces());
	}

}
