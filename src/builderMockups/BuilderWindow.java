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
import javax.swing.SpinnerListModel;
import java.awt.Font;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
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

		JPanel panelContentArea = new JPanel();
		JPanel panelButtonGroup = new JPanel();
		JPanel panelTileCreation = new JPanel();
		JPanel panelLevelProperties = new JPanel();
		JScrollPane bullPen = new BullPen();
		
		panelContentArea.setBackground(Color.WHITE);

		// ==================== LAYOUT SETTINGS ==================== //
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panelContentArea, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panelTileCreation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelLevelProperties, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
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
							.addComponent(panelLevelProperties, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelTileCreation, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelButtonGroup, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(panelContentArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		JLabel lblLevelProperties = new JLabel("Level Properties");
		lblLevelProperties.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lblTileCount = new JLabel("Tile Count:");
		lblTileCount.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblTuleCountVar = new JLabel("5");

		JLabel lblSetMoves = new JLabel("Set Moves:");
		lblSetMoves.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblSetTime = new JLabel("Set Time:");
		lblSetTime.setHorizontalAlignment(SwingConstants.RIGHT);

		JSpinner spinMoves = new JSpinner();
		spinMoves.setModel(new SpinnerNumberModel(1, 1, 100, 1));

		JSpinner spinTime = new JSpinner();
		spinTime.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		GroupLayout gl_panelLevelProperties = new GroupLayout(panelLevelProperties);
		gl_panelLevelProperties.setHorizontalGroup(
				gl_panelLevelProperties.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLevelProperties.createSequentialGroup()
						.addGroup(gl_panelLevelProperties.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelLevelProperties.createParallelGroup(Alignment.LEADING, false)
										.addGroup(Alignment.TRAILING, gl_panelLevelProperties.createSequentialGroup()
												.addComponent(lblTileCount, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGap(4)
												.addComponent(lblTuleCountVar, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panelLevelProperties.createSequentialGroup()
												.addComponent(lblLevelProperties)))
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
						.addComponent(lblLevelProperties)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelLevelProperties.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTileCount)
								.addComponent(lblTuleCountVar))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelLevelProperties.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSetMoves)
								.addComponent(spinMoves, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelLevelProperties.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSetTime)
								.addComponent(spinTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				);
		panelLevelProperties.setLayout(gl_panelLevelProperties);

		JLabel lblNewLabel = new JLabel("Tile Creation");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));

		JButton btn1 = new JButton("1");
		btn1.setForeground(Color.BLACK);
		btn1.setBackground(Color.BLUE);


		JButton btn2 = new JButton("2");
		btn2.setForeground(Color.BLACK);
		btn2.setBackground(Color.BLUE);

		JButton btn3 = new JButton("3");
		btn3.setForeground(Color.BLACK);
		btn3.setBackground(Color.BLUE);

		JButton btn4 = new JButton("4");
		btn4.setForeground(Color.BLACK);
		btn4.setBackground(Color.BLUE);

		JButton btn5 = new JButton("5");
		btn5.setForeground(Color.BLACK);
		btn5.setBackground(Color.BLUE);

		JButton btn6 = new JButton("6");
		btn6.setForeground(Color.BLACK);
		btn6.setBackground(Color.BLUE);

		JLabel lblColor = new JLabel("Color:");

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerListModel(new String[] {"Blue", "Yellow", "Red"}));
		GroupLayout gl_panelTileCreation = new GroupLayout(panelTileCreation);
		gl_panelTileCreation.setHorizontalGroup(
				gl_panelTileCreation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTileCreation.createSequentialGroup()
						.addGroup(gl_panelTileCreation.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelTileCreation.createSequentialGroup()
										.addContainerGap()
										.addComponent(lblNewLabel))
								.addGroup(gl_panelTileCreation.createSequentialGroup()
										.addGap(8)
										.addGroup(gl_panelTileCreation.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panelTileCreation.createSequentialGroup()
														.addComponent(btn5)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(btn6))
												.addGroup(gl_panelTileCreation.createSequentialGroup()
														.addComponent(btn3)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(btn4))
												.addGroup(gl_panelTileCreation.createSequentialGroup()
														.addComponent(btn1)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(btn2))))
								.addGroup(gl_panelTileCreation.createSequentialGroup()
										.addGap(8)
										.addComponent(lblColor)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		gl_panelTileCreation.setVerticalGroup(
				gl_panelTileCreation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTileCreation.createSequentialGroup()
						.addGap(5)
						.addComponent(lblNewLabel)
						.addGroup(gl_panelTileCreation.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelTileCreation.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btn1))
								.addGroup(gl_panelTileCreation.createSequentialGroup()
										.addGap(6)
										.addComponent(btn2)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelTileCreation.createParallelGroup(Alignment.BASELINE)
								.addComponent(btn3)
								.addComponent(btn4))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelTileCreation.createParallelGroup(Alignment.BASELINE)
								.addComponent(btn5)
								.addComponent(btn6))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelTileCreation.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblColor)
								.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		panelTileCreation.setLayout(gl_panelTileCreation);

		JButton btnRemovePieces = new JButton("Remove Pieces");

		btnRemovePieces.setToolTipText("Remove all pieces on the board");

		JToggleButton btnConvertHint = new JToggleButton("Convert to Hint");

		btnConvertHint.setToolTipText("Pieces on board are turned into a hint");

		JButton btnSave = new JButton("Save");
		btnSave.setToolTipText("Save Level");

		JButton btnUndo = new JButton("");
		btnUndo.setToolTipText("Undo");

		btnUndo.setIcon(new ImageIcon(BuilderWindow.class.getResource("/icons/Undo.png")));

		JButton btnRedo = new JButton("");
		btnRedo.setToolTipText("Redo");
		btnRedo.setIcon(new ImageIcon(BuilderWindow.class.getResource("/icons/Redo.png")));
		GroupLayout gl_panelButtonGroup = new GroupLayout(panelButtonGroup);
		gl_panelButtonGroup.setHorizontalGroup(
			gl_panelButtonGroup.createParallelGroup(Alignment.LEADING)
				.addComponent(btnRemovePieces, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
				.addComponent(btnConvertHint, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
				.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_panelButtonGroup.createSequentialGroup()
					.addComponent(btnUndo, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addComponent(btnRedo, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
		);
		gl_panelButtonGroup.setVerticalGroup(
			gl_panelButtonGroup.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelButtonGroup.createSequentialGroup()
					.addGroup(gl_panelButtonGroup.createParallelGroup(Alignment.LEADING)
						.addComponent(btnUndo)
						.addComponent(btnRedo))
					.addComponent(btnRemovePieces, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addComponent(btnConvertHint, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
		);
		gl_panelButtonGroup.linkSize(SwingConstants.VERTICAL, new Component[] {btnRemovePieces, btnConvertHint, btnSave});
		gl_panelButtonGroup.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnRemovePieces, btnConvertHint, btnSave});
		panelButtonGroup.setLayout(gl_panelButtonGroup);

		JPanel panelBoard = new JPanel();
		panelBoard.setBackground(Color.WHITE);

		JPanel panelPieceViewer = new JPanel();
		panelPieceViewer.setBackground(Color.CYAN);
		GroupLayout gl_panelContentArea = new GroupLayout(panelContentArea);
		gl_panelContentArea.setHorizontalGroup(
				gl_panelContentArea.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelContentArea.createSequentialGroup()
						.addGroup(gl_panelContentArea.createParallelGroup(Alignment.LEADING, false)
								.addComponent(panelPieceViewer, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
								.addComponent(panelBoard, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)))
				);
		gl_panelContentArea.setVerticalGroup(
				gl_panelContentArea.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelContentArea.createSequentialGroup()
						.addComponent(panelPieceViewer, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelBoard, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE))
				);
		panelContentArea.setLayout(gl_panelContentArea);
		contentPane.setLayout(gl_contentPane);
	}
}
