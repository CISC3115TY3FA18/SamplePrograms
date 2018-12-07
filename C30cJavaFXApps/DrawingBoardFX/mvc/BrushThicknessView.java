import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.control.Spinner;
import javafx.geometry.Pos;
import javafx.scene.canvas.GraphicsContext;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class BrushThicknessView {
  public final static double BRUSH_THICKNESS_SCENE_WIDTH = 500.;
  public final static double BRUSH_THICKNESS_SCENE_HEIGHT = 300.;
  public final static double BRUSH_THICKNESS_DEMO_LINE_CANVAS_WIDTH = 100.;
  public final static double BRUSH_THICKNESS_DEMO_LINE_CANVAS_HEIGHT = 100.;

  private final static double BUTTON_SPACING = 20.;

  private final static double PADDING_TOP = 20.;
  private final static double PADDING_RIGHT = 20.;
  private final static double PADDING_BOTTOM = 20.;
  private final static double PADDING_LEFT = 20.;

  private final static Insets HBOX_PADDING = new Insets(PADDING_TOP, PADDING_RIGHT, PADDING_BOTTOM, PADDING_LEFT);

  private HBox hbox;
  private Spinner<Double> spinner;

  private GraphicsContext gc;

  public BrushThicknessView() {
    buildBrushThicknessView();
  }

  public Scene getScene() {
    return new Scene(hbox, BRUSH_THICKNESS_SCENE_WIDTH, BRUSH_THICKNESS_SCENE_HEIGHT);
  }

  public GraphicsContext getGraphicsContext() {
    return gc;
  }

  public Spinner<Double> getSpinner() {
    return spinner;
  }

  private void buildBrushThicknessView() {
    hbox = new HBox();
    hbox.setAlignment(Pos.CENTER);
    hbox.setPadding(HBOX_PADDING);
    hbox.setSpacing(BUTTON_SPACING);

    Canvas canvas = new Canvas(BRUSH_THICKNESS_DEMO_LINE_CANVAS_WIDTH, BRUSH_THICKNESS_DEMO_LINE_CANVAS_HEIGHT);

    gc = canvas.getGraphicsContext2D();
    hbox.getChildren().add(canvas);

    spinner = new Spinner<Double>();
    hbox.getChildren().add(spinner);
  }

}
