package builderMockups;

import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BoardView extends JPanel{
	private JLabel lblBoardImage;
	GroupLayout groupLayout;

	public BoardView(){
		setPreferredSize(new Dimension(384, 384));


		//TODO: Change this line to set the image displayed for mockups
		//TODO: Remove lblBoardImage after mockups are done
		lblBoardImage = new JLabel("");
		lblBoardImage.setIcon(new ImageIcon(BoardView.class.getResource("/board/emptyBoardMockup.png")));


		setupLayout();
	}

	private void setupLayout(){
		groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(lblBoardImage)
						.addGap(384))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(lblBoardImage)
				);
		setLayout(groupLayout);
	}
}
