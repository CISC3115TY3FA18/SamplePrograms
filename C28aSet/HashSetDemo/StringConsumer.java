import java.util.function.Consumer;

public class StringConsumer implements Consumer<String> {
  public void accept(String s) {
    System.out.print(s.toLowerCase() + " ");
  }
}
