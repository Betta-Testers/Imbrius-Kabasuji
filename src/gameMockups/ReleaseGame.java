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
import java.awt.Component;
import javax.swing.ImageIcon;

public class ReleaseGame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panelNumberSets = new JPanel();
		
				JToggleButton btnShowHint = new JToggleButton("Show Hint");
				btnShowHint.setMnemonic(KeyEvent.VK_ENTER);
				
						btnShowHint.setToolTipText("Pieces on board are turned into a hint");
		
		BullpenView bullpenView = new BullpenView();
		
		PlayingAreaViewRelease playingAreaView = new PlayingAreaViewRelease();
		
		LevelInfoView levelInfoView_1 = new LevelInfoView();

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(playingAreaView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
								.addGap(89)
								.addComponent(bullpenView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(121))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(levelInfoView_1, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
									.addComponent(panelNumberSets, GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(79)
							.addComponent(btnShowHint)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(levelInfoView_1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bullpenView, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panelNumberSets, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnShowHint))
						.addComponent(playingAreaView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel lblSetsReleased = new JLabel("Sets Released");
		lblSetsReleased.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		NumbersReleasedView numbersReleased_1 = new NumbersReleasedView();
		
		NumbersReleasedView numbersReleased_2 = new NumbersReleasedView();
		
		NumbersReleasedView numbersReleased_3 = new NumbersReleasedView();
		GroupLayout gl_panelNumberSets = new GroupLayout(panelNumberSets);
		gl_panelNumberSets.setHorizontalGroup(
			gl_panelNumberSets.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelNumberSets.createSequentialGroup()
					.addGap(66)
					.addComponent(lblSetsReleased)
					.addContainerGap(75, Short.MAX_VALUE))
				.addComponent(numbersReleased_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
				.addComponent(numbersReleased_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
				.addComponent(numbersReleased_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
		);
		gl_panelNumberSets.setVerticalGroup(
			gl_panelNumberSets.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNumberSets.createSequentialGroup()
					.addGap(5)
					.addComponent(lblSetsReleased)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(numbersReleased_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(numbersReleased_2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(numbersReleased_3, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelNumberSets.setLayout(gl_panelNumberSets);
		contentPane.setLayout(gl_contentPane);
	}
}