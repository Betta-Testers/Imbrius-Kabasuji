package controllers.builder;

import controllers.common.Move;
import model.AbstractTile;
import model.Board;
import model.BoardTile;
import model.Bullpen;
import model.Piece;
import view.BullpenView;

/**
 * Represents using a placed piece to make a hint in builder
 * 
 * @author Evan
 * @author Dylan
 *
 */

public class PieceToHintMove extends Move{
	Bullpen bp;
	Board b;
	Piece p;
	AbstractTile source;
	BullpenView bpv;
	
	public PieceToHintMove (Bullpen bp, Board b, AbstractTile source, BullpenView bpv) {
		this.bpv = bpv;
		this.bp = bp;
		this.b = b;
		this.source = source;
		this.p = bp.getSelectedPiece();
		
	}
	
	public boolean doMove() {
		if (isValid()) {
			p.setLocation(source.getRow(), source.getCol());
			for(int i = 0; i < 6; i++){
				((BoardTile) b.getTileAt(p.getTiles()[i].getCol()*32, p.getTiles()[i].getRow()*32)).setHint(true);
			}
			bp.clearSelectedPiece();
			return true;
		}
		return false;
	}
	
	public boolean isValid() {
		if(bp.getSelectedPiece() != null){
			if(b.willFit(p, source.getRow(), source.getCol())){
				return true;
			}
		}
		return false;
	}
	
	public boolean undo() {
		for(int i = 0; i < 6; i++){
			((BoardTile) b.getTileAt(p.getTiles()[i].getCol()*32, p.getTiles()[i].getRow()*32)).setHint(false);
		}
		bp.setSelectedPiece(p.getID());
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
