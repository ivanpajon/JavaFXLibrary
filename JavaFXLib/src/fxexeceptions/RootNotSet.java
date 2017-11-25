package fxexeceptions;

/**
 * <h1>This class captures errors if not set any root</h1>
 * @author Ivan Zhen
 * @version 1.0
 */
public class RootNotSet extends Exception {
	private static final long serialVersionUID = 3916639037484347802L;
	
	/**
	 * Creates a new RootNotSet error with default message
	 */
	public RootNotSet() {
		super("Root can't be null");
	}
	
	/**
	 * Creates a new RootNotSet error with custom message
	 * @param message Message to show in error description
	 */
	public RootNotSet(String message) {
		super(message);
	}

}
