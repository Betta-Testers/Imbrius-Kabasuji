package view;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;

public class BoardView extends JPanel{
	//TODO Add Attribute: TileView tiles[]
	//TODO Add Attribute: Board modelBoard

	//TODO Change Arguments: Board b
	public BoardView(){
		setPreferredSize(new Dimension(384, 384));
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
