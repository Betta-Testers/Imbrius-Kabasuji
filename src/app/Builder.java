package app;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import controllers.builder.BuilderBoardController;
import controllers.builder.CloseBuilderDialog;
import controllers.builder.PieceGroupSpinnerController;
import controllers.builder.RedoButtonController;
import controllers.builder.RemovePiecesButtonController;
import controllers.builder.SaveAndCloseLevelButtonController;
import controllers.builder.UndoButtonController;
import controllers.common.BullpenPieceSelectController;
import view.AbstractPieceGroupView;
import view.BuilderPieceGroupView;
import view.BuilderView;
import view.LevelTypeSelectView;
import model.AbstractLevelModel;

/**
 * Application class tracking the Builder. Prepares the views and controllers for LevelTypeSelectView and
 * manages the returning and leaving between the builderView and the LevelTypeSelectionView.
 * @author dfontana
 *
 */
public class Builder extends LevelIO{

	/**The LevelTypeSelectionView to select the type of level the builder wants to make**/
	LevelTypeSelectView ltsv;

	/**The BuilderView, for displaying the level once the builder has choosen to edit/create a level**/
	BuilderView bv;

	/**Current level being edited.**/
	AbstractLevelModel currentLevel;

	/**
	 * Creates the builder
	 * @param directory the builder is located in
	 */
	public Builder(String directory){
		super(directory);
		this.initialize();
	}

	/**
	 * Initializes the starMap for the builder, the views, and the controllers.
	 */
	void initialize(){
		this.levelData = loadStarMap();
		this.initializeView();
		ltsv.initializeControllers(this);
	}

	/**
	 * Prepares the view of the level Type Select screen, adding all existing levels to the 
	 * screen.
	 */
	void initializeView(){
		ltsv = new LevelTypeSelectView();

		for(int id: levelData.keySet()){
			try {
				ltsv.addExistingLevel(levelData.get(id), id, this);
			} catch (Exception e) {
				throw new RuntimeException("ID not found in levelData, LTSV couldn't be initialized" + e.getMessage());
			}
		}
		
		ltsv.refreshExistingLevels();
	}

	/**
	 * Saves the level being edited to disk. If the level is not already in levelData, it is
	 * then added to levelData and the LTSV. This method assumes the board/bullpen/any termination conditions have
	 * already been reset to a default state (bullpen has all pieces restored to it if they were testing, board has all pieces
	 * cleared from it, etc).
	 * 
	 * The file format is ID_TYPE.storage
	 */
	public void saveLevel(){
		ObjectOutputStream oos = null;

		int id = currentLevel.getID();
		String type = currentLevel.getType();
		String location = defaultDirectory+id+"_"+type+".storage";

		try {
			oos = new ObjectOutputStream(new FileOutputStream(location));
			oos.writeObject(currentLevel);
		} catch (Exception e) {
			System.err.println("Unable to save the level:" + e.getMessage());
		}

		if (oos != null) {
			try { oos.close(); } catch (IOException ioe) { } 
		}

		if(!levelData.containsKey(id)){
			levelData.put(id, type);
			ltsv.addExistingLevel(type, id, this);
			ltsv.refreshExistingLevels();
		}
	}

	/**
	 * Deletes a level from disk, which upon success will remove it from the view and the currentLevel
	 * fields. 
	 * @param id - ID of level being deleted
	 * @return true if the level could be deleted successfully
	 */
	public boolean deleteLevel(int id){
		if(levelData.deleteFromDisk(id)){
			ltsv.removeExistingLevel(id);
			this.currentLevel = null;
			return true;
		}
		return false;
	}
	
	/**
	 * Prepares the builderView and builder for creating a level.
	 * It sets the passed level to the current level, creates the Builder view and 
	 * then prepares that view and controllers of it.
	 * @param level to create
	 */
	public void createLevel(AbstractLevelModel level){
		currentLevel = level;
		bv = currentLevel.prepBuilder(this);
		bv.getBullpenView().prepBuilder(currentLevel.getBullpen());
		initializeLevelControllers();
	}

	/**
	 * For EDITING a level. This method is used by the ExistingLevelEditController
	 * to set the bv up for the level being edited.
	 * @param int levelID - level requested for editing. 
	 * @return boolean - true if level could be edited
	 */
	public boolean editLevel(int levelID){
		try{
			currentLevel = loadLevel(levelID);
			bv = currentLevel.prepBuilder(this);
			bv.getBullpenView().prepBuilder(currentLevel.getBullpen());
			initializeLevelControllers();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Prepares the controllers of the level being edited.
	 */
	void initializeLevelControllers(){
		bv.getButtonGroup().getSaveBtn().addActionListener(new SaveAndCloseLevelButtonController(this));
		bv.getButtonGroup().getRemoveBtn().addActionListener(new RemovePiecesButtonController(currentLevel.getBoard(), bv.getBoardView(), currentLevel.getBullpen(), bv.getBullpenView()));
		bv.getButtonGroup().getUndoBtn().addActionListener(new UndoButtonController(this));
		bv.getButtonGroup().getRedoBtn().addActionListener(new RedoButtonController(this));
		bv.setExitWindowListener(new CloseBuilderDialog(this, bv));
		bv.setBoardController(new BuilderBoardController(bv, currentLevel));
		
		for (AbstractPieceGroupView pgv : bv.getBullpenView().getPieceGroupViews()) {
			((BuilderPieceGroupView) pgv).addSelectButtonActionListener(new BullpenPieceSelectController(currentLevel.getBullpen(), bv.getSelectedPieceView()));
			((BuilderPieceGroupView) pgv).addSpinnerChangeListener(new PieceGroupSpinnerController(((BuilderPieceGroupView) pgv).getSpinner(), pgv.getPieceGroup(), currentLevel.getBullpen(),  bv.getSelectedPieceView().getPiecePanel()));
		}
	}
	//========================== Getters ==========================//
	/**
	 * Gets the builder view
	 * @return builder view
	 */
	public BuilderView getBuilderView(){
		return bv;
	}
	/**
	 * Gets the level Type select view
	 * @return LevelTypeSelectView
	 */
	public LevelTypeSelectView getLevelTypeSelectView(){
		return ltsv;
	}
	/**
	 * Get the next open ID for creation from the starmap (levelData).
	 * @return int of level ID
	 */
	public int getNextOpenID(){
		return levelData.nextOpenID();
	}
	/**
	 * Get the current level being modified in the builder.
	 * @return AbstractLevelModel currentLevel.
	 */
	public AbstractLevelModel getCurrentLevel(){
		return currentLevel;
	}
}
