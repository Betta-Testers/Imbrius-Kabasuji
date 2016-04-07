package builderMockups;

import java.awt.Font;

import javax.swing.JSplitPane;
import javax.swing.JTextArea;

public class LevelTypesAndText extends JSplitPane {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextArea txtAreaLevelTypeDescription;
	LevelTypeButtons levelTypeButtons;
	
	LevelTypesAndText() {
		super();
		this.setResizeWeight(0.5);
		this.setOrientation(JSplitPane.VERTICAL_SPLIT);
		levelTypeButtons = new LevelTypeButtons();
		this.setLeftComponent(levelTypeButtons);
		
		txtAreaLevelTypeDescription = new JTextArea();
		txtAreaLevelTypeDescription.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		txtAreaLevelTypeDescription.setLineWrap(true);
		txtAreaLevelTypeDescription.setWrapStyleWord(true);
		txtAreaLevelTypeDescription.setText("Information about each level type will go here when the corresponding toggle button is selected");
		this.setRightComponent(txtAreaLevelTypeDescription);
	}
}
