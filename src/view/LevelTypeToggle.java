package view;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

public class LevelTypeToggle extends JToggleButton {
	String levelType;
	LevelTypeToggle(String levelType, ImageIcon icon) {
		super(icon);
		this.levelType = levelType;
	}

	public String getLevelType() {
		return this.levelType;
	}
}
