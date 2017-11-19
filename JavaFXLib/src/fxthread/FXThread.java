package fxthread;

/**
 * <h1>This class allows to create a Thread and manage it</h1>
 * @author Ivan Zhen
 * @version 1.0
 */
public class FXThread {
	private Thread t;
	private Runnable r;
	
	/**
	 * Creates new empty FXThread
	 */
	public FXThread() {
		
	}
	
	/**
	 * Sets task for run when Thread starts
	 * @param r Runnable for assign to the thread
	 */
	public void setTask(Runnable r) {
		this.r = r;
	}
	
	/**
	 * Creates new Thread with its Runnable
	 */
	public void createThread() {
		this.t = new Thread(this.r);
		this.t.setDaemon(true);
	}
	
	/**
	 * Starts the Thread
	 */
	public void startThread() {
		this.t.start();
	}
	
	/**
	 * Stops the Thread
	 */
	public void stopThread() {
		this.t.interrupt();
	}
}
