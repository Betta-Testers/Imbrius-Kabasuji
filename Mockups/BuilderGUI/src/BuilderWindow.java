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
		
		JButton btnRedo = new JButton("Redo");
		
		JButton btnUndo = new JButton("Undo");
		
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblTileCount)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTuleCountVar, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
					.addGap(319))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
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
											.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(1)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addComponent(btnRemovePieces, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
											.addComponent(btnConvertHint, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
										.addComponent(btnValidateSave, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panelBoard, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSetMoves)
								.addComponent(lblSetTime))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(spinTime)
								.addComponent(spinMoves, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(scrollpaneBullpen, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblLevelProperties)
							.addGap(134)
							.addComponent(btnUndo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRedo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnResetLevel)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblLevelProperties)
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
							.addGap(31))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnResetLevel)
								.addComponent(btnRedo)
								.addComponent(btnUndo))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollpaneBullpen, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
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
							.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
							.addComponent(btnRemovePieces, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnConvertHint, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnValidateSave, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addGap(7))
		);
		
		JPanel panelScrollContainer = new JPanel();
		panelScrollContainer.setBackground(Color.WHITE);
		scrollpaneBullpen.setViewportView(panelScrollContainer);
		
		JPanel panelHex1 = new JPanel();
		
		JPanel panel = new JPanel();
		
		JSpinner spinner_1 = new JSpinner();
		
		JButton button = new JButton("<Image>");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(29)
					.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
				.addComponent(button, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(7))
		);
		panel.setLayout(gl_panel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(BuilderWindow.class.getResource("/Hexominoes_Images/1.bmp")));
		GroupLayout gl_panelScrollContainer = new GroupLayout(panelScrollContainer);
		gl_panelScrollContainer.setHorizontalGroup(
			gl_panelScrollContainer.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelScrollContainer.createSequentialGroup()
					.addComponent(panelHex1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(74, Short.MAX_VALUE))
		);
		gl_panelScrollContainer.setVerticalGroup(
			gl_panelScrollContainer.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelScrollContainer.createSequentialGroup()
					.addGroup(gl_panelScrollContainer.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
						.addComponent(panelHex1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 62, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 62, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JSpinner spinHex1 = new JSpinner();
		
		JButton btnHex1 = new JButton("<Image>");
		GroupLayout gl_panelHex1 = new GroupLayout(panelHex1);
		gl_panelHex1.setHorizontalGroup(
			gl_panelHex1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelHex1.createSequentialGroup()
					.addGap(29)
					.addComponent(spinHex1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
				.addComponent(btnHex1, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
		);
		gl_panelHex1.setVerticalGroup(
			gl_panelHex1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelHex1.createSequentialGroup()
					.addComponent(btnHex1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(spinHex1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(7))
		);
		panelHex1.setLayout(gl_panelHex1);
		panelScrollContainer.setLayout(gl_panelScrollContainer);
		contentPane.setLayout(gl_contentPane);
	}
}
