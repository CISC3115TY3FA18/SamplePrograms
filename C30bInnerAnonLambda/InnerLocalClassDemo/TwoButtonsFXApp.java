import javafx.application.Application;
import javafx.stage.Stage;

public class TwoButtonsFXApp extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage primaryStage) throws Exception {
    View view = new View();
    TextModel model = new TextModel();
    Controller controller = new Controller(model, view);
    controller.showViewOn(primaryStage);
    controller.registerEventHandlers();
  }
}
