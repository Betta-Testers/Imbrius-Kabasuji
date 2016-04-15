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
public class PlacePieceOnBoardFromBullpenMove extends Move{
	AbstractLevelModel levelModel;
	Bullpen bullpen;
	Board board;
	Piece p;
	AbstractTile sourceTile;
	
	PlacePieceOnBoardFromBullpenMove (AbstractLevelModel lm, AbstractTile tile) {
		this.levelModel = lm;
		this.bullpen = levelModel.getBullpen();
		this.board = levelModel.getBoard();
		this.sourceTile = tile;
		this.p = bullpen.getSelectedPiece();
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
		bullpen.addSinglePiece(p.getID());
	}
}