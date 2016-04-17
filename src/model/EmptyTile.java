package model;

import java.awt.Color;
import java.io.Serializable;

/**
 * 
 * @author hejohnson
 *
 */

public class EmptyTile extends AbstractTile implements Serializable{
	private static final long serialVersionUID = -8744970312057997685L;

	public EmptyTile(int row, int col) {
		super(row, col);
		this.color = Color.LIGHT_GRAY;
		this.defaultColor = color;
		this.tileType = "empty";
	}
}
