package fxwindow.fxmove;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class FXMove {
	
	private boolean maximized;
	private double initX, initY;

	public FXMove() {
		maximized = false;
	}
	
	public void movePressed(MouseEvent e) {
		if (!maximized) {
		    initX = e.getSceneX();
		    initY = e.getSceneY();
		}
    }
	
	public void moveDragged(MouseEvent e, Stage stage) {
		if (!maximized) {
	        stage.setX(e.getScreenX()-initX);
	        stage.setY(e.getScreenY()-initY);
		}
		else {
			stage.setMaximized(false);
			stage.setX(e.getScreenX()-initX);
	        stage.setY(e.getScreenY()-initY);
	        maximized = false;
		}
	}
}
