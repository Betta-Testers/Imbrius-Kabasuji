package gameMockups;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Component;

import javax.swing.ImageIcon;

import builderMockups.BullpenView;
import builderMockups.SelectedPieceView;

public class ReleaseGame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel LevelView;
	/**
	 * @wbp.nonvisual location=159,742
	 */
	private final LevelInfoView levelInfoView = new LevelInfoView();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReleaseGame frame = new ReleaseGame();
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
	public ReleaseGame() {
		setTitle("Release");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 651);
		LevelView = new JPanel();
		LevelView.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(LevelView);
		
		JPanel panelNumberSets = new JPanel();
		
		BullpenView bullpenView = new BullpenView("playing");
		
		BoardViewRelease playingAreaView = new BoardViewRelease();
		
		LevelInfoView levelInfoView_1 = new LevelInfoView();
		
		SelectedPieceView selectedPieceView = new SelectedPieceView((ImageIcon) null);

		GroupLayout gl_LevelView = new GroupLayout(LevelView);
		gl_LevelView.setHorizontalGroup(
			gl_LevelView.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_LevelView.createSequentialGroup()
					.addGroup(gl_LevelView.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_LevelView.createSequentialGroup()
							.addGap(2)
							.addComponent(playingAreaView, GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE))
						.addComponent(selectedPieceView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_LevelView.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_LevelView.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_LevelView.createSequentialGroup()
								.addGap(28)
								.addComponent(levelInfoView_1, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(gl_LevelView.createSequentialGroup()
								.addGap(69)
								.addComponent(bullpenView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(gl_LevelView.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panelNumberSets, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
								.addContainerGap()))
						.addGroup(gl_LevelView.createSequentialGroup()
							.addGap(70)
							.addContainerGap())))
		);
		gl_LevelView.setVerticalGroup(
			gl_LevelView.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_LevelView.createSequentialGroup()
					.addComponent(selectedPieceView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(playingAreaView, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_LevelView.createSequentialGroup()
					.addContainerGap()
					.addComponent(levelInfoView_1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bullpenView, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelNumberSets, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addContainerGap(36, Short.MAX_VALUE))
		);
		
		NumbersReleasedView numbersReleased_1 = new NumbersReleasedView();
		
		NumbersReleasedView numbersReleased_2 = new NumbersReleasedView();
		
		NumbersReleasedView numbersReleased_3 = new NumbersReleasedView();
		GroupLayout gl_panelNumberSets = new GroupLayout(panelNumberSets);
		gl_panelNumberSets.setHorizontalGroup(
			gl_panelNumberSets.createParallelGroup(Alignment.TRAILING)
				.addComponent(numbersReleased_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
				.addComponent(numbersReleased_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
				.addComponent(numbersReleased_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
		);
		gl_panelNumberSets.setVerticalGroup(
			gl_panelNumberSets.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNumberSets.createSequentialGroup()
					.addGap(27)
					.addComponent(numbersReleased_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(numbersReleased_2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(numbersReleased_3, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelNumberSets.setLayout(gl_panelNumberSets);
		LevelView.setLayout(gl_LevelView);
	}
}