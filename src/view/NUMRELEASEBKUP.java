package view;

import javax.swing.JPanel;

import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

public class NUMRELEASEBKUP extends JPanel {
	
	// TODO consumes AbstractLevelModel

	private static final long serialVersionUID = 1L;
	JLabel lblColorRed;
	JLabel lblColorBlue;
	JLabel lblColorYellow;
	
	JTextField redNums[] = new JTextField[7];
	JTextField blueNums[] = new JTextField[7];
	JTextField yellowNums[] = new JTextField[7];
	
//	JTextField numRed1;
//	JTextField numRed2;
//	JTextField numRed3;
//	JTextField numRed4;
//	JTextField numRed5;
//	JTextField numRed6;
//	JTextField numBlue1;
//	JTextField numBlue2;
//	JTextField numBlue3;
//	JTextField numBlue4;
//	JTextField numBlue5;
//	JTextField numBlue6;
//	JTextField numYellow1;
//	JTextField numYellow2;
//	JTextField numYellow3;
//	JTextField numYellow4;
//	JTextField numYellow5;
//	JTextField numYellow6;

	public NUMRELEASEBKUP() {
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
		
	private void setupLayout() {
		GroupLayout groupLayout = new GroupLayout(this);
		
		ParallelGroup pgroup = groupLayout.createParallelGroup(Alignment.LEADING);
		SequentialGroup sgroup;
	
		//ADD YELLOWS
		sgroup = groupLayout.createSequentialGroup();
		for(int j=1; j<=6; j++){
			sgroup.addComponent(yellowNums[j], GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
			.addGap(2);
		}
		pgroup.addGroup(Alignment.TRAILING, sgroup);
		
		//ADD BLUES
		sgroup = groupLayout.createSequentialGroup();
		for(int j=1; j<=6; j++){
			sgroup.addComponent(blueNums[j], GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
			.addGap(2);
		}
		pgroup.addGroup(Alignment.TRAILING, sgroup);
		
		//ADD REDS
		sgroup = groupLayout.createSequentialGroup();
		for(int j=1; j<=6; j++){
			sgroup.addComponent(redNums[j], GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
			.addGap(2);
		}
		pgroup.addGroup(Alignment.TRAILING, sgroup);
		
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblColorRed)
						.addComponent(lblColorBlue, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblColorYellow))
					.addGap(7)
					.addGroup(pgroup))
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
