import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DrawingBoardController {
  private DrawingBoardView view;
  private BrushColorController brushColorController;
  private BrushThicknessController brushThicknessController;

  private double lineWidth;
  private Color color;

  private Scene scene;

  public DrawingBoardController(DrawingBoardView view,
    BrushThicknessController brushThicknessController, BrushColorController brushColorController) {
    this.view = view;
    this.brushThicknessController = brushThicknessController;
    this.brushColorController = brushColorController;
    registerEventHandlers();
    this.view.getGraphicsContext().setLineWidth(brushThicknessController.getBrushLineWidth());
    this.view.getGraphicsContext().setStroke(brushColorController.getBrushColor());
  }

  public void showDrawingBoardViewOn(Stage stage) {
    if (scene == null) {
      scene = view.getScene();
    }
    stage.setScene(scene);
    stage.show();
  }

  private void registerEventHandlers() {
    view.getBtnBrushThickness().setOnAction(e -> {
      brushThicknessController.setBrushColor(brushColorController.getBrushColor());
      brushThicknessController.getStage().showAndWait();
      view.getGraphicsContext().setLineWidth(brushThicknessController.getBrushLineWidth());
    });
    view.getBtnBrushColor().setOnAction(e -> {
      brushColorController.getStage().showAndWait();
      view.getGraphicsContext().setStroke(brushColorController.getBrushColor());
    });


    // press-and-hold-and-draw
    view.getCanvas().setOnMousePressed(e -> {
      double x0 = e.getX();
      double y0 = e.getY();
      view.getGraphicsContext().moveTo(x0, y0);
      view.getGraphicsContext().beginPath();
    });

    view.getCanvas().setOnMouseDragged(e -> {
      double x1 = e.getX();
      double y1 = e.getY();
      view.getGraphicsContext().lineTo(x1, y1);
      view.getGraphicsContext().stroke();
    });

    view.getCanvas().setOnMouseReleased(e -> view.getGraphicsContext().closePath());

  }

}
