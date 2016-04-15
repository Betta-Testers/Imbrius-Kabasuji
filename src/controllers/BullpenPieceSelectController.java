/**
 * 
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.AbstractLevelModel;
import view.SelectPieceButton;

/**
 * @author hejohnson
 *
 */

//TODO Add view refresh stuff
public class BullpenPieceSelectController implements ActionListener {
	AbstractLevelModel levelModel;
	BullpenPieceSelectController (AbstractLevelModel levelModel) {
		this.levelModel = levelModel;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		SelectPieceButton source  = (SelectPieceButton) ae.getSource();
		levelModel.getBullpen().setSelectedPiece(source.getPieceID());
	}
}
