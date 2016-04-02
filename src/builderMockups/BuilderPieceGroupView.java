package builderMockups;

import javax.swing.JSpinner;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class BuilderPieceGroupView extends AbstractPieceGroupView{	
	JSpinner spinner;

	//TODO: The PieceGroup isn't used in the BuilderPieceGroupView (since the spinner sets the piece count, not other way around)
	public BuilderPieceGroupView(int id){
		super(id);
		spinner = new JSpinner();
		
		setupLayout();
	}
	
	void setupLayout(){
		layout = new GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createParallelGroup(Alignment.TRAILING)
					.addComponent(spinner, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
					.addComponent(button, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
		);
		setLayout(layout);
	}
}
