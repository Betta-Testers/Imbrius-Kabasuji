package app;

import java.awt.EventQueue;
import javax.swing.UIManager;
import view.BuilderView;
import view.LevelTypeSelectView;

public class Builder {
	static LevelTypeSelectView selectionView;
	// TODO Add Attribute: AbstractLevelModel buildingLevel;
	static BuilderView builderView;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					builderView = new BuilderView();
					selectionView = new LevelTypeSelectView(0, builderView);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	void initialize(){
		/**TODO Determine where to get highest level from....
		 * Probably need to have a method run before this that reads files and stores
		 * the highest number, then pass that as the argument
		 */
		
		
		//initializeView();
		//initializeControllers();
	}
	
	void initializeView(){
		//TODO Initialize selectionView in here
		
	}
	
	void initializeControllers(){
		//TODO Initialize selectionView controllers here
		
		/**
		 * TODO The controller for selection view should read the selection made 
		 * when you hit "play level" and call a builder initialization method inside
		 * THIS (so pass it this) that will prep a lightning, puzzle, or release.
		 * 
		 * -OR-
		 * 
		 * Pass it BuilderView and have it call the appropriate method on builderView to prepare it.
		 * Then set the builderView to visible and the selection view to hidden
		 * 
		 * Think about level views. When you prepare the level model and it reads in, how will your
		 * view adapt to that? It would call the proper method on the BuilderView to display the correct objects,
		 * after which boardView and bullpenView would read their models.
		 * 
		 * So if the player chooses to load a level, they would want to initializeModel(), then View, then Controllers.
		 * 
		 * Does that mean making a method here that lets you change the builderView to a new one generated in the
		 * controller so you can easily swap it? Or does that mean writing a reevaluate() method in the builderView,
		 * where it updates everything since a model inside must have beens set()
		 */
	}
	
	void initializeLevelModel(int levelID){
		
	}
	
	void loadLevelIDs(){
		
	}
	
	void initializeLevelView(){
		//TODO Initialize BuilderView in here
	}
	
	void initializeLevelControllers(){
		//TODO Initialize BuilderView Controllers in here
//		builderView.setVisible(true); to make builderview appear
	}


}
