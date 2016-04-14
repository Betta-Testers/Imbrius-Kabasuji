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
public class BoardMouseController implements MouseListener, MouseMotionListener{
	AbstractLevelModel levelModel;
	Piece draggedPiece;
	
	BoardMouseController (AbstractLevelModel levelModel) {
		this.levelModel = levelModel;
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		AbstractTile source  = levelModel.getTileAt(me.getX(), me.getY());
		//Place piece if valid, with origin tile at this location
		if (draggedPiece != null) {
			Piece p = levelModel.getSelectedPiece();
			if (levelModel.getBoard().willFit(p, source.getRow(), source.getCol())) {
				levelModel.placePieceOnBoard(draggedPiece, source.getRow(), source.getCol());
				levelModel.clearSelectedPiece();
				levelModel.updateLevelEndConditions();
			}
		} else {
			if (levelModel.getBoard().willFit(draggedPiece, source.getRow(), source.getCol())) {
				levelModel.placePieceOnBoard(draggedPiece, source.getRow(), source.getCol());
				levelModel.clearSelectedPiece();
				levelModel.updateLevelEndConditions();
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		// ask the board if placing a piece with the origin at this location is valid
		// mark the affected tiles appropriately either way
		AbstractTile source  = levelModel.getTileAt(me.getX(), me.getY());
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		if (draggedPiece == null) {
			levelModel.getBoard().clearPiecePreview();
		} else {
			levelModel.addPieceToBullpen(draggedPiece);
		}
		
	}

	@Override
	public void mousePressed(MouseEvent me) {
		AbstractTile source  = levelModel.getTileAt(me.getX(), me.getY());
		if (source instanceof PieceTile && levelModel instanceof PuzzleLevel) {
			draggedPiece = ((PieceTile)source).getPiece();
			levelModel.getBoard().removePiece(draggedPiece);
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseMoved(MouseEvent me) {
		AbstractTile source  = levelModel.getTileAt(me.getX(), me.getY());
		Piece p = levelModel.getSelectedPiece();
		levelModel.getBoard().showPiecePreview(p, source.getRow(), source.getCol());
	}
}
