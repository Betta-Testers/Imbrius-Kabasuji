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

/**
 * Shows an existing level for the builder ExistingLevelViewer.
 * @author hejohnson
 *
 */
public class ExistingLevelView extends JPanel implements Comparable<ExistingLevelView>{	
	private static final long serialVersionUID = 1L;
	
	/**Button to allow editing the level.**/
	JButton editLevel;
	
	/**Button to allow deletion of the level.**/
	JButton deleteLevel;
	
	/**Stores the number of the level.**/
	int levelNumber;
	
	/**Handles editLevel button presses.**/
	ActionListener editLevelHandler;
	
	/**Handles deleteLevel button presses.**/
	ActionListener deleteLevelHandler;
	
	/**
	 * Creates a new ExistingLevelView with a given type and level number.
	 * @param levelType - String
	 * @param levelNumber - Integer
	 */
	ExistingLevelView(String levelType, Integer levelNumber, ImageIcon icon) {
		super();
		this.levelNumber = levelNumber;
		editLevel = new JButton(levelType+" "+levelNumber.toString());
		Dimension levelPreviewSize = new Dimension(126, 126);

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
	
	/**
	 * Sets up the layout of the ExistingLevelView.
	 */
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
	 * Returns the level number.
	 * @return levelNumber - int
	 */
	public int getLevelNumber() {
		return this.levelNumber;
	}
	
	/**
	 * Sets ActionListener to the edit level button.
	 * @param al - ActionListener
	 */
	public void addActionListenerToEditButton(ActionListener al) {
		this.editLevelHandler = al;
		editLevel.addActionListener(al);
	}
	
	/**
	 * Sets ActionListener to the delete level button.
	 * @param al - ActionListener
	 */
	public void addActionListenerToDeleteButton(ActionListener al) {
		this.editLevelHandler = al;
		deleteLevel.addActionListener(al);
	}
	
	/**
	 * Returns ActionListener linked to the edit level button.
	 * @return editLevelHandler - ActionListener
	 */
	public ActionListener getEditHandler() {
		return this.editLevelHandler;
	}
	
	/**
	 * Returns ActionListener linked to the delete level button.
	 * @return deleteLevelHandler - ActionListener
	 */
	public ActionListener getDeleteHandler() {
		return this.deleteLevelHandler;
	}

	/**
	 * For sorting the list of existing levels
	 * @param elv view to to compare it to
	 * @return < 0 if the parameter is a higher numbered level
	 */
	@Override
	public int compareTo(ExistingLevelView elv) {
		return this.getLevelNumber()-elv.getLevelNumber();
	}
	
	/**
	 * Sets the icon of the button to a new board preview
	 * @param icon The new preview of the board
	 */
	public void updateIcon(ImageIcon icon) {
		this.editLevel.setIcon(icon);
		
	}
}
