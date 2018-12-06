public class TextModel {
  private final static String[] MESSAGES = { "Hello, World!", "What a wonderful day!", "Happy Holidays!", "Are you driven?",
           "I am bored, let's play!" };

  public String getMessage(int index) {
    return MESSAGES[index];
  }

  public int getNumberOfMessages() {
    return MESSAGES.length;
  }
}
