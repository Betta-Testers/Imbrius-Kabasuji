package builderMockups;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

public class BuilderWindow extends JFrame {
	private JPanel contentPane;
	BullpenView bullPen;
	ButtonGroupView panelButtonGroup;
	BoardView panelBoard;
	SelectedPieceView panelSelectedPiece;
	ReleaseNumberCreationView releaseNumbers;
	LevelPropertiesView levelProperties;

	public BuilderWindow() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		panelButtonGroup = new ButtonGroupView();
		releaseNumbers = new ReleaseNumberCreationView();
		levelProperties = new LevelPropertiesView();
		
		
		//*********************** HEY! LOOK HERE GUYS!! *****************************//
		// Toggle one of these lines to see the difference between the two bullpens. 
		// Right now only pieces can be generated in sequential order, but that's just
		// because I don't have an entity to read and it was easiest. If you want to generate
		// fewer pieces, you'll have to go dig around the BullpenView class and change 
		// the size of the AvailablePiece array to be less than 35
		
		bullPen = new BullpenView("builder");
		//bullpen = new BullpenView("playing");
		
		//*********************** HEY! LOOK HERE GUYS!! *****************************//
		// Change the images in the below lines and the board/selected piece view will
		// change what images are displayed. Making mockups super easy!
		ImageIcon pieceImage = new ImageIcon(SelectedPieceView.class.getResource("/board/selectedPieceArea.png"));
		ImageIcon boardImage = new ImageIcon(BuilderWindow.class.getResource("/board/releaseBoardMockup.png"));
		//ImageIcon pieceImage = new ImageIcon(SelectedPieceView.class.getResource("/board/emptyPiece.png"));
		//ImageIcon boardImage = new ImageIcon(BuilderWindow.class.getResource("/board/emptyBoardMockup.png"));
		
		panelBoard = new BoardView(boardImage);
		panelSelectedPiece = new SelectedPieceView(pieceImage);
		
		setupLayout();		
	}
	
	private void setupLayout(){
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panelSelectedPiece, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelBoard, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(levelProperties, GroupLayout.PREFERRED_SIZE, 111, Short.MAX_VALUE)
							.addComponent(bullPen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(panelButtonGroup, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(releaseNumbers, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(bullPen, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(levelProperties, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(releaseNumbers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panelButtonGroup, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panelSelectedPiece, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
							.addComponent(panelBoard, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
