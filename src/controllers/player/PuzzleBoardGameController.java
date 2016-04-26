package controllers.player;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;

import app.Game;
import controllers.common.IMove;
import controllers.common.MovePieceOffBoardMove;
import controllers.common.MovePieceOnBoardMove;
import controllers.common.PlacePieceOnBoardFromBullpenMove;
import model.AbstractTile;
import model.Piece;
import model.PieceTile;
import model.PuzzleLevel;
import view.BoardView;
import view.BullpenView;
import view.LevelView;
import view.SelectedPieceView;
import view.NumberMovesLeftView;

/**
 * @author hejohnson
 * @author awharrison
 *
 */

public class PuzzleBoardGameController implements MouseListener, MouseMotionListener{
	/** The level being played **/
	PuzzleLevel levelModel;
	/** Holds the tile that each mouse event is triggered over **/
	AbstractTile source;
	/** Holds the move to be executed **/
	IMove m;
	/** The overarching game object **/
	Game game;
	/** The view of the board **/
	BoardView boardView;
	/** The view of the bullpen and all its pieces **/
	BullpenView bpv;
	/** The view of the piece selected from the bullpen to be placed on the board **/
	SelectedPieceView spv;
	/** Window that holds the bullpen and board **/
	LevelView levelView;
	/** Tracks whether the mouse is over the board **/
	boolean mouseOn;
	/** Row offset of the clicked tile from the origin of the clicked piece for dragging **/
	int rOffset;
	/** Column offset of the clicked tile from the origin of the clikced piece for dragging **/
	int cOffset;

	/**
	 * 
	 * @param game The overarching game object
	 * @param lv The level view
	 */
	public PuzzleBoardGameController (Game game, LevelView lv) {
		this.game = game;
		this.levelModel = (PuzzleLevel)game.getCurrentLevel();
		this.levelView = lv;
		this.boardView = levelView.getBoardView();
		this.bpv = levelView.getBullpenView();
		this.spv = levelView.getSelectedPieceView();
	}
	
	@Override
	public void mouseClicked(MouseEvent me) {

	}

	@Override
	public void mouseEntered(MouseEvent me) {
		mouseOn = true;
	}

	/** 
	 * Handles dragging pieces off the board. 
	 * Clear the piece preview, and if a piece was being dragged, add it back to the bullpen and update the number of moves
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		mouseOn = false;
		if (levelModel.getBoard().getDraggedPiece() == null) {
			levelModel.getBoard().clearPiecePreview();
		} else { // currently dragging a piece
			IMove m = new MovePieceOffBoardMove(levelModel, levelView.getBullpenView(), boardView);
			m.doMove();
			levelModel.getBoard().setDraggedPiece(null);
			
			((NumberMovesLeftView)levelView.getEndConditionPanel()).updateMovesLeft(levelModel.getMoveLimit()-levelModel.incrementMovesMade());
			
			if (levelModel.checkStatus()) {
				levelView.dispatchEvent(new WindowEvent(levelView, WindowEvent.WINDOW_CLOSING));
			}
			levelView.getLevelInfoView().setStars(levelModel.getStarsEarned());
		}

	}

	/**
	 * Handles clicking a piece to drag it. If the mouse event occurs over a piece tile, the associated piece is removed from the board and set as the dragged piece in the board
	 * The row and column offsets are also set.
	 */
	@Override
	public void mousePressed(MouseEvent me) {
		source  = levelModel.getBoard().getTileAt(me.getX(), me.getY());
		if (levelModel.getBoard().getDraggedPiece() == null) {
			levelModel.getBoard().clearPiecePreview();
			boardView.redraw();
			boardView.repaint();
			if (source instanceof PieceTile) {
				levelModel.getBoard().setDraggedPiece(((PieceTile)source).getPiece());
				rOffset = -((PieceTile)source).getRowInPiece();
				cOffset = -((PieceTile)source).getColInPiece();
				levelModel.getBoard().removePiece(levelModel.getBoard().getDraggedPiece());	
				boardView.redraw();
				boardView.repaint();
			}
		}
	}

	/**
	 * Handles placing a piece on the board, whether it was in the bullpen or being dragged
	 * If a piece was being dragged, it is put back in its original location without updating the number of moves
	 */
	@Override
	public void mouseReleased(MouseEvent me) {
		source  = levelModel.getBoard().getTileAt(me.getX(), me.getY());

		if (mouseOn) {
			if (levelModel.getBoard().getDraggedPiece() == null) {
				m = new PlacePieceOnBoardFromBullpenMove(levelModel, source, levelView.getBullpenView(), spv, boardView);
			} else {
				m = new MovePieceOnBoardMove(levelModel.getBoard(), source, levelModel.getBoard().getDraggedPiece(), rOffset, cOffset, boardView);
			}
			
			if (m.doMove()) {
				levelModel.getBoard().setDraggedPiece(null);
				
				((NumberMovesLeftView)levelView.getEndConditionPanel()).updateMovesLeft(levelModel.getMoveLimit()-levelModel.incrementMovesMade());
				
				if (levelModel.checkStatus()) {
					levelView.dispatchEvent(new WindowEvent(levelView, WindowEvent.WINDOW_CLOSING));
				}
				levelView.getLevelInfoView().setStars(levelModel.getStarsEarned());
	
			} else {
				if (levelModel.getBoard().getDraggedPiece() != null) { // Can't place the piece, and a piece was being dragged. Just return the piece to the original location.
					levelModel.getBoard().putPieceOnBoard(levelModel.getBoard().getDraggedPiece(), levelModel.getBoard().getDraggedPiece().getOriginRow(), levelModel.getBoard().getDraggedPiece().getOriginCol());
					levelModel.getBoard().setDraggedPiece(null);
					levelModel.getBoard().clearPiecePreview();
				}
			} 
		}

	}

	/** 
	 * Handles showing the piece preview of a dragged piece if there is one
	 */
	@Override
	public void mouseDragged(MouseEvent me) {
		source  = levelModel.getBoard().getTileAt(me.getX(), me.getY());
		Piece p;
		if (levelModel.getBoard().getDraggedPiece() == null) {
			return;
		} else {
			p = levelModel.getBoard().getDraggedPiece();
		}
		levelModel.getBoard().clearPiecePreview();
		levelModel.getBoard().showPiecePreview(p, source.getRow()+rOffset, source.getCol()+cOffset);
		boardView.redraw();
		boardView.repaint();
	}

	/**
	 * Handles showing the piece preview when being placed from the bullpen
	 */
	@Override
	public void mouseMoved(MouseEvent me) {
		Piece p;
		source  = levelModel.getBoard().getTileAt(me.getX(), me.getY());
		p = levelModel.getBullpen().getSelectedPiece();
		
		if(p != null){
			levelModel.getBoard().clearPiecePreview();
			levelModel.getBoard().showPiecePreview(p, source.getRow(), source.getCol());
			boardView.redraw();
			boardView.repaint();
		}
	}
}
