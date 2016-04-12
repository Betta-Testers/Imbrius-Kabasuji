package model;

import java.awt.Color;

/**
 * 
 * @author hejohnson
 *
 */

public class HintTile extends AbstractTile {

	public HintTile(int row, int col) {
		super(row, col);
		this.color = Color.BLUE;
		this.tileType = "hint";
	}

}
