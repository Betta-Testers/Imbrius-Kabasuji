package builderMockups;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import java.awt.Font;
import javax.swing.SpinnerNumberModel;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import java.awt.Component;

public class BuilderWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					BuilderWindow frame = new BuilderWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BuilderWindow() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panelPlayingArea = new JPanel();
		ButtonGroupView panelButtonGroup = new ButtonGroupView();
		
		TileCreationView tileCreation = new TileCreationView();
		LevelPropertiesView levelProperties = new LevelPropertiesView();
		BullPenView bullPen = new BullPenView();
		
		panelPlayingArea.setBackground(Color.WHITE);
		

		// ==================== BUTTON PALETTE ==================== // 
//		JButton btnUndo = new JButton("");
//		JButton btnRedo = new JButton("");
//		JButton btnRemovePieces = new JButton("Remove Pieces");
//		JToggleButton btnConvertHint = new JToggleButton("Convert to Hint");
//		JButton btnSave = new JButton("Save");
//		btnRemovePieces.setToolTipText("Remove all pieces on the board");
//
//		btnConvertHint.setToolTipText("Pieces on board are turned into a hint");
//		btnSave.setToolTipText("Save Level");
//		btnUndo.setToolTipText("Undo");
//		btnUndo.setIcon(new ImageIcon(BuilderWindow.class.getResource("/icons/Undo.png")));
//		btnRedo.setToolTipText("Redo");
//		btnRedo.setIcon(new ImageIcon(BuilderWindow.class.getResource("/icons/Redo.png")));
		
		// ==================== Playing Area ==================== // 
		JPanel panelBoard = new JPanel();
		panelBoard.setBackground(Color.WHITE);

		JPanel panelPieceViewer = new JPanel();
		panelPieceViewer.setBackground(Color.CYAN);
		
		
		// ==================== LAYOUT SETTINGS - Overall ==================== //
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panelPlayingArea, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(tileCreation, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(levelProperties, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelButtonGroup, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(bullPen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(bullPen, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(levelProperties, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tileCreation, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelButtonGroup, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(panelPlayingArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);


		// ==================== LAYOUT SETTINGS - Button Palette ==================== // 
//		GroupLayout gl_panelButtonGroup = new GroupLayout(panelButtonGroup);
//		gl_panelButtonGroup.setHorizontalGroup(
//			gl_panelButtonGroup.createParallelGroup(Alignment.LEADING)
//				.addComponent(btnRemovePieces, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
//				.addComponent(btnConvertHint, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
//				.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
//				.addGroup(gl_panelButtonGroup.createSequentialGroup()
//					.addComponent(btnUndo, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
//					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
//					.addComponent(btnRedo, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
//		);
//		gl_panelButtonGroup.setVerticalGroup(
//			gl_panelButtonGroup.createParallelGroup(Alignment.TRAILING)
//				.addGroup(Alignment.LEADING, gl_panelButtonGroup.createSequentialGroup()
//					.addGroup(gl_panelButtonGroup.createParallelGroup(Alignment.LEADING)
//						.addComponent(btnUndo)
//						.addComponent(btnRedo))
//					.addComponent(btnRemovePieces, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
//					.addComponent(btnConvertHint, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
//					.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
//		);
//		gl_panelButtonGroup.linkSize(SwingConstants.VERTICAL, new Component[] {btnRemovePieces, btnConvertHint, btnSave});
//		gl_panelButtonGroup.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnRemovePieces, btnConvertHint, btnSave});
//		panelButtonGroup.setLayout(gl_panelButtonGroup);
		
		// ==================== LAYOUT SETTINGS - PlayingArea ==================== //
		GroupLayout gl_panelPlayingArea = new GroupLayout(panelPlayingArea);
		gl_panelPlayingArea.setHorizontalGroup(
				gl_panelPlayingArea.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPlayingArea.createSequentialGroup()
						.addGroup(gl_panelPlayingArea.createParallelGroup(Alignment.LEADING, false)
								.addComponent(panelPieceViewer, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
								.addComponent(panelBoard, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)))
				);
		gl_panelPlayingArea.setVerticalGroup(
				gl_panelPlayingArea.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPlayingArea.createSequentialGroup()
						.addComponent(panelPieceViewer, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelBoard, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE))
				);
		panelPlayingArea.setLayout(gl_panelPlayingArea);
		contentPane.setLayout(gl_contentPane);
	}
}
