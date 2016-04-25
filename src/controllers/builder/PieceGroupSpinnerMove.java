package controllers.builder;

import javax.swing.JSpinner;

import controllers.common.Move;
import model.PieceGroup;


/**
 * 
 * @author dfontana
 */
public class PieceGroupSpinnerMove extends Move {
	/**PieceGroup whose value is being changed**/
	PieceGroup pieceGroup;
	
	/**Spinner being modified. Needed to update its view on an undo**/
	JSpinner spinner;
	/**Value the spinner/pieceGroup previously had **/
	int oldValue;
	
	/**Value the spinner is giving to the pieceGroup **/
	int newValue;
	
	public PieceGroupSpinnerMove(PieceGroup pieceGroup, JSpinner spinner) {
		this.pieceGroup = pieceGroup;
		this.spinner = spinner;
		this.oldValue = pieceGroup.getNumPieces();
		this.newValue = (int)spinner.getValue();
	}

	/**
	 * 
	 * @return boolean - true if move is valid and successful
	 */
	@Override
	public boolean doMove() {
		if(!isValid()){ return false;}
		pieceGroup.setCount(newValue);
		return true;
	}

	/**
	 * Determines if this move can be done.
	 * This move is invalid if the old value is the same as the new value, or the new value is negative
	 * @return boolean Whether the value has changed and is non-negative
	 */
	@Override
	public boolean isValid() {
		return (oldValue != newValue && newValue >= 0);
	}

	/**
	 * Undoes the move by setting the pieceGroup and the spinner back to the old
	 * value.
	 * @return true - the undo can always be done
	 */
	@Override
	public boolean undo() {
		pieceGroup.setCount(oldValue);
		spinner.setValue(oldValue);
		return true;
	}
	
	/**
	 * Redoes the undone move. Only valid if no NEW moves have been done that 
	 * would break the undo order. Sets the spinner back to the value it was set to by the user in the original move
	 * @return true - the redo can always be done
	 */
	@Override
	public boolean redo() {
		pieceGroup.setCount(newValue);
		spinner.setValue(newValue);
		return true;
	}

}
