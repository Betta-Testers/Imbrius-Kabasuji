package controllers.builder;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSpinner;
import view.BuilderPieceGroupView;
import model.PieceGroup;

/**
 * Controls the actions performed on a PieceGroup spinner in builder mode that increments and decrements its number of pieces 
 * 
 * @author awharrison
 *
 */
public class BuilderPieceSpinnerController implements ChangeListener {
	BuilderPieceGroupView app;
	PieceGroup model;
	
	public BuilderPieceSpinnerController(BuilderPieceGroupView app, PieceGroup model) {
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
		int oldVal;
		Object o = ((JSpinner)e.getSource()).getPreviousValue();
		if( o != null){
			oldVal = (int)o;
			int newVal = (int)((JSpinner)e.getSource()).getValue();
			System.out.println("Changing");
			if(newVal > oldVal) {
				model.incrementCount();
			} else if (newVal < oldVal) {
				model.decrementCount();
			} else 
				throw new RuntimeException("BuilderPieceSpinnerController::Changing a builder piece group spinner caused no value change");
		}
	}
	
	
}
