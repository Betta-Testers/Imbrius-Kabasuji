package gameMockups;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class BullpenView extends JScrollPane {
	GroupLayout gl_panelScrollContainer;
	JPanel panelScrollContainer;
	
	AbstractPieceGroupView availablePieces[];
	//ECHO ALSO
	public BullpenView(String pieceGroupType){
		getVerticalScrollBar().setUnitIncrement(35);
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelScrollContainer = new JPanel();
		panelScrollContainer.setBackground(Color.WHITE);
		setViewportView(panelScrollContainer);
		
		if(pieceGroupType.equals("builder")){
			//TODO: Read the bullpen model for the size of the PIECEGROUP array. Initialize this array to that.
			availablePieces = new AbstractPieceGroupView[35];
			for(int i = 0; i<availablePieces.length; i++){
				//TODO: Change the constructor of BuilderPieceGroupView to take a PieceGroup
				availablePieces[i] = new BuilderPieceGroupView(i+1);
			}
			
		}else if(pieceGroupType.equals("playing")){
			//TODO: Read the bullpen model for the size of the PIECEGROUP array. Initialize this array to that.
			availablePieces = new AbstractPieceGroupView[4];
			for(int i = 0; i<availablePieces.length; i++){
				//TODO: Change the constructor of PlayingPieceGroupView to take a PieceGroup instead of ID
				availablePieces[i] = new PlayingPieceGroupView(i+1);
			}
			
		}else{
			//TODO: THROW ERROR
		}
		
		setupLayout();
	}
	
	private void setupLayout(){
		gl_panelScrollContainer = new GroupLayout(panelScrollContainer);
		GroupLayout.ParallelGroup hGroup = gl_panelScrollContainer.createParallelGroup(GroupLayout.Alignment.TRAILING);
		GroupLayout.ParallelGroup vGroup = gl_panelScrollContainer.createParallelGroup(GroupLayout.Alignment.LEADING);
		
		GroupLayout.SequentialGroup sGroup = gl_panelScrollContainer.createSequentialGroup();
		GroupLayout.SequentialGroup s2Group = gl_panelScrollContainer.createSequentialGroup();
		
		GroupLayout.ParallelGroup pGroup = gl_panelScrollContainer.createParallelGroup(GroupLayout.Alignment.LEADING, false);
		
		
		for(int i=0; i<availablePieces.length; i++){
			pGroup.addComponent(availablePieces[i], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
			s2Group.addComponent(availablePieces[i], GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE);
		}
		
		gl_panelScrollContainer.setHorizontalGroup(hGroup.addGroup(sGroup.addGroup(pGroup)));
		gl_panelScrollContainer.setVerticalGroup(vGroup.addGroup(s2Group));
		panelScrollContainer.setLayout(gl_panelScrollContainer);	
	}
		
}
