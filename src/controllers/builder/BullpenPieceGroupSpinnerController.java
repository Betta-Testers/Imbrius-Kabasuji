package controllers.builder;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import view.BuilderPieceGroupView;
import model.PieceGroup;

/**
 * Controls the actions performed on a PieceGroup spinner in builder mode that increments and decrements its number of pieces 
 * 
 * @author awharrison
 * @author Dylan
 *
 */
public class BullpenPieceGroupSpinnerController implements ChangeListener {
	BuilderPieceGroupView app;
	PieceGroup model;
	
	/** Prevents multiple pushes to the undo stack when the move for this controller is undone **/
	boolean doUpdate;
	
	public BullpenPieceGroupSpinnerController(BuilderPieceGroupView app, PieceGroup model) {
		this.app = app;
		this.model = model;
		this.doUpdate = true;
	}

	/**
	 * When the spinner is changed, the controller detects it and logs the 
	 * change as a move so it can be undone/redone.
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		if(doUpdate){
			doUpdate = false;
			
			//DO STUFF
			int val = (int) app.getSpinner().getValue();
			model.setCount(val);
			
			doUpdate = true;
		}
	}
	
	
}
