package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import controllers.common.FlipPieceHorizontalController;
import controllers.common.FlipPieceVerticalController;
import controllers.common.RotatePieceLeftController;
import controllers.common.RotatePieceRightController;
import model.Bullpen;

/**
 * This view is where the user can see a visual representation of the piece (PiecePPanel) and manipulate it.
 * @author dfontana
 */
public class SelectedPieceView extends JPanel{
	private static final long serialVersionUID = 1L;
	/**Stores the layout.**/
	GroupLayout groupLayout;
	/**Stores the piecePanel (used for graphics).**/
	PiecePanel piecePanel;
	/**Button to allow the user to rotate the piece counterclockwise.**/
	JButton btnRotateLeft;
	/**Button to allow the user to rotate the piece clockwise.**/
	JButton btnRotateRight;
	/**Button to allow the user to flip the piece vertically.**/
	JButton btnFlipV;
	/**Button to allow the user to flip the piece horizontally.**/
	JButton btnFlipH;
	/**Stores the Bullpen entity associated with this SelectedPieceView.**/
	Bullpen bp;
	
	/**
	 * Creates a SelectedPieceView with a given Bullpen.
	 * @param bp - Bullpen
	 */
	public SelectedPieceView(Bullpen bp){
		setPreferredSize(new Dimension(384, 224));
		this.bp = bp;
		btnRotateLeft = new JButton("");
		btnRotateLeft.setToolTipText("Rotate Left");
		btnRotateRight = new JButton("");
		btnRotateRight.setToolTipText("Rotate Right");
		btnFlipV = new JButton("");
		btnFlipV.setToolTipText("Flip Vertical");
		btnFlipH = new JButton("");
		btnFlipH.setToolTipText("Flip Horizontal");
		
		piecePanel = new PiecePanel(bp);
		setupLayout();
		this.setBackground(Color.WHITE);
		initializeControllers();
	}
	
	/**
	 * Returns the PiecePanel.
	 * @return piecePanel - PiecePanel
	 */
	public PiecePanel getPiecePanel(){
		return this.piecePanel;
	}

	/**
	 * Initialize the controllers associated with the SelectedPieceView.
	 */
	public void initializeControllers() {
		btnFlipV.addActionListener(new FlipPieceVerticalController(bp, this));
		btnFlipH.addActionListener(new FlipPieceHorizontalController(bp, this));
		btnRotateRight.addActionListener(new RotatePieceRightController(bp, this));
		btnRotateLeft.addActionListener(new RotatePieceLeftController(bp, this));
	}
	
	/**
	 * returns the button that causes the piece in the pieceViewer panel to rotate right.
	 * @return btnRotateRight - JButton
	 */
	public JButton getRotateRightBtn() {
		return this.btnRotateRight;
	}
	
	/**
	 * returns the button that causes the piece in the pieceViewer panel to rotate left.
	 * @return btnRotateLeft - JButton
	 */
	public JButton getRotateLeftBtn() {
		return this.btnRotateLeft;
	}
	
	/**
	 * returns the button that causes the piece in the pieceViewer panel to flip horizontally.
	 * @return btnFlipH - JButton
	 */
	public JButton getFlipHBtn() {
		return this.btnFlipH;
	}
	
	/**
	 * returns the button that causes the piece in the pieceViewer panel to flip vertically.
	 * @return btnFlipH - JButton
	 */
	public JButton getFlipVBtn() {
		return this.btnFlipV;
	}
	
    /**
	 * Sets up the layout of SelectedPieceView.
	 */
	private void setupLayout(){
		
		btnRotateLeft.setIcon(new ImageIcon(SelectedPieceView.class.getResource("/icons/RotateLeft.png")));
		btnRotateRight.setIcon(new ImageIcon(SelectedPieceView.class.getResource("/icons/RotateRight.png")));
		btnFlipV.setIcon(new ImageIcon(SelectedPieceView.class.getResource("/icons/FlipV.png")));
		btnFlipH.setIcon(new ImageIcon(SelectedPieceView.class.getResource("/icons/FlipH.png")));
		
		groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(96, Short.MAX_VALUE)
					.addComponent(piecePanel, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnFlipV, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnFlipH, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnRotateLeft, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRotateRight, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnRotateLeft)
								.addComponent(btnRotateRight))
							.addPreferredGap(ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnFlipV)
								.addComponent(btnFlipH)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(16)
							.addComponent(piecePanel, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);

		setLayout(groupLayout);
	}
}
