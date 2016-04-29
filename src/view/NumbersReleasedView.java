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

/**
 * Class for displaying the numbers released in a Release GAME.
 * 
 * @author awharrison
 * @author dfontana
 */
public class NumbersReleasedView extends JPanel {
	private static final long serialVersionUID = 1L;
	/**Label to designate red tiles, set to "Red:".**/
	JLabel lblColorRed;
	/**Label to designate blue tiles, set to "Blue:".**/
	JLabel lblColorBlue;
	/**Label to designate green tiles, set to "Green:".**/
	JLabel lblColorGreen;
	
	/**Each JTextField holds a released number.**/
	JTextField redNums[] = new JTextField[7];
	JTextField blueNums[] = new JTextField[7];
	JTextField greenNums[] = new JTextField[7];
	
	/**
	 * Creates a NumbersReleasedView.
	 */
	public NumbersReleasedView() {
		this.setPreferredSize(new Dimension(180, 90));
		lblColorRed = new JLabel("Red:");
		lblColorBlue = new JLabel("Blue:");
		lblColorGreen = new JLabel("Green:");
		
		for(int i=1; i<=6; i++){
			redNums[i] = new JTextField();
			redNums[i].setHorizontalAlignment(SwingConstants.CENTER);
			redNums[i].setText(Integer.toString(i));
			redNums[i].setColumns(10);
			
			blueNums[i] = new JTextField();
			blueNums[i].setHorizontalAlignment(SwingConstants.CENTER);
			blueNums[i].setText(Integer.toString(i));
			blueNums[i].setColumns(10);
			
			greenNums[i] = new JTextField();
			greenNums[i].setHorizontalAlignment(SwingConstants.CENTER);
			greenNums[i].setText(Integer.toString(i));
			greenNums[i].setColumns(10);
		}
	
		setupLayout();
		this.setBackground(Color.WHITE);
	}
	
	/**
	 * Changes the background of the red textpane corresponding to number
	 * to be red. This denotes to the player that the number is released from
	 * that set.
	 * @param number - int
	 */
	public void setReleasedRed(int number){
		redNums[number].setBackground(Color.red);
	}
	
	/**
	 * Changes the background of the blue textpane corresponding to number
	 * to be blue. This denotes to the player that the number is released from
	 * that set.
	 * @param number - int
	 */
	public void setReleasedBlue(int number){
		blueNums[number].setBackground(Color.blue);
	}
	
	/**
	 * Changes the background of the yellow textpane corresponding to number
	 * to be yellow. This denotes to the player that the number is released from
	 * that set.
	 * @param number - int
	 */
	public void setReleasedGreen(int number){
		greenNums[number].setBackground(Color.green);
	}
	
	/**
	 * Sets up the layout of NumbersReleasedView.
	 */
	private void setupLayout() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblColorRed)
						.addComponent(lblColorBlue, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblColorGreen))
					.addGap(7)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(greenNums[1], GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(greenNums[2], GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(greenNums[3], GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(greenNums[4], GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(greenNums[5], GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(greenNums[6], GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
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
						.addComponent(lblColorGreen)
						.addComponent(greenNums[1], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(greenNums[2], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(greenNums[3], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(greenNums[4], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(greenNums[5], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(greenNums[6], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		setLayout(groupLayout);

	}
}
