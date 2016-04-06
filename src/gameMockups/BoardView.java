package gameMockups;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;

public class BoardView extends JPanel{
	
	private static final long serialVersionUID = 1L;
	JLabel lblBoardView;
	// TODO TileView tiles[]
	// TODO Board modelBoard
	
	public BoardView(String type) {
		
		lblBoardView = new JLabel("");
		
		if(type.equals("Puzzle")) {
			lblBoardView.setIcon(new ImageIcon(BoardView.class.getResource("/board/boardMockupPuzzle.png")));
		} else if(type.equals("Lightning")) {
			lblBoardView.setIcon(new ImageIcon(BoardView.class.getResource("/board/boardMockupLightning.png")));
		} else if(type.equals("Release")) {
			lblBoardView.setIcon(new ImageIcon(BoardView.class.getResource("/board/boardMockupRelease.png")));
		} else {
			lblBoardView.setIcon(new ImageIcon());
		}
		
		setupLayout();
	}
	
	private void setupLayout() {
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addComponent(lblBoardView)
					.addContainerGap(34, Short.MAX_VALUE))
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

