package gameMockups;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;

public class PlayingAreaViewRelease extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JLabel lblPieceView;
	private JLabel lblBoardView;
	
	public PlayingAreaViewRelease() {
		
		lblPieceView = new JLabel("");
		lblPieceView.setIcon(new ImageIcon(PlayingAreaViewRelease.class.getResource("/board/viewerMockup.png")));
		
		lblBoardView = new JLabel("");
		lblBoardView.setIcon(new ImageIcon(PlayingAreaViewRelease.class.getResource("/board/boardMockupRelease.png")));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(93)
							.addComponent(lblPieceView, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblBoardView))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblPieceView)
					.addGap(6)
					.addComponent(lblBoardView)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
}
