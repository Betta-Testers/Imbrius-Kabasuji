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
import model.PuzzleLevel;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

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
	JLabel lblSetPieceCt;
	JSpinner spinMoves;
	JSpinner spinTime;
	JSpinner spinPieceCt;
	AbstractLevelModel levelModel;
	
	public LevelPropertiesView(){
		setPreferredSize(new Dimension(120, 120));
		lblTitle = new JLabel("Level Properties");
		lblTileCount = new JLabel("Tile Count:");
		lblTileCountVar = new JLabel("0");
		lblSetMoves = new JLabel("Set Moves:");
		lblSetTime = new JLabel("Set Time:");
		lblSetPieceCt = new JLabel("Set Piece Ct:");
		
		spinMoves = new JSpinner();
		spinTime = new JSpinner();
		spinPieceCt = new JSpinner();
		
		spinMoves.setEnabled(true);
		spinPieceCt.setEnabled(true);
		spinTime.setEnabled(true);
		
		lblSetMoves.setEnabled(true);
		lblSetPieceCt.setEnabled(true);
		lblSetTime.setEnabled(true);
		
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTileCount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSetMoves.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSetTime.setHorizontalAlignment(SwingConstants.RIGHT);
		
		spinMoves.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		//spinMoves.addChangeListener(new SetNumberOfMovesSpinnerController(this));
		spinTime.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		
		setupLayout();
	}
	
	
	/**
	 * Hides irrelevant information to a lightning level.
	 */
	public void lightning(){
		lblSetMoves.setVisible(false);
		spinMoves.setVisible(false);
		lblSetPieceCt.setVisible(true);
		spinPieceCt.setVisible(true);
		lblSetTime.setVisible(true);
		spinTime.setVisible(true);
	}
	
	/**
	 * Hides irrelevant information to a puzzle level.
	 */
	public void puzzle(){
		lblSetMoves.setVisible(true);
		spinMoves.setVisible(true);
		lblSetPieceCt.setVisible(false);
		spinPieceCt.setVisible(false);
		lblSetTime.setVisible(false);
		spinTime.setVisible(false);
	}
	
	/**
	 * Hides irrelevant information to a release level.
	 * 
	 */
	public void release(){
		lblSetPieceCt.setVisible(false);
		spinPieceCt.setVisible(false);
		lblSetMoves.setVisible(false);
		spinMoves.setVisible(false);
		lblSetTime.setVisible(false);
		spinTime.setVisible(false);
	}
	
	public void setLevelModel(AbstractLevelModel levelModel) {
		this.levelModel = levelModel;
	}
	
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
								.addComponent(lblSetPieceCt))
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTileCountVar, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
								.addComponent(spinTime, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
								.addComponent(spinMoves, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
								.addComponent(spinPieceCt, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)))
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
						.addComponent(lblSetPieceCt)
						.addComponent(spinPieceCt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		this.setLayout(groupLayout);
	}
	
	public AbstractLevelModel getLevelModel() {
		return levelModel;
	}

}
