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

import controllers.SetReleaseTileColorController;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ReleaseNumberCreationView extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GroupLayout groupLayout;
	JLabel lblTitle;
	JLabel lblColor;
	JToggleButton numButtons[];
	JSpinner spinner;
	JComboBox colorSelector;

	public ReleaseNumberCreationView(){
		setPreferredSize(new Dimension(105, 135));
		groupLayout = new GroupLayout(this);

		lblTitle = new JLabel("Release Numbers");
		lblColor = new JLabel("Color:");
		ButtonGroup creationGroup = new ButtonGroup();
		numButtons =  new JToggleButton[6];
		for (int i = 0; i<6; i++) {
			JToggleButton numBtn = new JToggleButton(""+(i+1));
			numBtn.setForeground(Color.BLUE);
			numBtn.setOpaque(true);
			numBtn.setBackground(Color.DARK_GRAY);
			creationGroup.add(numBtn);
			numButtons[i] = numBtn;
		}
		spinner = new JSpinner();

		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 12));

//		spinner.setModel(new SpinnerListModel(new String[] {"Blue", "Yellow", "Red"}));
//		spinner.addChangeListener(new SetReleaseTileColorController(this));
		colorSelector = new JComboBox(new String[] {"Blue", "Yellow", "Red"});
		colorSelector.addActionListener(new SetReleaseTileColorController(this));

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
														.addComponent(numButtons[4])
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(numButtons[5]))
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(numButtons[2])
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(numButtons[3]))
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(numButtons[0])
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(numButtons[1]))))
								.addGroup(groupLayout.createSequentialGroup()
										.addGap(8)
										.addComponent(lblColor)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(colorSelector, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)))
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
										.addComponent(numButtons[0]))
								.addGroup(groupLayout.createSequentialGroup()
										.addGap(6)
										.addComponent(numButtons[1])))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(numButtons[2])
								.addComponent(numButtons[3]))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(numButtons[4])
								.addComponent(numButtons[5]))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblColor)
								.addComponent(colorSelector, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		this.setLayout(groupLayout);
	}

	
	/**
	 * Makes all components inside this JPanel invisible or visible based
	 * on the value given. Overrides JPanel, as this is the intended 
	 * behavior when making the "panel" invisible
	 * @param visible True makes everything visible
	 */
	@Override
	public void setVisible(boolean visible){
		lblTitle.setVisible(visible);
		colorSelector.setVisible(visible);
		
		for (JToggleButton numBtn : numButtons) {
			numBtn.setVisible(visible);
		}
		lblColor.setVisible(visible);
	}
	
	public void updateNumberColors() {
		for (JToggleButton numBtn : numButtons) {
			numBtn.setForeground(getColorSelected());
		}
	}
	
	public Color getColorSelected() {
		if (this.colorSelector.getSelectedItem() == "Red") {
			return Color.RED;
		} else if (this.colorSelector.getSelectedItem() == "Yellow") {
			return Color.YELLOW;
		} else {
			return Color.BLUE;
		}
	}
	
	public int getNumberSelected() {
		for (JToggleButton numBtn : numButtons) {
			if (numBtn.isSelected()) {
				return Integer.parseInt(numBtn.getText());
			}
		}
		throw new RuntimeException("No number selected to add to tile");
	}
}
