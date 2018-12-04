import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

class RandomColorEventHandler implements EventHandler<ActionEvent> {
  private Label lblText;

  RandomColorEventHandler(Label lblText) {
    this.lblText = lblText;
  }

  public void handle(ActionEvent event) {
    lblText.setTextFill(RandomHelper.getRandomColor());
  }
}
