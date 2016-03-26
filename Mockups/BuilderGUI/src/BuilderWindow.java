import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.SpinnerListModel;
import java.awt.Font;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panelBoard = new JPanel();
		panelBoard.setBackground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("Tile Creation");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JButton btn1 = new JButton("1");
		btn1.setForeground(Color.BLACK);
		btn1.setBackground(Color.BLUE);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btn2 = new JButton("2");
		btn2.setForeground(Color.BLACK);
		btn2.setBackground(Color.BLUE);
		
		JLabel lblTileCount = new JLabel("Tile Count:");
		
		JLabel lblTuleCountVar = new JLabel("5");
		
		JLabel lblSetMoves = new JLabel("Set Moves:");
		
		JLabel lblSetTime = new JLabel("Set Time:");
		
		JLabel lblLevelProperties = new JLabel("Level Properties");
		lblLevelProperties.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JSpinner spinMoves = new JSpinner();
		spinMoves.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		
		JSpinner spinTime = new JSpinner();
		spinTime.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		
		JButton btnResetLevel = new JButton("Reset Level");
		btnResetLevel.setToolTipText("Clear level and start over");
		
		JButton btnRedo = new JButton("");
		btnRedo.setToolTipText("Redo");
		btnRedo.setIcon(new ImageIcon(BuilderWindow.class.getResource("/Icons/Redo.png")));
		
		JButton btnUndo = new JButton("");
		btnUndo.setToolTipText("Undo");
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnUndo.setIcon(new ImageIcon(BuilderWindow.class.getResource("/Icons/Undo.png")));
		
		JScrollPane scrollpaneBullpen = new JScrollPane();
		scrollpaneBullpen.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollpaneBullpen.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JButton btn4 = new JButton("4");
		btn4.setForeground(Color.BLACK);
		btn4.setBackground(Color.BLUE);
		
		JButton btn3 = new JButton("3");
		btn3.setForeground(Color.BLACK);
		btn3.setBackground(Color.BLUE);
		
		JButton btn5 = new JButton("5");
		btn5.setForeground(Color.BLACK);
		btn5.setBackground(Color.BLUE);
		
		JButton btn6 = new JButton("6");
		btn6.setForeground(Color.BLACK);
		btn6.setBackground(Color.BLUE);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerListModel(new String[] {"Blue", "Yellow", "Red"}));
		
		JLabel lblColor = new JLabel("Color:");
		
		JButton btnRemovePieces = new JButton("Remove Pieces");
		btnRemovePieces.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemovePieces.setToolTipText("Remove all pieces on the board");
		
		JButton btnValidateSave = new JButton("Validate & Save");
		btnValidateSave.setToolTipText("Check if level is valid and save if so");
		
		JButton btnConvertHint = new JButton("Convert to Hint");
		btnConvertHint.setToolTipText("Pieces on board are turned into a hint");
		
		JButton btnRotateLeft = new JButton("");
		btnRotateLeft.setIcon(new ImageIcon(BuilderWindow.class.getResource("/Icons/RotateLeft.png")));
		btnRotateLeft.setEnabled(false);
		btnRotateLeft.setToolTipText("Rotate selected piece left");
		
		JButton btnRotateRight = new JButton("");
		btnRotateRight.setIcon(new ImageIcon(BuilderWindow.class.getResource("/Icons/RotateRight.png")));
		btnRotateRight.setEnabled(false);
		btnRotateRight.setToolTipText("Rotate selected piece right");
		
		JButton btnFlipX = new JButton("X");
		btnFlipX.setEnabled(false);
		btnFlipX.setToolTipText("Flips piece over X Axis");
		
		JButton btnFlipY = new JButton("Y");
		btnFlipY.setEnabled(false);
		btnFlipY.setToolTipText("Flips piece over Y Axis");
		
		JButton btnResetOrientation = new JButton("Reset");
		btnResetOrientation.setEnabled(false);
		btnResetOrientation.setToolTipText("Resets Orientation of Selected Piece");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblTileCount)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTuleCountVar, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
					.addGap(319))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblLevelProperties)
							.addGap(80)
							.addComponent(btnRotateLeft, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnFlipX, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnResetOrientation, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnFlipY, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnRotateRight, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(1)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addComponent(btnRemovePieces, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
											.addComponent(btnConvertHint, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
										.addComponent(btnValidateSave, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(btn3, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(btn4, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(lblNewLabel)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(btn1)
													.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(btn2))))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btn5, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btn6, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblColor, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnUndo, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnRedo, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblSetMoves)
										.addComponent(lblSetTime))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(spinTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(spinMoves, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)))
								.addComponent(btnResetLevel))
							.addPreferredGap(ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panelBoard, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollpaneBullpen, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblLevelProperties)
								.addComponent(btnRotateLeft)
								.addComponent(btnFlipX, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnResetOrientation, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnFlipY, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnRotateRight))
							.addGap(8)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTileCount)
								.addComponent(lblTuleCountVar))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSetMoves)
								.addComponent(spinMoves, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSetTime)
								.addComponent(spinTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(25))
						.addComponent(scrollpaneBullpen, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelBoard, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btn1)
								.addComponent(btn2))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btn4)
								.addComponent(btn3))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btn5)
								.addComponent(btn6))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblColor)
								.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnRedo)
								.addComponent(btnUndo))
							.addGap(18)
							.addComponent(btnRemovePieces, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnConvertHint, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnValidateSave, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addGap(7))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnResetLevel)
					.addGap(308))
		);
		
