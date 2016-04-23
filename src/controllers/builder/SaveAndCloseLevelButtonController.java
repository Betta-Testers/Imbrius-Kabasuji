package controllers.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.Builder;
import model.Board;
import model.Bullpen;
import model.Piece;

/**
 * Controller listening for a Save Button action. On save the builder is told to save
 * the level, the BuilderView is hidden and the LTSV is displayed
 * @author hejohnson
 * @author Dylan
 */
public class SaveAndCloseLevelButtonController implements ActionListener {
	Builder builder;
	Board board;
	Bullpen bullpen;
	public SaveAndCloseLevelButtonController (Builder b) {
		this.builder = b;
		this.board = builder.getCurrentLevel().getBoard();
		this.bullpen = builder.getCurrentLevel().getBullpen();
	}

	/**
	 * When the level save button is triggered, the board is cleared of all pieces
	 * first and puts them back in the bullpen. Then, the level is saved to disk, the builder view is hidden, and the 
	 * LTSV is redisplayed.
	 */
	public void actionPerformed(ActionEvent arg0) {
		if(board.getPieceCount() > 0){
			for(Piece p: board.resetBoard()){
				bullpen.incrementPiece(p.getID());
			}
		}
		builder.saveLevel();
		builder.getBuilderView().setVisible(false);
		builder.getLevelTypeSelectView().setVisible(true);
	}
}
