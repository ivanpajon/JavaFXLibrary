package fxwindow.fxresize;

import java.util.ArrayList;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * <h1>This class allows to resize your undecorated window</h1>
 * @author	Ivan Zhen
 * @version	1.0
 */
public class FXResize {
	
	private AnchorPane root;
	private Pane paneUp, paneRight, paneDown, paneLeft, paneUpLeft, paneUpRight, paneDownRight, paneDownLeft;
	private ArrayList<Pane> panes;
	private double initY, initX, initWidth, initHeight;
	
	/**
	 * Creates empty FXResize object.
	 */
	public FXResize() {
		panes = new ArrayList<Pane>();
		panesToArrayList(this.panes);
	}
	
	/**
	 * Creates FXResize object with root element of stage.
	 * @param root Root element of the stage as AnchorPane.
	 */
	public FXResize(AnchorPane root) {
		this.root = root;
		
		panes = new ArrayList<Pane>();
		panesToArrayList(this.panes);
	}
	
	/**
	 * Creates FXResize object with root element of stage and vertical and horizontal panes for resizing the window.
	 * @param root		Root element of the stage as AnchorPane.
	 * @param paneUp	Pane element of the stage for resize to up.
	 * @param paneRight	Pane element of the stage for resize to right.
	 * @param paneDown	Pane element of the stage for resize to down.
	 * @param paneLeft	Pane element of the stage for resize to left.
	 */
	public FXResize(AnchorPane root, Pane paneUp, Pane paneRight, Pane paneDown, Pane paneLeft) {
		this.root = root;
		
		this.paneUp = paneUp;
		this.paneRight = paneRight;
		this.paneDown = paneDown;
		this.paneLeft = paneLeft;
		
		panes = new ArrayList<Pane>();
		panesToArrayList(this.panes);
	}
	
	/**
	 * Creates FXResize object with root element of stage and vertical, horizontal and diagonal panes for resizing the window.
	 * @param root			Root element of the stage as AnchorPane.
	 * @param paneUp		Pane element of the stage for resize to up.
	 * @param paneRight		Pane element of the stage for resize to right.
	 * @param paneDown		Pane element of the stage for resize to down.
	 * @param paneLeft		Pane element of the stage for resize to left.
	 * @param paneUpLeft	Pane element of the stage for resize to up and left.
	 * @param paneUpRight	Pane element of the stage for resize to up and right.
	 * @param paneDownRight	Pane element of the stage for resize to down and right.
	 * @param paneDownLeft	Pane element of the stage for resize to down and left.
	 */
	public FXResize(AnchorPane root, Pane paneUp, Pane paneRight, Pane paneDown, Pane paneLeft, Pane paneUpLeft, Pane paneUpRight, Pane paneDownRight, Pane paneDownLeft) {
		this.root = root;
		
		this.paneUp = paneUp;
		this.paneRight = paneRight;
		this.paneDown = paneDown;
		this.paneLeft = paneLeft;
		
		this.paneUpLeft = paneUpLeft;
		this.paneUpRight = paneUpRight;
		this.paneDownRight = paneDownRight;
		this.paneDownLeft = paneDownLeft;
		
		panes = new ArrayList<Pane>();
		panesToArrayList(this.panes);
	}
	
	/**
	 * Sets root elemet of stage for FXResize object.
	 * @param root Root element of the stage as AnchorPane.
	 */
	public void setContext(AnchorPane root) {
		this.root = root;
	}
	
	/**
	 * Sets upper pane.
	 * @param paneUp Pane element of the stage for resize to up.
	 */
	public void setPaneUp(Pane paneUp) {
		this.paneUp = paneUp;
	}
	
	/**
	 * Sets right pane.
	 * @param paneRight Pane element of the stage for resize to right.
	 */
	public void setPaneRight(Pane paneRight) {
		this.paneRight = paneRight;
	}
	
