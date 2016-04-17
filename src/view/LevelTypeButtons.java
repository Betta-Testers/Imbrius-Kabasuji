package view;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controllers.NewLevelTypeController;

public class LevelTypeButtons extends JPanel {
	private static final long serialVersionUID = 1L;
	
	ButtonGroup levelTypeButtons;
	LevelTypeToggle tglBtnPuzzle;
	LevelTypeToggle tglBtnLightning;
	LevelTypeToggle tglBtnRelease;
	
	LevelTypeButtons () {
		super();
		tglBtnPuzzle = new LevelTypeToggle("Puzzle", new ImageIcon(LevelTypeSelectView.class.getResource("/icons/Puzzle.png")));
		tglBtnLightning = new LevelTypeToggle("Lightning", new ImageIcon(LevelTypeSelectView.class.getResource("/icons/Lightning.png")));
		tglBtnRelease = new LevelTypeToggle("Release", new ImageIcon(LevelTypeSelectView.class.getResource("/icons/Release.png")));
		
		levelTypeButtons = new ButtonGroup();
		levelTypeButtons.add(tglBtnPuzzle);
		levelTypeButtons.add(tglBtnLightning);
		levelTypeButtons.add(tglBtnRelease);

		setupLayout();
	}

	public String getSelectedLevelType() {
		for (Enumeration<AbstractButton> buttons = levelTypeButtons.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();
			if (button.isSelected()) {
				return ((LevelTypeToggle) button).getLevelType();
			}
		}
		throw new RuntimeException("Selected button could not return a levelType");
	}

	public void addControllers(JTextArea textArea, JButton createLevelBtn) {
		tglBtnPuzzle.addActionListener(new NewLevelTypeController(textArea, createLevelBtn));
		tglBtnLightning.addActionListener(new NewLevelTypeController(textArea, createLevelBtn));
		tglBtnRelease.addActionListener(new NewLevelTypeController(textArea, createLevelBtn));
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
