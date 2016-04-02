package builderMockups;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PlayingPieceGroupView extends AbstractPieceGroupView{
	JLabel label;
	
	//TODO: Use the PieceGroup's piece count to initialize the JLabel
	public PlayingPieceGroupView(int id){
		super(id);
		label = new JLabel("0");

		setupLayout();
	}
	
	void setupLayout(){
		label.setHorizontalAlignment(SwingConstants.CENTER);
		layout = new GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, layout.createSequentialGroup()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(button, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
		);

		setLayout(layout);
	}
}
