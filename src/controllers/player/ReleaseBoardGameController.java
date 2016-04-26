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
	/** The current level being played **/
	ReleaseLevel levelModel;
	/** The overarching game object that holds all the views and the entities **/
	Game game;
	/** The view for the board **/
	BoardView boardView;
	/** The view of the bullpen and all it's pieces **/
	BullpenView bpv;
	/** The view that holds the piece selected from the bullpen to be placed on the board **/
	SelectedPieceView spv;
	/** The window that holds the board and bullpen **/
	LevelView levelView;
	
	/**
	 * @param game The game object
	 * @param lv The level view
	 */
	public ReleaseBoardGameController (Game game, LevelView lv) {
		this.game = game;
		this.levelModel = (ReleaseLevel)game.getCurrentLevel();
		this.levelView = lv;
		this.boardView = levelView.getBoardView();
		this.bpv = levelView.getBullpenView();
		this.spv = levelView.getSelectedPieceView();
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		
	}

	/** 
	 * Shows the selected piece with the origin tile located at the tile that the mouse is over
	 * @param me The mouse event
	 */
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
	
	/** 
	 * Checks if any of the tiles that the piece covered were release tiles, and if so, update the level
	 * @param p The piece that was placed
	 */
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

	/** 
	 * Clear the piece preview from the board
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		levelModel.getBoard().clearPiecePreview();
	}

	/**
	 * Place the piece when the mouse is pressed on a tile. If that move makes the level a 3 star level, exit the level
	 * @param me The mouse event that triggered this, from which the tile can be deduced
	 */
	@Override
	public void mousePressed(MouseEvent me) {
		AbstractTile source  = levelModel.getBoard().getTileAt(me.getX(), me.getY());
		PlacePieceOnBoardFromBullpenMove m = new PlacePieceOnBoardFromBullpenMove(levelModel, source, levelView.getBullpenView(), spv, boardView);
		
		if (m.doMove()) {
			Piece p = m.getPlacedPiece();
			updateReleasedNumbers(p);
			if (levelModel.checkStatus()) {
				levelView.dispatchEvent(new WindowEvent(levelView, WindowEvent.WINDOW_CLOSING));
			}
			levelView.getLevelInfoView().setStars(levelModel.getStarsEarned());
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {}

	@Override
	public void mouseDragged(MouseEvent arg0) {}
}
