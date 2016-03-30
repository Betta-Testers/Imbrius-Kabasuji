package builderMockups;

import java.awt.Font;

import javax.swing.JSplitPane;
import javax.swing.JTextArea;

public class LevelTypesAndText extends JSplitPane {
	private JTextArea levelTypeDescription;
	private LevelTypeButtons levelTypeButtons;
	
	LevelTypesAndText() {
		super();
		this.setResizeWeight(0.5);
		this.setOrientation(JSplitPane.VERTICAL_SPLIT);
		levelTypeButtons = new LevelTypeButtons();
		this.setTopComponent(levelTypeButtons);
		
		levelTypeDescription = new JTextArea();
		levelTypeDescription.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		this.setRightComponent(levelTypeDescription);
	}
}
