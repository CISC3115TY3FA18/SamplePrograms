import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class EventProcessingFXApp extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		View view = new View();
		Controller controller = new Controller(view);
		controller.registerEventsAlongTheChain(primaryStage);
		// controller.showViewOn(primaryStage);
		Stage stage = new Stage();
		controller.showViewAndWaitOn(stage);

		System.out.println("------------------------------");
		System.out.println(controller.getEventProcessingMessage());
	}
}
