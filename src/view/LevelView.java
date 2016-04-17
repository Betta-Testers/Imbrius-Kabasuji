package view;

import view.BoardView;

import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class LevelView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	
	// TODO AbstractLevelModel m;
	SelectedPieceView selectedPiece;
	BullpenView availablePieces;
	// TODO BoardView boardView;
	LevelInfoView levelInfo;
	NumberMovesLeftView movesLeftView;
//	NumbersReleasedView numbersReleasedView[];
	NumbersReleasedView numbersReleasedView;
	TimeRemainingView timeLeftView;
	BoardView boardView;
	JPanel content;
	
	// remove this later
	int sets = 3;
	
	public LevelView(String gameType) {
		this.setPreferredSize(new Dimension(600, 665));
		availablePieces = new BullpenView("playing");
		levelInfo = new LevelInfoView(1);
		timeLeftView = new TimeRemainingView();
		boardView = new BoardView(); 
		selectedPiece = new SelectedPieceView();
		movesLeftView = new NumberMovesLeftView();
		numbersReleasedView = new NumbersReleasedView();
//		for(int i = 0; i < sets; i++) {
//			numbersReleasedView[i] = new NumbersReleasedView();
//		}
		
		setupLayout(gameType);
	}
	
	private void setupLayout(String type) {
		setTitle(type);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // TODO this will change with the intercept
		setBounds(100, 100, 600, 665);
		content = new JPanel();
		content.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(content);
		GroupLayout gl_LevelView = new GroupLayout(this.getContentPane());
		gl_LevelView.setHorizontalGroup(
			gl_LevelView.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_LevelView.createSequentialGroup()
					.addGroup(gl_LevelView.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_LevelView.createSequentialGroup()
							.addGap(2)
							.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE))
						.addComponent(selectedPiece, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_LevelView.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_LevelView.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(numbersReleasedView, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_LevelView.createSequentialGroup()
							.addGap(24)
							.addComponent(levelInfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_LevelView.createSequentialGroup()
							.addGap(51)
							.addComponent(availablePieces, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(20))
		);
		gl_LevelView.setVerticalGroup(
			gl_LevelView.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_LevelView.createSequentialGroup()
					.addComponent(selectedPiece, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_LevelView.createSequentialGroup()
					.addContainerGap()
					.addComponent(levelInfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addComponent(availablePieces, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(numbersReleasedView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(94, Short.MAX_VALUE))
		);
		content.setLayout(gl_LevelView);

		gl_LevelView.setAutoCreateGaps(true);
		gl_LevelView.setAutoCreateContainerGaps(true);
					getContentPane().setLayout(gl_LevelView);
					//break;
				}
		//}
	//}
	

}
