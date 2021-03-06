package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import model.AbstractTile;
import model.Board;

/**
 * Handles the board graphics for both the game and builder.
 * @author dfontana
 * @author Heineman
 * @author awharrison
 */
public class BoardView extends JPanel{
	private static final long serialVersionUID = 1L;
	
	/**Stores the entity of the board.**/
	Board b;

	/** Double Buffering technique requires an offscreen image. */
	Image offscreenImage;
	Graphics offscreenGraphics;
	
	/**Handles mouse action events.**/
	MouseListener mouseActionHandler;
	
	/**Handles mouse motion events.**/
	MouseMotionListener mouseMotionHandler;
	
	/**
	 * Creates a new board view with an inputed board.
	 * @param b - Board
	 */
	BoardView(Board b){
		setPreferredSize(new Dimension(385, 385));
		this.b = b;
		repaint(); //Initial painting of board from file
	}

	/**
	 * Redraw recreates everything offscreen. Notice how there is an offscreen image and graphics.
	 * It even paints all shapes to the offscreen graphics supplied to the paintShape object.
	 * 		-> It is believed that the offscreenGraphics is an object stored within the offscreenImage
	 * 		-> This is the method called BEFORE calling .paint() on this panel
	 */
	public void redraw() {
		// nothing to draw into? Must stop here.
		if (offscreenImage == null) return;
		if (offscreenGraphics == null) return;    // detected during testing

		// clear the image.
		offscreenGraphics.clearRect(0, 0, this.getWidth(), this.getHeight());

		/** Draw all shapes. Note selected shape is not part of the model. */
		//I can assert that the board's graphics is empty at this point
		if(b != null){
			TileViewFactory factory = new TileViewFactory();
			for (int row = 0; row < 12; row++) {
				for(int col = 0; col < 12; col++){
					AbstractTile t = b.getTileAt(row*32, col*32);
					factory.drawToBoard(offscreenGraphics, t);
				}
				//I can assert that the board's graphics is FULL of tiles at this point
			}		
		}
	}

	/**
	 * Ensure image available prepares the offscreen image for painting if it is currently missing from
	 * the object (null). It gets called only INSIDE this class and is called in the paintComponent()
	 * method.
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
	 * @param g
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		ensureImageAvailable(g);
		g.drawImage(offscreenImage, 0, 0, getWidth(), getHeight(), this);
	}
	
	/**
	 * Sets the mouse action listener.
	 * @param ml - MouseListener
	 */
	public void setMouseActionController (MouseListener ml){
		this.mouseActionHandler = ml;
		this.addMouseListener(ml);
	}
	
	/**
	 * Sets the mouse motion listener of the this view
	 * @param mml - MouseMotionListener being added
	 */
	public void setMouseMotionController (MouseMotionListener mml){
		this.mouseMotionHandler = mml;
		this.addMouseMotionListener(mml);
	}
	
	/**
	 * Returns the mouse action listener.
	 * @return mouseActionHandler - MouseListener
	 */
	public MouseListener getMouseActionController() {
		return this.mouseActionHandler;
	}
	
	/**
	 * Returns the mouse motion listener.
	 * @return mouseMotionHandler - MouseMotionListener
	 */
	public MouseMotionListener getMouseMotionController() {
		return this.mouseMotionHandler;
	}
}
