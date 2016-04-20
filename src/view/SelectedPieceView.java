package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import model.AbstractTile;
import model.Bullpen;
import model.PieceTile;

public class SelectedPieceView extends JPanel{
	private static final long serialVersionUID = 1L;
	GroupLayout groupLayout;
	JPanel piecePanel;
	JButton btnRotateLeft;
	JButton btnRotateRight;
	JButton btnFlipX;
	JButton btnFlipY;
	Bullpen bp;
	
	/** Double Buffering technique requires an offscreen image. */
	Image offscreenImage;
	Graphics offscreenGraphics;
	
	public SelectedPieceView(Bullpen bp){
		setPreferredSize(new Dimension(384, 224));
		this.bp = bp;
		btnRotateLeft = new JButton("");
		btnRotateLeft.setToolTipText("Rotate Left");
		btnRotateRight = new JButton("");
		btnRotateRight.setToolTipText("Rotate Right");
		btnFlipX = new JButton("");
		btnFlipX.setToolTipText("Flip X");
		btnFlipY = new JButton("");
		btnFlipY.setToolTipText("Flip Y");
		
		piecePanel = new JPanel();
		setupLayout();
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
		int xCenter = 96-16;
		int yCenter = 96-16;
		
		for(PieceTile t: bp.getSelectedPiece().getTiles()){
			int xCoord = (t.getCol()*32)+xCenter;
			int yCoord = (t.getRow()*32)+yCenter;
			
			offscreenGraphics.setColor(Color.BLACK);
			offscreenGraphics.drawRect(xCoord, yCoord, 32, 32);
			offscreenGraphics.setColor(t.getColor());
			offscreenGraphics.fillRect(xCoord, yCoord, 32, 32);	
		}	
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
	
	private void setupLayout(){
		
		btnRotateLeft.setIcon(new ImageIcon(SelectedPieceView.class.getResource("/icons/RotateLeft.png")));
		btnRotateRight.setIcon(new ImageIcon(SelectedPieceView.class.getResource("/icons/RotateRight.png")));
		btnFlipX.setIcon(new ImageIcon(SelectedPieceView.class.getResource("/icons/FlipX.png")));
		btnFlipY.setIcon(new ImageIcon(SelectedPieceView.class.getResource("/icons/FlipY.png")));
		
		groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(96, Short.MAX_VALUE)
					.addComponent(piecePanel, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnFlipX, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnFlipY, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnRotateLeft, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRotateRight, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnRotateLeft)
								.addComponent(btnRotateRight))
							.addPreferredGap(ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnFlipX)
								.addComponent(btnFlipY)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(16)
							.addComponent(piecePanel, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		GroupLayout gl_piecePanel = new GroupLayout(piecePanel);
		gl_piecePanel.setHorizontalGroup(
			gl_piecePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 196, Short.MAX_VALUE)
		);
		gl_piecePanel.setVerticalGroup(
			gl_piecePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 197, Short.MAX_VALUE)
		);
		piecePanel.setLayout(gl_piecePanel);
		setLayout(groupLayout);
	}
}
