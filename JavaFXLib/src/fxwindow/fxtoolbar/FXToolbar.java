package fxwindow.fxtoolbar;

import fxexeceptions.ImageNotSet;
import fxwindow.fxresize.FXResize;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXToolbar {
	private AnchorPane root;
	private Image minimizeIcon;
    private Image maximizeIcon;
	
	public FXToolbar() {
		
	}
	
	public FXToolbar(AnchorPane root) {
		this.root = root;
	}
	
	public FXToolbar(AnchorPane root, Image minimizeIcon, Image maximizeIcon) {
		this.root = root;
		
		this.minimizeIcon = minimizeIcon;
		this.maximizeIcon = maximizeIcon;
	}
	
	public void setContext(AnchorPane root) {
		this.root = root;
	}
	
	public void setMinimizeIcon(Image minimizeIcon) {
		this.minimizeIcon = minimizeIcon;
	}

	public void setMaximizeIcon(Image maximizeIcon) {
		this.maximizeIcon = maximizeIcon;
	}
	
	public Image getMinimizeIcon() {
		return minimizeIcon;
	}

	public Image getMaximizeIcon() {
		return maximizeIcon;
	}

	public void closeWindow() {
		Stage stage = (Stage) root.getScene().getWindow();
        stage.close();
	}
	
	public void maximizeWindow() {
		Stage stage = (Stage) root.getScene().getWindow();
		
        if (!stage.isMaximized()) {
            stage.setMaximized(true);
        }
        else {
            stage.setMaximized(false);
        }
    }
	
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
	
	public void iconifyWindow() {
		Stage stage = (Stage) root.getScene().getWindow();
        stage.setIconified(true);
    }
	
}
