import javafx.scene.input.MouseEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {
  private View view;
  private Scene scene;
  private StringBuilder sb;

  public Controller(View view) {
    this.view = view;
    scene = new Scene(view.getRoot(), 400., 400.);
    sb = new StringBuilder();
  }

  public void showViewOn(Stage stage) {
    stage.setTitle("Event Handling: dispatcher chain");
    stage.setScene(scene);
    stage.show();
  }

  public void showViewAndWaitOn(Stage stage) {
    stage.setTitle("Event Handling: dispatcher chain");
    stage.setScene(scene);
    stage.showAndWait();
  }

  public void registerEventsAlongTheChain(Stage stage) {
    // default event capturing and bubbling chain
    // event capturing: from root to leaf, invokes event-filter method
    stage.addEventFilter(MouseEvent.MOUSE_CLICKED, new MouseEventHandler(sb, "stage's event filter"));
    scene.addEventFilter(MouseEvent.MOUSE_CLICKED, new MouseEventHandler(sb, "scene's event filter"));
    view.getRoot().addEventFilter(MouseEvent.MOUSE_CLICKED, new MouseEventHandler(sb, "root's event filter"));
    view.getRectangle().addEventFilter(MouseEvent.MOUSE_CLICKED, new MouseEventHandler(sb, "rectangle's event filter"));
    view.getPane().addEventFilter(MouseEvent.MOUSE_CLICKED, new MouseEventHandler(sb, "pane's event filter"));
    view.getCircle().addEventFilter(MouseEvent.MOUSE_CLICKED, new MouseEventHandler(sb, "circle's event filter"));
    view.getTriangle().addEventFilter(MouseEvent.MOUSE_CLICKED, new MouseEventHandler(sb, "triangle's event filter"));

    // event bubbling, in reverse order, invoke event handler
    stage.addEventHandler(MouseEvent.MOUSE_CLICKED, new MouseEventHandler(sb, "stage's event handler"));
    scene.addEventHandler(MouseEvent.MOUSE_CLICKED, new MouseEventHandler(sb, "scene's event handler"));
    view.getRoot().addEventHandler(MouseEvent.MOUSE_CLICKED, new MouseEventHandler(sb, "root's event handler"));
    view.getRectangle().addEventHandler(MouseEvent.MOUSE_CLICKED, new MouseEventHandler(sb, "rectangle's event handler"));
    view.getPane().addEventHandler(MouseEvent.MOUSE_CLICKED, new MouseEventHandler(sb, "pane's event handler"));
    view.getCircle().addEventHandler(MouseEvent.MOUSE_CLICKED, new MouseEventHandler(sb, "circle's event handler"));
    view.getTriangle().addEventHandler(MouseEvent.MOUSE_CLICKED, new MouseEventHandler(sb, "triangle's event handler"));


    // circle.setOnMouseclicked (...) is almost equivalent to (with exception that it is being excecuted
    // last if there is more than one event handler for this node)
    // circle.addEventHandler(MouseEvent.MOUSE_CLICKED, ...);
    // view.getCircle().setOnMouseClicked(new MouseEventHandler(sb, "circle's onMouseClicked"));
    // view.getTriangle().setOnMouseClicked(new MouseEventHandler(sb, "triangle's onMouseClicked"));
    // view.getRectangle().setOnMouseClicked(new MouseEventHandler(sb, "rectangle's onMouseClicked"));
    // view.getPane().setOnMouseClicked(new MouseEventHandler(sb, "pane's onMouseClicked"));
    // view.getRoot().setOnMouseClicked(new MouseEventHandler(sb, "root's onMouseClicked"));
    // scene.setOnMouseClicked(new MouseEventHandler(sb, "scene's onMouseClicked"));
  }

  public String getEventProcessingMessage() {
    return sb.toString();
  }
}
