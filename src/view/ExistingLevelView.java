package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ExistingLevelView extends JPanel {	
	ImageIcon icon;
	JButton editLevel;
	JButton deleteLevel;
	int levelNumber;
	ExistingLevelView(String levelType, Integer levelNumber) {
		super();
		this.levelNumber = levelNumber;
		editLevel = new JButton(levelType+" "+levelNumber.toString());
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
		editLevel.setIcon(icon);
		editLevel.setHorizontalAlignment(SwingConstants.CENTER);
		editLevel.setHorizontalTextPosition(SwingConstants.CENTER);
		editLevel.setVerticalTextPosition(SwingConstants.BOTTOM);
		editLevel.setPreferredSize(levelPreviewSize);
		editLevel.setMaximumSize(levelPreviewSize);
		editLevel.setMinimumSize(levelPreviewSize);
		this.add(editLevel);
		
		deleteLevel = new JButton("Delete");
		this.add(deleteLevel);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setupLayout();
	}
	
	void setupLayout() {
		GroupLayout gl_ltsv = new GroupLayout(this);
		gl_ltsv.setHorizontalGroup(
			gl_ltsv.createParallelGroup(Alignment.CENTER)
					.addComponent(editLevel)
					.addComponent(deleteLevel)
		);
		gl_ltsv.setVerticalGroup(
			gl_ltsv.createSequentialGroup()
				.addComponent(editLevel)
				.addComponent(deleteLevel)
		);
		this.setLayout(gl_ltsv);
	}
	/**
	 * A method used by outside objects/classes to retrieve the level number
	 * @return int representing the level number
	 */
	public int getLevelNumber() {
		return this.levelNumber;
	}
	
	public void addActionListenerToEditButton(ActionListener al) {
		editLevel.addActionListener(al);
	}
	
	public void addActionListenerToDeleteButton(ActionListener al) {
		deleteLevel.addActionListener(al);
	}
}
