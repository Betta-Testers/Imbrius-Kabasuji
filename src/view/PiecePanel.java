/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import model.AbstractTile;
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
	public PiecePanel(Bullpen bp){
		this.setPreferredSize(new Dimension(192,192));
		this.bp = bp;
		this.setBorder(BorderFactory.createLineBorder(Color.black)); //TODO REMOVE
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
		int xCenter = 96-16;
		int yCenter = 96-16;
		if (bp != null && bp.getSelectedPiece()!=null) {
			for(PieceTile t: bp.getSelectedPiece().getTiles()){
				int xCoord = (t.getCol()*32)+xCenter;
				int yCoord = (t.getRow()*32)+yCenter;
				
				offscreenGraphics.setColor(t.getColor());
				offscreenGraphics.fillRect(xCoord, yCoord, 32, 32);
				offscreenGraphics.setColor(Color.BLACK);
				offscreenGraphics.drawRect(xCoord, yCoord, 32, 32);
			}	
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
