public class Parenthesis extends Token {
  public Parenthesis(String value) {
    super(value);
  }

  public int getParenthesisType() {
    if (getToken().equals("(")) {
      return -1;
    } else {
      return 1;
    }
  }

  public static boolean isValid(String value) {
    boolean valid = false;
    switch(value) {
      case "(":
      case ")":
        valid = true;
    }
    return valid;
  }

  public static boolean isValid(char value) {
    return isValid(String.valueOf(value));
  }
}
