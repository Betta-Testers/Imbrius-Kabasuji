package view;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;

import model.PieceGroup;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

/**
 * Represents the view with a spinner and a piece in the builder.
 * @author dfontana
 * @author awharrison
 *
 */
public class BuilderPieceGroupView extends AbstractPieceGroupView{	
	private static final long serialVersionUID = 1L;
	
	/**Stores the layout of the BuilderPieceGroupView.**/
	GroupLayout groupLayout;
	
	/**Spinner attached to the BuilderPieceGroupView. Allows the user to increment and decrement the amount of one piece.**/
	JSpinner spinner;
	
	/**Handles changes with the spinner.**/
	ChangeListener pieceCountHandler;

	/**
	 * Creates a new BuilderPieceGroupView with a given PieceGroup.
	 * @param pg - PieceGroup
	 */
	public BuilderPieceGroupView(PieceGroup pg){
		super(pg);
		SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 99, 1);  
		spinner = new JSpinner(model);
		spinner.setValue(pg.getNumPieces());
		
		setupLayout();
	}
	
	/**
	 * Updates count of spinner.
	 */
	@Override
	void updateCount() {
		spinner.setValue(pieceGroup.getNumPieces());
	}
	
	/**
	 * Sets spinner change listener.
	 * @param cl - ChangeListener
	 */
	public void addSpinnerChangeListener(ChangeListener cl) {
		this.pieceCountHandler = cl;
		spinner.addChangeListener(cl);
	}
	
	/**
	 * Returns spinner change listener.
	 * @return pieceCountHandler - ChangeListener
	 */
	public ChangeListener getSpinnerChangeListener() {
		return this.pieceCountHandler;
	}
	
	/**
	 * Returns the spinner associated with the BuilderPieceGroupview.
	 * @return spinner - JSpinner
	 */
	public JSpinner getSpinner() {
		return this.spinner;
	}
	
	/**
	 * Sets up the layout for the BuilderPieceGroupview.
	 */
	void setupLayout(){
		groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
					.addComponent(spinner, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
					.addComponent(button, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
		);
		setLayout(groupLayout);
	}
}
