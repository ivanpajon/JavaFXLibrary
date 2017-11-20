package fxwindow.fxstage;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXStage {
	private URL url;
	private String title;
	
	public FXStage() {
		
	}
	
	public FXStage(URL url, String title) {
		this.url = url;
		this.title = title;
	}
	
	public void open() {
		try {
			Stage secondaryStage = new Stage();
			AnchorPane root = FXMLLoader.load(getClass().getResource(this.url.getFile().replaceAll("%20", " ")));
	        Scene scene = new Scene(root);
	        secondaryStage.setScene(scene);
	        secondaryStage.setTitle(this.title);
	        
	        secondaryStage.show();
		}
		catch (IOException e) {
			System.out.println(e);
		}
	}
}
