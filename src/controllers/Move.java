/**
 * 
 */
package controllers;

/**
 * @author hejohnson
 *
 */
public abstract class Move {

		Move () {
			
		}
		
		abstract public boolean doMove();
		
		abstract public boolean isValid();
		
		abstract public boolean undo();
		
		abstract public boolean redo();
}
