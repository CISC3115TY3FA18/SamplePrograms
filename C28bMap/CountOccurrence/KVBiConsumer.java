
import java.util.function.BiConsumer;

public class KVBiConsumer implements BiConsumer<String, Integer> {
  public void accept(String name, Integer age) {
    System.out.print(name + ": " + age + " ");
  }
}
