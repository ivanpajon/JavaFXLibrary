package fxwindow.fxtoolbar;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXToolbar {
	private AnchorPane root;
	
	public FXToolbar() {
		
	}
	
	public FXToolbar(AnchorPane root) {
		this.root = root;
	}
	
	public void setContext(AnchorPane root) {
		this.root = root;
	}
	
	public void closeWindow() {
		Stage stage = (Stage) root.getScene().getWindow();
        stage.close();
	}
}