// ==================== THE BULLPEN ==================== //
		JPanel panelScrollContainer = new JPanel();
		panelScrollContainer.setBackground(Color.WHITE);
		scrollpaneBullpen.setViewportView(panelScrollContainer);
		
		JPanel panelHex1 = new JPanel();
		JPanel panelHex2 = new JPanel();
		JPanel panelHex3 = new JPanel();
		
		JSpinner spinHex1 = new JSpinner();
		JSpinner spinHex2 = new JSpinner();
		JSpinner spinHex3 = new JSpinner();

// ==================== HEXOMINOE BUTTON SETTINGS ==================== //
		JButton btnHex1 = new JButton(""); //FIX FOR 6 SQUARE TALL HEXOMINOES
		btnHex1.setIcon(new ImageIcon(new ImageIcon(BuilderWindow.class.getResource("/Hexominoes_Images/1.png")).getImage().getScaledInstance(30, 30,java.awt.Image.SCALE_SMOOTH)));
		GroupLayout gl_panelHex1 = new GroupLayout(panelHex1);
		gl_panelHex1.setHorizontalGroup(
			gl_panelHex1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelHex1.createSequentialGroup()
					.addGap(0)
					.addGroup(gl_panelHex1.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(spinHex1, Alignment.LEADING)
						.addComponent(btnHex1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE))
					.addGap(0))
		);
		gl_panelHex1.setVerticalGroup(
			gl_panelHex1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelHex1.createSequentialGroup()
					.addComponent(btnHex1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
					.addComponent(spinHex1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		panelHex1.setLayout(gl_panelHex1);
		
		
		JButton btnHex2 = new JButton("");
		btnHex2.setIcon(new ImageIcon(BuilderWindow.class.getResource("/Hexominoes_Images/2.png")));
		GroupLayout gl_panelHex2 = new GroupLayout(panelHex2);
		gl_panelHex2.setHorizontalGroup(
			gl_panelHex2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelHex2.createSequentialGroup()
					.addGap(0)
					.addGroup(gl_panelHex2.createParallelGroup(Alignment.LEADING, false)
						.addComponent(spinHex2)
						.addComponent(btnHex2, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)))
		);
		gl_panelHex2.setVerticalGroup(
			gl_panelHex2.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelHex2.createSequentialGroup()
					.addComponent(btnHex2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
					.addComponent(spinHex2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		panelHex2.setLayout(gl_panelHex2);
		
		
		JButton btnHex3 = new JButton("");
		btnHex3.setIcon(new ImageIcon(BuilderWindow.class.getResource("/Hexominoes_Images/3.png")));
		GroupLayout gl_panelHex3 = new GroupLayout(panelHex3);
		gl_panelHex3.setHorizontalGroup(
			gl_panelHex3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 35, Short.MAX_VALUE)
				.addGroup(gl_panelHex3.createSequentialGroup()
					.addGap(0)
					.addGroup(gl_panelHex3.createParallelGroup(Alignment.LEADING, false)
						.addComponent(spinHex3)
						.addComponent(btnHex3, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)))
		);
		gl_panelHex3.setVerticalGroup(
			gl_panelHex3.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelHex3.createSequentialGroup()
					.addComponent(btnHex3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
					.addComponent(spinHex3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		panelHex3.setLayout(gl_panelHex3);
		
		
// ==================== SCROLL CONTAINER SETTINGS ==================== //
		GroupLayout gl_panelScrollContainer = new GroupLayout(panelScrollContainer);
		gl_panelScrollContainer.setHorizontalGroup(
			gl_panelScrollContainer.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelScrollContainer.createSequentialGroup()
					.addComponent(panelHex1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addComponent(panelHex2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addComponent(panelHex3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(237, Short.MAX_VALUE))
		);
		gl_panelScrollContainer.setVerticalGroup(
			gl_panelScrollContainer.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelScrollContainer.createSequentialGroup()
					.addGroup(gl_panelScrollContainer.createParallelGroup(Alignment.LEADING)
						.addComponent(panelHex1, GroupLayout.PREFERRED_SIZE, 62, Short.MAX_VALUE)
						.addComponent(panelHex2, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelHex3, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panelScrollContainer.setLayout(gl_panelScrollContainer);
		contentPane.setLayout(gl_contentPane);
	}
}
