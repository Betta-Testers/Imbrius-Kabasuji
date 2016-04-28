package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

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

/**
 * Used in the builder to allow users to select a ReleaseTile they want to create.
 * @author dfontana
 * @author awharrison
 */
public class ReleaseNumberCreationView extends JPanel{
	private static final long serialVersionUID = 1L;
	/**Stores the layout.**/
	GroupLayout groupLayout;
	/**Title of the ReleaseNumberCreationView, set to "Release Numbers".**/
	JLabel lblTitle;
	/**Title for picking colors, set to "Color:".**/
	JLabel lblColor;
	/**Toggle buttons, one for each number from 1 to 6.**/
	JToggleButton numButtons[];
	/**Group for all of the toggle buttons.**/
	ButtonGroup creationGroup;
	/**Allows the user to pick a color.**/
	JComboBox<String> colorSelector;
	/**Handles and events with the colorSelector.**/
	ActionListener setColorHandler;

	/**
	 * Creates a ReleaseNumberCreationView.
	 */
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
		addSetColorController(new SetReleaseTileColorController(this));

		setupLayout();
		this.setBackground(Color.WHITE);
	}

	/**
	 * Makes all components inside this JPanel invisible or visible based
	 * on the value given. Overrides JPanel, as this is the intended 
	 * behavior when making the "panel" invisible.
	 * @param visible (True makes everything visible) - boolean
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

	/**
	 * Updates the colors of the toggle buttons to what the user selected using the colorSelector.
	 */
	public void updateNumberColors() {
		for (JToggleButton numBtn : numButtons) {
			numBtn.setBorder(new LineBorder(getColorSelected()));
		}
	}
	/**
	 * Returns the color selected by the colorSelector. Converts String input to Color output.
	 * @return the correct color - Color
	 */
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
	 * If no toggleButton is selected, then -1 is returned.
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

	/**
	 * Sets up the layout of ReleaseNumberCreationView.
	 */
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

	/**
	 * Returns the colorSelector. Used for testing.
	 * @return colorSelector - JComboBox<String>
	 */
	public JComboBox<String> getColorSelector() {
		return this.colorSelector;
	}
	/**
	 * Toggles the button given by the index. Used for testing.
	 * @param index - ind
	 */
	public void toggleButton (int index) {
		for (int i = 0; i<6; i++) {
			if(i == index)
				numButtons[i].doClick();
		}
	}
	
	/**
	 * Sets the setColorHandler (set by the inputted ActionListener) to the colorSelector.
	 * @param al - ActionListener
	 */
	public void addSetColorController(ActionListener al) {
		this.setColorHandler = al;
		this.colorSelector.addActionListener(al);
	}
	/**
	 * Returns the setColorHandler.
	 * @return setColorHandler - ActionListener
	 */
	public ActionListener getSetColorController() {
		return this.setColorHandler;
	}
}
