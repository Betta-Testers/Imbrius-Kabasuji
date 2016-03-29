package gameMockups;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.KeyEvent;

public class PuzzleGame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PuzzleGame frame = new PuzzleGame();
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
	public PuzzleGame() {
		setTitle("Puzzle");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 651);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panelContentArea = new JPanel();
		panelContentArea.setBackground(Color.WHITE);

		JPanel panelButtonGroup = new JPanel();

		JPanel panelLevelDescription = new JPanel();
		
		JPanel panelBullpenPlaceholder = new JPanel();

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panelContentArea, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panelBullpenPlaceholder, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
						.addComponent(panelLevelDescription, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panelButtonGroup, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(panelLevelDescription, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelBullpenPlaceholder, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(panelButtonGroup, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
						.addComponent(panelContentArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		JLabel lblBullpenGoesHere = new JLabel("Bullpen Goes Here");
		panelBullpenPlaceholder.add(lblBullpenGoesHere);

		JLabel lblLevel = new JLabel("Level");
		lblLevel.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lblLevelNumber = new JLabel("1");
		lblLevelNumber.setFont(new Font("Tahoma", Font.BOLD, 13));
		GroupLayout gl_panelLevelDescription = new GroupLayout(panelLevelDescription);
		gl_panelLevelDescription.setHorizontalGroup(
			gl_panelLevelDescription.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLevelDescription.createSequentialGroup()
					.addGap(19)
					.addComponent(lblLevel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblLevelNumber, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panelLevelDescription.setVerticalGroup(
			gl_panelLevelDescription.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLevelDescription.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panelLevelDescription.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLevel)
						.addComponent(lblLevelNumber))
					.addContainerGap(82, Short.MAX_VALUE))
		);
		panelLevelDescription.setLayout(gl_panelLevelDescription);

		JToggleButton btnShowHint = new JToggleButton("Show Hint");
		btnShowHint.setMnemonic(KeyEvent.VK_ENTER);

		btnShowHint.setToolTipText("Pieces on board are turned into a hint");
		GroupLayout gl_panelButtonGroup = new GroupLayout(panelButtonGroup);
		gl_panelButtonGroup.setHorizontalGroup(
			gl_panelButtonGroup.createParallelGroup(Alignment.LEADING)
				.addComponent(btnShowHint)
		);
		gl_panelButtonGroup.setVerticalGroup(
			gl_panelButtonGroup.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelButtonGroup.createSequentialGroup()
					.addGap(56)
					.addComponent(btnShowHint, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(113, Short.MAX_VALUE))
		);
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