package view;

import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.Builder;
import controllers.builder.BuilderBoardController;
import controllers.builder.CloseBuilderDialog;
import controllers.player.ExitLevelButtonController;
import controllers.player.PuzzleBoardGameController;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * 
 * @author Dylan
 * @author awharrison
 *
 */

public class BuilderView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	BoardView boardView;
	ButtonGroupView buttonGroupView;
	ReleaseNumberCreationView releaseNumberView;
	LevelPropertiesView levelPropertyView;
	BullpenView bullpenView;
	SelectedPieceView selectedPieceView;
	Builder builder;
	WindowListener exitWindowHandler;
	
	public BuilderView(Builder b) {
		this.builder = b;
		setResizable(false);
		setVisible(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 520, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		boardView = new BoardView(b.getCurrentLevel().getBoard());
		buttonGroupView = new ButtonGroupView(this);
		releaseNumberView = new ReleaseNumberCreationView();
		bullpenView = new BullpenView();	
		levelPropertyView = new LevelPropertiesView();	
		selectedPieceView = new SelectedPieceView(b.getCurrentLevel().getBullpen());
		
		setupLayout();		
	}

	/**
	 * Prepares the view of a puzzle level by disabling release
	 * tile creation and showing only relevant information in
	 * property view for a puzzle level.
	 */
	public void prepPuzzle(){
		releaseNumberView.setVisible(false);
		bullpenView.prepBuilder(builder.getCurrentLevel().getBullpen());
		levelPropertyView.setLevelModel(builder.getCurrentLevel());
		levelPropertyView.puzzle();	
		
		boardView.addMouseListener(new BuilderBoardController(this, builder.getCurrentLevel()));
		boardView.addMouseMotionListener(new BuilderBoardController(this, builder.getCurrentLevel()));
		this.setExitWindowListener(new CloseBuilderDialog(builder, this));
	}
	
	/**
	 * Prepares the view of a lightning level by disabling release
	 * tile creation and showing only relevant information in
	 * property view for a lightning level.
	 */
	public void prepLightning(){
		releaseNumberView.setVisible(false);
		bullpenView.prepBuilder(builder.getCurrentLevel().getBullpen());
		levelPropertyView.setLevelModel(builder.getCurrentLevel());
		levelPropertyView.lightning();	
	}
	
	/**
	 * Prepares the view of a release level by showing only 
	 * relevant information in the property view for a release
	 * level (I.E. nothing)
	 */
	public void prepRelease(){
		releaseNumberView.setVisible(true);
		bullpenView.prepBuilder(builder.getCurrentLevel().getBullpen());
		levelPropertyView.setLevelModel(builder.getCurrentLevel());
		levelPropertyView.release();
	}
	
	/**
	 * returns the ReleaseNumberView so the number selected
	 * can be retrieved 
	 * @return
	 */
	public ReleaseNumberCreationView getReleaseNumberView(){
		return this.releaseNumberView;
	}
	
	/**
	 * returns the BullpenView
	 * @return
	 */
	public BullpenView getBullpenView() {
		return this.bullpenView;
	}
	
	/**
	 * Sets the windows listener of the BuilderView and adds it 
	 * @param we - WindowListener being added
	 */
	public void setExitWindowListener(WindowListener we) {
		this.exitWindowHandler = we;
		this.addWindowListener(we);
	}
	
	/**
	 * Returns the window listener of the exit window
	 * @return Window Listener
	 */
	public WindowListener getExitWindowListener() {
		return this.exitWindowHandler;
	}
	
	/**
	 * Returns the builder object associated with this view
	 * @return Builder
	 */
	public Builder getBuilder() {
		return this.builder;
	}

	/*
	 * Method for setting up the layout for the BuilderView
	 */
	void setupLayout(){
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(selectedPieceView, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)
						.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(levelPropertyView, GroupLayout.PREFERRED_SIZE, 111, Short.MAX_VALUE)
							.addComponent(bullpenView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(buttonGroupView, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(releaseNumberView, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(bullpenView, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(levelPropertyView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(releaseNumberView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(buttonGroupView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(selectedPieceView, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
							.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
