package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.Bullpen;
import model.PieceTile;

/**
 * Draws the selected piece of the bullpen at the top of the screen, inside the selectedPieceView.
 * @author dfontana
 */
public class PiecePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	/** Double Buffering technique requires an offscreen image. */
	Image offscreenImage;
	/**The offscreen graphics object, also used in double buffering.**/
	Graphics offscreenGraphics;
	/**Stores the bullpen**/
	Bullpen bp;

	/**
	 * Creates the piece panel object
	 * @param bp the bullpen whose selected piece is being displayed in this panel.
	 */
	PiecePanel(Bullpen bp){
		this.setPreferredSize(new Dimension(192,192));
		this.bp = bp;
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}

	/**
	 * Redraw recreates everything offscreen. Notice how there is an offscreen image and graphics.
	 * It even paints all shapes to the offscreen graphics supplied to the paintShape object
	 * 		-> It is believed that the offscreenGraphics is an object stored within the offscreenImage
	 * 		-> This is the method called BEFORE calling .paint() on this panel
	 */
	public void redraw() {
		// nothing to draw into? Must stop here.
		if (offscreenImage == null) return;
		if (offscreenGraphics == null) return;    // detected during testing

		// clear the image.
		offscreenGraphics.clearRect(0, 0, this.getWidth(), this.getHeight());

		/**
		 * X and Y center of the jPanel, offset by half a tile width to make the tile
		 * appear in the center, not the top left corner
		 */

		/***
		 *  private BufferedImage cropImage(BufferedImage src, int x, int y) {
      			BufferedImage dest = src.getSubimage(0, 0, this.getWidth(), this.getHeight());
      			return dest; 
   			}

   			Try cropping the image. So generate it the way you were, but then grab the top left corner
   			of the top left most tile (you'll need to find this, it'll be the most negative.
		 */
		if (bp != null && bp.getSelectedPiece()!=null) {
			//Recompute the piece tile's locations to be more manageable (won't go out of raster!)
			int restoreCol = bp.getSelectedPiece().getOriginCol();
			int restoreRow = bp.getSelectedPiece().getOriginRow();
			bp.getSelectedPiece().setLocation(6,6); 
			
			//Boundaries
			ArrayList<PieceTile> tiles = bp.getSelectedPiece().getTiles();
			int topRow = tiles.get(0).getRow();
			int leftCol = tiles.get(0).getCol();
			int rightCol = tiles.get(0).getCol();
			int botRow = tiles.get(0).getRow();
			
			
			for(int i = 1; i < tiles.size(); i++){
				PieceTile t = tiles.get(i);
			
				//Find boundaries
				if(t.getRow() > botRow){ 	botRow = t.getRow();}
				if(t.getRow() < topRow){ 	topRow = t.getRow();}
				if(t.getCol() > rightCol){ 	rightCol = t.getCol();}
				if(t.getCol() < leftCol){	leftCol = t.getCol();}
			}	
			
			//Compute a size that will fit within the bounds of the jpanel
			int pieceWidth = Math.abs(rightCol - leftCol)+1;
			int pieceHeight = Math.abs(botRow - topRow)+1;
			int sidelength = 32;			
			
			boolean fits = false;
			do{
				//Find size
				if(pieceWidth*sidelength < this.getWidth() && pieceHeight*sidelength < this.getHeight()){
					fits = true;
				}else{
					sidelength -= 2;
				}
			}while(!fits);

			//Draw the image to a buffered image.
			int xCenter = (this.getWidth()/2)-(sidelength/2);
			int yCenter = (this.getHeight()/2)-(sidelength/2);
			
			 // Create a buffered image with transparency
		    BufferedImage temp = new BufferedImage(this.getWidth()*2, this.getHeight()*2, BufferedImage.TYPE_INT_ARGB);
		    Graphics2D pieceGraphics = temp.createGraphics();

			for(PieceTile t: bp.getSelectedPiece().getTiles()){
				int xCoord = (t.getCol()*sidelength)+xCenter;
				int yCoord = (t.getRow()*sidelength)+yCenter;

				pieceGraphics.setColor(t.getColor());
				pieceGraphics.fillRect(xCoord, yCoord, sidelength, sidelength);
				pieceGraphics.setColor(Color.BLACK);
				pieceGraphics.drawRect(xCoord, yCoord, sidelength, sidelength);
			}
			
			BufferedImage dest = temp.getSubimage((leftCol*sidelength)+xCenter, (topRow*sidelength)+yCenter, pieceWidth*sidelength+1, pieceHeight*sidelength+1);
			
			offscreenGraphics.drawImage(dest, 96-(dest.getWidth()/2), 96-(dest.getHeight()/2), dest.getWidth(), dest.getHeight(), this);
			
			bp.getSelectedPiece().setLocation(restoreRow,restoreCol);
		}
	}

	/**
	 * Ensure image available prepares the offscreen image for painting if it is currently missing from
	 * the object (null). It gets called only INSIDE this class and is called in the paintComponent()
	 * method.
	 * @param g - Graphics
	 */
	void ensureImageAvailable(Graphics g) {
		if (offscreenImage == null) {  
			offscreenImage = this.createImage(this.getWidth(), this.getHeight());
			offscreenGraphics = offscreenImage.getGraphics();			

			redraw();
		}
	}

	/** 
	 * This is the method called by .paint(). It supers the constructor and then called ensureImageAvailable
	 * to make sure there is an offscreen image to bring onto the board. THAT'S why redraw() is called before
	 * paint(), so that way the offscreen is ready to go before it is brought onscreen.
	 * 
	 * After that, the paint method draws the image as it is, to this panel with g.drawImage.
	 * It then draws every one of his shapes over that image.
	 * 
	 * To Draw within a JPanel, you need to have a protected void method of this name.
	 * Note that the first operation of this method MUST BE to invoke super.paintComponent(g)
	 * 
	 * @param g - Graphics
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		ensureImageAvailable(g);
		g.drawImage(offscreenImage, 0, 0, getWidth(), getHeight(), this);
	}
}
