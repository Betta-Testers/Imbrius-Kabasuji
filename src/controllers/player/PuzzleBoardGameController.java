package controllers.player;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import app.Game;
import controllers.common.Move;
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
	PuzzleLevel levelModel;
	AbstractTile source;
	Move m;
	Game game;
	BoardView boardView;
	BullpenView bpv;
	SelectedPieceView spv;
	LevelView levelView;
	boolean mouseOn;
	int rOffset;
	int cOffset;

	public PuzzleBoardGameController (Game game, LevelView levelView) {
		this.game = game;
		this.levelModel = (PuzzleLevel)game.getCurrentLevel();
		this.levelView = levelView;
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

	@Override
	public void mouseExited(MouseEvent arg0) {
		mouseOn = false;
		if (levelModel.getBoard().getDraggedPiece() == null) {
			levelModel.getBoard().clearPiecePreview();
		} else { // currently dragging a piece
			Move m = new MovePieceOffBoardMove(levelModel, game.getLevelView().getBullpenView());
			m.doMove();
			levelModel.getBoard().setDraggedPiece(null);
			levelModel.getBoard().clearPiecePreview();
			
			((NumberMovesLeftView)levelView.getEndConditionPanel()).updateMovesLeft(levelModel.getMoveLimit()-levelModel.incrementMovesMade());
			
			if (levelModel.checkStatus()) {
				if (game.highestUnlockedID() == game.getCurrentLevel().getID()) {
					game.unlockNextLevel();
				}
				game.updateStars(game.getCurrentLevel().getID(), game.getCurrentLevel().getStarsEarned());
				game.getSelectView().updateStarsForLevel(game.getCurrentLevel().getID(), game.getCurrentLevel().getStarsEarned());
				game.getExitView().setStars(game.getCurrentLevel().getStarsEarned());
				game.getExitView().setVisible(true);
				game.getLevelView().dispose();
			}
			game.getLevelView().getLevelInfoView().setStars(levelModel.getStarsEarned());
		}
		boardView.redraw();
		boardView.repaint();
	}

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

	@Override
	public void mouseReleased(MouseEvent me) {
		source  = levelModel.getBoard().getTileAt(me.getX(), me.getY());

		if (mouseOn) {
			if (levelModel.getBoard().getDraggedPiece() == null) {
				if (levelModel.getBullpen().getSelectedPiece() != null) {
					m = new PlacePieceOnBoardFromBullpenMove(levelModel, source, game.getLevelView().getBullpenView());
				}
			} else {
				m = new MovePieceOnBoardMove(levelModel, source, levelModel.getBoard().getDraggedPiece(), rOffset, cOffset);
			}
			
			if (m.doMove()) {
				//levelModel.pushMove(m); // If it's a builder, the level will push onto the stack. If player, the level can just discard it
				levelModel.getBoard().setDraggedPiece(null);
				spv.getPiecePanel().redraw();
				spv.getPiecePanel().repaint();
				
				((NumberMovesLeftView)levelView.getEndConditionPanel()).updateMovesLeft(levelModel.getMoveLimit()-levelModel.incrementMovesMade());
				
				if (levelModel.checkStatus()) {
					if (game.highestUnlockedID() == game.getCurrentLevel().getID()) {
						game.unlockNextLevel();
					}
					game.updateStars(game.getCurrentLevel().getID(), game.getCurrentLevel().getStarsEarned());
					game.getSelectView().updateStarsForLevel(game.getCurrentLevel().getID(), game.getCurrentLevel().getStarsEarned());
					game.getExitView().setStars(game.getCurrentLevel().getStarsEarned());
					game.getExitView().setVisible(true);
					game.getLevelView().dispose();
				}
				game.getLevelView().getLevelInfoView().setStars(levelModel.getStarsEarned());
	
			} else {
				if (levelModel.getBoard().getDraggedPiece() != null) { // Can't place the piece, and a piece was being dragged. Just return the piece to the original location.
					levelModel.getBoard().putPieceOnBoard(levelModel.getBoard().getDraggedPiece(), levelModel.getBoard().getDraggedPiece().getOriginRow(), levelModel.getBoard().getDraggedPiece().getOriginCol());
					levelModel.getBoard().setDraggedPiece(null);
					levelModel.getBoard().clearPiecePreview();
				}
			} 
		}
		boardView.redraw();
		boardView.repaint();

	}

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
