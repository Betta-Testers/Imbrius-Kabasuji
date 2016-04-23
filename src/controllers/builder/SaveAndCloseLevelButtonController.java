/**
 * 
 */
package controllers.builder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.Builder;

/**
 * @author hejohnson
 *
 */
public class SaveAndCloseLevelButtonController implements ActionListener {
	Builder builder;
	public SaveAndCloseLevelButtonController (Builder b) {
		this.builder = b;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (builder.isNewLevel()) {
			builder.getLevelTypeSelectView().addExistingLevel(builder.getCurrentLevel().getType(), builder.getCurrentLevel().getID());
		}
		builder.saveLevel();
		builder.getBuilderView().setVisible(false);
		builder.getLevelTypeSelectView().setVisible(true);
		
	}

}
