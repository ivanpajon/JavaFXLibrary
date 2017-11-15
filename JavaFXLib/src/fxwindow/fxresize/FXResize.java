package fxwindow.fxresize;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FXResize {
	
	private AnchorPane root;
	private Pane paneUp, paneRight, paneDown, paneLeft;
	private double initY, initX, initWidth, initHeight;
	
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
	
	public void setVerticalPanes(Pane paneUp, Pane paneDown) {
		this.paneUp = paneUp;
		this.paneDown = paneDown;
	}
	
	public void setHorizontalPanes(Pane paneLeft, Pane paneRight) {
		this.paneLeft = paneLeft;
		this.paneRight = paneRight;
	}
	
	public void setAllPanes(Pane paneUp, Pane paneRight, Pane paneDown, Pane paneLeft) {
		this.paneUp = paneUp;
		this.paneRight = paneRight;
		this.paneDown = paneDown;
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
    
    public void resizeDownDragged(MouseEvent e) {
        Stage stage = (Stage) root.getScene().getWindow();
        
        stage.setHeight(e.getScreenY()-initY);
    }
    
    public void resizeHorizontalPressed(MouseEvent e) {
    	Stage stage = (Stage) root.getScene().getWindow();
        
        initWidth = stage.getWidth();
        initX = stage.getX();
    }
    
    public void resizeLeftDragged(MouseEvent e) {
    	Stage stage = (Stage) root.getScene().getWindow();
        
    	stage.setWidth(initWidth+(initX-e.getScreenX()));
        stage.setX(e.getScreenX());
    }
    
    public void resizeRightDragged(MouseEvent e) {
    	Stage stage = (Stage) root.getScene().getWindow();
        
        stage.setWidth(e.getScreenX()-initX);
    }
}
