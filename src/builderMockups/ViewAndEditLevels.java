package builderMockups;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JSplitPane;

public class ViewAndEditLevels extends JSplitPane {
	ViewAndEditLevels () {
		super();
		this.setOrientation(JSplitPane.VERTICAL_SPLIT);
		this.setEnabled(false);
		JLabel lblExistingLevels = new JLabel("Existing Levels (Click to edit)");
		lblExistingLevels.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.setLeftComponent(lblExistingLevels);
		ExistingLevelViewer levelViewer = new ExistingLevelViewer();
		this.setRightComponent(levelViewer);
		
		for (int i=1; i<=5; i++){
			levelViewer.addLevelView("Puzzle", i);
			levelViewer.addLevelView("Lightning", i);
			levelViewer.addLevelView("Release", i);
		}
	}
}
