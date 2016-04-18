package view;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class ExistingLevelViewer extends JScrollPane {
	private static final long serialVersionUID = 1L;
	
	JPanel levelsList;
	ArrayList<ExistingLevelView> existingLevels;
	
	ExistingLevelViewer(){
		super();
		this.setEnabled(false);
		this.getHorizontalScrollBar().setUnitIncrement(126);
		this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		levelsList = new JPanel();
		existingLevels = new ArrayList<ExistingLevelView>();
		this.setViewportView(levelsList);
	}
	
	public void addLevelView(String levelType, Integer levelIndex) {
		ExistingLevelView elv = new ExistingLevelView(levelType, levelIndex);
		levelsList.add(elv);
		existingLevels.add(elv);
	}
	
	public ArrayList<ExistingLevelView> getExistingLevelButtons() {
		return existingLevels;
	}
}
