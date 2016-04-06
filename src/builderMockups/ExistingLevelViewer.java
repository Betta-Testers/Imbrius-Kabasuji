package builderMockups;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class ExistingLevelViewer extends JScrollPane {
	JPanel levelsList;
	ExistingLevelViewer(){
		super();
		this.setEnabled(false);
		this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		levelsList = new JPanel();
		this.setViewportView(levelsList);
	}
	
	public void addLevelView(String levelType, Integer levelIndex) {
		levelsList.add(new ExistingLevelView(levelType, levelIndex));
	}
}
