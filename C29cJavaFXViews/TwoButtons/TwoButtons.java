import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class TwoButtons extends Application {
  private final static int WINDOW_WIDTH = 400;
  private final static int WINDOW_HEIGHT = 200;
  private final static int BUTTON_SPACING = 20;
  private final static int PADDING_TOP = 20;
  private final static int PADDING_RIGHT = 20;
  private final static int PADDING_BOTTOM = 20;
  private final static int PADDING_LEFT = 20;
  private final static Insets HBOX_PADDING =
    new Insets(PADDING_TOP, PADDING_RIGHT, PADDING_BOTTOM, PADDING_LEFT);

  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage primaryStage) throws Exception {
    Scene scene = buildScene();

    showSceneOnStage(scene, primaryStage);
  }

  private Scene buildScene() {
    Label lblText = new Label();
    lblText.setText("Hello, World!");
    // Different operating systems comes with different set of fonts.
    // On Mac: e.g., use
    // lblText.setFont(Font.font("Zapfino", FontWeight.NORMAL, 60.));
    // On Windows: e.g., use
    // lblText.setFont(Font.font("Kunstler Script", FontWeight.NORMAL, 60.));
    lblText.setFont(Font.font("Kunstler Script", FontWeight.NORMAL, 60.));

    Button btnSetText = new Button();
    btnSetText.setText("Set Random Text");
    btnSetText.setOnAction(new SetTextEventHandler(lblText));

    Button btnSetColor = new Button();
    btnSetColor.setText("Set Random Color");
    btnSetColor.setOnAction(new RandomColorEventHandler(lblText));

    HBox hboxButtons = new HBox();
    hboxButtons.getChildren().add(btnSetText);
    hboxButtons.getChildren().add(btnSetColor);
    hboxButtons.setAlignment(Pos.CENTER);
    hboxButtons.setSpacing(BUTTON_SPACING);
    hboxButtons.setPadding(HBOX_PADDING);

    VBox vbox = new VBox();
    vbox.getChildren().add(hboxButtons);
    vbox.getChildren().add(lblText);
    vbox.setAlignment(Pos.TOP_CENTER);

    return new Scene(vbox, WINDOW_WIDTH, WINDOW_HEIGHT);
  }

  private void showSceneOnStage(Scene scene, Stage stage) {
    stage.setTitle("Two Buttons");
    stage.setScene(scene);
    stage.show();
  }
}
