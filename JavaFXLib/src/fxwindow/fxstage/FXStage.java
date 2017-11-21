package fxwindow.fxstage;

import java.io.IOException;
import java.nio.file.Paths;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FXStage {
	private String url;
	private String title;
	private boolean undecorated;
	private boolean open;
	private AnchorPane root;
	private Scene scene;
	private Stage stage;
	
	public FXStage() {
		this.stage = new Stage();
		this.undecorated = false;
		this.open = false;
	}
	
	public FXStage(String url, String title) {
		this.url = url;
		this.title = title;
		this.stage = new Stage();
		this.undecorated = false;
		this.open = false;
	}
	
	public void open() {
		try {
			if (!open) {
				if (undecorated) {
					this.root = FXMLLoader.load(Paths.get(this.url).toUri().toURL());
			        this.scene = new Scene(this.root);
			        this.stage.setScene(this.scene);
			        this.stage.setTitle(this.title);
			        this.stage.initStyle(StageStyle.TRANSPARENT);
					this.scene.setFill(Color.TRANSPARENT);
			        
			        this.stage.show();
			        this.open = true;
				}
				else {
					this.root = FXMLLoader.load(Paths.get(this.url).toUri().toURL());
			        this.scene = new Scene(this.root);
			        this.stage.setScene(this.scene);
			        this.stage.setTitle(this.title);
			        
			        this.stage.show();
			        this.open = true;
				}
			}
			else {
				this.stage.show();
			}
		}
		catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public void setUndecorated(Boolean b) {
		this.undecorated = b;
	}
}
