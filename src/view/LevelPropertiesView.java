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
import controllers.builder.SetBullpenSizeSpinnerController;
import controllers.builder.TimeLimitSpinnerController;
import model.PuzzleLevel;
import model.LightningLevel;

public class LevelPropertiesView extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GroupLayout groupLayout;
	JLabel lblTitle;
	JLabel lblTileCount;
	JLabel lblTileCountVar;
	JLabel lblSetMoves;
	JLabel lblSetTime;
	JLabel lblBullpenSize;
	JSpinner spinMoves;
	JSpinner spinTime;
	JSpinner spinBullpenSize;
	AbstractLevelModel levelModel;
	
	public LevelPropertiesView(){
		setPreferredSize(new Dimension(120, 120));
		lblTitle = new JLabel("Level Properties");
		lblTileCount = new JLabel("Tile Count:");
		lblTileCountVar = new JLabel("0");
		lblSetMoves = new JLabel("Set Moves:");
		lblSetTime = new JLabel("Set Time:");
		lblBullpenSize = new JLabel("Bullpen Size:");
		
		spinMoves = new JSpinner();
		spinTime = new JSpinner();
		spinBullpenSize = new JSpinner();
		
		spinMoves.setEnabled(true);
		spinBullpenSize.setEnabled(true);
		spinTime.setEnabled(true);
		
		lblSetMoves.setEnabled(true);
		lblBullpenSize.setEnabled(true);
		lblSetTime.setEnabled(true);
		
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTileCount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSetMoves.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSetTime.setHorizontalAlignment(SwingConstants.RIGHT);
		
		spinMoves.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinTime.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinBullpenSize.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		
		setupLayout();
	}
	
	/**
	 * Hides irrelevant information to a lightning level.
	 * Prepares the controllers relevant to a lightning level.
	 */
	public void lightning(){
		lblSetMoves.setVisible(false);
		spinMoves.setVisible(false);
		lblBullpenSize.setVisible(true);
		spinBullpenSize.setVisible(true);
		lblSetTime.setVisible(true);
		spinTime.setVisible(true);
		spinTime.setValue(((LightningLevel)levelModel).getTotalTime());
		
		spinTime.addChangeListener(new TimeLimitSpinnerController((LightningLevel) levelModel));
		spinBullpenSize.addChangeListener(new SetBullpenSizeSpinnerController(this));
	}
	
	/**
	 * Hides irrelevant information to a puzzle level.
	 * Prepares the controllers relevant to a puzzle level.
	 */
	public void puzzle(){
		lblSetMoves.setVisible(true);
		lblBullpenSize.setVisible(false);
		spinBullpenSize.setVisible(false);
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
		lblBullpenSize.setVisible(false);
		spinBullpenSize.setVisible(false);
		lblSetMoves.setVisible(false);
		spinMoves.setVisible(false);
		lblSetTime.setVisible(false);
		spinTime.setVisible(false);
	}
	
	/**
	 * A method used to set the level model of a LevelPropertiesView
	 * @param levelModel the LevelModel being set by the method
	 */
	public void setLevelModel(AbstractLevelModel levelModel) {
		this.levelModel = levelModel;
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
								.addComponent(lblSetMoves)
								.addComponent(lblBullpenSize))
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTileCountVar, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
								.addComponent(spinTime, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
								.addComponent(spinMoves, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
								.addComponent(spinBullpenSize, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)))
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
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBullpenSize)
						.addComponent(spinBullpenSize, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		this.setLayout(groupLayout);
	}
	
	public AbstractLevelModel getLevelModel() {
		return levelModel;
	}

}
