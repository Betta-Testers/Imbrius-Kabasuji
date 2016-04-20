package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;

import model.AbstractTile;
import model.Board;


public class BoardView extends JPanel{
	private static final long serialVersionUID = 1L;
	Board b;
	TileView tiles[];
	
	/** Double Buffering technique requires an offscreen image. */
	Image offscreenImage;
	Graphics offscreenGraphics;
	Graphics canvasGraphics;
	

	//TODO Change Arguments: Board b
	public BoardView(Board b){
		setPreferredSize(new Dimension(384, 384));
		this.b = b;

		

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
		
		/** Draw all shapes. Note selected shape is not part of the model. */
		//I can assert that the board's graphics is empty at this point
		TileView factory = new TileView();
		for (int row = 0; row < 12; row++) {
			for(int col = 0; col < 12; col++){
				AbstractTile t = b.getTileAt(row, col);
				factory.drawToBoard(offscreenGraphics, t);
			}
		//I can assert that the board's graphics is FULL of tiles at this point
		}
		
					//paintShape(offscreenGraphics, s);
		
	}
	
	/**
	 * Ensure image available prepares the offscreen image for painting if it is currently missing from
	 * the object (null). It gets called only INSIDE this class and is called in the paintComponent()
	 * method
	 */
	void ensureImageAvailable(Graphics g) {
		
		if (offscreenImage == null) {  
			offscreenImage = this.createImage(this.getWidth(), this.getHeight());
			offscreenGraphics = offscreenImage.getGraphics();			
			canvasGraphics = g;
			
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
		
		// draw selected on top of offscreen image, since not part of the model.
		// Shape selected = model.getSelected();
		// if (selected != null) {
		// 	paintShape(g, selected);
		// }
	}

	// /** Paint the shape right to the screen */
	// public void paintShape(Shape s) {
	// 	paintShape(canvasGraphics, s);
	// }
	// 
	// /** Paint the shape into the given graphics context using its drawer. */
	// public void paintShape(Graphics g, Shape s) {
	// 	if (g == null) { return; }
	// 	
	// 	ShapeDrawer sd = s.getDrawer();
	// 	sd.drawShape(g, s);
	// }
	
	/**
	 * Method found inside ShapeDrawer. We should have either the model draw itself
	 * or the factory do this. Basically pass the board around and let everyone draw 
	 * themselves onto the graphics object
	 */
	/**
	 * Draws shape of word.
	 * 
	 * Fill in background and draw outline on top. Finally, draw the text.
	 * Subclass determines how to draw accordingly.
	 *  
	 * Strategy design pattern being applied here.
	 * 
	 * @param g
	 * @param s
	 */
	// public void drawShape(Graphics g, Shape s) {
	// 	fillBox(g, s);
	// 	outlineBox(g, s);
	// 	drawText(g, s);
	// }
	
	/**
	 * Need one more draw method that handles drawing a piece at a given mouse object
	 * or x/y coordinate (which ever the controller wants to pass to this method when
	 * it is attempting a drag or placement)
	 *
	 * It would need to consume the piece attempting to be drawn, to get an idea
	 * of where each tile is relative to the ORIGIN tile (the origin tile would be 
	 * drawn around the mouse. The rest of the tiles would be extrapolated from that)
	 *
	 * The tiles outlines would be red if the entire piece doesn't fit on the board,
	 * green if they all do. So we would want a way to draw all tiles possible and then
	 * return true if they all could fit, false if not. That way we know what color to
	 * set.
	 */
	
	
	
	
	
	
	
	
	
	
	
	void setMouseMotionAdapter(MouseMotionAdapter ma){
		//TODO Fill Stub - setMouseMotionAdapter
	}
	
	void setMouseAdapter(MouseAdapter ma){
		//TODO Fill Stub - setMouseAdapter
	}
	
}
