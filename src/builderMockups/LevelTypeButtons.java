package builderMockups;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class LevelTypeButtons extends JPanel {
	private ButtonGroup levelTypeButtons;
	private JToggleButton puzzleBtn;
	private JToggleButton lightningBtn;
	private JToggleButton releaseBtn;
	LevelTypeButtons () {
		super();
		
		levelTypeButtons = new ButtonGroup();
		puzzleBtn = new JToggleButton("", new ImageIcon(LevelTypeSelectView.class.getResource("/icons/Puzzle.png")));
		levelTypeButtons.add(puzzleBtn);
		lightningBtn = new JToggleButton("", new ImageIcon(LevelTypeSelectView.class.getResource("/icons/Lightning.png")));
		levelTypeButtons.add(lightningBtn);
		releaseBtn = new JToggleButton("", new ImageIcon(LevelTypeSelectView.class.getResource("/icons/Release.png")));
		levelTypeButtons.add(releaseBtn);
		
		GroupLayout gl_levelTypesPanel = new GroupLayout(this);
		gl_levelTypesPanel.setAutoCreateGaps(true);
		gl_levelTypesPanel.setAutoCreateContainerGaps(true);
		gl_levelTypesPanel.setHorizontalGroup(
			gl_levelTypesPanel.createParallelGroup(Alignment.CENTER)
				.addGroup(Alignment.CENTER, gl_levelTypesPanel.createSequentialGroup()
					.addContainerGap(5, Short.MAX_VALUE)
					.addComponent(puzzleBtn)
					.addContainerGap(5, Short.MAX_VALUE)
					.addComponent(lightningBtn)
					.addContainerGap(5, Short.MAX_VALUE)
					.addComponent(releaseBtn)
					.addContainerGap(5, Short.MAX_VALUE))
		);
		gl_levelTypesPanel.setVerticalGroup(
			gl_levelTypesPanel.createParallelGroup(Alignment.CENTER)
				.addGroup(Alignment.CENTER, gl_levelTypesPanel.createSequentialGroup()
						.addContainerGap(5, Short.MAX_VALUE)
						.addGroup(gl_levelTypesPanel.createParallelGroup()
							.addComponent(puzzleBtn)
							.addComponent(lightningBtn)
							.addComponent(releaseBtn))
						.addContainerGap(5, Short.MAX_VALUE))
		);
		this.setLayout(gl_levelTypesPanel);
		
		puzzleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		lightningBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		releaseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
								
			}
		});
	}
}
