package view;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;

import model.PieceGroup;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

/**
 * 
 * @author dfontana
 * @author awharrison
 *
 */
public class BuilderPieceGroupView extends AbstractPieceGroupView{	
	private static final long serialVersionUID = 1L;
	GroupLayout groupLayout;
	JSpinner spinner;
	ChangeListener pieceCountHandler;

	public BuilderPieceGroupView(PieceGroup pg){
		super(pg);
		SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 99, 1);  
		spinner = new JSpinner(model);
		spinner.setValue(pg.getNumPieces());
		
		setupLayout();
	}
	
	@Override
	void updateCount() {
		spinner.setValue(pieceGroup.getNumPieces());
	}
	
	public void addSpinnerChangeListener(ChangeListener cl) {
		this.pieceCountHandler = cl;
		spinner.addChangeListener(cl);
	}
	
	public ChangeListener getSpinnerChangeListener() {
		return this.pieceCountHandler;
	}
	
	public JSpinner getSpinner() {
		return this.spinner;
	}
	
	/**
	 * Method for setting up the layout for the BuilderPieceGroupview
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
