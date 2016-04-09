package view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class LevelPropertiesView extends JPanel{
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
		spinTime.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		
		setupLayout();
	}
	
	/**
	 * Hides irrelevant information to a lightning level
	 * A lightning level wants to see setPieceCount and
	 * setTimer
	 */
	public void lightning(){
		lblSetMoves.setVisible(false);
		spinMoves.setVisible(false);
	}
	
	/**
	 * Hides irrelevant information to a puzzle level
	 * A puzzle level wants to see setMoveCount only.
	 */
	public void puzzle(){
		lblSetPieceCt.setVisible(false);
		spinPieceCt.setVisible(false);
		lblSetTime.setVisible(false);
		spinTime.setVisible(false);
	}
	
	/**
	 * Hides irrelevant information to a release level
	 * A release level wants to see nothing inside the
	 * level properties view
	 */
	public void release(){
		lblSetPieceCt.setVisible(false);
		spinPieceCt.setVisible(false);
		lblSetMoves.setVisible(false);
		spinMoves.setVisible(false);
		lblSetTime.setVisible(false);
		spinTime.setVisible(false);
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

}
