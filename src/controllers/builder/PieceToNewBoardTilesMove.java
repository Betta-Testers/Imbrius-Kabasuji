package controllers.builder;

import controllers.common.Move;
import model.AbstractTile;
import model.Board;
import model.BoardTile;
import model.Bullpen;
import model.EmptyTile;
import model.Piece;
import view.LevelPropertiesView;

/**
 * Move class for using a piece to place board tiles onto a board.
 * @author Evan
 * @author Dylan
 */
public class PieceToNewBoardTilesMove extends Move{
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
	
	/**
	 * Constructor for a PieceToNewBoardTilesMove
	 * @param bullpen being modified
	 * @param board being modified
	 * @param tile origin of click
	 * @param lpv LevelPropertiesView whose tile count is being updated
	 */
	public PieceToNewBoardTilesMove (Bullpen bullpen, Board board, AbstractTile tile, LevelPropertiesView lpv) {
		this.bullpen = bullpen;
		this.board = board;
		this.sourceTile = tile;
		this.p = bullpen.getSelectedPiece();
		this.lpv = lpv;
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
			for(int i = 0; i < 6; i++){
				board.swapTile(new BoardTile(p.getTiles()[i].getRow(), p.getTiles()[i].getCol()));
			}
			bullpen.clearSelectedPiece();
			lpv.adjustTileCount(6);
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
	 * The move is undone by swapping the tiles that were modified on the board back to empty tiles.
	 * The selected piece is reset to the piece that was used to make the board tiles.
	 * The LevelPropertiesView then adjusts the tile count of the board.
	 * @return true
	 */
	public boolean undo() {
		for(int i = 0; i < 6; i++){
			board.swapTile(new EmptyTile(p.getTiles()[i].getRow(), p.getTiles()[i].getCol()));
		}
		bullpen.setSelectedPiece(p.getID());
		lpv.adjustTileCount(-6);
		return true;
	}
	
	/**
	 * The move is redone by executing the doMove again, returning true on completion
	 * @return true
	 */
	public boolean redo() {
		doMove();
		return true;
	}
}
