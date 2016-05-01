package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import app.UndoManager;

/**
 * Represents the buttons on the builder. 
 * @author dfontana
 *
 */
public class ButtonGroupView extends JPanel{
	private static final long serialVersionUID = 1L;
	
	/**Stores the layout of the ButtonGroupView.**/
	GroupLayout groupLayout;
	/**The undo button of the ButtonGroupView.**/
	JButton btnUndo;
	/**The redo button of the ButtonGroupView.**/
	JButton btnRedo;
	/**The save button of the ButtonGroupView.**/
	JButton btnSave;
	/**The remove-pieces button of the ButtonGroupView.**/
	JButton btnRemovePieces;
	
	/**
	 * Creates a new ButtonGroupView.
	 */
	ButtonGroupView(){
		setPreferredSize(new Dimension(120, 85));
		btnUndo = new JButton("");
		btnRedo = new JButton("");
		btnRemovePieces = new JButton("Remove Pieces");
		btnSave = new JButton("Save");
		
		btnRemovePieces.setToolTipText("Remove all pieces on the board");
		btnSave.setToolTipText("Save the level to disk and close the builder.");
		btnUndo.setToolTipText("Undo");
		btnRedo.setToolTipText("Redo");
		btnUndo.setEnabled(false);
		btnRedo.setEnabled(false);
		btnUndo.setIcon(new ImageIcon(this.getClass().getResource("/icons/Undo.png")));
		btnRedo.setIcon(new ImageIcon(this.getClass().getResource("/icons/Redo.png")));
		
		//CRITICAL LINE: Gives undo/redo enable/disable control to the undo manager!
		UndoManager.getInstance().giveButtonGroup(this);
		
		setupLayout();
		this.setBackground(Color.WHITE);
	}
		
	/**
	 * Sets the redo button enabled by the given boolean.
	 * @param enabled - boolean
	 */
	public void setRedoEnabled(boolean enabled){
		btnRedo.setEnabled(enabled);
	}
	
	/**
	 * Sets the undo button enabled by the given boolean.
	 * @param enabled - boolean
	 */
	public void setUndoEnabled(boolean enabled){
		btnUndo.setEnabled(enabled);
	}
	
	//** FOR TESTING **//
	
	/**
	 * Returns the undo move button.
	 * @return btnUndo - JButton
	 */
	public JButton getUndoBtn() {
		return this.btnUndo;
	}
	
	/**
	 * Returns the redo move button.
	 * @return btnRedo - JButton
	 */
	public JButton getRedoBtn() {
		return this.btnRedo;
	}
	
	/**
	 * Returns the remove all pieces button.
	 * @return btnRemovePieces - JButton
	 */
	public JButton getRemoveBtn() {
		return this.btnRemovePieces;
	}
	
	/**
	 * Returns the save button.
	 * @return btnSave - JButton
	 */
	public JButton getSaveBtn(){
		return btnSave;
	}
	/**
	 * Sets up the layout for the ButtonGroupView.
	 */
	private void setupLayout(){
		groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(btnUndo, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
					.addComponent(btnRedo, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
				.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
				.addComponent(btnRemovePieces, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnUndo)
						.addComponent(btnRedo))
					.addComponent(btnRemovePieces, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.linkSize(SwingConstants.VERTICAL, new Component[] {btnRemovePieces, btnSave});
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnRemovePieces, btnSave});
		this.setLayout(groupLayout);
	}
}
