package controllers;

import java.awt.event.WindowAdapter;

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
	public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		String message = "<html>Closing a level will not save your progress and return to level select</html>";
		String title = "Are you sure?";
		int response = JOptionPane.showConfirmDialog(bv,message, title,JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
		if (response == JOptionPane.OK_OPTION){
			b.cancelBuild();
		}else{
			//Close dialog
		}
	}
}
