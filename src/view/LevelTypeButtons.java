package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class LevelTypeButtons extends JPanel {
	ButtonGroup levelTypeButtons;
	JToggleButton tglBtnPuzzle;
	JToggleButton tglBtnLightning;
	JToggleButton tglBtnRelease;
	LevelTypeButtons () {
		super();
		
		levelTypeButtons = new ButtonGroup();
		tglBtnPuzzle = new JToggleButton("", new ImageIcon(LevelTypeSelectView.class.getResource("/icons/Puzzle.png")));
		levelTypeButtons.add(tglBtnPuzzle);
		tglBtnLightning = new JToggleButton("", new ImageIcon(LevelTypeSelectView.class.getResource("/icons/Lightning.png")));
		levelTypeButtons.add(tglBtnLightning);
		tglBtnRelease = new JToggleButton("", new ImageIcon(LevelTypeSelectView.class.getResource("/icons/Release.png")));
		levelTypeButtons.add(tglBtnRelease);
		
		tglBtnPuzzle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		tglBtnLightning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		tglBtnRelease.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
								
			}
		});
		
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
}
