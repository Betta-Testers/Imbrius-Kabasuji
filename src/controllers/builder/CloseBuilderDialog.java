package controllers.builder;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import app.Builder;
import view.BuilderView;

public class CloseBuilderDialog extends WindowAdapter{
	Builder b;
	BuilderView bv;
	
	public CloseBuilderDialog(Builder b, BuilderView bv){
		this.b = b;
		this.bv = bv;
	}
	
	@Override
	/**
	 * Displays a new JOptionPane when a window closes and prompts the user whether or not they wish to close the window or not
	 * 
	 * @param windowEvent WindowEvent
	 */
	public void windowClosing(WindowEvent windowEvent) {
		String message = "<html>Closing a level will not save your progress and return to level select</html>";
		String title = "Are you sure?";
		int response = JOptionPane.showConfirmDialog(bv,message, title,JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
		if (response == JOptionPane.OK_OPTION){
			b.getBuilderView().setVisible(false);
			b.getLevelTypeSelectView().setVisible(true);
		}else{
			//Close dialog
		}
	}
}
