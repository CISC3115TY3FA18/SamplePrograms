import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.Parent;
import javafx.scene.layout.Priority;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SimpleUIFXApp extends Application {
  private final static double MAIN_WIN_WIDTH = 500;
  private final static double MAIN_WIN_HEIGHT = 300;

  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage primaryStage) {
    Scene scene = buildMainScene(MAIN_WIN_WIDTH, MAIN_WIN_HEIGHT);

    showSceneOnStage(scene, primaryStage);
  }

  private Scene buildMainScene(double width, double height) {
    HBox rootHBox = new HBox();
    VBox leftVBox = new VBox();
    VBox rightVBox = new VBox();

    // size and shape and margin of rootHBox's children
    rootHBox.getChildren().addAll(leftVBox, rightVBox);
    rootHBox.setMargin(leftVBox, new Insets(10., 5., 10., 10.));
    rootHBox.setMargin(rightVBox, new Insets(10., 10., 10., 5.));
    rootHBox.setHgrow(leftVBox, Priority.ALWAYS);

    Button btnOK = new Button("OK");
    Button btnCancel = new Button("Cancel");
    btnOK.setMinWidth(100.);
    btnCancel.setMinWidth(100.);
    btnOK.setMaxWidth(Double.MAX_VALUE);
    btnCancel.setMaxWidth(Double.MAX_VALUE);
    rightVBox.getChildren().addAll(btnOK, btnCancel);
    rightVBox.setAlignment(Pos.TOP_LEFT);
    rightVBox.setSpacing(5.);

    TextArea textArea = new TextArea();
    textArea.setMinWidth(150.0);
    textArea.setMinHeight(150.0);
    textArea.setMaxHeight(Double.MAX_VALUE);
    leftVBox.getChildren().add(textArea);
    leftVBox.setVgrow(textArea, Priority.ALWAYS);


    return new Scene(rootHBox, width, height);
  }

  private void showSceneOnStage(Scene scene, Stage stage) {
    stage.setScene(scene);
    stage.setTitle("Building Scene Graph with Layout and Controls");
    stage.show();
  }

}
