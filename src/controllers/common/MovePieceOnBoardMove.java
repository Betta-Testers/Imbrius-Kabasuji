/**
 * 
 */
package controllers.common;

import model.AbstractLevelModel;
import model.AbstractTile;
import model.Board;
import model.Piece;

/**
 * @author hejohnson
 * @author Dylan
 */
public class MovePieceOnBoardMove extends Move{
	AbstractLevelModel levelModel;
	Board board;
	/** Piece being dragged in the board **/
	Piece p;
	AbstractTile sourceTile;
	int originalRow;
	int originalCol;
	int rOffset;
	int cOffset;
	
	public MovePieceOnBoardMove (AbstractLevelModel lm, AbstractTile tile, Piece p, int rOffset, int cOffset) {
		this.levelModel = lm;
		this.board = levelModel.getBoard();
		this.sourceTile = tile;
		this.p = p;
//		this.originalRow = p.getOriginRow();
//		this.originalCol = p.getOriginCol();
		this.rOffset = rOffset;
		this.cOffset = cOffset;
	}
	
	public boolean doMove() {
		if (isValid()) {
			this.originalRow = p.getOriginRow();
			this.originalCol = p.getOriginCol();
			board.putPieceOnBoard(p, sourceTile.getRow()+rOffset, sourceTile.getCol()+cOffset);
			return true;
		}
		return false;
	}
	
	public boolean isValid() {
		if(this.p != null){
			if(board.willFit(p, sourceTile.getRow()+rOffset, sourceTile.getCol()+cOffset)){
				return true;
			}
		}
		return false;
	}
	
	public boolean undo() {
		board.removePiece(p);
		board.putPieceOnBoard(p, originalRow, originalCol);
		return true;
	}
	
	@Override
	public boolean redo() {
		doMove();
		return true;
	}
}
