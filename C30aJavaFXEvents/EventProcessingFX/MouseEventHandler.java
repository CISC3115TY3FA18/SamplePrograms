import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MouseEventHandler implements EventHandler<MouseEvent> {
  private StringBuilder sb = new StringBuilder();
  private String tag;

  public MouseEventHandler(StringBuilder sb, String tag) {
      this.sb = sb;
      this.tag = tag;
  }

  public void handle(MouseEvent e) {
      sb.append("\n\t-> capured/bubbled at " + e.getSource().toString() + " with event tag as " + tag);
      System.out.println(tag + ": mouse clicked: source -> target:" + e.getSource() + "->" + e.getTarget());
      // if (e.getSource() instanceof javafx.scene.layout.Pane && tag.contains("filter")) {
      //   e.consume();
      //   System.out.println("\n\tevent is consumed at " + e.getSource().toString() + " no more capturing and bubbling");
      // }
      // if (e.getSource() instanceof  javafx.scene.shape.Circle && tag.contains("handler")) {
      //   e.consume();
      //   System.out.println("\n\tevent is consumed at " + e.getSource().toString() + " no more bubbling");
      // }
  }
}
