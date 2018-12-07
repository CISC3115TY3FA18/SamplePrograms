import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HelloWorldFx extends Application {

	@Override
	public void start(Stage primaryStage) {
		// build a scene graph
		Pane rootPane = new Pane();
		Text text = new Text(10, 50, "Hello, World!");
		rootPane.getChildren().add(text);

		// instantiate a scene from the scene graph
		Scene scene = new Scene(rootPane, 300, 250);

		// instantiate a scene (or use the primary Stage) and set scene on the stage
		primaryStage.setScene(scene);

		// customize the stage
		primaryStage.setTitle("Hello World!");

		// show the stage (curtains up)
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
