package gameMockups;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;

public class BoardViewPuzzle extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JLabel lblBoardView;
	
	public BoardViewPuzzle() {
		
		lblBoardView = new JLabel("");
		lblBoardView.setIcon(new ImageIcon(BoardViewPuzzle.class.getResource("/board/boardMockupPuzzle.png")));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblBoardView)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblBoardView)
					.addContainerGap(198, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
}
