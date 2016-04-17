package view;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

public class NumbersReleasedView extends JPanel {
private static final long serialVersionUID = 1L;
	JLabel lblColorRed;
	JLabel lblColorBlue;
	JLabel lblColorYellow;
	
	JTextField redNums[] = new JTextField[7];
	JTextField blueNums[] = new JTextField[7];
	JTextField yellowNums[] = new JTextField[7];
	
	public NumbersReleasedView() {
		this.setPreferredSize(new Dimension(180, 90));
		lblColorRed = new JLabel("Red:");
		lblColorBlue = new JLabel("Blue:");
		lblColorYellow = new JLabel("Yellow:");
		
		for(int i=1; i<=6; i++){
			redNums[i] = new JTextField();
			redNums[i].setHorizontalAlignment(SwingConstants.CENTER);
			redNums[i].setText(Integer.toString(i));
			redNums[i].setColumns(10);
			
			blueNums[i] = new JTextField();
			blueNums[i].setHorizontalAlignment(SwingConstants.CENTER);
			blueNums[i].setText(Integer.toString(i));
			blueNums[i].setColumns(10);
			
			yellowNums[i] = new JTextField();
			yellowNums[i].setHorizontalAlignment(SwingConstants.CENTER);
			yellowNums[i].setText(Integer.toString(i));
			yellowNums[i].setColumns(10);
		}
	
		setupLayout();
	}
	
	/**
	 * Changes the background of the red textpane corresponding to number
	 * to be red. This denotes to the player that the number is released from
	 * that set.
	 * @author Dylan
	 * @param number
	 */
	void setReleasedRed(int number){
		redNums[number].setBackground(Color.red);
	}
	
	/**
	 * Changes the background of the blue textpane corresponding to number
	 * to be blue. This denotes to the player that the number is released from
	 * that set.
	 * @author Dylan
	 * @param number
	 */
	void setReleasedBlue(int number){
		blueNums[number].setBackground(Color.blue);
	}
	
	/**
	 * Changes the background of the yellow textpane corresponding to number
	 * to be yellow. This denotes to the player that the number is released from
	 * that set.
	 * @author Dylan
	 * @param number
	 */
	void setReleasedYellow(int number){
		yellowNums[number].setBackground(Color.yellow);
	}
	
	private void setupLayout() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblColorRed)
						.addComponent(lblColorBlue, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblColorYellow))
					.addGap(7)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(yellowNums[1], GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(yellowNums[2], GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(yellowNums[3], GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(yellowNums[4], GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(yellowNums[5], GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(yellowNums[6], GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(blueNums[1], GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(blueNums[2], GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(blueNums[3], GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(blueNums[4], GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(blueNums[5], GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(blueNums[6], GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(redNums[1], GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(redNums[2], GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(redNums[3], GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(redNums[4], GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(redNums[5], GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(redNums[6], GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblColorRed)
						.addComponent(redNums[1], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(redNums[2], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(redNums[3], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(redNums[4], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(redNums[5], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(redNums[6], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblColorBlue)
						.addComponent(blueNums[1], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(blueNums[2], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(blueNums[3], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(blueNums[4], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(blueNums[5], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(blueNums[6], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblColorYellow)
						.addComponent(yellowNums[1], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(yellowNums[2], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(yellowNums[3], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(yellowNums[4], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(yellowNums[5], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(yellowNums[6], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		setLayout(groupLayout);

	}
}
