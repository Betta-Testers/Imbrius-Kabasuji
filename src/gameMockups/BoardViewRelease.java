package gameMockups;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;

public class BoardViewRelease extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JLabel lblBoardView;
	
	public BoardViewRelease() {
		
		lblBoardView = new JLabel("");
		lblBoardView.setIcon(new ImageIcon(BoardViewRelease.class.getResource("/board/boardMockupRelease.png")));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addComponent(lblBoardView)
					.addContainerGap(97, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblBoardView)
					.addContainerGap(199, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
}