	/**
	 * Sets bottom pane.
	 * @param paneDown Pane element of the stage for resize to down.
	 */
	public void setPaneDown(Pane paneDown) {
		this.paneDown = paneDown;
	}
	
	/**
	 * Sets left pane.
	 * @param paneLeft Pane element of the stage for resize to left.
	 */
	public void setPaneLeft(Pane paneLeft) {
		this.paneLeft = paneLeft;
	}
	
	/**
	 * Sets vertical panes.
	 * @param paneUp	Pane element of the stage for resize to up.
	 * @param paneDown	Pane element of the stage for resize to down.
	 */
	public void setVerticalPanes(Pane paneUp, Pane paneDown) {
		this.paneUp = paneUp;
		this.paneDown = paneDown;
	}
	
	/**
	 * Sets horizontal panes.
	 * @param paneLeft	Pane element of the stage for resize to left.
	 * @param paneRight	Pane element of the stage for resize to right.
	 */
	public void setHorizontalPanes(Pane paneLeft, Pane paneRight) {
		this.paneLeft = paneLeft;
		this.paneRight = paneRight;
	}
	
	/**
	 * Sets corner panes.
	 * @param paneUpLeft	Pane element of the stage for resize to upper left.
	 * @param paneUpRight	Pane element of the stage for resize to upper right.
	 * @param paneDownRight	Pane element of the stage for resize to bottom right.
	 * @param paneDownLeft	Pane element of the stage for resize to bottom left.
	 */
	public void setCornerPanes(Pane paneUpLeft, Pane paneUpRight, Pane paneDownRight, Pane paneDownLeft) {
		this.paneUpLeft = paneUpLeft;
		this.paneUpRight = paneUpRight;
		this.paneDownRight = paneDownRight;
		this.paneDownLeft = paneDownLeft;
	}
	
	/**
	 * Sets all panes.
	 * @param paneUp		Pane element of the stage for resize to up.
	 * @param paneRight		Pane element of the stage for resize to right.
	 * @param paneDown		Pane element of the stage for resize to down.
	 * @param paneLeft		Pane element of the stage for resize to left.
	 * @param paneUpLeft	Pane element of the stage for resize to upper left.
	 * @param paneUpRight	Pane element of the stage for resize to upper right.
	 * @param paneDownRight	Pane element of the stage for resize to down right.
	 * @param paneDownLeft	Pane element of the stage for resize to down left.
	 */
	public void setAllPanes(Pane paneUp, Pane paneRight, Pane paneDown, Pane paneLeft, Pane paneUpLeft, Pane paneUpRight, Pane paneDownRight, Pane paneDownLeft) {
		this.paneUp = paneUp;
		this.paneRight = paneRight;
		this.paneDown = paneDown;
		this.paneLeft = paneLeft;
		
		this.paneUpLeft = paneUpLeft;
		this.paneUpRight = paneUpRight;
		this.paneDownRight = paneDownRight;
		this.paneDownLeft = paneDownLeft;
	}
	
	/**
	 * Captures window position and dimensions when clicked on vertical resize panel.
	 * @param e MouseEvent.
	 */
	public void resizeVerticalPressed(MouseEvent e) {
        Stage stage = (Stage) root.getScene().getWindow();
        
        initHeight = stage.getHeight();
        initY = stage.getY();
    }
    
	/**
	 * Resizes window when upper pane its dragged.
	 * @param e MouseEvent.
	 */
    public void resizeUpDragged(MouseEvent e) {
        Stage stage = (Stage) root.getScene().getWindow();
        
        stage.setHeight(initHeight-(e.getScreenY()-initY));
        stage.setY(e.getScreenY());
    }
    
    /**
     * Resizes window when bottom pane its dragged.
     * @param e MouseEvent.
     */
    public void resizeDownDragged(MouseEvent e) {
        Stage stage = (Stage) root.getScene().getWindow();
        
        stage.setHeight(e.getScreenY()-initY);
    }
    
