package view;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import model.AbstractLevelModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import controllers.builder.SetNumberOfMovesSpinnerController;
import controllers.builder.TimeLimitSpinnerController;
import model.PuzzleLevel;
import model.LightningLevel;

/**
 * JPanel for displaying the properties of a given level.
 * Configurable to display information relevant only to the current
 * level type being edited.
 * @author Dylan
 */
public class LevelPropertiesView extends JPanel{
	private static final long serialVersionUID = 1L;
	/**Layout manager for this LevelPropertiesView**/
	GroupLayout groupLayout;
	/**Title of the panel**/
	JLabel lblTitle;
	/**Label for the Tile Count**/
	JLabel lblTileCount;
	/**Label displaying the current tile count**/
	JLabel lblTileCountVar;
	/**Integer tracking the tile count label's value.**/
	int tileCount;
	/**Label for setting Moves in Puzzle**/
	JLabel lblSetMoves;
	/**Label for setting Time in Lightning**/
	JLabel lblSetTime;
	/**Spinner for setting the value of Move Limit in Puzzle**/
	JSpinner spinMoves;
	/**Spinner for setting the value of Time in Lightning**/
	JSpinner spinTime;
	/**The level whose properties are being displayed**/
	AbstractLevelModel levelModel;
	
	/**
	 * Constructs a LevelPropertiesView
	 */
	public LevelPropertiesView(){
		setPreferredSize(new Dimension(120, 120));
		lblTitle = new JLabel("Level Properties");
		lblTileCount = new JLabel("Tile Count:");
		lblTileCountVar = new JLabel("0");
		lblSetMoves = new JLabel("Set Moves:");
		lblSetTime = new JLabel("Set Time:");
		
		spinMoves = new JSpinner();
		spinTime = new JSpinner();
		
		spinMoves.setEnabled(true);
		spinTime.setEnabled(true);
		
		lblSetMoves.setEnabled(true);
		lblSetTime.setEnabled(true);
		
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTileCount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSetMoves.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSetTime.setHorizontalAlignment(SwingConstants.RIGHT);
		
		spinMoves.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinTime.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		
		tileCount = 0;
		setupLayout();
	}
	
	/**
	 * Hides irrelevant information to a lightning level.
	 * Prepares the controllers relevant to a lightning level.
	 */
	public void lightning(){
		lblSetMoves.setVisible(false);
		spinMoves.setVisible(false);
		lblSetTime.setVisible(true);
		spinTime.setVisible(true);
		spinTime.setValue(((LightningLevel)levelModel).getTotalTime());
		
		spinTime.addChangeListener(new TimeLimitSpinnerController((LightningLevel) levelModel));
	}
	
	/**
	 * Hides irrelevant information to a puzzle level.
	 * Prepares the controllers relevant to a puzzle level.
	 */
	public void puzzle(){
		lblSetMoves.setVisible(true);
		lblSetTime.setVisible(false);
		spinTime.setVisible(false);
		spinMoves.setVisible(true);
		spinMoves.setValue(((PuzzleLevel)levelModel).getMoveLimit());
		
		spinMoves.addChangeListener(new SetNumberOfMovesSpinnerController((PuzzleLevel)levelModel));
	}
	
	/**
	 * Hides irrelevant information to a release level.
	 */
	public void release(){
		lblSetMoves.setVisible(false);
		spinMoves.setVisible(false);
		lblSetTime.setVisible(false);
		spinTime.setVisible(false);
	}
	
	/**
	 * Adjusts the label showing the current count of board tile, making
	 * it easier to build levels that of size 6n.
	 * @param delta - The amount to adjust the tile count by. Can be positive or
	 * negative
	 */
	public void adjustTileCount(int delta){
		tileCount += delta;
		lblTileCountVar.setText(Integer.toString(tileCount));
	}
	
	/**
	 * A method used to set the level model of a LevelPropertiesView.
	 * This initializes information regarding the number of board tiles as well.
	 * Sets the label's text to reflect this amount
	 * @param levelModel the LevelModel being set by the method
	 */
	public void setLevelModel(AbstractLevelModel levelModel) {
		this.levelModel = levelModel;
		tileCount = levelModel.getBoard().getNumBoardTiles();
		lblTileCountVar.setText(Integer.toString(tileCount));
	}
	
	/**
	 * 	Returns the levelModel used in the LevelPropertiesView.
	 * @return AbstractLevelModel
	 */
	public AbstractLevelModel getLevelModel() {
		return levelModel;
	}

	/**
	 * Method for setting up the layout for the LevelPropertiesView
	 */
	private void setupLayout(){
		groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTileCount)
								.addComponent(lblSetTime)
								.addComponent(lblSetMoves))
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTileCountVar, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
								.addComponent(spinTime, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
								.addComponent(spinMoves, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)))
						.addComponent(lblTitle)))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTileCount)
						.addComponent(lblTileCountVar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSetMoves)
						.addComponent(spinMoves, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSetTime)
						.addComponent(spinTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED))
		);
		this.setLayout(groupLayout);
	}

}
