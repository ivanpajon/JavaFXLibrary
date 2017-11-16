package fxwindow.fxresize;

import java.util.ArrayList;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FXResize {
	
	private AnchorPane root;
	private Pane paneUp, paneRight, paneDown, paneLeft, paneUpLeft, paneUpRight, paneDownRight, paneDownLeft;
	private ArrayList<Pane> panes;
	private double initY, initX, initWidth, initHeight;
	
	public FXResize() {
		panes = new ArrayList<Pane>();
		panesToArrayList(this.panes);
	}
	
	public FXResize(AnchorPane root) {
		this.root = root;
		
		panes = new ArrayList<Pane>();
		panesToArrayList(this.panes);
	}
	
	public FXResize(AnchorPane root, Pane paneUp, Pane paneRight, Pane paneDown, Pane paneLeft) {
		this.root = root;
		
		this.paneUp = paneUp;
		this.paneRight = paneRight;
		this.paneDown = paneDown;
		this.paneLeft = paneLeft;
		
		panes = new ArrayList<Pane>();
		panesToArrayList(this.panes);
	}
	
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
	
	public void setCornerPanes(Pane paneUpLeft, Pane paneUpRight, Pane paneDownRight, Pane paneDownLeft) {
		this.paneUpLeft = paneUpLeft;
		this.paneUpRight = paneUpRight;
		this.paneDownRight = paneDownRight;
		this.paneDownLeft = paneDownLeft;
	}
	
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
    
    public void resizeCornerPressed(MouseEvent e) {
    	Stage stage = (Stage) root.getScene().getWindow();
        
        initHeight = stage.getHeight();
        initY = stage.getY();
        
        initWidth = stage.getWidth();
        initX = stage.getX();
    }
    
    public void resizeUpLeftDragged(MouseEvent e) {
    	Stage stage = (Stage) root.getScene().getWindow();
        
    	stage.setHeight(initHeight-(e.getScreenY()-initY));
        stage.setY(e.getScreenY());
        
        stage.setWidth(initWidth+(initX-e.getScreenX()));
        stage.setX(e.getScreenX());
    }
    
    public void resizeUpRightDragged(MouseEvent e) {
    	Stage stage = (Stage) root.getScene().getWindow();
        
    	stage.setHeight(initHeight-(e.getScreenY()-initY));
        stage.setY(e.getScreenY());
        
        stage.setWidth(e.getScreenX()-initX);
    }
    
    public void resizeDownRightDragged(MouseEvent e) {
    	Stage stage = (Stage) root.getScene().getWindow();
        
        stage.setHeight(e.getScreenY()-initY);
        
        stage.setWidth(e.getScreenX()-initX);
    }
    
    public void resizeDownLeftDragged(MouseEvent e) {
    	Stage stage = (Stage) root.getScene().getWindow();
        
        stage.setHeight(e.getScreenY()-initY);
        
        stage.setWidth(initWidth+(initX-e.getScreenX()));
        stage.setX(e.getScreenX());
    }
    
    public void disableResizing() {
    	for (Pane p : panes) {
    		if (p != null) {
    			p.setVisible(false);
    		}
    	}
    }
    
    public void enableResizing() {
    	for (Pane p : panes) {
    		if (p != null) {
    			p.setVisible(true);
    		}
    	}
    }
    
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
