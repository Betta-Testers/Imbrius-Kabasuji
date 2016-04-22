package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import controllers.builder.SetReleaseTileColorController;

public class ReleaseNumberCreationView extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GroupLayout groupLayout;
	JLabel lblTitle;
	JLabel lblColor;
	JToggleButton numButtons[];
	ButtonGroup creationGroup;
	JComboBox<String> colorSelector;

	public ReleaseNumberCreationView(){
		setPreferredSize(new Dimension(105, 135));
		groupLayout = new GroupLayout(this);

		lblTitle = new JLabel("Release Numbers");
		lblColor = new JLabel("Color:");
		creationGroup = new ButtonGroup(){
			private static final long serialVersionUID = 1L;
			@Override
			public void setSelected(ButtonModel model, boolean selected) {
				if(selected){super.setSelected(model, selected);
				}else{clearSelection();}
			}
		};
		numButtons =  new JToggleButton[6];
		for (int i = 0; i<6; i++) {
			JToggleButton numBtn = new JToggleButton(""+(i+1));
			numBtn.setBorder(new LineBorder(Color.BLUE));
			numBtn.setOpaque(true);
			numBtn.setBackground(Color.DARK_GRAY);
			creationGroup.add(numBtn);
			numButtons[i] = numBtn;
		}

		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 12));

		colorSelector = new JComboBox<String>(new String[] {"Blue", "Green", "Red"});
		colorSelector.addActionListener(new SetReleaseTileColorController(this));

		setupLayout();
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
			numBtn.setBorder(new LineBorder(getColorSelected()));
		}
	}

	public Color getColorSelected() {
		if (this.colorSelector.getSelectedItem() == "Red") {
			return Color.RED;
		} else if (this.colorSelector.getSelectedItem() == "Green") {
			return Color.GREEN;
		} else {
			return Color.BLUE;
		}
	}

	/**
	 * Returns the number of the jToggleButton selected.
	 * If no toggleButton is selected, then -1 is returned
	 * @return int 1-6, or -1 if no button is selected
	 */
	public int getNumberSelected() {
		for (JToggleButton numBtn : numButtons) {
			if (numBtn.isSelected()) {
				return Integer.parseInt(numBtn.getText());
			}
		}
		return -1;
	}
	//.addComponent(btnRedo, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)

	void setupLayout(){
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
														.addComponent(numButtons[4], GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(numButtons[5], GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(numButtons[2], GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(numButtons[3], GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(numButtons[0], GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(numButtons[1], GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))))
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
										.addComponent(numButtons[0], GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addGap(6)
										.addComponent(numButtons[1], GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(numButtons[2], GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(numButtons[3], GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(numButtons[4], GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(numButtons[5], GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblColor)
								.addComponent(colorSelector, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		this.setLayout(groupLayout);
	}

	//** For testing **//
	public JComboBox<String> getColorSelector() {
		return this.colorSelector;
	}

	public void setSelected (int index) {
		for (int i = 0; i<6; i++) {
			numButtons[i].setSelected(i==index);
		}
	}
}
