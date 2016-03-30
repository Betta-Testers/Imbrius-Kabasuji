package builderMockups;

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
	JLabel lblTitle;
	JLabel lblTileCount;
	JLabel lblTileCountVar;
	JLabel lblSetMoves;
	JLabel lblSetTime;
	JSpinner spinMoves;
	JSpinner spinTime;
	
	public LevelPropertiesView(){
		lblTitle = new JLabel("Level Properties");
		lblTileCount = new JLabel("Tile Count:");
		lblTileCountVar = new JLabel("0");
		lblSetMoves = new JLabel("Set Moves:");
		lblSetTime = new JLabel("Set Time:");
		spinMoves = new JSpinner();
		spinTime = new JSpinner();
		
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTileCount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSetMoves.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSetTime.setHorizontalAlignment(SwingConstants.RIGHT);
		spinMoves.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinTime.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		
		setupLayout();
	}
	
	private void setupLayout(){
		GroupLayout gl_panelLevelProperties = new GroupLayout(this);
		gl_panelLevelProperties.setHorizontalGroup(
				gl_panelLevelProperties.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLevelProperties.createSequentialGroup()
						.addGroup(gl_panelLevelProperties.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelLevelProperties.createParallelGroup(Alignment.LEADING, false)
										.addGroup(Alignment.TRAILING, gl_panelLevelProperties.createSequentialGroup()
												.addComponent(lblTileCount, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGap(4)
												.addComponent(lblTileCountVar, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panelLevelProperties.createSequentialGroup()
												.addComponent(lblTitle)))
								.addGroup(Alignment.TRAILING, gl_panelLevelProperties.createSequentialGroup()
										.addGroup(gl_panelLevelProperties.createParallelGroup(Alignment.LEADING, false)
												.addComponent(lblSetTime, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblSetMoves, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(gl_panelLevelProperties.createParallelGroup(Alignment.LEADING, false)
												.addComponent(spinTime)
												.addComponent(spinMoves)))))
				);
		gl_panelLevelProperties.setVerticalGroup(
				gl_panelLevelProperties.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLevelProperties.createSequentialGroup()
						.addComponent(lblTitle)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelLevelProperties.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTileCount)
								.addComponent(lblTileCountVar))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelLevelProperties.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSetMoves)
								.addComponent(spinMoves, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelLevelProperties.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSetTime)
								.addComponent(spinTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				);
		this.setLayout(gl_panelLevelProperties);
	}

}
