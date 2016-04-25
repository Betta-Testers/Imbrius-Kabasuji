package controllers.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.Builder;
import app.UndoManager;
import model.Board;
import view.BuilderView;
import view.SelectedPieceView;

/**
 * Controller to link to the redo button in the level builder
 * @author awharrison
 * @author dfontana
 */
public class RedoButtonController implements ActionListener{
	/**Link to the UndoManager singleton for the button to perform actions on**/
	UndoManager manager;
	/**The board having undos done to it**/
	Board board;
	/**View of the board for redrawing/painting after undo**/
	BuilderView builderView;
	/**Piece preview that would need to be redrawn after undo**/
	SelectedPieceView spv;
	
	/**
	 * Makes the RedoButtonController
	 * @param builder - the builder object holding all needed information
	 * for repainting
	 */
	public RedoButtonController(Builder builder) {
		this.builderView = builder.getBuilderView();
		this.board = builder.getCurrentLevel().getBoard();
		this.spv = builderView.getSelectedPieceView();
		
		manager = UndoManager.getInstance();
	}
	
	/**
	 * Call redo on the undoManager when the listener is triggered.
	 * If there is a move to be redone, it repaints the board and selected
	 * piece preview. If there wasn't, it does nothing
	 * @param ActionEvent of button being pressed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(manager.redo()){
			board.clearPiecePreview();
			spv.getPiecePanel().redraw();
			spv.getPiecePanel().repaint();
			builderView.getBoardView().redraw();
			builderView.getBoardView().repaint();
		}
	}
}
