package fxwindow.fxresize;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FXResize {
	
	private AnchorPane root;
	private Pane paneUp, paneRight, paneDown, paneLeft;
	private double initY, initHeight;
	
	
	public FXResize() {
		
	}
	
	public FXResize(AnchorPane root) {
		this.root = root;
	}
	
	public FXResize(AnchorPane root, Pane paneUp, Pane paneRight, Pane paneDown, Pane paneLeft) {
		this.root = root;
		
		this.paneUp = paneUp;
		this.paneRight = paneRight;
		this.paneDown = paneDown;
		this.paneLeft = paneLeft;
	}
	
	public void setContext(AnchorPane root) {
		this.root = root;
	}
	
	public void setPaneUp(Pane paneUp) {
		this.paneUp = paneUp;
	}
	
	public void setPaneRight(Pane paneRight) {
		this.paneRight = paneRight;
	}

	public void setPaneDown(Pane paneDown) {
		this.paneDown = paneDown;
	}

	public void setPaneLeft(Pane paneLeft) {
		this.paneLeft = paneLeft;
	}
	
	public void resizeVerticalPressed(MouseEvent e) {
        Stage stage = (Stage) root.getScene().getWindow();
        
        initHeight = stage.getHeight();
        initY = stage.getY();
    }
    
    public void resizeUpDragged(MouseEvent e) {
        Stage stage = (Stage) root.getScene().getWindow();
        
        stage.setHeight(initHeight-(e.getScreenY()-initY));
        stage.setY(e.getScreenY());
    }
}
