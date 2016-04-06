package gameMockups;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;

import builderMockups.BullpenView;
import builderMockups.SelectedPieceView;

public class LightningGame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel LevelView;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LightningGame frame = new LightningGame();
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
	public LightningGame() {
		setTitle("Lightning");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 651);
		LevelView = new JPanel();
		LevelView.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(LevelView);
		
		BullpenView bullpenView = new BullpenView("playing");
		
		LevelInfoView levelInfoView = new LevelInfoView();
		
		TimeRemainingView timeRemainingView = new TimeRemainingView();
		
		BoardViewLightning playingAreaView = new BoardViewLightning();
		
		SelectedPieceView selectedPieceView = new SelectedPieceView((ImageIcon) null);
		GroupLayout gl_LevelView = new GroupLayout(LevelView);
		gl_LevelView.setHorizontalGroup(
			gl_LevelView.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_LevelView.createSequentialGroup()
					.addGroup(gl_LevelView.createParallelGroup(Alignment.LEADING)
						.addComponent(playingAreaView, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)
						.addComponent(selectedPieceView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_LevelView.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_LevelView.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_LevelView.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_LevelView.createSequentialGroup()
									.addGap(70)
									.addComponent(bullpenView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_LevelView.createSequentialGroup()
									.addGroup(gl_LevelView.createParallelGroup(Alignment.TRAILING)
										.addComponent(timeRemainingView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(levelInfoView, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
									.addGap(39))))
						.addGroup(gl_LevelView.createSequentialGroup()
							.addGap(77)))
					.addGap(39))
		);
		gl_LevelView.setVerticalGroup(
			gl_LevelView.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_LevelView.createSequentialGroup()
					.addGap(12)
					.addComponent(levelInfoView, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bullpenView, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(timeRemainingView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addContainerGap(31, Short.MAX_VALUE))
				.addGroup(gl_LevelView.createSequentialGroup()
					.addComponent(selectedPieceView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(playingAreaView, 0, 0, Short.MAX_VALUE))
		);
		LevelView.setLayout(gl_LevelView);
	}
}