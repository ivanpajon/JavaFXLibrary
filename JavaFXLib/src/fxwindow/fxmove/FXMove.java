package fxwindow.fxmove;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMove {
	
	private AnchorPane root;
	private double initX, initY;

	public FXMove() {
		
	}
	
	public FXMove(AnchorPane root) {
		this.root = root;
	}
	
	public void setContext(AnchorPane root) {
		this.root = root;
	}
	
	public void movePressed(MouseEvent e) {
		Stage stage = (Stage) root.getScene().getWindow();
		
		if (!stage.isMaximized()) {
		    initX = e.getSceneX();
		    initY = e.getSceneY();
		}
    }
	
	public void moveDragged(MouseEvent e) {
		Stage stage = (Stage) root.getScene().getWindow();
		
		if (!stage.isMaximized()) {
	        stage.setX(e.getScreenX()-initX);
	        stage.setY(e.getScreenY()-initY);
		}
		else {
			stage.setMaximized(false);
			stage.setX(e.getScreenX()-initX);
	        stage.setY(e.getScreenY()-initY);
		}
	}
	
	public void dragToUp(MouseEvent e) {
		Stage stage = (Stage) root.getScene().getWindow();
 		
 		if (e.getScreenY() < 10) {
 			stage.setMaximized(true);
 		}
 	}
	
	public void dragToCenter(MouseEvent e) {
		Stage stage = (Stage) root.getScene().getWindow();
 		
 		if (e.getScreenY() >= 10) {
 			stage.setMaximized(false);
 		}
 	}
	
	public boolean isDraggedToUp(MouseEvent e) {
 		if (e.getScreenY() < 10) {
 			return true;
 		}
 		else {
 			return false;
 		}
 	}
}
