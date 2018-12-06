import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Random;

public class Controller {
  private TextModel textModel;
  private View view;
  private Scene scene;

  public Controller(TextModel textModel, View view) {
    this.textModel = textModel;
    this.view = view;
  }

  public void showViewOn(Stage stage) {
    if (scene == null) {
      scene = view.getScene();
    }
    stage.setTitle("Two Buttons");
    stage.setScene(scene);
    stage.show();
  }

  public void registerEventHandlers() {

    // this is a local class
    class SetTextEventHandler implements EventHandler<ActionEvent> {
      private Random rng;
      private Label lblText;

      SetTextEventHandler(Label lblText) {
        this.lblText = lblText;
        this.rng = new Random();
      }
      public void handle(ActionEvent event) {
        lblText.setText(textModel.getMessage(rng.nextInt(textModel.getNumberOfMessages())));
      }
    }
    view.getBtnSetText().setOnAction(new SetTextEventHandler(view.getLblText()));

    view.getBtnSetColor().setOnAction(new RandomColorEventHandler(view.getLblText()));
  }

  // this is an inner class
  class RandomColorEventHandler implements EventHandler<ActionEvent> {
    private Random rng;
    private Label lblText;

    RandomColorEventHandler(Label lblText) {
      this.lblText = lblText;
      rng = new Random();
    }

    public void handle(ActionEvent event) {
      lblText.setTextFill(getRandomColor());
    }

    private Color getRandomColor() {
      int r = rng.nextInt(256);
      int g = rng.nextInt(256);
      int b = rng.nextInt(256);
      return Color.rgb(r, g, b);
    }
  }
}
