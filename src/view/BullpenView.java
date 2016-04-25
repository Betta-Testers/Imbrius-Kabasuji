package view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import model.Bullpen;
import model.Piece;
import model.PieceGroup;

public class BullpenView extends JScrollPane {
	private static final long serialVersionUID = 1L;
	GroupLayout groupLayout;
	JPanel panelScrollContainer;
	AbstractPieceGroupView pieceGroupViews[];
	Bullpen bp;

	public BullpenView(){
		this.getVerticalScrollBar().setUnitIncrement(35);
		this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	}

	public void prepBuilder(Bullpen bp){
		this.bp = bp;
		ArrayList<PieceGroup> pg = bp.getPlayablePieces();
		pieceGroupViews = new AbstractPieceGroupView[pg.size()];
		for(int i = 0; i<pieceGroupViews.length; i++){
			pieceGroupViews[i] = new BuilderPieceGroupView(pg.get(i));
		}
		setupLayout();
	}

	public void prepPlayer(Bullpen bp){
		this.bp = bp;
		ArrayList<PieceGroup> pg = bp.getPlayablePieces();
		pieceGroupViews = new AbstractPieceGroupView[pg.size()];
		for(int i = 0; i<pieceGroupViews.length; i++){
			pieceGroupViews[i] = new PlayingPieceGroupView(pg.get(i));
		}
		setupLayout();
	}
	
	public void updatePieceGroup(Piece p){
		for(AbstractPieceGroupView pgv :pieceGroupViews){
			if(pgv.getPieceGroup().getPiece().equals(p)){
				pgv.updateCount();
			}
		}
	}
	
	public AbstractPieceGroupView[] getPieceGroupViews() {
		return pieceGroupViews;
	}
	
	private void setupLayout(){
		/**
		 * NOTE DO NOT REMOVE PANEL LINES FROM SETUPLAYOUT.
		 * Turns out the bullpen won't shrink inbetween different sizes (so if you select a level
		 * with a large bullpen and then a small one). Why? I actually don't know... probably
		 * something to do with how the bullpen handles the jPanel and adding components to it.
		 */
		this.panelScrollContainer = new JPanel();
		this.panelScrollContainer.setBackground(Color.WHITE);
		panelScrollContainer.setPreferredSize(new Dimension(72,223));
		this.setViewportView(panelScrollContainer);
		groupLayout = new GroupLayout(panelScrollContainer);
		GroupLayout.ParallelGroup hGroup = groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING);
		GroupLayout.ParallelGroup vGroup = groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING);

		GroupLayout.SequentialGroup sGroup = groupLayout.createSequentialGroup();
		GroupLayout.SequentialGroup s2Group = groupLayout.createSequentialGroup();

		GroupLayout.ParallelGroup pGroup = groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false);


		for(int i=0; i<pieceGroupViews.length; i++){
			pGroup.addComponent(pieceGroupViews[i], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
			s2Group.addComponent(pieceGroupViews[i], GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE);
		}

		groupLayout.setHorizontalGroup(hGroup.addGroup(sGroup.addGroup(pGroup)));
		groupLayout.setVerticalGroup(vGroup.addGroup(s2Group));
		panelScrollContainer.setLayout(groupLayout);	
	}

}
