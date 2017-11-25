package fxwindow.fxstage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Paths;

import fxexeceptions.RootNotSet;
import fxexeceptions.SceneNotSet;
import fxexeceptions.UrlNotSet;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * <h1>This class allows to manage stages and basic actions for them</h1>
 * @author Ivan Zhen
 * @version 1.0
 */
public class FXStage {
	private String url;
	private String title;
	private boolean undecorated;
	private AnchorPane root;
	private Scene scene;
	private Stage stage;
	
	/**
	 * Creates empty FXStage object.
	 */
	public FXStage() {
		this.undecorated = false;
	}
	
	/**
	 * Creates FXStage object with root element of stage.
	 * @param root Root element of the stage as AnchorPane.
	 */
	public FXStage(AnchorPane root) {
		this.root = root;
		
		this.undecorated = false;
	}
	
	/**
	 * Creates FXStage object with url for open a new stage with it or refresh the actually.
	 * @param url Path to fxml archive relative to the project folder.
	 */
	public FXStage(String url) {
		this.url = url;
		
		this.undecorated = false;
	}
	
	/**
	 * Creates FXStage object with root element of stage and with url for open a new stage with it or refresh the current one.
	 * @param root Root element of the stage as AnchorPane.
	 * @param url Path to fxml archive relative to the project folder.
	 */
	public FXStage(AnchorPane root, String url) {
		this.root = root;
		this.url = url;
		
		this.undecorated = false;
	}
	
	/**
	 * Sets root elemet of stage for FXToolbar object.
	 * @param root Root element of the stage as AnchorPane.
	 */
	public void setContext(AnchorPane root) {
		this.root = root;
	}
	
	/**
	 * Sets the relative path to fxml archive.
	 * @param url Path to fxml archive relative to the project folder.
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * Sets title for the new stage.
	 * @param title Title for the new stage.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Sets the scene by giving it the url to fxml archive.
	 * @param url Path to fxml archive relative to the project folder.
	 */
	public void setScene(String url) {
		try {
			this.url = url;
			this.root = FXMLLoader.load(Paths.get(url).toUri().toURL());
	        this.scene = new Scene(this.root);
		}
		catch (IOException e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Sets if the new stage will be decorated or undecorated.
	 * @param b True for new undecorated stage, false for new decorated stage.
	 */
	public void setUndecorated(Boolean b) {
		this.undecorated = b;
	}
	
	/**
	 * Refresh current scene by giving it the url to fxml archive.
	 * @param url Path to fxml archive relative to the project folder.
	 */
	public void updateScene(String url) {
		try {
			if (this.root == null) {throw new RootNotSet();}
			this.stage = (Stage) this.root.getScene().getWindow();
			this.url = url;
			
			this.root = FXMLLoader.load(Paths.get(this.url).toUri().toURL());
			this.scene = new Scene(this.root);
		}
		catch (MalformedURLException e) {
			System.out.println(e);
		}
		catch (IOException e) {
			System.out.println(e);
		}
		catch (RootNotSet rns) {
			rns.printStackTrace();
		}
		
		this.stage.setScene(this.scene);
		this.stage.setTitle(this.title);
		this.stage.show();
	}
	
	/**
	 * Refresh current scene. Make sure you have set an url in your FXStage object.
	 */
	public void updateScene() {
		try {
			if (this.root == null) {throw new RootNotSet();}
			this.stage = (Stage) this.root.getScene().getWindow();
			
			if (this.url != null) {
				this.root = FXMLLoader.load(Paths.get(this.url).toUri().toURL());
				this.scene = new Scene(this.root);
			}
			if (this.scene == null) {throw new SceneNotSet();}
			this.root = FXMLLoader.load(Paths.get(this.url).toUri().toURL());
			this.scene = new Scene(this.root);
		}
		catch (MalformedURLException e) {
			System.out.println(e);
		}
		catch (IOException e) {
			System.out.println(e);
		}
		catch (SceneNotSet sns) {
			sns.printStackTrace();
		}
		catch (RootNotSet rns) {
			rns.printStackTrace();
		}
		
		this.stage.setScene(this.scene);
		this.stage.setTitle(this.title);
		this.stage.show();
	}
	
	/**
	 * Opens a new stage. Make sure you have set an url in your FXStage object.
	 */
	public void open() {
		try {
			if (this.url == null) {throw new UrlNotSet();}
			if (undecorated) {
				this.stage = new Stage();
				this.root = FXMLLoader.load(Paths.get(this.url).toUri().toURL());
		        this.scene = new Scene(this.root);
		        this.stage.setScene(this.scene);
		        this.stage.setTitle(this.title);
		        this.stage.initStyle(StageStyle.TRANSPARENT);
				this.scene.setFill(Color.TRANSPARENT);
		        
		        this.stage.show();
			}
			else {
				this.stage = new Stage();
				this.root = FXMLLoader.load(Paths.get(this.url).toUri().toURL());
		        this.scene = new Scene(this.root);
		        this.stage.setScene(this.scene);
		        this.stage.setTitle(this.title);
		        
		        this.stage.show();
			}
		}
		catch (IOException e) {
			System.out.println(e);
		}
		catch (UrlNotSet e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Closes current stage and their threads without exiting entire application.
	 */
	public void close() {
		this.stage = (Stage) this.root.getScene().getWindow();
        this.stage.close();
        for (Thread t : Thread.getAllStackTraces().keySet()) {
    		if (t.getState() == Thread.State.RUNNABLE) {
    			t.interrupt();
    		}
    	}
	}
}
