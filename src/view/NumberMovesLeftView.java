package view;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Dimension;
import java.awt.Font;

/**
 * Class for displaying the number of moves left in a puzzle GAME.
 * 
 * @author dfontana
 * @author aharrison
 */
public class NumberMovesLeftView extends JPanel {
	private static final long serialVersionUID = 1L;
	
	JTextPane numberMoves;
	JLabel lblTitle;

	public NumberMovesLeftView() {
		this.setPreferredSize(new Dimension(180, 90));
		numberMoves = new JTextPane();
		numberMoves.setFont(new Font("Tahoma", Font.PLAIN, 24));
		numberMoves.setText("00");
		lblTitle = new JLabel("Moves Remaining");
		
		setupLayout();
	}
	
	/**
	 * Method to set the text of the moves left textPane. 
	 * Method converts integer argument into a string.
	 * The passed argument should be two places. Ex: 10 or 09
	 * @param movesLeft - Number of remaining moves to be displayed
	 */
	void updateMovesLeft(int movesLeft){
		numberMoves.setText(Integer.toString(movesLeft));
	}
	
	private void setupLayout() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(49)
							.addComponent(lblTitle))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(74)
							.addComponent(numberMoves, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(48, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(lblTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(numberMoves, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
}
