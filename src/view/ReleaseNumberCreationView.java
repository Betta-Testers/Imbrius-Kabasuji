package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.SpinnerListModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ReleaseNumberCreationView extends JPanel{
	GroupLayout groupLayout;
	JLabel lblTitle;
	JLabel lblColor;
	JToggleButton btn1, btn2, btn3, btn4, btn5, btn6;
	JSpinner spinner;
	
	public ReleaseNumberCreationView(){
		setPreferredSize(new Dimension(105, 135));
		groupLayout = new GroupLayout(this);
		
		lblTitle = new JLabel("Release Numbers");
		lblColor = new JLabel("Color:");
		btn1 = new JToggleButton("1");
		btn2 = new JToggleButton("2");
		btn3 = new JToggleButton("3");
		btn4 = new JToggleButton("4");
		btn5 = new JToggleButton("5");
		btn6 = new JToggleButton("6");
		spinner = new JSpinner();
		
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn1.setForeground(Color.BLUE);
		btn2.setForeground(Color.BLUE);
		btn3.setForeground(Color.BLUE);
		btn4.setForeground(Color.BLUE);
		btn5.setForeground(Color.BLUE);
		btn6.setForeground(Color.BLUE);

		spinner.setModel(new SpinnerListModel(new String[] {"Blue", "Yellow", "Red"}));
		
		ButtonGroup creationGroup = new ButtonGroup();
		
		creationGroup.add(btn1);
		creationGroup.add(btn2);
		creationGroup.add(btn3);
		creationGroup.add(btn4);
		creationGroup.add(btn5);
		creationGroup.add(btn6);
	
	
		setupLayout();
	}
	
	private void setupLayout(){
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblTitle))
								.addGroup(groupLayout.createSequentialGroup()
										.addGap(8)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(btn5)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(btn6))
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(btn3)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(btn4))
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(btn1)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(btn2))))
								.addGroup(groupLayout.createSequentialGroup()
										.addGap(8)
										.addComponent(lblColor)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(5)
						.addComponent(lblTitle)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btn1))
								.addGroup(groupLayout.createSequentialGroup()
										.addGap(6)
										.addComponent(btn2)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btn3)
								.addComponent(btn4))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btn5)
								.addComponent(btn6))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblColor)
								.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		this.setLayout(groupLayout);
	}
	
	public void disablePanel(){
		spinner.setEnabled(false);
		btn1.setEnabled(false);
		btn2.setEnabled(false);
		btn3.setEnabled(false);
		btn4.setEnabled(false);
		btn5.setEnabled(false); 
		btn6.setEnabled(false);
	}
	
	public void enablePanel(){
		spinner.setEnabled(true);
		btn1.setEnabled(true);
		btn2.setEnabled(true);
		btn3.setEnabled(true);
		btn4.setEnabled(true);
		btn5.setEnabled(true); 
		btn6.setEnabled(true);
	}
}
