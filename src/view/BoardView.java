package view;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class BoardView extends JPanel{
	//TODO Add Attribute: TileView tiles[]
	//TODO Add Attribute: Board modelBoard

	//TODO Change Arguments: Board b
	public BoardView(){
		setPreferredSize(new Dimension(384, 384));
		
		//TODO REMOVE THIS CODE FOR ACTUAL BOARD
		JLabel lblSAMPLEboardView = new JLabel("");
		lblSAMPLEboardView.setIcon(new ImageIcon(BoardView.class.getResource("/board/emptyBoardMockup.png")));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(1)
					.addComponent(lblSAMPLEboardView)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblSAMPLEboardView)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	
	void redraw(){
		//TODO Fill Stub - redraw
	}
	
	void setMouseMotionAdapter(MouseMotionAdapter ma){
		//TODO Fill Stub - setMouseMotionAdapter
	}
	
	void setMouseAdapter(MouseAdapter ma){
		//TODO Fill Stub - setMouseAdapter
	}
	

}
