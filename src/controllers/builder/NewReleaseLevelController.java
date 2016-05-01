package controllers.builder;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTextArea;
import app.Builder;
import app.LevelFactory;


/**
 * Controller attached to the create new Release level option in the builder.
 * @author dfontana
 */
public class NewReleaseLevelController implements MouseListener{
	/** The builder object that holds everything **/
	Builder b;
	/** The text area in the Level Type Select View that displays a description of each type of level **/
	JTextArea textArea;
	/** Level type specific text that gets displayed in the text area **/
	String descriptionText;
	
	/**
	 * Controller to change the text displayed in the level type description box
	 * @param b The builder application
	 * @param textArea The text area in the Level Type Select View to set the contents of
	 * @param descriptionText The text to set the text area contents to
	 */
	public NewReleaseLevelController (Builder b, JTextArea textArea, String descriptionText) {
		this.b = b;
		this.textArea = textArea;
		this.descriptionText = descriptionText;
	}

	/**
	 * Sets the textArea's description back to level-specific message when entering button
	 * @param arg0 of entering
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
		textArea.setText(descriptionText);
	}
	
	/**
	 * Sets the textArea's description back to default message when leaving button
	 * @param arg0 of exiting
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		textArea.setText("Mouse over a level to see its description");
	}
	
	/**
	 * Creates a new builder, and sets up the windows to show the level and hide the level type select view
	 * @param arg0 of pressing
	 */
	@Override
	public void mousePressed(MouseEvent arg0){
		LevelFactory factory = new LevelFactory(); 
		b.createLevel(factory.GenerateBlankRelease(b.getNextOpenID()));
		b.getLevelTypeSelectView().setVisible(false);
		b.getBuilderView().setVisible(true);
	}
	/**
	 * Does nothing on mouseClicked
	 * @param arg0 - mouse clicked event
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {}
	/**
	 * Does nothing on mouseReleased
	 * @param arg0 - mouse released event
	 */
	@Override
	public void mouseReleased(MouseEvent arg0){}
}