package builderMockups;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PlayingPieceGroupView extends AbstractPieceGroupView{
	GroupLayout groupLayout;
	JLabel label;
	
	//TODO Change Arguments: PieceGroup pg
	public PlayingPieceGroupView(int id){
		super(id);
		
		//TODO: Initialize JLabel text to piece group count.
		label = new JLabel("0");
		
		setupLayout();
	}
	
	void setupLayout(){
		label.setHorizontalAlignment(SwingConstants.CENTER);
		groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(button, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
		);

		setLayout(groupLayout);
	}
}
