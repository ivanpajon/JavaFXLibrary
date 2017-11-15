# JavaFXLibrary

This library is created to allow doing most common actions on JavaFX easily.

## FXThread package

This package is used to create and manage Threads in JavaFX.

### Create a thread
First you need is create a FXThread object, and then initialize it:

```
private FXThread t1;

@Override
public void initialize(URL url, ResourceBundle rb) {
  t1 = new FXThread();
  t2 = new FXThread();
}
```

Now, you need a function to do:

```
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

```
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
