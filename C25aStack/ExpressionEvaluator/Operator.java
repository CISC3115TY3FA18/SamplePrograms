public class Operator extends Token {
  private int precedence;   // greater number means higher precedence

  public Operator(String operator) {
    super(operator);
    this.precedence = lookup(operator);
  }


  public boolean isOperator() {
    return true;
  }

  public int getPrecedence() {
    return precedence;
  }

  public boolean isParenthesis() {
    return getToken().equals("(");
  }


  public static boolean isValid(String operator) {
    boolean valid = false;
    switch(operator) {
      case "+":
      case "-":
      case "*":
      case "/":
        valid = true;
    }
    return valid;
  }

  public static boolean isValid(char singleCharOperator) {
    return isValid(String.valueOf(singleCharOperator));
  }

  private int lookup(String operator) {
    int precedence = 0;
    switch(operator) {
      case "+":
      case "-":
        precedence = 1;
        break;
      case "*":
      case "/":
        precedence = 2;
        break;
      default:
        throw new IllegalArgumentException("opeartor " + operator + " not supported");
    }
    return precedence;
  }
}
