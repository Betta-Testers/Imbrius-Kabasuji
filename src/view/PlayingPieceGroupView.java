package view;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import model.PieceGroup;
/**
 * View of the piece group in the player. Shows the current count of the number of that piece available to place on the board. 
 * Has a button to click to select piece for reorientation and placement.
 * @author dfontana
 * @author hejohnson
 *
 */
public class PlayingPieceGroupView extends AbstractPieceGroupView{
	private static final long serialVersionUID = 1L;
	/**Stores the layout of the PlayingPieceGroupView.**/
	GroupLayout groupLayout;
	/**Shows the amount of pieces in a PieceGroup.**/
	JLabel label;
	
	/**
	 * Creates a PlayingPieceGroupView.
	 * @param pieceGroup - PieceGroup
	 */
	PlayingPieceGroupView(PieceGroup pieceGroup){
		super(pieceGroup);
		
		label = new JLabel();
		updateCount();
		
		setupLayout();
	}
	
	/**
	 * Updates label to show the correct amount of pieces in a PieceGroup. 
	 */
	@Override
	void updateCount() {
		int count = pieceGroup.getNumPieces();
		label.setText(Integer.toString(count));
		if(count < 1){
			this.setVisible(false);
		}else{
			this.setVisible(true);
		}
	}
	
	/**
	 * Sets up the layout of PlayingPieceGroupView.
	 */
	void setupLayout(){
		label.setHorizontalAlignment(SwingConstants.CENTER);
		groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(button, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
		);

		setLayout(groupLayout);
	}


}
