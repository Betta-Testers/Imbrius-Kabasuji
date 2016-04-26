/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import model.AbstractTile;
import model.ReleaseTile;

/**
 * Handles drawing tiles.
 * @author hejohnson
 *
 */
public class TileViewFactory {
	public TileViewFactory () {
		
	}
	/**
	 * Draws a tile.
	 * @param g - Graphics
	 * @param at - AbstractTile
	 */
	public void drawToBoard(Graphics g, AbstractTile at) {
		int xCoord = at.getCol()*32;
		int yCoord = at.getRow()*32;
		g.setColor(at.getColor());
		g.fillRect(xCoord, yCoord, 32, 32);
		g.setColor(Color.BLACK);
		g.drawRect(xCoord, yCoord, 32, 32);
		if(at.getNumber() > 0){
			g.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
			g.setColor(((ReleaseTile) at).getColorSet());
			g.drawString(Integer.toString(at.getNumber()), xCoord+10, yCoord+24);
		}
	}
}
