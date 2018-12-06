import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class View {
  private Group rootGroup;
  private Pane pane;
  private Rectangle rectangle;
  private Circle circle;
  private Polygon triangle;

  public View() {
    rootGroup = new Group();

    rectangle = new Rectangle(400., 100., Color.BLUE);
		rectangle.setX(0);
		rectangle.setY(0);

		pane = new Pane();
		pane.setStyle("-fx-background-color: black;");
		pane.setLayoutY(100);
		pane.setPrefSize(400, 300);

		circle = new Circle(100, Color.ALICEBLUE);
		circle.relocate(20, 50);

    triangle = new Polygon();
		triangle.getPoints().addAll(new Double[] { 50.0, 0.0, 0.0, 200.0, 100.0, 200.0 });
		triangle.relocate(250, 50);
		triangle.setFill(Color.GREEN);

    pane.getChildren().addAll(circle, triangle);
		rootGroup.getChildren().addAll(pane, rectangle);
  }

  public Group getRoot() {
    return rootGroup;
  }

  public Rectangle getRectangle() {
    return rectangle;
  }

  public Circle getCircle() {
    return circle;
  }

  public Polygon getTriangle() {
    return triangle;
  }

  public Pane getPane() {
    return pane;
  }
}
