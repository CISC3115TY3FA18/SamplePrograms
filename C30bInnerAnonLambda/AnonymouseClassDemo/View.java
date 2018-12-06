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

public class View {
  private final static int WINDOW_WIDTH = 400;
  private final static int WINDOW_HEIGHT = 200;
  private final static int BUTTON_SPACING = 20;
  private final static int PADDING_TOP = 20;
  private final static int PADDING_RIGHT = 20;
  private final static int PADDING_BOTTOM = 20;
  private final static int PADDING_LEFT = 20;
  private final static Insets HBOX_PADDING =
    new Insets(PADDING_TOP, PADDING_RIGHT, PADDING_BOTTOM, PADDING_LEFT);

  private Label lblText;
  private Button btnSetText;
  private Button btnSetColor;
  private VBox vbox;

  public View() {
    buildScene();
  }

  private void buildScene() {
    lblText = new Label();
    lblText.setText("Hello, World!");
    // Different operating systems comes with different set of fonts.
    // On Mac: e.g., use
    // lblText.setFont(Font.font("Zapfino", FontWeight.NORMAL, 60.));
    // On Windows: e.g., use
    // lblText.setFont(Font.font("Kunstler Script", FontWeight.NORMAL, 60.));
    lblText.setFont(Font.font("Kunstler Script", FontWeight.NORMAL, 60.));

    btnSetText = new Button();
    btnSetText.setText("Set Random Text");

    btnSetColor = new Button();
    btnSetColor.setText("Set Random Color");

    HBox hboxButtons = new HBox();
    hboxButtons.getChildren().add(btnSetText);
    hboxButtons.getChildren().add(btnSetColor);
    hboxButtons.setAlignment(Pos.CENTER);
    hboxButtons.setSpacing(BUTTON_SPACING);
    hboxButtons.setPadding(HBOX_PADDING);

    vbox = new VBox();
    vbox.getChildren().add(hboxButtons);
    vbox.getChildren().add(lblText);
    vbox.setAlignment(Pos.TOP_CENTER);
  }

  public Scene getScene() {
    return new Scene(vbox, WINDOW_WIDTH, WINDOW_HEIGHT);
  }

  public Button getBtnSetText() {
    return btnSetText;
  }

  public Button getBtnSetColor() {
    return btnSetColor;
  }

  public Label getLblText() {
    return lblText;
  }
}
