package controllers.builder;

import controllers.common.IMove;
import model.AbstractTile;
import model.Board;
import model.BoardTile;
import model.Bullpen;
import model.EmptyTile;
import model.Piece;
import model.PieceTile;
import view.BoardView;
import view.LevelPropertiesView;
import view.SelectedPieceView;

/**
 * Move class for using a piece to place board tiles onto a board.
 * @author ejbosia
 * @author dfontana
 */
public class PieceToNewBoardTilesMove implements IMove{
	/**Bullpen whose piece is being used to make board tiles**/
	Bullpen bullpen;
	/**Board who is having tiles placed onto it**/
	Board board;
	/**Piece being used to place the tiles**/
	Piece p;
	/**The tile that was the source of the click**/
	AbstractTile sourceTile;
	/** LevelPropertiesView whose tile count is affected by the move**/
	LevelPropertiesView lpv;
	/**Updates the selected piece view after the move is done**/
	SelectedPieceView spv;
	/**Updates the board after the move is done**/
	BoardView bv;
	
	/**
	 * Constructor for a PieceToNewBoardTilesMove
	 * @param bullpen being modified
	 * @param board being modified
	 * @param tile origin of click
	 * @param lpv LevelPropertiesView whose tile count is being updated
	 * @param spv - selected piece view being cleared
	 * @param bv - board view being redrawn after move
	 */
	PieceToNewBoardTilesMove (Bullpen bullpen, Board board, AbstractTile tile, LevelPropertiesView lpv, SelectedPieceView spv, BoardView bv) {
		this.bullpen = bullpen;
		this.board = board;
		this.sourceTile = tile;
		this.p = bullpen.getSelectedPiece();
		this.lpv = lpv;
		this.spv = spv;
		this.bv = bv;
	}
	
	/**
	 * The move sets the location of the model piece to be where the user clicks on the board.
	 * It then swaps all tiles on the board with where that piece is with a BoardTile
	 * The bullpen clears the piece used (the selected piece)
	 * The LevelPropertiesView updates the change in Tile Count after move finishes.
	 * @return true if the move is done
	 */
	public boolean doMove() {
		if (isValid()) {
			p.setLocation(sourceTile.getRow(), sourceTile.getCol());
			for(PieceTile pt : p.getTiles()){
				board.swapTile(new BoardTile(pt.getRow(), pt.getCol()));
			}
			bullpen.clearSelectedPiece();
			lpv.adjustTileCount(6);
			
			//Redraw
			spv.getPiecePanel().redraw();
			spv.getPiecePanel().repaint();
			bv.redraw();
			bv.repaint();
			return true;
		}
		return false;
	}
	
	/**
	 * Determines if the move is valid, by asking the board if the piece can be placed at the location of the source tile
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
	 * The move is undone by swapping the tiles that were modified on the board back to empty tiles.
	 * The selected piece is reset to the piece that was used to make the board tiles.
	 * The LevelPropertiesView then adjusts the tile count of the board.
	 * @return true
	 */
	public boolean undo() {
		for(PieceTile pt : p.getTiles()){
			board.swapTile(new EmptyTile(pt.getRow(), pt.getCol()));
		}
		p.setLocation(0, 0);
		bullpen.setSelectedPiece(p);
		lpv.adjustTileCount(-6);
		
		//Redraw
		spv.getPiecePanel().redraw();
		spv.getPiecePanel().repaint();
		bv.redraw();
		bv.repaint();
		return true;
	}
	
	/**
	 * The move is redone by executing the doMove again, returning true on completion
	 * @return true if move was done again
	 */
	public boolean redo() {
		return doMove();
	}
}
