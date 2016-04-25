package controllers.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.UndoManager;

/**
 * Controller to link to the redo button in the level builder
 * @author awharrison
 * @author dfontana
 */
public class RedoButtonController implements ActionListener{
	/**Link to the UndoManager singleton for the button to perform actions on**/
	UndoManager manager;
	
	public RedoButtonController() {
		manager = UndoManager.getInstance();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(manager.redo()){
			System.out.println("Move REDONE!");
		}else{
			//No more moves to redo
			System.out.println("Nothing to redo!");
			//TODO Gray out button. How do you get the button to be reenabled, then?
		}
	}
}
