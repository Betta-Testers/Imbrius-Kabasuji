package controllers;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSpinner;
import view.BuilderPieceGroupView;
import model.PieceGroup;

/**
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
	public void stateChanged(ChangeEvent e) {
		int oldVal = (int)((JSpinner)e.getSource()).getPreviousValue();
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
