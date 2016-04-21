/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.Graphics;

import model.AbstractTile;

/**
 * @author hejohnson
 *
 */
public class TileViewFactory {
	public TileViewFactory () {
		
	}
	
	public void drawToBoard(Graphics g, AbstractTile at) {
		int xCoord = at.getCol()*32;
		int yCoord = at.getRow()*32;
		g.setColor(at.getColor());
		g.fillRect(xCoord, yCoord, 32, 32);
		g.setColor(Color.BLACK);
		g.drawRect(xCoord, yCoord, 32, 32);
	}
}
