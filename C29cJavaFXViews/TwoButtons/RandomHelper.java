import java.util.Random;
import javafx.scene.paint.Color;

class RandomHelper {
  private final static String[] MESSAGES = { "Hello, World!", "What a wonderful day!", "Happy Holidays!", "Are you driven?",
           "I am bored, let's play!" };
  private static Random rng = new Random();

  public static String getRandomMessage() {
    return MESSAGES[rng.nextInt(MESSAGES.length)];
  }

  public static Color getRandomColor() {
    int r = rng.nextInt(256);
    int g = rng.nextInt(256);
    int b = rng.nextInt(256);
    return Color.rgb(r, g, b);
  }
}
