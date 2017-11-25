package fxexeceptions;

/**
 * <h1>This class captures errors if not set any url</h1>
 * @author Ivan Zhen
 * @version 1.0
 */
public class UrlNotSet extends Exception {
	private static final long serialVersionUID = -8133437171497735464L;
	
	/**
	 * Creates a new UrlNotSet error with default message
	 */
	public UrlNotSet() {
		super("Url can't be null");
	}
	
	/**
	 * Creates a new UrlNotSet error with custom message
	 * @param message Message to show in error description
	 */
	public UrlNotSet(String message) {
		super(message);
	}

}
