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
			
			(if tile == null) {
				throw new RuntimeException("TileConversionController::somehow did not click a tile");
			}
			
			String type = tile.getTileType();
			switch(type) {
			case "Board":
				// TODO if toggle release number is on, set to release tile
				tile.setTileType("Empty");
				break;
			case "Empty":
				tile.setTileType("Board");
				break;
			case "Piece":
				break;
			case "Release":
				tile.setTileType("Board");
				break;
			default:
				break;
			}
		}
	}
}
