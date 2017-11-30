package fxwindow.fxtoolbar;

import fxexeceptions.ImageNotSet;
import fxwindow.fxresize.FXResize;
import javafx.animation.FadeTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * <h1>This class allow to manage basic actions for window</h1>
 * @author Ivan Zhen
 * @version 1.0
 */
public class FXToolbar {
	private AnchorPane root;
	private Image minimizeIcon;
    private Image maximizeIcon;
	
    /**
     * Creates empty FXToolbar object
     */
	public FXToolbar() {
		
	}
	
	/**
	 * Creates FXToolbar object with root element of stage
	 * @param root Root element of the stage as AnchorPane
	 */
	public FXToolbar(AnchorPane root) {
		this.root = root;
	}
	
	/**
	 * Creates FXToolbar object with root element of stage and icons for minimize and maximize
	 * @param root			Root element of the stage as AnchorPane
	 * @param minimizeIcon	Image for button when window is maximized
	 * @param maximizeIcon	Image for button when window is minimized
	 */
	public FXToolbar(AnchorPane root, Image minimizeIcon, Image maximizeIcon) {
		this.root = root;
		
		this.minimizeIcon = minimizeIcon;
		this.maximizeIcon = maximizeIcon;
	}
	
	/**
	 * Sets root elemet of stage for FXToolbar object
	 * @param root Root element of the stage as AnchorPane
	 */
	public void setContext(AnchorPane root) {
		this.root = root;
	}
	
	/**
	 * Sets image for minimize
	 * @param minimizeIcon Image for button when window is maximized
	 */
	public void setMinimizeIcon(Image minimizeIcon) {
		this.minimizeIcon = minimizeIcon;
	}
	
	/**
	 * Sets image for maximize
	 * @param maximizeIcon Image for button when window is minimized
	 */
	public void setMaximizeIcon(Image maximizeIcon) {
		this.maximizeIcon = maximizeIcon;
	}
	
	/**
	 * Returns minimize image
	 * @return Minimize image
	 */
	public Image getMinimizeIcon() {
		return minimizeIcon;
	}
	
	/**
	 * Returns maximize image
	 * @return Maximize image
	 */
	public Image getMaximizeIcon() {
		return maximizeIcon;
	}
	
	/**
	 * Closes window with transition
	 */
	public void closeWindow() {
		FadeTransition ft = new FadeTransition();
		ft.setDuration(Duration.millis(250));
		ft.setNode(root);
		ft.setFromValue(1);
		ft.setToValue(0);
		ft.setOnFinished(e -> closeAction());
		ft.play();
	}
	
	/**
	 * Closes window when transition finishes
	 */
	private void closeAction() {
		Stage stage = (Stage) root.getScene().getWindow();
        stage.close();
        for (Thread t : Thread.getAllStackTraces().keySet()) {
    		if (t.getState() == Thread.State.RUNNABLE) {
    			t.interrupt();
    		}
    	}
	}
	
	/**
	 * Maximizes and minimizes window
	 */
	public void maximizeWindow() {
		Stage stage = (Stage) root.getScene().getWindow();
		
        if (!stage.isMaximized()) {
            stage.setMaximized(true);
        }
        else {
            stage.setMaximized(false);
        }
    }
	
	/**
	 * Maximizes and minimizes window and disable or enable resizing
	 * @param fxresize Object FXResize only if you are using resizing
	 */
	public void maximizeWindow(FXResize fxresize) {
		Stage stage = (Stage) root.getScene().getWindow();
		
        if (!stage.isMaximized()) {
            stage.setMaximized(true);
            fxresize.disableResizing();
        }
        else {
            stage.setMaximized(false);
            fxresize.enableResizing();
        }
    }
	
	/**
	 * Maximizes or minimizes window and manages maximize and minimize images for ImageView
	 * @param imgMaximize ImageView for maximize and minimize button
	 */
	public void maximizeWindow(ImageView imgMaximize) {
		try {
			Stage stage = (Stage) root.getScene().getWindow();
			
			if (minimizeIcon == null || maximizeIcon == null) {
				throw new ImageNotSet();
			}
			
	        if (!stage.isMaximized()) {
	            stage.setMaximized(true);
	            imgMaximize.setImage(minimizeIcon);
	        }
	        else {
	            stage.setMaximized(false);
	            imgMaximize.setImage(maximizeIcon);
	        }
		}
		catch(ImageNotSet ins) {
			ins.printStackTrace();
		}
    }
	
	/**
	 * Maximizes or minimizes window, disable or enable resizing, and manages maximize and minimize images for ImageView
	 * @param fxresize		Object FXResize only if you are using resizing
	 * @param imgMaximize	ImageView for maximize and minimize button
	 */
	public void maximizeWindow(FXResize fxresize, ImageView imgMaximize) {
		try {
			Stage stage = (Stage) root.getScene().getWindow();
			
			if (minimizeIcon == null || maximizeIcon == null) {
				throw new ImageNotSet();
			}
			
	        if (!stage.isMaximized()) {
	            stage.setMaximized(true);
	            fxresize.disableResizing();
	            imgMaximize.setImage(minimizeIcon);
	        }
	        else {
	            stage.setMaximized(false);
	            fxresize.enableResizing();
	            imgMaximize.setImage(maximizeIcon);
	        }
		}
		catch(ImageNotSet ins) {
			ins.printStackTrace();
		}
    }
	
	/**
	 * Iconifies window
	 */
	public void iconifyWindow() {
		Stage stage = (Stage) root.getScene().getWindow();
        stage.setIconified(true);
    }
	
}
