/**
 * 
 */
package controllers.common;

/**
 * @author hejohnson
 *
 */
public abstract class Move {

		public Move () {
			
		}
		
		abstract public boolean doMove();
		
		abstract public boolean isValid();
		
		abstract public boolean undo();
		
		abstract public boolean redo();
}
