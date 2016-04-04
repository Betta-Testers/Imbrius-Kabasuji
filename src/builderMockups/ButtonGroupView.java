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
import javax.swing.LayoutStyle.ComponentPlacement;

public class ButtonGroupView extends JPanel{
	GroupLayout gl_panelButtonGroup;
	JButton btnUndo;
	JButton btnRedo;
	JButton btnSave;
	JButton btnRemovePieces;
	JToggleButton btnConvertHint;
	
	public ButtonGroupView(){
		setPreferredSize(new Dimension(107, 115));
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
		btnUndo.setIcon(new ImageIcon(BuilderWindow.class.getResource("/icons/Undo.png")));
		btnRedo.setIcon(new ImageIcon(BuilderWindow.class.getResource("/icons/Redo.png")));
		
		setupLayout();
	}
	
	private void setupLayout(){
		gl_panelButtonGroup = new GroupLayout(this);
		gl_panelButtonGroup.setHorizontalGroup(
			gl_panelButtonGroup.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelButtonGroup.createSequentialGroup()
					.addComponent(btnUndo, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addComponent(btnRedo, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelButtonGroup.createSequentialGroup()
					.addGroup(gl_panelButtonGroup.createParallelGroup(Alignment.LEADING)
						.addComponent(btnRemovePieces, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnConvertHint, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panelButtonGroup.setVerticalGroup(
			gl_panelButtonGroup.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelButtonGroup.createSequentialGroup()
					.addGroup(gl_panelButtonGroup.createParallelGroup(Alignment.LEADING)
						.addComponent(btnUndo)
						.addComponent(btnRedo))
					.addComponent(btnRemovePieces, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addComponent(btnConvertHint, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
		);
		gl_panelButtonGroup.linkSize(SwingConstants.VERTICAL, new Component[] {btnRemovePieces, btnConvertHint, btnSave});
		gl_panelButtonGroup.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnRemovePieces, btnConvertHint, btnSave});
		this.setLayout(gl_panelButtonGroup);
	}
}
