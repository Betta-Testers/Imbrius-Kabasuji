package controllers.builder;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTextArea;
import app.Builder;


/**
 * Controller attached to the create new Release level option in the 
 * builder.
 * @author dfontana
 */
public class NewReleaseLevelController implements MouseListener{
	Builder b;
	JTextArea textArea;
	String descriptionText;
	
	/**
	 * Controller to change the text displayed in the level type description box
	 * @param builder The builder application
	 * @param textArea The text area in the Level Type Select View to set the contents of
	 * @param descriptionText The text to set the text area contents to
	 */
	public NewReleaseLevelController (Builder b, JTextArea textArea, String descriptionText) {
		this.b = b;
		this.textArea = textArea;
		this.descriptionText = descriptionText;
	}

	/**
	 * When the button is clicked, tell the builder to create a new puzzle level and
	 * prepare the view of it.
	 */
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	/**
	 * Sets the textArea's description back to level-specific message when entering button
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
		textArea.setText(descriptionText);
	}
	
	/**
	 * Sets the textArea's description back to default message when leaving button
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		textArea.setText("Mouse over a level to see its description");
	}
	
	/**
	 * Creates a new builder, and sets up the windows to show the level and hide the level type select view
	 */
	@Override
	public void mousePressed(MouseEvent arg0){
		b.createReleaseLevel();
		b.getLevelTypeSelectView().setVisible(false);
		b.getBuilderView().setVisible(true);
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0){}
}