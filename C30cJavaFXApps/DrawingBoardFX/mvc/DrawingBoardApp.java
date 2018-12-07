import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DrawingBoardApp extends Application {
  private final static Color INIT_BRUSH_COLOR = Color.BLUE;
  private final static double INIT_BRUSH_WIDTH = 1.0;

  public void start(Stage primaryStage) {
    DrawingBoardView drawingBoardView = new DrawingBoardView();
    BrushColorView brushColorView = new BrushColorView(INIT_BRUSH_COLOR);
    BrushThicknessView brushThicknessView = new BrushThicknessView();

    Stage brushThicknessStage = buildBrushTicknessStage(brushThicknessView);
    Stage brushColorStage = buildColorPickerStage(brushColorView);

    BrushColorController brushColorController = new BrushColorController(brushColorStage, brushColorView, INIT_BRUSH_COLOR);
    BrushThicknessController brushThicknessController =
      new BrushThicknessController(brushThicknessStage, brushThicknessView, INIT_BRUSH_WIDTH, INIT_BRUSH_COLOR);
    DrawingBoardController drawingBoardController =
      new DrawingBoardController(drawingBoardView, brushThicknessController, brushColorController);
    drawingBoardController.showDrawingBoardViewOn(primaryStage);
  }


  private Stage buildBrushTicknessStage(BrushThicknessView view) {
    Stage brushThicknessStage = new Stage();
    brushThicknessStage.setTitle("Select thickness of your paintbrush");
    brushThicknessStage.initModality(Modality.APPLICATION_MODAL);
    brushThicknessStage.setScene(view.getScene());
    return brushThicknessStage;
  }

  private Stage buildColorPickerStage(BrushColorView view) {
    Stage brushColorStage = new Stage();
    brushColorStage.setTitle("Select the color of your paintbrush");
    brushColorStage.initModality(Modality.APPLICATION_MODAL);
    brushColorStage.setScene(view.getScene());
    return brushColorStage;
  }
}
