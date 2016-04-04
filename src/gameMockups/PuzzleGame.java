package gameMockups;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
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
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(panelBullpenPlaceholder, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
								.addComponent(panelLevelDescription, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(panelButtonGroup, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(62))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panelLevelDescription, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelBullpenPlaceholder, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelButtonGroup, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
						.addComponent(panelContentArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		JLabel lblBullpenGoesHere = new JLabel("Bullpen Goes Here");
		GroupLayout gl_panelBullpenPlaceholder = new GroupLayout(panelBullpenPlaceholder);
		gl_panelBullpenPlaceholder.setHorizontalGroup(
			gl_panelBullpenPlaceholder.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBullpenPlaceholder.createSequentialGroup()
					.addGap(56)
					.addComponent(lblBullpenGoesHere))
		);
		gl_panelBullpenPlaceholder.setVerticalGroup(
			gl_panelBullpenPlaceholder.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBullpenPlaceholder.createSequentialGroup()
					.addGap(5)
					.addComponent(lblBullpenGoesHere))
		);
		panelBullpenPlaceholder.setLayout(gl_panelBullpenPlaceholder);

		JLabel lblLevel = new JLabel("Level");
		lblLevel.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lblLevelNumber = new JLabel("1");
		lblLevelNumber.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel labelStar1 = new JLabel("");
		labelStar1.setIcon(new ImageIcon(ReleaseGame.class.getResource("/board/blankStar.png")));
		
		JLabel labelStar2 = new JLabel("");
		labelStar2.setIcon(new ImageIcon(ReleaseGame.class.getResource("/board/blankStar.png")));
		
		JLabel labelStar3 = new JLabel("");
		labelStar3.setIcon(new ImageIcon(ReleaseGame.class.getResource("/board/blankStar.png")));
		GroupLayout gl_panelLevelDescription = new GroupLayout(panelLevelDescription);
		gl_panelLevelDescription.setHorizontalGroup(
			gl_panelLevelDescription.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLevelDescription.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelLevelDescription.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelLevelDescription.createSequentialGroup()
							.addComponent(lblLevel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblLevelNumber, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelLevelDescription.createSequentialGroup()
							.addComponent(labelStar1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(labelStar2, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(labelStar3, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panelLevelDescription.setVerticalGroup(
			gl_panelLevelDescription.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLevelDescription.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panelLevelDescription.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLevel)
						.addComponent(lblLevelNumber))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelLevelDescription.createParallelGroup(Alignment.LEADING)
						.addComponent(labelStar3, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelStar1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelStar2, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		panelLevelDescription.setLayout(gl_panelLevelDescription);

		JToggleButton btnShowHint = new JToggleButton("Show Hint");
		btnShowHint.setMnemonic(KeyEvent.VK_ENTER);

		btnShowHint.setToolTipText("Pieces on board are turned into a hint");
		GroupLayout gl_panelButtonGroup = new GroupLayout(panelButtonGroup);
		gl_panelButtonGroup.setHorizontalGroup(
			gl_panelButtonGroup.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelButtonGroup.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnShowHint)
					.addContainerGap())
		);
		gl_panelButtonGroup.setVerticalGroup(
			gl_panelButtonGroup.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelButtonGroup.createSequentialGroup()
					.addGap(9)
					.addComponent(btnShowHint, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(27, Short.MAX_VALUE))
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