package model;

import java.awt.Color;
import java.io.Serializable;

/**
 * 
 * @author hejohnson
 *
 */

public class LightningTile extends AbstractTile implements Serializable{
	private static final long serialVersionUID = -3635072059517548496L;

	public LightningTile(int row, int col) {
		super(row, col);
		this.color = Color.GREEN;
		this.defaultColor = color;
		this.tileType = "lightning";
	}

}
