# JavaFXLibrary

This library is created to allow doing most common actions on JavaFX easily.

You can download **FXLib** [here](https://github.com/ivanzhenlms/JavaFXLibrary/raw/master/JavaFXLib/FXLib.jar).

Or if you prefer, you can see and download and example using this library [here](https://github.com/ivanzhenlms/JavaFXLibraryTest).

This project needs you configure _build-path_.

## FXThread package

This package is used to create and manage **Threads** in **JavaFX**.

### Create a thread
First you need is create a **FXThread** object, and then initialize it:

```java
private FXThread t1;

@Override
public void initialize(URL url, ResourceBundle rb) {
  t1 = new FXThread();
  t2 = new FXThread();
}
```

Now, you need a function to do:

```java
private void runTask() {
  try {
    while (true) {
      if (Platform.isFxApplicationThread()) {
        new Runnable() {
          public void run( ) {
            System.out.println("Running!");
          }
        };
      }
      else {
        Platform.runLater(
        new Runnable() {
          public void run( ) {
            System.out.println("Running!");
          }
        }
      );
      }
      Thread.sleep(100);  // Little delay to prevent program crash
    }
  }
  catch (InterruptedException e) {
    System.out.println(e);
  }
```

Once you have done this, let's make the main function:

```java
private void startTask() {
  Runnable task = () -> runTask();  // Only needed if don't use lambda

  // Both methods are allowed to asign the task
  t1.setTask(task);
  //t1.setTask(() -> runTask(l));
  
  // Create the thread with the task and then start it
  t1.createThread();
  t1.startThread();
}
```

**NOTE**: Order is relevant, when we have already create and initialize FXThread object and a runnable with the function you want to do, must to do this in order:
* Use **setTask()**
* Use **createThread()**
* Use **startThread()**

## FXWindow

This package contains **FXMove** and **FXResize**. You can create as many objects as you need.

### FXMove

When you create a **FXMove** object you must to give an **AnchorPane** to the constructor.
See principal functions here:
* **movePressed(_MouseEvent e_)**
* **moveDragged(_MouseEvent e_)**
* **dragToUp(_MouseEvent e_)**
* **dragToCenter(_MouseEvent e_)**
* **isDraggedToUp(_MouseEvent e_)**

### FXResize

When you create a **FXResize** object you must to give an **AnchorPane** to the constructor, and all **Panes** for resizing a window (paneUp, paneRight, paneDown, paneLeft, paneUpLeft, paneUpRight, paneDownRight, paneDownLeft) following **clockwise** direction. Also, you have many different constructors like:
* **FXResize()**
* **FXResize(_AnchorPane root_)**
* **FXResize(_AnchorPane root, Pane paneUp, Pane paneRight, Pane paneDown, Pane paneLeft_)**
* **FXResize(_AnchorPane root, Pane paneUp, Pane paneRight, Pane paneDown, Pane paneLeft, Pane paneUpLeft, Pane paneUpRight, Pane paneDownRight, Pane paneDownLeft_)**

> I strongly recommend to use the last constructor.

Main functions of **FXResize** class are the following:
* **setContext(**_AnchorPane root_**)**
* **setPaneUp(_Pane paneUp_)**
* **setPaneRight(_Pane paneRight_)**
* **setPaneDown(_Pane paneDown_)**
* **setPaneLeft(_Pane paneLeft_)**
* **setVerticalPanes(_Pane paneUp, Pane paneDown_)**
* **setHorizontalPanes(_Pane paneLeft, Pane paneRight_)**
* **setCornerPanes(_Pane paneUpLeft, Pane paneUpRight, Pane paneDownRight, Pane paneDownLeft_)**
* **setAllPanes(_Pane paneUp, Pane paneRight, Pane paneDown, Pane paneLeft, Pane paneUpLeft, Pane paneUpRight, Pane paneDownRight, Pane paneDownLeft_)**
* **resizeVerticalPressed(_MouseEvent e_)**
* **resizeUpDragged(_MouseEvent e_)**
* **resizeDownDragged(_MouseEvent e_)**
* **resizeHorizontalPressed(_MouseEvent e_)**
* **resizeLeftDragged(_MouseEvent e_)**
* **resizeRightDragged(_MouseEvent e_)**
* **resizeCornerPressed(_MouseEvent e_)**
* **resizeUpLeftDragged(_MouseEvent e_)**
* **resizeUpRightDragged(_MouseEvent e_)**
* **resizeDownRightDragged(_MouseEvent e_)**
* **resizeDownLeftDragged(_MouseEvent e_)**
* **disableResizing()**
* **enableResizing()**

> **NOTE:** _disableResizing()_ and _enableResizing()_ actually only work if you setted out all panes.
