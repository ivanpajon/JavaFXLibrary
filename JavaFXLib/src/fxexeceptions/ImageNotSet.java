package fxexeceptions;

public class ImageNotSet extends Exception {
	private static final long serialVersionUID = 919409365054623198L;
	
	public ImageNotSet() {
		super("Image can't be null");
	}
	
	public ImageNotSet(String message) {
		super(message);
	}
	
}
