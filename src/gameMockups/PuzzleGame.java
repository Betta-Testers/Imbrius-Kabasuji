package gameMockups;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;

public class PuzzleGame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel LevelView;

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
		LevelView = new JPanel();
		LevelView.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(LevelView);
		
		BoardViewPuzzle BoardView = new BoardViewPuzzle();
		BoardView.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		LevelInfoView LevelInfoView = new LevelInfoView();
		
		BullpenView bullpenView = new BullpenView("playing");
		
		
		SelectedPieceView selectedPieceView = new SelectedPieceView((ImageIcon) null);
		
		NumberMovesLeftView numberMovesLeftView = new NumberMovesLeftView();

		GroupLayout gl_LevelView = new GroupLayout(LevelView);
		gl_LevelView.setHorizontalGroup(
			gl_LevelView.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_LevelView.createSequentialGroup()
					.addGroup(gl_LevelView.createParallelGroup(Alignment.LEADING)
						.addComponent(BoardView, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE)
						.addComponent(selectedPieceView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_LevelView.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_LevelView.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_LevelView.createParallelGroup(Alignment.LEADING)
								.addComponent(LevelInfoView, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
								.addGroup(gl_LevelView.createSequentialGroup()
									.addGap(62)
									.addComponent(bullpenView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(29)))
							.addGap(18))
						.addGroup(gl_LevelView.createSequentialGroup()
							.addGap(58)
							.addGroup(gl_LevelView.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_LevelView.createSequentialGroup()
									.addGap(10))
								.addComponent(numberMovesLeftView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(63))))
		);
		gl_LevelView.setVerticalGroup(
			gl_LevelView.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_LevelView.createSequentialGroup()
					.addComponent(selectedPieceView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(BoardView, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE))
				.addGroup(Alignment.LEADING, gl_LevelView.createSequentialGroup()
					.addContainerGap()
					.addComponent(LevelInfoView, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bullpenView, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(numberMovesLeftView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		LevelView.setLayout(gl_LevelView);
	}
}