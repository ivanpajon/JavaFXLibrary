package fxexeceptions;

/**
 * <h1>This class captures errors if not set any scene</h1>
 * @author Ivan Zhen
 * @version 1.0
 */
public class SceneNotSet extends Exception {
	private static final long serialVersionUID = 8316916157705665051L;
	
	/**
	 * Creates a new SceneNotSet error with default message
	 */
	public SceneNotSet() {
		super("Scene can't be null");
	}
	
	/**
	 * Creates a new SceneNotSet error with custom message
	 * @param message Message to show in error description
	 */
	public SceneNotSet(String message) {
		super(message);
	}

}
