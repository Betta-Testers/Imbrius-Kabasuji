package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.AbstractTile;

/**
 * 
 * @author awharrison
 *
 */
public class TileConversionController extends MouseAdapter {
	TileView view;

	public TileConversionController(TileView v) {
		this.view = v;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() > 1) {
			AbstractTile tile = (AbstractTile) view.getModelElement();
			String type = tile.getTileType();
			switch(type) {
			case "Board":
				break;
			case "Empty":
				break;
			case "Piece":
				break;
			case "Release":
				break;
			case "Hint":
				break;
			case "Lightning":
				break;
			default:
				break;
			}
		}
	}
}
