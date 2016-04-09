package builderMockups;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;


public class ButtonGroupView extends JPanel{
	GroupLayout groupLayout;
	JButton btnUndo;
	JButton btnRedo;
	JButton btnSave;
	JButton btnRemovePieces;
	JToggleButton btnConvertHint;
	
	public ButtonGroupView(){
		setPreferredSize(new Dimension(105, 115));
		btnUndo = new JButton("");
		btnRedo = new JButton("");
		btnRemovePieces = new JButton("Remove Pieces");
		btnConvertHint = new JToggleButton("Convert to Hint");
		btnSave = new JButton("Save");
		
		btnRemovePieces.setToolTipText("Remove all pieces on the board");
		btnConvertHint.setToolTipText("Pieces on board are turned into a hint");
		btnSave.setToolTipText("Save Level");
		btnUndo.setToolTipText("Undo");
		btnRedo.setToolTipText("Redo");
		btnUndo.setIcon(new ImageIcon(this.getClass().getResource("/icons/Undo.png")));
		btnRedo.setIcon(new ImageIcon(this.getClass().getResource("/icons/Redo.png")));
		
		setupLayout();
	}
	
	private void setupLayout(){
		groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(btnUndo, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(btnRedo, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnRemovePieces, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnConvertHint, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnUndo)
						.addComponent(btnRedo))
					.addComponent(btnRemovePieces, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addComponent(btnConvertHint, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.linkSize(SwingConstants.VERTICAL, new Component[] {btnRemovePieces, btnConvertHint, btnSave});
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnRemovePieces, btnConvertHint, btnSave});
		this.setLayout(groupLayout);
	}
}
