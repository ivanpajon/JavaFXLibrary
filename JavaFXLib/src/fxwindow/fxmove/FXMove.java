package fxwindow.fxmove;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * <h1>This class allows to move your undecorated JavaFX window</h1>
 * @author	Ivan Zhen
 * @version	1.0
 */
public class FXMove {
	
	private AnchorPane root;
	private double initX, initY;
	
	/**
	 * Creates empty FXMove object
	 */
	public FXMove() {
		
	}
	
	/**
	 * Creates FXMove object with root element of stage
	 * @param root Root element of the stage as AnchorPane
	 */
	public FXMove(AnchorPane root) {
		this.root = root;
	}
	
	/**
	 * Sets root elemet of stage for FXMove object
	 * @param root Root element of the stage as AnchorPane
	 */
	public void setContext(AnchorPane root) {
		this.root = root;
	}
	
	/**
	 * Captures window position when clicked on move panel
	 * @param e MouseEvent
	 */
	public void movePressed(MouseEvent e) {
		Stage stage = (Stage) root.getScene().getWindow();
		
		if (!stage.isMaximized()) {
		    initX = e.getSceneX();
		    initY = e.getSceneY();
		}
    }
	
	/**
	 * Move the window when drag the move panel
	 * @param e MouseEvent
	 */
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
	
	/**
	 * Maximize the window when its dragged to upper and released
	 * @param e MouseEvent
	 */
	public void dragToUp(MouseEvent e) {
		Stage stage = (Stage) root.getScene().getWindow();
 		
 		if (e.getScreenY() < 10) {
 			stage.setMaximized(true);
 		}
 	}
	
	/**
	 * Minimizes the window when it is maximized and is dragged to the center
	 * @param e MouseEvent
	 */
	public void dragToCenter(MouseEvent e) {
		Stage stage = (Stage) root.getScene().getWindow();
 		
 		if (e.getScreenY() >= 10) {
 			stage.setMaximized(false);
 		}
 	}
	
	/**
	 * Check if window is dragged to upper
	 * @param e	MouseEvent
	 * @return	True if window it is dragged to upper or false if doesn't
	 */
	public boolean isDraggedToUp(MouseEvent e) {
 		if (e.getScreenY() < 10) {
 			return true;
 		}
 		else {
 			return false;
 		}
 	}
}
