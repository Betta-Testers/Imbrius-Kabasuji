package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Dimension;

public class ExistingLevelView extends JButton {	
	ImageIcon icon;
	int levelNumber;
	ExistingLevelView(String levelType, Integer levelNumber) {
		super(levelType+" "+levelNumber.toString());
		this.levelNumber = levelNumber;
		Dimension levelPreviewSize = new Dimension(126, 126);
		if (levelType.equals("Release")) {
			icon = new ImageIcon(LevelTypeSelectView.class.getResource("/icons/ReleaseSm.png"));
		} else if (levelType.equals("Lightning")) {
			icon = new ImageIcon(LevelTypeSelectView.class.getResource("/icons/LightningSm.png"));
		} else if (levelType.equals("Puzzle")) {
			icon = new ImageIcon(LevelTypeSelectView.class.getResource("/icons/PuzzleSm.png"));
		} else {
			//#TODO: some kind of behavior here
		}
		this.setIcon(icon);
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setHorizontalTextPosition(SwingConstants.CENTER);
		this.setVerticalTextPosition(SwingConstants.BOTTOM);
		this.setPreferredSize(levelPreviewSize);
		this.setMaximumSize(levelPreviewSize);
		this.setMinimumSize(levelPreviewSize);
		//this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	public int getLevelNumber() {
		return this.levelNumber;
	}
}
