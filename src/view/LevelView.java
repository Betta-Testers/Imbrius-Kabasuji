package view;

import view.BoardView;

import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import controllers.common.BullpenPieceSelectController;
import model.AbstractLevelModel;

public class LevelView extends JFrame {
	private static final long serialVersionUID = 1L;
	JPanel content;
	
	SelectedPieceView selectedPiece;
	BullpenView bullpenView;
	BoardView boardView;
	LevelInfoView levelInfo;
	AbstractLevelModel m;
	
	JPanel endConditionPanel;

	public LevelView(String title, JPanel endConditionPanel, AbstractLevelModel m) {
		this.setPreferredSize(new Dimension(600, 660));
		this.setBounds(100, 100, 600, 660);
		this.content = new JPanel();
		this.content.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(content);
		this.setTitle(title);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.m = m;
		this.endConditionPanel = endConditionPanel;
		this.selectedPiece = new SelectedPieceView(m.getBullpen());
		this.bullpenView = new BullpenView();
		bullpenView.prepPlayer(m.getBullpen());
		this.boardView = new BoardView(m.getBoard()); 
		this.levelInfo = new LevelInfoView(1);
		
		
		initializeControllers();
		setupLayout();
	}
	
	public void initializeControllers() {
		for (AbstractPieceGroupView pgv : bullpenView.getPieceGroupViews()) {
			pgv.addSelectButtonActionListener(new BullpenPieceSelectController(m.getBullpen(), selectedPiece));
		}
	}

	/**
	 * Returns the endConditionPanel associated with THIS level view
	 * Allows the ability to cast the return, and thus calling specific
	 * methods on that panel.
	 * @return JPanel - Either NumberMovesLeftView, NumberReleasedView, TimeRemiainingView in form of JPanel
	 */
	public JPanel getEndConditionPanel(){
		return endConditionPanel;
	}
	
	public BoardView getBoardView() {
		return this.boardView;
	}

	public BullpenView getBullpenView() {
		return this.bullpenView;
	}
	
	public SelectedPieceView getSelectedPieceView(){
		return this.selectedPiece;
	}
	
	private void setupLayout() {
		GroupLayout gl_LevelView = new GroupLayout(this.getContentPane());
		gl_LevelView.setHorizontalGroup(
				gl_LevelView.createSequentialGroup()
				.addGroup(gl_LevelView.createParallelGroup(Alignment.LEADING)
						.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE)
						.addComponent(selectedPiece, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_LevelView.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_LevelView.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(endConditionPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_LevelView.createSequentialGroup()
								.addGap(24)
								.addComponent(levelInfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_LevelView.createSequentialGroup()
								.addGap(51)
								.addComponent(bullpenView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				);
		gl_LevelView.setVerticalGroup(
				gl_LevelView.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_LevelView.createSequentialGroup()
						.addComponent(selectedPiece, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_LevelView.createSequentialGroup()
						.addContainerGap()
						.addComponent(levelInfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(41)
						.addComponent(bullpenView, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
						.addGap(35)
						.addComponent(endConditionPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
		content.setLayout(gl_LevelView);
	}


}
