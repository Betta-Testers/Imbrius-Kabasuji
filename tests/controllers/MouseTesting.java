package controllers;

import java.awt.event.MouseEvent;

import javax.swing.JComponent;

import junit.framework.TestCase;


/**
 * Derived from George Heineman's KSTestCase for use in testing Kabasuji
 * <p>
 * If you would like to use this capability, have your JUnit test case
 * extend from this class instead of {@link TestCase}.
 * 
 * @author George Heineman
 * @author hejohnson
 */
public abstract class MouseTesting extends TestCase {
	/** (dx,dy) are offsets into the widget space. Feel Free to Use as Is. */
	public MouseEvent createPressed (JComponent view, int dx, int dy) {
		MouseEvent me = new MouseEvent(view, MouseEvent.MOUSE_PRESSED, 
				System.currentTimeMillis(), 0, 
				dx, dy, 0, false);
		return me;
	}
	
	/** (dx,dy) are offsets into the widget space. Feel Free to Use as Is. */
	public MouseEvent createRightClick (JComponent view, int dx, int dy) {
		MouseEvent me = new MouseEvent(view, MouseEvent.MOUSE_PRESSED, 
				System.currentTimeMillis(), 0, 
				dx, dy, 0, true);
		return me;
	}
	
	/** (dx,dy) are offsets into the widget space. Feel Free to Use as Is. */
	public MouseEvent createReleased (JComponent view, int dx, int dy) {
		MouseEvent me = new MouseEvent(view, MouseEvent.MOUSE_RELEASED, 
				System.currentTimeMillis(), 0, 
				view.getX()+dx, view.getY()+dy, 0, false);
		return me;
	}
	
	/** (dx,dy) are offsets into the widget space. Feel Free to Use as Is. */
	public MouseEvent createClicked (JComponent view, int dx, int dy) {
		MouseEvent me = new MouseEvent(view, MouseEvent.MOUSE_CLICKED, 
				System.currentTimeMillis(), 0, 
				dx, dy, 1, false);
		return me;
	}
	
	/** (dx,dy) are offsets into the widget space. Feel Free to Use as Is. */
	public MouseEvent createDoubleClicked (JComponent view, int dx, int dy) {
		MouseEvent me = new MouseEvent(view, MouseEvent.MOUSE_CLICKED, 
				System.currentTimeMillis(), 0, 
				dx, dy, 2, false);
		return me;
	}
}
