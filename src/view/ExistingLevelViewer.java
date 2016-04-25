package view;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 * Shows all of the ExistingLevelViews in a scrollpane for the builder.
 * @author hejohnson
 *
 */
public class ExistingLevelViewer extends JScrollPane {
	private static final long serialVersionUID = 1L;
	
	/**Panel of the view.**/
	JPanel levelsList;
	/**Array of the ExistingLevelViews that make up the ExistingLevelViewer.**/
	ArrayList<ExistingLevelView> existingLevels;
	
	/**
	 * Creates a new ExistingLevelViewer.
	 */
	ExistingLevelViewer(){
		super();
		this.setEnabled(false);
		this.getHorizontalScrollBar().setUnitIncrement(126);
		this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		levelsList = new JPanel();
		existingLevels = new ArrayList<ExistingLevelView>();
		this.setViewportView(levelsList);
	}
	/**
	 * Add a level view to the list of existing levels.
	 * @param levelType - String
	 * @param levelIndex - int
	 */
	public ExistingLevelView addLevelView(String levelType, Integer levelIndex) {
		ExistingLevelView elv = new ExistingLevelView(levelType, levelIndex);
		levelsList.add(elv);
		existingLevels.add(elv);
		this.revalidate();
		this.repaint();
		return elv;
	}
	
	/**
	 * Remove a level view to the list of existing levels.
	 * @param levelNumber - int
	 */
	public void removeLevelView(int levelNumber) {
		for(ExistingLevelView elv : existingLevels){
			if (elv.getLevelNumber() == levelNumber){
				existingLevels.remove(elv);
				levelsList.remove(elv);
				this.revalidate();
				this.repaint();
				break;
			}
		}
	}
	
	/**
	 * Returns all of the currently available level buttons.
	 * @return ArrayList<ExistingLevelView> returns an array list containing all of the current existing level buttons
	 */
	public ArrayList<ExistingLevelView> getExistingLevelButtons() {
		return existingLevels;
	}

}
