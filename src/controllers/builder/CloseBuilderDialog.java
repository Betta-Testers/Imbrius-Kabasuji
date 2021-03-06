package controllers.builder;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import app.Builder;
import app.UndoManager;
import view.BuilderView;

/**
 * Class for creating the dialog when the builder is closed.
 * @author dfontana
 */

public class CloseBuilderDialog extends WindowAdapter{
	/**Builder being returned to.**/
	Builder b;
	/**View the dialog is attatched to.**/
	BuilderView bv;
	
	/**
	 * Creates a close builder dialog
	 * @param b - builder being returned to
	 * @param bv - view being attatched to.
	 */
	public CloseBuilderDialog(Builder b, BuilderView bv){
		this.b = b;
		this.bv = bv;
	}
	
	/**
	 * Displays a new JOptionPane when a window closes and prompts the user whether 
	 * or not they wish to close the window.
	 * @param windowEvent WindowEvent
	 */
	@Override
	public void windowClosing(WindowEvent windowEvent) {
		String message = "<html>Closing a level will not save your progress and return to level select</html>";
		String title = "Are you sure?";
		int response = JOptionPane.showConfirmDialog(bv,message, title,JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
		if (response == JOptionPane.OK_OPTION){
			UndoManager.getInstance().flush();
			b.getBuilderView().setVisible(false);
			b.getLevelTypeSelectView().setVisible(true);
		}else{
			//Close dialog
		}
	}
}
