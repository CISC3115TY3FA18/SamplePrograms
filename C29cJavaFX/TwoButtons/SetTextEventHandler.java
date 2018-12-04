import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class SetTextEventHandler implements EventHandler<ActionEvent> {
  private Label lblText;

  SetTextEventHandler(Label lblText) {
    this.lblText = lblText;
  }
  public void handle(ActionEvent event) {
    lblText.setText(RandomHelper.getRandomMessage());
  }
}
