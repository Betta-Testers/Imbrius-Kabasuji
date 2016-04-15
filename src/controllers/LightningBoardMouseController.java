/**
 * 
 */
package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

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

public class LightningBoardMouseController implements MouseListener, MouseMotionListener{
	AbstractLevelModel levelModel;
	
	LightningBoardMouseController (AbstractLevelModel levelModel) {
		this.levelModel = levelModel;
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		AbstractTile source  = levelModel.getBoard().getTileAt(me.getX(), me.getY());
		Move m = new PlacePieceOnBoardFromBullpenMove(levelModel, source);
		
		if (m.doMove()) {
			//levelModel.pushMove(m); // If it's a builder, the level will push onto the stack. If player, the level can just discard it
		}
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

	@Override
	public void mouseMoved(MouseEvent me) {
		AbstractTile source  = levelModel.getBoard().getTileAt(me.getX(), me.getY());
		Piece p = levelModel.getBullpen().getSelectedPiece();
		levelModel.getBoard().showPiecePreview(p, source.getRow(), source.getCol());
	}
}
