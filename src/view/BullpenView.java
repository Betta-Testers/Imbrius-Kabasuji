package view;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class BullpenView extends JScrollPane {
	GroupLayout groupLayout;
	JPanel panelScrollContainer;
	AbstractPieceGroupView piecesInBullpen[];
	//TODO Add Attribute: modelBullpen
	
	//TODO Change Arguments: Buullpen bp, String pieceGroupType
	public BullpenView(String pieceGroupType){
		getVerticalScrollBar().setUnitIncrement(35);
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelScrollContainer = new JPanel();
		panelScrollContainer.setBackground(Color.WHITE);
		setViewportView(panelScrollContainer);
		
		if(pieceGroupType.equals("builder")){
			//TODO: Read the bullpen model for the size of the PIECEGROUP array. Initialize this array to that.
			piecesInBullpen = new AbstractPieceGroupView[35];
			for(int i = 0; i<piecesInBullpen.length; i++){
				//TODO: Change the constructor of BuilderPieceGroupView to take a PieceGroup
				piecesInBullpen[i] = new BuilderPieceGroupView(i+1);
			}
			
		}else if(pieceGroupType.equals("playing")){
			//TODO: Read the bullpen model for the size of the PIECEGROUP array. Initialize this array to that.
			piecesInBullpen = new AbstractPieceGroupView[35];
			for(int i = 0; i<piecesInBullpen.length; i++){
				//TODO: Change the constructor of PlayingPieceGroupView to take a PieceGroup
				piecesInBullpen[i] = new PlayingPieceGroupView(i+1);
			}
			
		}else{
			//TODO: THROW ERROR
		}
		
		setupLayout();
	}
	
	private void setupLayout(){
		groupLayout = new GroupLayout(panelScrollContainer);
		GroupLayout.ParallelGroup hGroup = groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING);
		GroupLayout.ParallelGroup vGroup = groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING);
		
		GroupLayout.SequentialGroup sGroup = groupLayout.createSequentialGroup();
		GroupLayout.SequentialGroup s2Group = groupLayout.createSequentialGroup();
		
		GroupLayout.ParallelGroup pGroup = groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false);
		
		
		for(int i=0; i<piecesInBullpen.length; i++){
			pGroup.addComponent(piecesInBullpen[i], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
			s2Group.addComponent(piecesInBullpen[i], GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE);
		}
		
		groupLayout.setHorizontalGroup(hGroup.addGroup(sGroup.addGroup(pGroup)));
		groupLayout.setVerticalGroup(vGroup.addGroup(s2Group));
		panelScrollContainer.setLayout(groupLayout);	
	}
		
}
