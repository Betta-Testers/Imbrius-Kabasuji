/**
 * 
 */
package controllers;

import model.AbstractLevelModel;
import model.AbstractTile;
import model.Board;
import model.Bullpen;
import model.Piece;

/**
 * @author hejohnson
 *
 */
public class MovePieceOnBoardMove extends Move{
	AbstractLevelModel levelModel;
	Board board;
	Piece p;
	AbstractTile sourceTile;
	int originalRow;
	int originalCol;
	
	MovePieceOnBoardMove (AbstractLevelModel lm, AbstractTile tile, Piece p) {
		this.levelModel = lm;
		this.board = levelModel.getBoard();
		this.sourceTile = tile;
		this.p = p;
		this.originalRow = p.getOriginRow();
		this.originalCol = p.getOriginCol();
	}
	
	public boolean doMove() {
		if (isValid()) {
			board.placePiece(p, sourceTile.getRow(), sourceTile.getCol());
			bullpen.decrementSelectedPiece();
			bullpen.clearSelectedPiece();
			levelModel.updateLevelEndConditions();
			return true;
		}
		return false;
	}
	
	public boolean isValid() {
		return board.willFit(p, sourceTile.getRow(), sourceTile.getCol());
	}
	
	public boolean undo() {
		board.removePiece(p);
		board.placePiece(p, originalRow, originalCol);
	}
}