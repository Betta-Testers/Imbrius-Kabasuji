package controllers.builder;

import controllers.common.Move;
import model.AbstractLevelModel;
import model.AbstractTile;
import model.Board;
import model.BoardTile;
import model.Bullpen;
import model.EmptyTile;
import model.Piece;
import view.BullpenView;

/**
 * Represents using a placed piece to make new boardTiles in builder
 * 
 * @author Evan
 *
 */

public class PieceToNewBoardTilesMove extends Move{
	AbstractLevelModel levelModel;
	Bullpen bullpen;
	Board board;
	Piece p;
	AbstractTile sourceTile;
	BullpenView bpv;
	
	public PieceToNewBoardTilesMove (AbstractLevelModel lm, AbstractTile tile, BullpenView bpv) {
		this.bpv = bpv;
		this.levelModel = lm;
		this.bullpen = levelModel.getBullpen();
		this.board = levelModel.getBoard();
		this.sourceTile = tile;
		this.p = bullpen.getSelectedPiece();
		
		p.setLocation(tile.getRow(), tile.getCol());
	}
	
	public boolean doMove() {
		if (isValid()) {
			for(int i = 0; i < 6; i++){
				System.out.println(p.getTiles()[i].getRow() +"," + p.getTiles()[i].getCol());
				board.swapTile(new BoardTile(p.getTiles()[i].getRow(), 
											 p.getTiles()[i].getCol()));
			}
			bullpen.clearSelectedPiece();
			return true;
		}
		return false;
	}
	
	public boolean isValid() {		
		return board.isValidConvert(p, sourceTile.getRow(), sourceTile.getCol());
	}
	
	public boolean undo() {
		for(int i = 0; i < 6; i++){
			board.swapTile(new EmptyTile(p.getTiles()[i].getRow(), p.getTiles()[i].getCol()));
		}
		bullpen.setSelectedPiece(p.getID());
		return true;
	}
	
	public boolean redo() {
		doMove();
		return true;
	}
	
	public Piece getPlacedPiece() {
		return this.p;
	}
}
