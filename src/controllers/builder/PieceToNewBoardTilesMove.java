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
	/** Bullpen model in the level**/
	Bullpen bullpen;
	/** Board model in the level **/
	Board board;
	/** Piece that the hint is made from **/
	Piece p;
	/** Tile that was clicked to make the hint on, origin of piece centered here **/
	AbstractTile sourceTile;
	/** View of the bullpen, has the selected piece view **/
	BullpenView bpv;
	
	/**
	 * 
	 * @param bullpen Bullpen containing the piece to make the hint from
	 * @param board Board to place the hint on
	 * @param tile The tile that was clicked on, the location to place the origin tile of the piece at
	 * @param bpv View of the bullpen, containing the selected piece view, to update
	 */
	public PieceToNewBoardTilesMove (Bullpen bullpen, Board board, AbstractTile tile, BullpenView bpv) {
		this.bpv = bpv;
		this.bullpen = bullpen;
		this.board = board;
		this.sourceTile = tile;
		this.p = bullpen.getSelectedPiece();
		
	}
	
	/** 
	 * If move is valid, swaps out all tiles that the piece would have occupied with board tiles
	 * @return boolean True if move executed properly
	 */
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
	
	/**
	 * Determines if the move is valid, by asking the board if the piece can be placed at the location of the source tile
	 * @see model.board#isValidConvert()
	 * @return True if the move is valid, will return false if there is no piece selected in the bullpen
	 */
	public boolean isValid() {		
		if(bullpen.getSelectedPiece() != null){
			if(board.isValidConvert(p, sourceTile.getRow(), sourceTile.getCol())){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 */
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
