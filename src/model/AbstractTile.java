package model;

import java.awt.Color;
import java.io.Serializable;

/**
<<<<<<< HEAD
 * AbstractTile is the parent class for all variations of tiles.
=======
 * Abstract class governing tile creation. A tile is a single unit of a board and piece.
>>>>>>> refs/remotes/origin/Builder
 * @author hejohnson
 *
 */

public abstract class AbstractTile implements Serializable{
	private static final long serialVersionUID = 6566817267314437128L;
	
<<<<<<< HEAD
	/**The rowOnBoard of a tile is its row location on the board, with higher values farther down the board **/
	int rowOnBoard;
	
	/**The colOnBoard of a tile is its column location on the board, with higher values farther to the right of the board **/
	int colOnBoard;
	
	/**The tileType of a tile is determined by the subclasses of AbstractTile**/
	String tileType;
	
	/**The color of a tile is determined by the subclasses of AbstractTile**/
	Color color;
	
	/**The color of a tile is determined by the subclasses of AbstractTile**/
=======
	/**The row that the tile is located at on the board (0 based indexing)**/
	int rowOnBoard;
	/**The row that the tile is located at on the board (0 based indexing)**/
	int colOnBoard;
	/**The type of the tile. This value can be: 'board' 'empty' 'release' 'puzzle' 'lightning'**/
	String tileType;
	/**The color of the tile in its current state.**/
	Color color;
	/**The color of the tile as it wants to be by default.**/
>>>>>>> refs/remotes/origin/Builder
	Color defaultColor;

	/**
	 * Abstract constructor for all types of tiles to use. Creates a tile at the specified location
	 * @param row Row on the board
	 * @param col Column on the board
	 */
	public AbstractTile (int row, int col) {
		this.rowOnBoard = row;
		this.colOnBoard = col;
	}
	
	/**
	 * @return The type of tile (lowercase) followed by its row location followed by column location
	 */
	public String toString() {
		return this.tileType + " r:" + this.rowOnBoard + " c:" + this.colOnBoard;
	}
	
	/**
<<<<<<< HEAD
	 * Return the row location of the tile.
	 * @return rowOnBoard - int
=======
	 * Returns the row this tile is located at on the board
	 * @return int >= 0 and < 12
>>>>>>> refs/remotes/origin/Builder
	 */
	public int getRow() {
		return this.rowOnBoard;
	}
	
	/**
<<<<<<< HEAD
	 * Return the column location of the tile.
	 * @return colOnBoard - int
=======
	 * Returns the col this tile is located at on the board
	 * @return int >= 0 and < 12
>>>>>>> refs/remotes/origin/Builder
	 */
	public int getCol() {
		return this.colOnBoard;
	}
	
	/**
<<<<<<< HEAD
	 * Return the column location of the tile. Note that this is determined by the subclasses of abstractTile.
	 * @return color - Color
=======
	 * Returns the current color of this tile
	 * @return Color object, of current state
>>>>>>> refs/remotes/origin/Builder
	 */
	public Color getColor() {
		return this.color;
	}
	
	/**
<<<<<<< HEAD
	 * Returns the number displayed on this tile. Because an abstractTile is not a releaseTile, -1 is returned.
	 * @return -1 - int
=======
	 * Returns the number displayed on this tile
	 * @return int representation of a tile. -1 if not a ReleaseTile
>>>>>>> refs/remotes/origin/Builder
	 */
	public int getNumber() {
		return -1;
	}
	
	/**
	 * Changes the color of the tile if the tile's view is included in a piece flyby. The parameter isValidLocation determines what color the tile will be.
	 * @param isValidLocation - boolean
	 */
	public void setMouseOverColor(boolean isValidLocation) {
		if (isValidLocation) {
			this.color = Color.GREEN;
		} else {
			this.color = Color.RED;
		}
	}
	
	/**
<<<<<<< HEAD
	 * Resets the pieces color if it was mousedOver.
=======
	 * Resets the tile's color if it was mousedOver
>>>>>>> refs/remotes/origin/Builder
	 */
	public void resetColor() {
		this.color = this.defaultColor;
	}
	
	/**
	 * Returns the type of the tile. Note that this is determined by the subclasses of abstractTile.
	 * @return tileType - String
	 */
	public String getTileType() {
		return this.tileType;
	}
}
