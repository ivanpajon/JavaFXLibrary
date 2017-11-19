package fxexeceptions;

/**
 * This class captures errors if not set any image
 * @author Ivan Zhen
 * @version 1.0
 */
public class ImageNotSet extends Exception {
	private static final long serialVersionUID = 919409365054623198L;
	
	/**
	 * Creates a new ImageNotSet error with default message
	 */
	public ImageNotSet() {
		super("Image can't be null");
	}
	
	/**
	 * Creates a new ImageNotSet error with custom message
	 * @param message Message to show in error description
	 */
	public ImageNotSet(String message) {
		super(message);
	}
	
}
