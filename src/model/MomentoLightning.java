package model;

import java.io.Serializable;

/**
 * Records the state of a hint tile for for persistent storage.
 * @author Dylan
 */
public class MomentoLightning implements Serializable{

	/**
	 * Unique tag for momentos of this type on disk
	 */
	private static final long serialVersionUID = 5239958016301296619L;
	
	/**
	 * Parameters that need to be stored are passed as copies and stored in
	 * local, package protected fields. This information can then later be
	 * reconstituted. 
	 * @param
	 */
	public MomentoLightning() {

	}
}
