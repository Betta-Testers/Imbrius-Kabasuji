package model;

import java.awt.Color;
import java.io.Serializable;

/**
 * 
 * @author hejohnson
 *
 */

public class HintTile extends AbstractTile implements Serializable{
	private static final long serialVersionUID = -8764265154615476615L;

	public HintTile(int row, int col) {
		super(row, col);
		this.color = Color.DARK_GRAY;
		this.defaultColor = color;
		this.tileType = "hint";
	}

}
