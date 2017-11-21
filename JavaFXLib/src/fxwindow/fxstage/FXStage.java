package fxwindow.fxstage;

import java.io.IOException;
import java.nio.file.Paths;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FXStage {
	private String url;
	private String title;
	private boolean undecorated;
	private AnchorPane root;
	private Scene scene;
	private Stage stage;
	
	public FXStage() {
		this.undecorated = false;
	}
	
	public FXStage(String url) {
		this.url = url;
		
		this.undecorated = false;
	}
	
	public FXStage(String url, String title) {
		this.url = url;
		this.title = title;
		
		this.undecorated = false;
	}
	
	public void setContext(AnchorPane root) {
		this.root = root;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setScene(String url) {
		try {
			this.root = FXMLLoader.load(Paths.get(url).toUri().toURL());
	        this.scene = new Scene(this.root);
		}
		catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public void setUndecorated(Boolean b) {
		this.undecorated = b;
	}
	
	public void updateScene(ActionEvent e) {
		this.stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		
		this.stage.setScene(this.scene);
		this.stage.setTitle(this.title);
		this.stage.show();
	}
	
	public void open() {
		try {
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
	}
}
