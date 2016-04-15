/**
 * 
 */
package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import app.Game;
import app.LevelIO;
import model.AbstractLevelModel;
import model.AbstractTile;
import model.Piece;
import model.PieceTile;
import view.BullpenView;

/**
 * @author hejohnson
 *
 */

//TODO add view update stuff

public class PuzzleBoardGameController implements MouseListener, MouseMotionListener{
	AbstractLevelModel levelModel;
	Piece draggedPiece;
	AbstractTile source;
	Piece p;
	Move m;
	Game game;
	
	PuzzleBoardGameController (Game game) {
		this.game = game;
		this.levelModel = game.getCurrentLevel();
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		
	}

	@Override
	public void mouseEntered(MouseEvent me) {
	
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		if (draggedPiece == null) {
			levelModel.getBoard().clearPiecePreview();
		} else { // currently dragging a piece
			Move m = new MovePieceOffBoardMove(levelModel, draggedPiece);
			m.doMove();
			if (levelModel.checkStatus()) {
				game.updateStars(levelModel.getID(), levelModel.getStarsEarned());
			}
			//levelModel.pushMove(m);
		}
	}

	@Override
	public void mousePressed(MouseEvent me) {
		source  = levelModel.getBoard().getTileAt(me.getX(), me.getY());
		if (source instanceof PieceTile) {
			draggedPiece = ((PieceTile)source).getPiece();
			levelModel.getBoard().removePiece(draggedPiece);		
		}
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		source  = levelModel.getBoard().getTileAt(me.getX(), me.getY());
		
		if (draggedPiece == null) {
			m = new PlacePieceOnBoardFromBullpenMove(levelModel, source);
		} else {
			m = new MovePieceOnBoardMove(levelModel, source, draggedPiece);
		}
		
		if (m.doMove()) {
			//levelModel.pushMove(m); // If it's a builder, the level will push onto the stack. If player, the level can just discard it
			if (levelModel.checkStatus()) {
				game.updateStars(levelModel.getID(), levelModel.getStarsEarned());
			}
		} else {
			if (draggedPiece != null) { // Can't place the piece, and a piece was being dragged. Just return the piece to the original location.
				levelModel.getBoard().putPieceOnBoard(p, p.getOriginRow(), p.getOriginCol());
			}
		} 
		draggedPiece = null;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseMoved(MouseEvent me) {
		source  = levelModel.getBoard().getTileAt(me.getX(), me.getY());
		Piece p = levelModel.getBullpen().getSelectedPiece();
		levelModel.getBoard().showPiecePreview(p, source.getRow(), source.getCol());
	}
}
