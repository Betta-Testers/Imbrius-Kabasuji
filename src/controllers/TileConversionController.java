package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import view.BoardView;
import model.AbstractTile;
import model.Board;

/**
 * 
 * @author awharrison
 *
 */
public class TileConversionController extends MouseAdapter {
	Board model;
	BoardView view;

	public TileConversionController(Board model, BoardView view) {
		this.model = model;
		this.view = view;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() > 1) {
			int xPoint = e.getLocationOnScreen().x;
			int yPoint = e.getLocationOnScreen().y;
			
			AbstractTile toSwap = model.getTileAt(xPoint, yPoint);
			// TODO Delete this soon, turning into move classes
		}
	}
}
