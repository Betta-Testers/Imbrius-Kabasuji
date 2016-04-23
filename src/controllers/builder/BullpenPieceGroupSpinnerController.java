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
	
	public BullpenPieceGroupSpinnerController(BuilderPieceGroupView app, PieceGroup model) {
		this.app = app;
		this.model = model;
	}

	@Override
	/**
	 * Handles increments and decrements to the PieceGroup
	 * 
	 * @param e ChangeEvent
	 */
	public void stateChanged(ChangeEvent e) {
		int val = (int) app.getSpinner().getValue();
		model.setCount(val);
	}
	
	
}
