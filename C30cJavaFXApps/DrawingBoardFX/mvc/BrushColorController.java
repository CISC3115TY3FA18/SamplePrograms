import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BrushColorController {
  private BrushColorView view;
  private Color brushColor;

  private Stage stage;

  public BrushColorController(Stage stage, BrushColorView view, Color color) {
    this.view = view;
    this.stage = stage;
    this.brushColor = color;
    view.getColorPicker().setValue(color);
    view.getColorPicker().setOnAction(e -> brushColor = view.getColorPicker().getValue());
  }

  public Color getBrushColor() {
    return brushColor;
  }

  public Stage getStage() {
    return stage;
  }
}
