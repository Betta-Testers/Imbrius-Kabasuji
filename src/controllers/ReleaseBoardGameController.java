/**
 * 
 */
package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import app.Game;
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

public class ReleaseBoardGameController implements MouseListener, MouseMotionListener{
	AbstractLevelModel levelModel;
	Game game;
	
	ReleaseBoardGameController (Game game) {
		this.game = game;
		this.levelModel = game.getCurrentLevel();
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		AbstractTile source  = levelModel.getBoard().getTileAt(me.getX(), me.getY());
		PlacePieceOnBoardFromBullpenMove m = new PlacePieceOnBoardFromBullpenMove(levelModel, source);
		
		if (m.doMove()) {
			m.getPlacedPiece();
			if (levelModel.checkStatus()) {
				game.updateStars(levelModel.getID(), levelModel.getStarsEarned());
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent me) {
		AbstractTile source  = levelModel.getBoard().getTileAt(me.getX(), me.getY());
		Piece p = levelModel.getBullpen().getSelectedPiece();
		levelModel.getBoard().showPiecePreview(p, source.getRow(), source.getCol());
	}
	
	@Override
	public void mouseEntered(MouseEvent me) {
	
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent me) {
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		 
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
