package view;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import model.LightningLevel;

import java.awt.Dimension;
import java.awt.Font;

/**
 * Class for displaying the time remaining in a lightning level.
 * @author awharrison
 * @author dfontana
 */
public class TimeRemainingView extends JPanel {
	private static final long serialVersionUID = 1L;
	/**Shows the remaining time.**/
	JTextPane textPaneTime;
	/**Title for time remaining, set to "Seconds Remaining".**/
	JLabel lblTitle;
	
	/**
	 * Creates a TimeRemaingView with a given lightning level.
	 * @param level - LightningLevel
	 */
	public TimeRemainingView(LightningLevel level) {
		this.setPreferredSize(new Dimension(180, 90));
		textPaneTime = new JTextPane();
		textPaneTime.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textPaneTime.setText(""+level.getTotalTime());
		
		lblTitle = new JLabel("Seconds Remaining");
		
		setupLayout();
	}
	
	/**
	 * Method for changing the text displayed to the remaining amount of time
	 * Method takes formatted string
	 * @param secondsRemaining - The time remaining in string form
	 */
	public void updateTimeLeft(String secondsRemaining){
		textPaneTime.setText(secondsRemaining);
	}
	
	/**
	 * Sets up the layout of the TimeRemainingView.
	 */
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
