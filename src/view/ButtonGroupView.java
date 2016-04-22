package view;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;

import controllers.builder.SaveAndCloseLevelButtonController;
import javax.swing.LayoutStyle.ComponentPlacement;


public class ButtonGroupView extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GroupLayout groupLayout;
	JButton btnUndo;
	JButton btnRedo;
	JButton btnSave;
	JButton btnRemovePieces;
	JButton btnConvertPiecesToLevel;
	
	public ButtonGroupView(BuilderView bv){
		setPreferredSize(new Dimension(105, 115));
		btnUndo = new JButton("");
		btnRedo = new JButton("");
		btnRemovePieces = new JButton("Remove Pieces");
		btnConvertPiecesToLevel = new JButton("Convert Pieces to Board");
		btnSave = new JButton("Save");
		
		btnRemovePieces.setToolTipText("Remove all pieces on the board");
		btnConvertPiecesToLevel.setToolTipText("Pieces placed on the board region get turned into a board");
		btnSave.setToolTipText("Save the level to disk and close the builder.");
		btnSave.addActionListener(new SaveAndCloseLevelButtonController(bv.getBuilder()));
		btnUndo.setToolTipText("Undo");
		btnRedo.setToolTipText("Redo");
		btnUndo.setIcon(new ImageIcon(this.getClass().getResource("/icons/Undo.png")));
		btnRedo.setIcon(new ImageIcon(this.getClass().getResource("/icons/Redo.png")));
		
		setupLayout();
	}
	
//	public boolean getHintSelected() {
//		return btnConvertHint.isSelected();
//	}
	
	
	/**
	 * Method for setting up the layout for the available level view
	 */
	private void setupLayout(){
		groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(btnUndo, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
					.addComponent(btnRedo, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
				.addComponent(btnConvertPiecesToLevel, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
				.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
				.addComponent(btnRemovePieces, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnUndo)
						.addComponent(btnRedo))
					.addComponent(btnRemovePieces, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addComponent(btnConvertPiecesToLevel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.linkSize(SwingConstants.VERTICAL, new Component[] {btnRemovePieces, btnConvertPiecesToLevel, btnSave});
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnRemovePieces, btnConvertPiecesToLevel, btnSave});
		this.setLayout(groupLayout);
	}
	
	/**
	 * CONSTRUCTOR USED FOR WINDOW BUILDER
	 * Window builder doesn't like the idea of passing the "this" you are 
	 * currently editing, so it throws an exception. To resolve this, this is a constructor that
	 * doesn't require "this". 
	 * DO NOT INSTANTIATE THIS!!!!
	 */
	public ButtonGroupView(){
		setPreferredSize(new Dimension(160, 115));
		btnUndo = new JButton("");
		btnRedo = new JButton("");
		btnRemovePieces = new JButton("Remove Pieces");
		btnConvertPiecesToLevel = new JButton("Convert Pieces To Board");
		btnSave = new JButton("Save");
		
		btnRemovePieces.setToolTipText("Remove all pieces on the board");
		btnConvertPiecesToLevel.setToolTipText("Pieces placed on the board region get turned into a board");
		btnSave.setToolTipText("Save the level to disk and close the builder.");
		btnUndo.setToolTipText("Undo");
		btnRedo.setToolTipText("Redo");
		btnUndo.setIcon(new ImageIcon(this.getClass().getResource("/icons/Undo.png")));
		btnRedo.setIcon(new ImageIcon(this.getClass().getResource("/icons/Redo.png")));
		
		setupLayout();
	}
}
