package controllers.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.Builder;
import app.UndoManager;
import model.Board;
import view.BuilderView;
import view.SelectedPieceView;

/**
 * Controller to link to the undo button in the level builder
 * @author awharrison
 * @author dfontana
 */
public class UndoButtonController implements ActionListener{
	/**Link to the UndoManager singleton for the button to perform actions on**/
	UndoManager manager;
	/**The board having undos done to it**/
	Board board;
	/**View of the board for redrawing/painting after undo**/
	BuilderView builderView;
	/**Piece preview that would need to be redrawn after undo**/
	SelectedPieceView spv;
	
	/**
	 * Makes the UndoButtonController
	 * @param builder - the builder object holding all needed information
	 * for repainting
	 */
	public UndoButtonController(Builder builder){
		this.builderView = builder.getBuilderView();
		this.board = builder.getCurrentLevel().getBoard();
		this.spv = builderView.getSelectedPieceView();
		
		manager = UndoManager.getInstance();
	}

	/**
	 * Call undo on the undoManager when the listener is triggered.
	 * If there is a move to be undone, it repaints the board and selected
	 * piece preview. If there wasn't, it does nothing
	 * @param e button pressed event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(manager.undo()){
			board.clearPiecePreview();
			spv.getPiecePanel().redraw();
			spv.getPiecePanel().repaint();
			builderView.getBoardView().redraw();
			builderView.getBoardView().repaint();
		}
	}
}
