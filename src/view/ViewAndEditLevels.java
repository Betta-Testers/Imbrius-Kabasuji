package view;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JSplitPane;

public class ViewAndEditLevels extends JSplitPane {
	private static final long serialVersionUID = 1L;
	
	ExistingLevelViewer levelViewer;
	JLabel lblExistingLevels;
	
	ViewAndEditLevels () {
		super();
		this.setOrientation(JSplitPane.VERTICAL_SPLIT);
		this.setEnabled(false);
		
		lblExistingLevels = new JLabel("Existing Levels (Click to edit)");
		lblExistingLevels.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		this.setLeftComponent(lblExistingLevels);
		
		levelViewer = new ExistingLevelViewer();
		this.setRightComponent(levelViewer);
	}
	
	public ArrayList<ExistingLevelView> getExistingLevelButtons() {
		return levelViewer.getExistingLevelButtons();
	}
	
	public void addLevel(String levelType, int levelNum) {
		levelViewer.addLevelView(levelType, levelNum);
	}
}
