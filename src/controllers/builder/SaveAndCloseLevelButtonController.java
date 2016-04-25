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
	/**The builder whose level is being saved**/
	Builder builder;
	/**The board of the level being saved**/
	Board board;
	/**The bullpen of the level being saved**/
	Bullpen bullpen;
	
	/**
	 * Creates the controller
	 * @param b - Builder whose level is being saved and closed
	 */
	public SaveAndCloseLevelButtonController (Builder b) {
		this.builder = b;
		this.board = builder.getCurrentLevel().getBoard();
		this.bullpen = builder.getCurrentLevel().getBullpen();
	}

	/**
	 * When the level save button is triggered, the board is cleared of all pieces
	 * first and puts them back in the bullpen. Then, the level is saved to disk, 
	 * the builder view is hidden, and the levelTypeSelectView is redisplayed.
	 * @param ActionEvent of button click
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
