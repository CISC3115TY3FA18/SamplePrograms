import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.control.Spinner;
import javafx.stage.Stage;

public class BrushThicknessController {
  private final static double MIN_LINE_WIDTH = 1.0;
  private final static double MAX_LINE_WIDTH = 100.0;
  private final static double LINE_WIDTH_STEP = 1.0;

  private BrushThicknessView view;
  private GraphicsContext gc;

  private double brushLineWidth;
  private Color brushColor;

  private Stage stage;

  public BrushThicknessController(Stage stage, BrushThicknessView view, double brushLineWidth, Color brushColor) {
    this.view = view;
    this.gc = view.getGraphicsContext();
    this.brushLineWidth = brushLineWidth;
    this.brushColor = brushColor;
    this.stage = stage;
    setUpSpinner(this.view.getSpinner());
    updateTheLine();
  }

  public double getBrushLineWidth() {
    return brushLineWidth;
  }

  public void setBrushColor(Color color) {
    brushColor = color;
    updateTheLine();
  }

  public Stage getStage() {
    return stage;
  }

  public void setUpSpinner(Spinner<Double> spinner) {
    SpinnerValueFactory<Double> lineWidthValueFactory = new SpinnerValueFactory<Double>() {

      @Override
      public void decrement(int steps) {
        double lw = brushLineWidth;
        lw -= steps * LINE_WIDTH_STEP;
        if (lw >= MIN_LINE_WIDTH) {
          brushLineWidth = lw;
          setValue(brushLineWidth);
          updateTheLine();
        }
      }

      @Override
      public void increment(int steps) {
        double lw = brushLineWidth;
        lw += steps * LINE_WIDTH_STEP;
        if (lw <= MAX_LINE_WIDTH) {
          brushLineWidth = lw;
          setValue(brushLineWidth);
          updateTheLine();
        }
      }
    };
    lineWidthValueFactory.setValue(brushLineWidth);
    spinner.setValueFactory(lineWidthValueFactory);
  }

  private void updateTheLine() {
    gc.setLineWidth(brushLineWidth);
    gc.setStroke(brushColor);
    gc.clearRect(0, 0, BrushThicknessView.BRUSH_THICKNESS_DEMO_LINE_CANVAS_WIDTH, BrushThicknessView.BRUSH_THICKNESS_DEMO_LINE_CANVAS_HEIGHT);
    gc.beginPath();
    gc.moveTo(0, BrushThicknessView.BRUSH_THICKNESS_DEMO_LINE_CANVAS_HEIGHT / 2.);
    gc.lineTo(BrushThicknessView.BRUSH_THICKNESS_DEMO_LINE_CANVAS_WIDTH, BrushThicknessView.BRUSH_THICKNESS_DEMO_LINE_CANVAS_HEIGHT / 2.);
    gc.stroke();
    gc.closePath();
  }
}
