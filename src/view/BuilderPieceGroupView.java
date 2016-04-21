package view;

import javax.swing.JSpinner;
import javax.swing.event.ChangeListener;

import model.PieceGroup;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

/**
 * 
 * @author Dylan
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
		spinner = new JSpinner();
		spinner.setValue(pg.getNumPieces());
		
		setupLayout();
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
	
	public void addSpinnerChangeListener(ChangeListener cl) {
		this.pieceCountHandler = cl;
		spinner.addChangeListener(cl);
	}
	
	public JSpinner getSpinner() {
		return this.spinner;
	}
}
