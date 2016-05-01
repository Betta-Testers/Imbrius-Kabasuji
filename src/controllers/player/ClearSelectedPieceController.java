/**
 * 
 */
package controllers.player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.Game;
import model.Bullpen;
import view.LevelView;
import view.SelectedPieceView;

/**
 * Clears the selected piece when triggered, then redraws the selected piece view.
 * @author hejohnson
 *
 */
public class ClearSelectedPieceController implements ActionListener {
	SelectedPieceView spv;
	Bullpen bp;
	
	/**
	 * @param g The game object that contains the bullpen
	 * @param view The level view that contains the piece panel
	 */
	public ClearSelectedPieceController(Game g, LevelView view) {
		this.bp = g.getCurrentLevel().getBullpen();
		this.spv = view.getSelectedPieceView();
	}

	/**
	 * Clears the selected piece from the bullpen and redraws the preview area
	 * @param e The action event that triggered this
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		bp.clearSelectedPiece();
		spv.getPiecePanel().redraw();
		spv.getPiecePanel().repaint();
	}
	
	
}
