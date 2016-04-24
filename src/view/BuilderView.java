package view;

import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.Builder;
import controllers.builder.BuilderBoardController;
import controllers.builder.PieceGroupSpinnerController;
import controllers.builder.PlacePieceToggleListener;
import controllers.builder.CloseBuilderDialog;
import controllers.common.BullpenPieceSelectController;
import model.AbstractLevelModel;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JToggleButton;
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
	
	ButtonGroup placementGroup;
	JToggleButton tglbtnPlacePieces;
	JToggleButton tglbtnPlaceBoard;
	JToggleButton tglbtnPlaceHints;
	
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
		setBounds(100, 100, 525, 715);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		boardView = new BoardView(b.getCurrentLevel().getBoard());
		buttonGroupView = new ButtonGroupView();
		releaseNumberView = new ReleaseNumberCreationView();
		bullpenView = new BullpenView();	
		levelPropertyView = new LevelPropertiesView();	
		selectedPieceView = new SelectedPieceView(b.getCurrentLevel().getBullpen());
		
		tglbtnPlacePieces = new JToggleButton("Place Pieces");
		tglbtnPlaceBoard = new JToggleButton("Make Board With Pieces");
		tglbtnPlaceHints = new JToggleButton("Place Hints");
		
		prepareToggleButtons();
		setupLayout();		
	}

	void prepareToggleButtons() {
		placementGroup = new ButtonGroup(){
			private static final long serialVersionUID = 1L;
			@Override
			public void setSelected(ButtonModel model, boolean selected) {
				if(selected){super.setSelected(model, selected);
				}else{clearSelection();}
			}
		};
		placementGroup.add(tglbtnPlaceBoard);
		placementGroup.add(tglbtnPlaceHints);
		tglbtnPlaceBoard.setEnabled(false);
		tglbtnPlaceHints.setEnabled(false);
		tglbtnPlacePieces.addActionListener(new PlacePieceToggleListener(tglbtnPlaceBoard, tglbtnPlaceHints, placementGroup));
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
		BuilderBoardController builderBoardControl = new BuilderBoardController(this, m);
		boardView.setMouseActionController(builderBoardControl);
		boardView.setMouseMotionController(new BuilderBoardController(this, m));
		for (AbstractPieceGroupView pgv : bullpenView.getPieceGroupViews()) {
			((BuilderPieceGroupView) pgv).addSelectButtonActionListener(new BullpenPieceSelectController(m.getBullpen(), selectedPieceView));
			((BuilderPieceGroupView) pgv).addSpinnerChangeListener(new PieceGroupSpinnerController(((BuilderPieceGroupView) pgv).getSpinner(), pgv.getPieceGroup(), m.getBullpen(), selectedPieceView.getPiecePanel()));
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
	
	public boolean getStateOfBoardConvert(){
		
	}
	
	public boolean getStateOfHintConvert(){
		
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
		tglbtnPlaceBoard.setToolTipText("When toggled, pieces you place on the board become the board");
		tglbtnPlaceHints.setToolTipText("When toggled, pieces you place on the board become hints");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(tglbtnPlacePieces)
							.addGap(18)
							.addComponent(tglbtnPlaceBoard, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(tglbtnPlaceHints, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE)
							.addComponent(selectedPieceView, GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE)))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(bullpenView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(levelPropertyView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonGroupView, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(releaseNumberView, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(selectedPieceView, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(tglbtnPlacePieces, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(tglbtnPlaceHints, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
									.addComponent(tglbtnPlaceBoard, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
							.addGap(10))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(bullpenView, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
							.addGap(58)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(levelPropertyView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(releaseNumberView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(buttonGroupView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE)))
		);
		gl_contentPane.linkSize(SwingConstants.VERTICAL, new Component[] {tglbtnPlacePieces, tglbtnPlaceBoard, tglbtnPlaceHints});
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL, new Component[] {tglbtnPlacePieces, tglbtnPlaceHints});
		contentPane.setLayout(gl_contentPane);
	}
}
