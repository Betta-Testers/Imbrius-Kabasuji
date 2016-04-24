package controllers.builder;

import controllers.common.Move;
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
	Bullpen bullpen;
	Board board;
	Piece p;
	AbstractTile sourceTile;
	BullpenView bpv;
	
	public PieceToNewBoardTilesMove (Bullpen bullpen, Board board, AbstractTile tile, BullpenView bpv) {
		this.bpv = bpv;
		this.bullpen = bullpen;
		this.board = board;
		this.sourceTile = tile;
		this.p = bullpen.getSelectedPiece();
		
	}
	
	public boolean doMove() {
		if (isValid()) {
			p.setLocation(sourceTile.getRow(), sourceTile.getCol());
			for(int i = 0; i < 6; i++){
				board.swapTile(new BoardTile(p.getTiles()[i].getRow(), p.getTiles()[i].getCol()));
			}
			bullpen.clearSelectedPiece();
			return true;
		}
		return false;
	}
	
	public boolean isValid() {		
		if(bullpen.getSelectedPiece() != null){
			if(board.isValidConvert(p, sourceTile.getRow(), sourceTile.getCol())){
				return true;
			}
		}
		return false;
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