    /**
     * Captures window position and dimensions when clicked on horizontal resize panel.
     * @param e MouseEvent.
     */
    public void resizeHorizontalPressed(MouseEvent e) {
    	Stage stage = (Stage) root.getScene().getWindow();
        
        initWidth = stage.getWidth();
        initX = stage.getX();
    }
    
    /**
     * Resizes window when left pane its dragged.
     * @param e MouseEvent.
     */
    public void resizeLeftDragged(MouseEvent e) {
    	Stage stage = (Stage) root.getScene().getWindow();
        
    	stage.setWidth(initWidth+(initX-e.getScreenX()));
        stage.setX(e.getScreenX());
    }
    
    /**
     * Resizes window when right pane its dragged.
     * @param e MouseEvent.
     */
    public void resizeRightDragged(MouseEvent e) {
    	Stage stage = (Stage) root.getScene().getWindow();
        
        stage.setWidth(e.getScreenX()-initX);
    }
    
    /**
     * Captures window position and dimensions when clicked on corner resize panel.
     * @param e MouseEvent.
     */
    public void resizeCornerPressed(MouseEvent e) {
    	Stage stage = (Stage) root.getScene().getWindow();
        
        initHeight = stage.getHeight();
        initY = stage.getY();
        
        initWidth = stage.getWidth();
        initX = stage.getX();
    }
    
    /**
     * Resizes window when upper left pane its dragged.
     * @param e MouseEvent.
     */
    public void resizeUpLeftDragged(MouseEvent e) {
    	Stage stage = (Stage) root.getScene().getWindow();
        
    	stage.setHeight(initHeight-(e.getScreenY()-initY));
        stage.setY(e.getScreenY());
        
        stage.setWidth(initWidth+(initX-e.getScreenX()));
        stage.setX(e.getScreenX());
    }
    
    /**
     * Resizes window when upper right pane its dragged.
     * @param e MouseEvent.
     */
    public void resizeUpRightDragged(MouseEvent e) {
    	Stage stage = (Stage) root.getScene().getWindow();
        
    	stage.setHeight(initHeight-(e.getScreenY()-initY));
        stage.setY(e.getScreenY());
        
        stage.setWidth(e.getScreenX()-initX);
    }
    
    /**
     * Resizes window when bottom right pane its dragged.
     * @param e MouseEvent.
     */
    public void resizeDownRightDragged(MouseEvent e) {
    	Stage stage = (Stage) root.getScene().getWindow();
        
        stage.setHeight(e.getScreenY()-initY);
        
        stage.setWidth(e.getScreenX()-initX);
    }
    
    /**
     * Resizes window when bottom left pane its dragged.
     * @param e MouseEvent.
     */
    public void resizeDownLeftDragged(MouseEvent e) {
    	Stage stage = (Stage) root.getScene().getWindow();
        
        stage.setHeight(e.getScreenY()-initY);
        
        stage.setWidth(initWidth+(initX-e.getScreenX()));
        stage.setX(e.getScreenX());
    }
    
    /**
     * Disable window resizing for all setted panes.
     */
    public void disableResizing() {
    	for (Pane p : panes) {
    		if (p != null) {
    			p.setVisible(false);
    		}
    	}
    }
    
    /**
     * Enable window resizing for all setted panes.
     */
    public void enableResizing() {
    	for (Pane p : panes) {
    		if (p != null) {
    			p.setVisible(true);
    		}
    	}
    }
    
    /**
     * Loads all panes inside an ArrayList.
     * @param panes ArrayList to load panes inside it.
     */
    private void panesToArrayList(ArrayList<Pane> panes) {
    	panes.add(this.paneUp);
    	panes.add(this.paneRight);
    	panes.add(this.paneDown);
    	panes.add(this.paneLeft);
    	
    	panes.add(this.paneUpLeft);
    	panes.add(this.paneUpRight);
    	panes.add(this.paneDownRight);
    	panes.add(this.paneDownLeft);
    }
}
