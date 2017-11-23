package fxexeceptions;

public class RootNotSet extends Exception {
	private static final long serialVersionUID = 3916639037484347802L;
	
	public RootNotSet() {
		super("Root can't be null");
	}
	
	public RootNotSet(String message) {
		super(message);
	}

}
