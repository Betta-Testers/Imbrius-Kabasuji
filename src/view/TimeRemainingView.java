package view;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Dimension;
import java.awt.Font;

public class TimeRemainingView extends JPanel {
	private static final long serialVersionUID = 1L;
	JTextPane textPaneTime;
	JLabel lblTitle;
	
	public TimeRemainingView() {
		this.setPreferredSize(new Dimension(180, 90));
		textPaneTime = new JTextPane();
		textPaneTime.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textPaneTime.setText("000");
		
		lblTitle = new JLabel("Seconds Remaining");
		
		setupLayout();
	}
	
	/**
	 * Method for changing the text displayed to the remaining amount of time
	 * Method converts secondsRemaining into a string to be displayed
	 * Should be in a 3 digit format: 009, 090, or 900
	 * @author Dylan
	 * @param secondsRemaining
	 */
	void updateTimeLeft(int secondsRemaining){
		textPaneTime.setText(Integer.toString(secondsRemaining));
	}
	
	private void setupLayout() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(44)
							.addComponent(lblTitle))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(68)
							.addComponent(textPaneTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(lblTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPaneTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
}
