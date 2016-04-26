package controllers.player;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import app.Game;
import controllers.common.PlacePieceOnBoardFromBullpenMove;
import model.AbstractTile;
import model.Piece;
import model.ReleaseLevel;
import model.ReleaseTile;
import view.BoardView;
import view.BullpenView;
import view.LevelView;
import view.NumbersReleasedView;
import view.SelectedPieceView;

/**
 * 
 * @author hejohnson
 */

public class ReleaseBoardGameController implements MouseListener, MouseMotionListener{
	ReleaseLevel levelModel;
	Game game;
	BoardView boardView;
	BullpenView bpv;
	SelectedPieceView spv;
	LevelView levelView;
	
	public ReleaseBoardGameController (Game game, LevelView levelView) {
		this.game = game;
		this.levelModel = (ReleaseLevel)game.getCurrentLevel();
		this.levelView = levelView;
		this.boardView = levelView.getBoardView();
		this.bpv = levelView.getBullpenView();
		this.spv = levelView.getSelectedPieceView();
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		
	}

	@Override
	public void mouseMoved(MouseEvent me) {
		Piece p;
		AbstractTile source  = levelModel.getBoard().getTileAt(me.getX(), me.getY());
		p = levelModel.getBullpen().getSelectedPiece();
		
		if(p != null){
			levelModel.getBoard().clearPiecePreview();
			levelModel.getBoard().showPiecePreview(p, source.getRow(), source.getCol());
			boardView.redraw();
			boardView.repaint();
		}
	}
	
	void updateReleasedNumbers(Piece p) {
		ArrayList<AbstractTile> coveredTiles = p.getPreviousTiles();
		for (AbstractTile at : coveredTiles) {
			if (at instanceof ReleaseTile) {
				Color color  = ((ReleaseTile) at).getColorSet();
				int number = ((ReleaseTile) at).getNumber();
				if(color.equals(Color.RED)){
					levelModel.addToRedReleased(number);
					((NumbersReleasedView)levelView.getEndConditionPanel()).setReleasedRed(number);
				} else if (color.equals(Color.BLUE)) {
					levelModel.addToBlueReleased(number);
					((NumbersReleasedView)levelView.getEndConditionPanel()).setReleasedBlue(number);
				} else if (color.equals(Color.GREEN)) {
					levelModel.addToGreenReleased(number);
					((NumbersReleasedView)levelView.getEndConditionPanel()).setReleasedGreen(number);
				} else {
					throw new RuntimeException("Unknown color");
				}
			}
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent me) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent me) {
		AbstractTile source  = levelModel.getBoard().getTileAt(me.getX(), me.getY());
		PlacePieceOnBoardFromBullpenMove m = new PlacePieceOnBoardFromBullpenMove(levelModel, source, game.getLevelView().getBullpenView(), spv, boardView);
		
		if (m.doMove()) {
			Piece p = m.getPlacedPiece();
			updateReleasedNumbers(p);
//			spv.getPiecePanel().redraw();
//			spv.getPiecePanel().repaint(); TODO Remove this if working
//			boardView.redraw();
//			boardView.repaint();
			if (levelModel.checkStatus()) {
				game.getLevelView().dispatchEvent(new WindowEvent(game.getLevelView(), WindowEvent.WINDOW_CLOSING));
			}
			game.getLevelView().getLevelInfoView().setStars(levelModel.getStarsEarned());
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {}

	@Override
	public void mouseDragged(MouseEvent arg0) {}
}
