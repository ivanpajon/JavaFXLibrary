package fxexeceptions;

public class SceneNotSet extends Exception {
	private static final long serialVersionUID = 8316916157705665051L;
	
	public SceneNotSet() {
		super("Scene can't be null");
	}
	
	public SceneNotSet(String message) {
		super(message);
	}

}
