/**
 * 
 */
package controllers.player;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import app.Game;
import controllers.common.PlacePieceOnBoardFromBullpenMove;
import model.AbstractTile;
import model.Piece;
import model.ReleaseLevel;
import model.ReleaseTile;

/**
 * @author hejohnson
 *
 */

//TODO add view update stuff

public class ReleaseBoardGameController implements MouseListener, MouseMotionListener{
	ReleaseLevel levelModel;
	Game game;
	
	ReleaseBoardGameController (Game game) {
		this.game = game;
		this.levelModel = (ReleaseLevel)game.getCurrentLevel();
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		AbstractTile source  = levelModel.getBoard().getTileAt(me.getX(), me.getY());
		PlacePieceOnBoardFromBullpenMove m = new PlacePieceOnBoardFromBullpenMove(levelModel, source);
		
		if (m.doMove()) {
			Piece p = m.getPlacedPiece();
			updateReleasedNumbers(p);
			
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
	
	void updateReleasedNumbers(Piece p) {
		ArrayList<AbstractTile> coveredTiles = p.getPreviousTiles();
		for (AbstractTile at : coveredTiles) {
			if (at instanceof ReleaseTile) {
				Color color  = ((ReleaseTile) at).getColorSet();
				int number = ((ReleaseTile) at).getNumber();
				if(color == Color.RED){
					levelModel.addToRedReleased(number);
				} else if (color == Color.BLUE) {
					levelModel.addToBlueReleased(number);
				} else if (color == Color.YELLOW) {
					levelModel.addToYellowReleased(number);
				} else {
					throw new RuntimeException("Unknown color");
				}
			}
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
}
