package gameMockups;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

public class NumbersReleasedView extends JPanel {
	
	// TODO consumes AbstractLevelModel
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField number1;
	JTextField number2;
	JTextField number3;
	JTextField number4;
	JTextField number5;
	JTextField number6;
	JLabel lblColor;

	/**
	 * Create the panel.
	 */
	public NumbersReleasedView() {
		
		number1 = new JTextField();
		number1.setHorizontalAlignment(SwingConstants.CENTER);
		number1.setText("1");
		number1.setColumns(10);
		
		number2 = new JTextField();
		number2.setText("2");
		number2.setHorizontalAlignment(SwingConstants.CENTER);
		number2.setColumns(10);
		
		number3 = new JTextField();
		number3.setText("3");
		number3.setHorizontalAlignment(SwingConstants.CENTER);
		number3.setColumns(10);
		
		number4 = new JTextField();
		number4.setText("4");
		number4.setHorizontalAlignment(SwingConstants.CENTER);
		number4.setColumns(10);
		
		number5 = new JTextField();
		number5.setText("5");
		number5.setHorizontalAlignment(SwingConstants.CENTER);
		number5.setColumns(10);
		
		number6 = new JTextField();
		number6.setText("6");
		number6.setHorizontalAlignment(SwingConstants.CENTER);
		number6.setColumns(10);
		
		lblColor = new JLabel("Color:");
		
		setupLayout();
	}
		
	private void setupLayout() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(13)
					.addComponent(lblColor)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(number1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(number2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(number3, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(number4, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(number5, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(number6, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(252, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(number1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(number4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(number5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(number2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(number3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblColor)
						.addComponent(number6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(274, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
