package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import app.Builder;
import view.LevelTypeSelectView;


/**
 * 
 * @author hejohnson
 *
 */


public class NewLevelTypeController implements MouseListener{
	LevelTypeSelectView ltsv;
	String descriptionText;
	Builder builder;

	/**
	 * Controller to change the text displayed in the level type description box
	 * @param levelDescription - JTextArea being updated
	 * @param createLevel - CreateLevelButton being set enabled/disabled
	 * @author dfontana
	 */

	public NewLevelTypeController (Builder b, LevelTypeSelectView ltsv, String descriptionText) {
		this.ltsv = ltsv;
		this.descriptionText = descriptionText;
		this.builder = b;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Logic for starting new level
		/*builder.createLevel(descriptionText.split(":")[0]);
		builder.getLevelTypeSelectView().setVisible(false);
		builder.getBuilderView().setVisible(true);*/
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		ltsv.setDescriptionText(descriptionText);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		ltsv.setDescriptionText("Mouse over a level to see its description");
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
}