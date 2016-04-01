package builderMockups;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;

public class PlayingAreaView extends JPanel{
	JPanel panelBoard;
	JPanel panelPieceViewer;
	
	public PlayingAreaView(){
		setPreferredSize(new Dimension(384, 608));
		
		panelBoard = new JPanel();
		panelPieceViewer = new JPanel();
		
		panelBoard.setBackground(Color.WHITE);
		panelPieceViewer.setBackground(Color.CYAN);
		
		setupLayout();
	}
	
	private void setupLayout(){
		GroupLayout gl_panelPlayingArea = new GroupLayout(this);
		gl_panelPlayingArea.setHorizontalGroup(
				gl_panelPlayingArea.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPlayingArea.createSequentialGroup()
						.addGroup(gl_panelPlayingArea.createParallelGroup(Alignment.LEADING, false)
								.addComponent(panelPieceViewer, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
								.addComponent(panelBoard, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)))
				);
		gl_panelPlayingArea.setVerticalGroup(
				gl_panelPlayingArea.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPlayingArea.createSequentialGroup()
						.addComponent(panelPieceViewer, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelBoard, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE))
				);
		this.setLayout(gl_panelPlayingArea);
	}
}
