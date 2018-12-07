import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class BrushColorView {
  private final static double BRUSH_COLOR_SCENE_WIDTH = 400.;
  private final static double BRUSH_COLOR_SCENE_HEIGHT = 300.;
  private final static double PADDING_TOP = 20.;
  private final static double PADDING_RIGHT = 20.;
  private final static double PADDING_BOTTOM = 20.;
  private final static double PADDING_LEFT = 20.;
  private final static Insets HBOX_PADDING = new Insets(PADDING_TOP, PADDING_RIGHT, PADDING_BOTTOM, PADDING_LEFT);

  private StackPane holder;
  private ColorPicker colorPicker;

  public BrushColorView(Color defaultColor) {
    buildBrushColorPickerView(defaultColor);
  }

  public Scene getScene() {
    return new Scene(holder, BRUSH_COLOR_SCENE_WIDTH, BRUSH_COLOR_SCENE_HEIGHT);
  }

  public ColorPicker getColorPicker() {
    return colorPicker;
  }

  private void buildBrushColorPickerView(Color color) {
    colorPicker = new ColorPicker();
    colorPicker.setMaxWidth(Double.MAX_VALUE);
    colorPicker.setValue(color);

    holder = new StackPane();
    holder.setAlignment(Pos.TOP_CENTER);
    holder.setPadding(HBOX_PADDING);
    holder.getChildren().add(colorPicker);
  }
}
