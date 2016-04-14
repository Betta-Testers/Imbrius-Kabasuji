/**
 * 
 */
package controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.AbstractLevelModel;
import model.AbstractTile;
import model.Piece;
import view.BullpenView;

/**
 * @author hejohnson
 *
 */
public class BoardTileController implements MouseListener{
	AbstractLevelModel levelModel;
	AbstractTile source;
	
	BoardTileController (AbstractLevelModel levelModel, AbstractTile source) {
		this.levelModel = levelModel;
		this.source = source;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		//Place piece if valid, with origin tile at this location
		Piece p = levelModel.getSelectedPiece();
		levelModel.placePieceOnBoard(p, source);
		levelModel.clearSelectedPiece();
		levelModel.updateLevelEndConditions();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// ask the board if placing a piece with the origin at this location is valid
		// mark the affected tiles appropriately either way
		Piece p = levelModel.getSelectedPiece();
		levelModel.showPieceOnBoard(p, source);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
