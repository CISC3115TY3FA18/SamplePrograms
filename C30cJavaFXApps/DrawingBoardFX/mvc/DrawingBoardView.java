import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class DrawingBoardView {
  private final static String CANVAS_HOLDER_STYLE = "-fx-background-color: white";
  private final static double CANVAS_WIDTH = 650.;
  private final static double CANVAS_HEIGHT = 400.;

  private final static double MAIN_SCENE_WIDTH = 900.;
  private final static double MAIN_SCENE_HEIGHT = 500.;


  private final static double BUTTON_SPACING = 20.;
  private final static double PADDING_TOP = 20.;
  private final static double PADDING_RIGHT = 20.;
  private final static double PADDING_BOTTOM = 20.;
  private final static double PADDING_LEFT = 20.;
  private final static Insets VBOX_PADDING = new Insets(PADDING_TOP, PADDING_RIGHT, PADDING_BOTTOM, PADDING_LEFT);
  private final static Insets HBOX_PADDING = new Insets(PADDING_TOP, PADDING_RIGHT, PADDING_BOTTOM, PADDING_LEFT);

  private GraphicsContext gc;
  private Canvas canvas;
  private HBox hbox;
  private Button btnBrushThickness;
  private Button btnBrushColor;

  public DrawingBoardView() {
    buildMainView();
  }

  public GraphicsContext getGraphicsContext() {
    return gc;
  }

  public Scene getScene() {
    return new Scene(hbox, MAIN_SCENE_WIDTH, MAIN_SCENE_HEIGHT);
  }

  public Button getBtnBrushThickness() {
    return btnBrushThickness;
  }

  public Button getBtnBrushColor() {
    return btnBrushColor;
  }

  public Canvas getCanvas() {
    return canvas;
  }

  private void buildMainView() {
    btnBrushThickness = new Button("Brush Thickness");
    btnBrushThickness.setMaxWidth(Double.MAX_VALUE);

    btnBrushColor = new Button("Brush Color");
    btnBrushColor.setMaxWidth(Double.MAX_VALUE);

    VBox vbox = new VBox();
    vbox.setAlignment(Pos.TOP_CENTER);
    vbox.setPadding(VBOX_PADDING);
    vbox.setSpacing(BUTTON_SPACING);
    vbox.getChildren().add(btnBrushThickness);
    vbox.getChildren().add(btnBrushColor);

    canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
    gc = canvas.getGraphicsContext2D();

    StackPane canvasHolder = new StackPane();
    canvasHolder.setStyle(CANVAS_HOLDER_STYLE);
    canvasHolder.getChildren().add(canvas);

    hbox = new HBox();
    hbox.setPadding(HBOX_PADDING);
    hbox.getChildren().add(canvasHolder);
    hbox.getChildren().add(vbox);

  }

}
