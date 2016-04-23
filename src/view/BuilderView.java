package view;

import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.Builder;
import controllers.builder.BuilderBoardController;
import controllers.builder.BullpenPieceGroupSpinnerController;
import controllers.builder.CloseBuilderDialog;
import controllers.common.BullpenPieceSelectController;
import model.AbstractLevelModel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Component;

/**
 * 
 * @author Dylan
 * @author awharrison
 *
 */

public class BuilderView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	Builder builder;
	AbstractLevelModel m;
	SelectedPieceView selectedPieceView;
	BoardView boardView;
	BullpenView bullpenView;
	
	JButton btnConvertHint;
	JToggleButton tglbtnPlacePieces;
	
	ButtonGroupView buttonGroupView;
	ReleaseNumberCreationView releaseNumberView;
	LevelPropertiesView levelPropertyView;
	
	WindowListener exitWindowHandler;
	
	public BuilderView(Builder b) {
		this.builder = b;
		this.m = b.getCurrentLevel();
		
		setResizable(false);
		setVisible(false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 570, 715);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		boardView = new BoardView(b.getCurrentLevel().getBoard());
		buttonGroupView = new ButtonGroupView();
		releaseNumberView = new ReleaseNumberCreationView();
		bullpenView = new BullpenView();	
		levelPropertyView = new LevelPropertiesView();	
		selectedPieceView = new SelectedPieceView(b.getCurrentLevel().getBullpen());
		tglbtnPlacePieces = new JToggleButton("Put Pieces On Board");
		btnConvertHint = new JButton("Convert Pieces To Hint");
		
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
		
		initializeControllers();
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
		
		initializeControllers();
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
		
		initializeControllers();
	}
	
	void initializeControllers(){
		this.setExitWindowListener(new CloseBuilderDialog(builder, this));
		BuilderBoardController builderBoardControl = new BuilderBoardController(this, builder.getCurrentLevel());
		boardView.setMouseActionController(builderBoardControl);
		boardView.setMouseMotionController(new BuilderBoardController(this, builder.getCurrentLevel()));
		for (AbstractPieceGroupView pgv : bullpenView.getPieceGroupViews()) {
			((BuilderPieceGroupView) pgv).addSelectButtonActionListener(new BullpenPieceSelectController(m.getBullpen(), selectedPieceView));
			((BuilderPieceGroupView) pgv).addSpinnerChangeListener(new BullpenPieceGroupSpinnerController((BuilderPieceGroupView) pgv, pgv.getPieceGroup()));
		}
		
		buttonGroupView.initializeControllers(builder);
	}
	
	/**
	 * returns the ReleaseNumberView so the number selected
	 * can be retrieved 
	 * @return
	 */
	public ReleaseNumberCreationView getReleaseNumberView(){
		return this.releaseNumberView;
	}
	
	public SelectedPieceView getSelectedPieceView() {
		return selectedPieceView;
	}
	
	/**
	 * returns the BullpenView
	 * @return
	 */
	public BullpenView getBullpenView() {
		return this.bullpenView;
	}
	
	/**
	 * returns the boardView associated with this builder view
	 * @return BoardView
	 */
	public BoardView getBoardView() {
		return this.boardView;
	}
	
	/**
	 * Returns whether the toggle button for piece placement is 
	 * turned on (true) or not (false)
	 * @return boolean about state
	 */
	public boolean getStateOfPlacement() {
		return tglbtnPlacePieces.isSelected();
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
		tglbtnPlacePieces.setToolTipText("When toggled, you can place pieces on the board");
		btnConvertHint.setToolTipText("Any pieces on the board are turned into hints!");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
								.addComponent(tglbtnPlacePieces)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnConvertHint))
							.addComponent(selectedPieceView, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(levelPropertyView, GroupLayout.PREFERRED_SIZE, 152, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(releaseNumberView, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(bullpenView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(buttonGroupView, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(bullpenView, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
						.addComponent(levelPropertyView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(releaseNumberView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(buttonGroupView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(selectedPieceView, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
						.addGap(10)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnConvertHint, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addComponent(tglbtnPlacePieces, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addGap(10)
						.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE)))
		);
		gl_contentPane.linkSize(SwingConstants.VERTICAL, new Component[] {tglbtnPlacePieces, btnConvertHint});
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL, new Component[] {tglbtnPlacePieces, btnConvertHint});
		contentPane.setLayout(gl_contentPane);
	}
}
