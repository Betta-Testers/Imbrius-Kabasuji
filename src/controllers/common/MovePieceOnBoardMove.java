package controllers.common;

import model.AbstractTile;
import model.Board;
import model.Piece;
import view.BoardView;
import view.SelectedPieceView;

/**
 * Move handling the movement of a piece on the board into another location on the board
 * @author hejohnson
 * @author dfontana
 * @author awharrison
 */
public class MovePieceOnBoardMove implements IMove{
	/**Board whose pieces are being moved about**/
	Board board;
	/** Piece being dragged in the board **/
	Piece p;
	/**Tile that was clicked (destination tile)**/
	AbstractTile sourceTile;
	/**Location the piece was originally in - row**/
	int originalRow;
	/**Location the piece was originally in - col**/
	int originalCol;
	/**Location the piece will be placed in - row**/
	int rOffset;
	/**Location the piece will be placed in - col**/
	int cOffset;
	/**Updates the selected piece view**/
	SelectedPieceView spv;
	/**Updates the view of the board**/
	BoardView bv;
	
	/**
	 * Creates the move
	 * @param lm - level model being manipulated
	 * @param tile - tile that was pressed (destination)
	 * @param p - piece that is being moved
	 * @param rOffset - offset of row where the piece wants to be placed
	 * @param cOffset - offset of col where the piece wants to be placed
	 */
	public MovePieceOnBoardMove (Board board, AbstractTile tile, Piece p, int rOffset, int cOffset, SelectedPieceView spv, BoardView bv) {
		this.board = board;
		this.sourceTile = tile;
		this.p = p;
		this.rOffset = rOffset;
		this.cOffset = cOffset;
	}
	
	/**
	 * The move is done by clearing the preview, storing the location of the piece,
	 * removing the piece from the board, placing the piece back on the board in the offset
	 * location, and then setting the dragged piece of the board to null.
	 * @return true if the move was made.
	 */
	public boolean doMove() {
		if (isValid()) {
			board.clearPiecePreview();
			this.originalRow = p.getOriginRow();
			this.originalCol = p.getOriginCol();
			board.removePiece(p);
			board.putPieceOnBoard(p, sourceTile.getRow()+rOffset, sourceTile.getCol()+cOffset);
			board.setDraggedPiece(null);
			
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
	 * Checks to see if the piece passed in is not null (hence being dragged from the board). If so,
	 * it checks if the piece will fit where it is trying to go. If both
	 * check out, the move is valid.
	 * @return boolean - true if the move can be made
	 */
	public boolean isValid() {
		if(this.p != null){
			if(board.willFit(p, sourceTile.getRow()+rOffset, sourceTile.getCol()+cOffset)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Undoes the move by removing the piece and restoring it to the location it was
	 * previously at on the board
	 * @return true - the move can always be undone
	 */
	public boolean undo() {
		board.removePiece(p);
		board.putPieceOnBoard(p, originalRow, originalCol);
		
		//Redraw
		spv.getPiecePanel().redraw();
		spv.getPiecePanel().repaint();
		bv.redraw();
		bv.repaint();
		return true;
	}
	
	/**
	 * Redoes the move.
	 * @return true if the move could be made again
	 */
	@Override
	public boolean redo() {
		return doMove();
	}
}
