package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class LevelTypeButtons extends JPanel {
	ButtonGroup levelTypeButtons;
	ArrayList<LevelTypeToggle> levelTypeButtonsList;
	LevelTypeToggle tglBtnPuzzle;
	LevelTypeToggle tglBtnLightning;
	LevelTypeToggle tglBtnRelease;
	LevelTypeButtons () {
		super();
		
		levelTypeButtons = new ButtonGroup();
		levelTypeButtonsList = new ArrayList<LevelTypeToggle>();
		tglBtnPuzzle = new LevelTypeToggle("Puzzle", new ImageIcon(LevelTypeSelectView.class.getResource("/icons/Puzzle.png")));
		levelTypeButtons.add(tglBtnPuzzle);
		levelTypeButtonsList.add(tglBtnPuzzle);
		tglBtnLightning = new LevelTypeToggle("Lightning", new ImageIcon(LevelTypeSelectView.class.getResource("/icons/Lightning.png")));
		levelTypeButtons.add(tglBtnLightning);
		levelTypeButtonsList.add(tglBtnLightning);
		tglBtnRelease = new LevelTypeToggle("Release", new ImageIcon(LevelTypeSelectView.class.getResource("/icons/Release.png")));
		levelTypeButtons.add(tglBtnRelease);
		levelTypeButtonsList.add(tglBtnRelease);
		
		
		setupLayout();
	}
	
	void setupLayout() {
		GroupLayout gl_levelTypesPanel = new GroupLayout(this);
		gl_levelTypesPanel.setAutoCreateGaps(true);
		gl_levelTypesPanel.setAutoCreateContainerGaps(true);
		gl_levelTypesPanel.setHorizontalGroup(
			gl_levelTypesPanel.createParallelGroup(Alignment.CENTER)
				.addGroup(Alignment.CENTER, gl_levelTypesPanel.createSequentialGroup()
					.addContainerGap(5, Short.MAX_VALUE)
					.addComponent(tglBtnPuzzle)
					.addContainerGap(5, Short.MAX_VALUE)
					.addComponent(tglBtnLightning)
					.addContainerGap(5, Short.MAX_VALUE)
					.addComponent(tglBtnRelease)
					.addContainerGap(5, Short.MAX_VALUE))
		);
		gl_levelTypesPanel.setVerticalGroup(
			gl_levelTypesPanel.createParallelGroup(Alignment.CENTER)
				.addGroup(Alignment.CENTER, gl_levelTypesPanel.createSequentialGroup()
						.addContainerGap(5, Short.MAX_VALUE)
						.addGroup(gl_levelTypesPanel.createParallelGroup()
							.addComponent(tglBtnPuzzle)
							.addComponent(tglBtnLightning)
							.addComponent(tglBtnRelease))
						.addContainerGap(5, Short.MAX_VALUE))
		);
		this.setLayout(gl_levelTypesPanel);
	}
	
	public ArrayList<LevelTypeToggle> getButtons() {
		return levelTypeButtonsList;
	}
}
