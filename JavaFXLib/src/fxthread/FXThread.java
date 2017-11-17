package fxthread;

public class FXThread {
	private Thread t;
	private Runnable r;
	
	public FXThread() {
		
	}
	
	public FXThread(Runnable r) {
		this.t = new Thread(this.r);
		this.t.setDaemon(true);
	}
	
	public void setTask(Runnable r) {
		this.r = r;
	}
	
	public void createThread() {
		this.t = new Thread(this.r);
		this.t.setDaemon(true);
	}
	
	public void startThread() {
		this.t.start();
	}
	
	public void stopThread() {
		this.t.interrupt();
	}
}
