package fxexeceptions;

public class UrlNotSet extends Exception {
	private static final long serialVersionUID = -8133437171497735464L;
	
	public UrlNotSet() {
		super("Url can't be null");
	}
	
	public UrlNotSet(String message) {
		super(message);
	}

}
